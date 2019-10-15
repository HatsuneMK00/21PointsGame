package makise.ooad.lab2.entity;

import java.util.HashMap;

public class Request {
    private String level;
    private HashMap<String,Object> requestContent;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public HashMap<String, Object> getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(HashMap<String, Object> requestContent) {
        this.requestContent = requestContent;
    }
}
