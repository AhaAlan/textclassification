package com.lacoders.textclassification.util;

import com.lacoders.textclassification.bean.base.Result;

public class ResultUtils {


    public static <T> Result<T> gatewaySuccess(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode(Result.ResultCode.GATEWAY_SUCCESS);

        return result;
    }

    public static <T> Result<T> successResult(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode(Result.ResultCode.SUCCESS);

        return result;
    }

    public static <T> Result<T> successMsg(T data, String msg) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode(Result.ResultCode.SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> failResult(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(message);

        return result;
    }

}