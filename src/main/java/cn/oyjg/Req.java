package cn.oyjg;

import java.util.List;

public class Req {
    private String action="next";
    private String conversation_id;
    private List<Message> messages;
    private String parent_message_id;
    private String model ="text-davinci-002-render";

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getParent_message_id() {
        return parent_message_id;
    }

    public void setParent_message_id(String parent_message_id) {
        this.parent_message_id = parent_message_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
