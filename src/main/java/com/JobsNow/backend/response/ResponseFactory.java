package com.JobsNow.backend.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {

    public static ResponseEntity<BaseResponse> success(Object data) {
        BaseResponse res = new BaseResponse();
        res.setCode(200);
        res.setMessage("Success");
        res.setData(data);
        return ResponseEntity.ok(res);
    }

    public static ResponseEntity<BaseResponse> successMessage(String message) {
        BaseResponse res = new BaseResponse();
        res.setCode(200);
        res.setMessage(message);
        res.setData(null);
        return ResponseEntity.ok(res);
    }

    public static ResponseEntity<BaseResponse> error(int code, String message, HttpStatus status) {
        BaseResponse res = new BaseResponse();
        res.setCode(code);
        res.setMessage(message);
        res.setData(null);
        return ResponseEntity.status(status).body(res);
    }
}

