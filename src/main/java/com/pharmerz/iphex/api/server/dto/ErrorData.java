package com.pharmerz.iphex.api.server.dto;

/**
 * Created by ankurpathak on 02-02-2016.
 */
public class ErrorData {
    private Integer code;
    private String message;
    private String documentation;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }


    public ErrorData(Integer code, String message, String documentation) {
        this.code = code;
        this.message = message;
        this.documentation = documentation;
    }
}
