package org.donstu.domain;

public class Response {
    private String FIO;
    private String phoneNumber;
    private String text;

    public Response(String FIO, String phoneNumber, String text) {
        this.FIO = FIO;
        this.phoneNumber = phoneNumber;
        this.text = text;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
