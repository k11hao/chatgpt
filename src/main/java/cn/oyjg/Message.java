package cn.oyjg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Message {
    private String id;
    private String role;
    private String create_time;
    private String update_time;
    private String recipient;
    private Content content;

    public void initContent(String... content){
        List<String> parts = Arrays.asList(content);
        if(this.getContent()==null){
            this.content = new Content();
        }
        this.getContent().setParts(parts);
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
class Content{
    private String content_type="text";
    private List<String> parts =new ArrayList<>();

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }
}
