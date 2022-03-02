package com.lacoders.textclassification.bean.base;

import lombok.ToString;

/**
 * @author liyitian
 * @version $Id: Result.java, v 0.1 2022年02月28日 上午11:28 liyitian Exp $$
 */
@ToString
public class Result<T> {

    /**
     * 成功标识
     */
    private Boolean success;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result() {

    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 执行成功
     *
     * @param
     * @return
     */
    public static Result success() {
        return new Result(ResultCode.SUCCESS, "执行成功");
    }

    /**
     * 执行成功
     *
     * @param succMsg
     * @return
     */
    public static Result success(String succMsg) {
        return new Result(ResultCode.SUCCESS, succMsg);
    }

    public static <T> Result<T> successResult(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);
        result.setCode(Result.ResultCode.SUCCESS);

        return result;
    }

    /**
     * 执行失败
     *
     * @param failMsg
     * @return
     */
    public static Result fail(String failMsg) {
        return new Result(ResultCode.FAIL, failMsg);
    }

    /**
     * 当前不需要执行
     *
     * @param filterMsg
     * @return
     */
    public static Result filtered(String filterMsg) {
        return new Result(ResultCode.FILTER, filterMsg);
    }

    /**
     * 是否是执行失败
     *
     * @return
     */
    public Boolean isFail() {
        return this.code == ResultCode.FAIL.intValue();
    }

    /**
     * 是否执行成功
     *
     * @return
     */
    public Boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.intValue();
    }

    /**
     * 是否别过滤掉未执行
     *
     * @return
     */
    public Boolean isFilter() {
        return this.code == ResultCode.FILTER.intValue();
    }

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public interface ResultCode {

        Integer GATEWAY_SUCCESS = 0;// 网关成功
        Integer SUCCESS = 200;//执行成功
        Integer FAIL = 500;//执行失败
        Integer FILTER = 800;//过滤 没有执行
    }

}
