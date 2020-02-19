package org.techtown.ai_eng_v2_00;

public class Data {

    private String title;
    private String content;
    private String writer;
    private String date;
    private int resId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public void setwriter(String writer) {
        this.writer = writer;
    }

    public String getwriter() {
        return writer;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getdate() {
        return date;
    }

}