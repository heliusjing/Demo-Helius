package com.helius.synchronizedDemo;

public class Message {

    /**
     * 消息体
     */
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }

}