package com.xinlan.loaderdemo.core.net;

/**
 * 异常处理接口
 * 主要是網絡異常
 * @Title:
 * @Description:
 * @Author:11120500
 * @Since:2013-4-23
 * @Version:
 */
public interface ExceptionHandler// 异常处理接口
{// 全局的异常处理接口
    public void handleException(int _identity, Exception e);// 异常处理方法
}// 待扩充