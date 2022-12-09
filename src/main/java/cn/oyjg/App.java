package cn.oyjg;

import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static Resp lastMessage;

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        App app = new App();
        router.route("/chatgpt/send").handler(ctx -> {
            HttpServerResponse response = ctx.response();
            response.setChunked(true);

            WorkerExecutor executor = vertx.createSharedWorkerExecutor("my-worker-sync");
            executor.executeBlocking(future -> {
//                HttpServerRequest req = ctx.request();
                String body = ctx.getBodyAsString();
                String content = "";

                if ("重置".equals(body)) {
                    lastMessage = null;
                    ctx.json("{}");
                }
                Resp resp = app.chat(content);
                future.complete(resp);
            }, res -> {
                Resp resp = (Resp) res.result();
                String result = resp.getMessage().getContent().getParts().toString();
//                response.write(result);
                ctx.json(result);
//                ctx.response().end();
            });

        });
        server.requestHandler(router).listen(9001);

    }

    public Resp chat(String str) {

        String chat_url = "https://chat.openai.com/backend-api/conversation";
        Req req = new Req();
        Resp respData = null;
        try {
            Message message = new Message();
            message.initContent(str);
            message.setRole("user");
            if (lastMessage != null) {
                chat_url = "https://chat.openai.com/backend-api/conversation";
                lastMessage.setConversation_id(lastMessage.getConversation_id());
                req.setParent_message_id(lastMessage.getMessage().getId());
                req.setConversation_id(lastMessage.getConversation_id());
                message.setId(UUID.randomUUID().toString());
                req.setMessages(Arrays.asList(message));
            } else {
                req.setMessages(Arrays.asList(message));
                req.setParent_message_id("");
            }

            String reqBody = JSONUtil.toJsonStr(req);

            HttpResponse res2 = HttpRequest.post(chat_url)
                    .addHeaders(getHeader())
                    .body(reqBody)
                    .execute();
            String respStr = res2.body();
            String[] dlist = res2.body().split("data: ");
            if (dlist.length < 2) {
                System.out.println(respStr);
                return null;
            }
            String last = dlist[dlist.length - 2];
            respData = JSONUtil.toBean(last, Resp.class);
            lastMessage = respData;
        } catch (Exception err) {
            err.printStackTrace();
        }
        return respData;
    }


    private Map<String, String> getHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("__Secure-next-auth.session-token", "eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..2o_drKqwwUm9hDhD.dYQmSdGfsW9EJDLb0gr15IO3DXseznTegY3BBhcm7djlHcuditvTZqPB6zZU5aZ8s_wETzj8JvO_yLqG4Fn66RR0_csA61Ni5NAKdIk1LCgGirHvtUozx0vRCNIizpwb86nfGoVj2y0rYq2sEKW9OKDpaka1B_PaIgCF9-_3wdK5_2byQj748v6ZHvbytiy_h_os8Qwg3_Z_LVREFrtXfkVWxYE57OE6uVJd3CdyDtqGXXX0VQMzDMzi-FQ0TrJu_a1c8RsemsDk2MP1eHYsAU3GoqVWzcCRouukhmDHVMGuPTBXT_me2W-CPM9hrESt0KdFQvKaRe_CMqEtD8GmU2ncKKQoM1IADumlhfQKijkQ1XMhpv_HrIC4QZ3EovJZv9PisidQxfXCg1IAVUyp3ytaoxfuo6WxWcFUGmBxpb6jCmgOLU5zBVbuIym6n4fGtagUR7ptEKlq7WIBNrbpqSInv1HvSv-0T6c_Ga1TsSStYez0nPXD9nBUOvSq-koKB35uA0m7RV6sSub8KrLE7YIh2WUQBn4PoNcTVu1VkCwDGds2F00jH0zRcg8JAFxGK5B3AEc2EMJxXTkXs_PKBqeMWplUzWKPdp81CsUrOdZ5SK2n-F24CqwIn9ywp4w7MiOYDAem32EM-ORH0RrFHU6txFSbM_gM7z7jZwQADjUcKPMkObrEZPYy2WYfCRmCeGtXFTivJDImngoVN0r7Wr41VBanfjgMQlp8CIb9lk9dJ6GVefXk2cTy365jZdFbeAGKCz8vTti0TBlPqj2kplcbpDpkLpuXllU6CqVSOInlBnQxCAAdVZYkmg3K_U2myIid3_oPqbENUlAJOdYk_gv6rBUvSk1VUqrlx5nADu70QL0V42pG9EkQjWXw-NNCOCj3hafbGOxLp2JypK8MQjM8lT71ez-Fe77oTSmsABayze5B3EiUr8A0OCgWV4kC7OJsJOejFOFgbZ2h_DUXBPKYMS3vQA7OP5AjZJdNepCCRJl8Eu-XpOnQ4V7A2Rb2HI-apfOjHCwlgJuDUIbiDtG_lrzI3pS8PtKyRh90Ft0JWQqv46u9ChB42g11opIjVBaZ7pf8GVNqDZurtSh-7bOSHFfGDM8G23zFscu5S1F1-9MFM1dsO7mRgnLM_cujTYpChRMBrHm8AM9lNz-vYfSPAXLGA1UCWUJt8Pa0f4mq6RkRts0tqqJ8F0QNDyGf2iuzKvlXZB7gEnzp9ZAd1Hjo8IH2j5r5I1LSRBO0pwBBkcA4xanWkAIi7TnoZU_Ljtu-pi6fXqwOHemlwCSVEBH-z3c8DumtUawG5QKhYHtd1NVKesrPLrRVsaBzX_ZxcYDXObarexG9c0WcMS73zkQV9iG0ahZsLje-Lp4I55eEubSOVxntZ9iKCd2wWTea5EQswbubZaWAsc7KiYMxEtl4UIyLBPA66AUQxe1oWKpgp1zah3gE6p-UqkSeGRymKmTvdNE0HstIybRgKaYOaEt0haHXQy64yRhZ-FZ7FODC9TLPCfG_QcuEZT4UlfCSa6Rkvr71kV5gmc3lpZ5TsJhnY9xA6VTZa9o8LU8o7222jT2gk4nzJ3sPebxxpa66sNdB-OzCXOFiHVqtfblJGAeDeoWzCG4XKhcYxXnCC7JQxDF1ePMAA2pYHt7y7KVU2FY2Jv3M-QVmUahjhyZM6Qt6cAsnb0aJfu3Z05Co1xrmbDlKn505fCVAaFcmcUdNGEiSSu0-ycahpWGI8w2QrhZCT5yWbpLiik0Rt4uPyabb63m1ydxvLpDomfZIHWJ8nAid3EGHad31h9OOESe1Qb2rWgDjHEQeMwCbbbaKME3q3CJInJY3qQACuyo4GEe-NFmS0HPHUDKYcJne7G3-cnOYSgmAgXhKLiea0c2kzYZV8W8VmCpkTFQ05C-Arr-IjVoVKvs0_CLX1drnZBNmtE4KwdMqlZg8Hd0Rmzz7Xs6JVY6tucYvmsh05GZ9UxwNhoyjwPsiEkAgXEzb93P8TEiN1xT-EGTfo3AB8cFLTUIi5p98VG6nrYaH4sAmUXEsFyLbHJRJ66O7mt8avXXkryKbM7Ta5gvokz8BplGkKgbhIROwvEgIz1eBZwmMu2Fnw93hjDhYqFiahMKFp56Oc15yIZevolCwt0XRlaBpRVUGgvFNnU1GXrwW1lVL5XWajRJ8KC75dvOgMPqj-lHyyeTxEOl0qzNl9qb_rvXlcgm3BXglEHYsyU3JiVP00teEL632rm0_1TLPKivK8szqk4qz2A6YX_4BHnBewmgJRqSAVzA1epedXt6kTIoCUstzib6_tjAcu6_HqmEeAWt6.4CJH7K3BPx1CfpFDIy9-wg");
        header.put("Accept", "application/json");
//      header.put(r("intercom-session-dgkjq2bp","K0dEZkErZWNINEdYNlZxNDhVRTduT0dVeTFTblc1MDNYdWtPZlN6dWxKdklaUlJEUzRYR2k5TTE3WGtCZllNaC0tTWlselBMdEFPc2pCRkJSa3NRa3FRUT09--344a956052d21e9e45d14d0811c72e95c4910827")
        header.put("Content-Type", "application/json");
//      header.put(r("__Host-next-auth.csrf-token","6fcca562ce1dafc707083273513872e583ecb40a4373d70f08432af8f1ab5c23%7C107fb54e5bf97581d84cdeec0ba9900a33ac1cb2824b3770e0063ef865c6369f")
        header.put("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1UaEVOVUpHTkVNMVFURTRNMEZCTWpkQ05UZzVNRFUxUlRVd1FVSkRNRU13UmtGRVFrRXpSZyJ9.eyJodHRwczovL2FwaS5vcGVuYWkuY29tL3Byb2ZpbGUiOnsiZW1haWwiOiJrMTFoYW9AMTYzLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJnZW9pcF9jb3VudHJ5IjoiVVMifSwiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS9hdXRoIjp7InVzZXJfaWQiOiJ1c2VyLWJveThHRjdiUVVFWGRUNXhkQUtqbzNLTSJ9LCJpc3MiOiJodHRwczovL2F1dGgwLm9wZW5haS5jb20vIiwic3ViIjoiYXV0aDB8NjM5MWU5NTYyOTgzYzJiZDEzN2EyNzJlIiwiYXVkIjpbImh0dHBzOi8vYXBpLm9wZW5haS5jb20vdjEiLCJodHRwczovL29wZW5haS5hdXRoMC5jb20vdXNlcmluZm8iXSwiaWF0IjoxNjcwNTA3MjA4LCJleHAiOjE2NzA1OTM2MDgsImF6cCI6IlRkSkljYmUxNldvVEh0Tjk1bnl5d2g1RTR5T282SXRHIiwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSBtb2RlbC5yZWFkIG1vZGVsLnJlcXVlc3Qgb3JnYW5pemF0aW9uLnJlYWQgb2ZmbGluZV9hY2Nlc3MifQ.UKNvrRfevKq1C9_wIPC77BmOg1CaQcJdqFI5FyHF3Ec8PGMxWDzpC1CMnnfiQXqBWlRGVUSwo1WdqtHoxC75K50Y0khCeNHohvqtXc9UR8SvbFwHzpNEGF6U6EE1Qs2qanVr8LCVcect55LHL7-NXJhT9I3RXtOdVOXg_34ffGkxJ5w1LTpldO96tx5wpS3fwamXO5XVDISWEoHvPZX87g5efwFDc70a5t7jkeuhyO3-OsCjo4ND6HPi3w5I0ey-O6AGQdBosX6TA8b_NN8XbDCTXXxWeKoyZ2iIB1O6Lm8J5PNkf8dxkmxhxNzpCl7SfoYeQ152TpU16diNfqsLgg");
        return header;
    }
}
