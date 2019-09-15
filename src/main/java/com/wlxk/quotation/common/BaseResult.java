package com.wlxk.quotation.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 鼠行止
 * @date: 2019/9/14
 */
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -5398289762718706504L;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 数据
     */
    private T data;
    /**
     * 错误码
     */
    private String errCode;
    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 查询条件
     */
    private BaseQuery query;

    public static <T> BaseResult ok(T data, BaseQuery query) {
        BaseResult<T> result = new BaseResult<>();
        result.setData(data);
        result.setQuery(query);
        result.setSuccess(true);
        return result;
    }

    public static BaseResult ok() {
        return ok((Object) null);
    }

    public static <T> BaseResult ok(T data) {
        return ok(data, (BaseQuery) null);
    }

}
