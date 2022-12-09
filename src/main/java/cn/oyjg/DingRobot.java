package cn.oyjg;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

public class DingRobot {
    public static void send(String msg) {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=1dca527edcbae422e79049e817fd37ecdfabbd6f013496fc45da5054f26ec76d");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("chatGPT");
        markdown.setText(msg);
        request.setMarkdown(markdown);
        try {
            OapiRobotSendResponse response = client.execute(request);
            System.out.println(JSONUtil.toJsonStr(response));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
