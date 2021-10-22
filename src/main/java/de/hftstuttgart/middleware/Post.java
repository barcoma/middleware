package de.hftstuttgart.middleware;

public class Post {
    private final Integer ID;
    private String content;

    Post(Integer ID, String content) {
        System.out.println("reation: " + ID + " " + content);
        this.ID = ID;
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getID() {
        return this.ID;
    }
}
