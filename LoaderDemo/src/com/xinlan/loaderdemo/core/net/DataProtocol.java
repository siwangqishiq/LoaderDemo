package com.xinlan.loaderdemo.core.net;

/**
 * 
 * @Title:
 * @Description:
 * @Author:Administrator
 * @Since:2013-5-2
 * @Version:
 */
public interface DataProtocol<D> // 网络请求数据回调接口
{// 待扩充
    public D handle(String content) throws ZLNetworkException;// 抛出网络异常
}
