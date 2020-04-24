package com.imma.elastics.base;

import lombok.Data;

/**
 * api格式粉装
 */
@Data
public class ApiResponse {
    private Integer code;

    private String message;

    private Object data;

    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    /**
     * 请求成功 不返回数据
     * @param code
     * @param message
     * @return
     */
    public static ApiResponse ofMessage(Integer code, String message) {
        return new ApiResponse(code, message, null);
    }

    /**
     * 请求成功返回数据
     * @param data
     * @return
     */
    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    /**
     * 请求成功 返回自定义状态
     * @param status
     * @return
     */
    public static ApiResponse ofStatus(Status status){
        return new ApiResponse(status.getCode(),status.getStandardMessage(),null);
    }

    public enum Status {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        INTERNAL_SERVER_ERROR(500, "Unknown Server Error"),
        NOT_VALID_PARAM(5001, "Not Valid Param"),
        NOT_SUPPORT_OPERATOR(5002, "Not Support Operator"),
        NOT_LOGIN(5003, "Not Login");

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
