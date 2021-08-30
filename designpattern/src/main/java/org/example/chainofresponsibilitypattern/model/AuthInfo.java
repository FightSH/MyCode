package org.example.chainofresponsibilitypattern.model;

public class AuthInfo {
    private String code;
    private String info = " ";

    public AuthInfo(String code, String... info) {
        this.code = code;
        for (String s : info) {
            this.info = this.info.concat(s);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
