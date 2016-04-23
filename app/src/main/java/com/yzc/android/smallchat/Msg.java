package com.yzc.android.smallchat;

/**
 * Created by yzc on 2016/4/23.
 */
public class Msg {

    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SENT = 1;

    private String content;

    private int type;

    private int imageId;

    public Msg(String content, int type, int imageId) {
        this.content = content;
        this.type = type;
        this.imageId = imageId;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getImageId() {
        return imageId;
    }
}
