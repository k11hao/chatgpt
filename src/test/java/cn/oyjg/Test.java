package cn.oyjg;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        App  app = new App();
        app.chat("你好呀");
    }
    @org.junit.Test
    public void splitData(){
        String data="data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": []}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\\u544a\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\\u544a\\u8bc9\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\\u544a\\u8bc9\\u6211\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\\u544a\\u8bc9\\u6211\\u3002\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: {\"message\": {\"id\": \"bfa3efe5-43aa-414d-961b-7f3bf05736e3\", \"role\": \"assistant\", \"user\": null, \"create_time\": null, \"update_time\": null, \"content\": {\"content_type\": \"text\", \"parts\": [\"\\u4f60\\u597d\\uff01\\u5f88\\u9ad8\\u5174\\u80fd\\u4e3a\\u60a8\\u670d\\u52a1\\u3002\\u5982\\u679c\\u60a8\\u6709\\u4ec0\\u4e48\\u95ee\\u9898\\uff0c\\u8bf7\\u968f\\u65f6\\u544a\\u8bc9\\u6211\\u3002\"]}, \"end_turn\": null, \"weight\": 1.0, \"metadata\": {}, \"recipient\": \"all\"}, \"conversation_id\": \"7fb5f6a1-eb15-4cca-845c-104138caf347\", \"error\": null}\n" +
                "\n" +
                "data: [DONE]\n" +
                "\n";
        System.out.println(data.split("data: "));
        String[] dlist = data.split("data: ");
        String last = dlist[dlist.length-2];
        Resp jsonObject = JSONUtil.toBean(last,Resp.class);

        System.out.println(data);
    }
}
