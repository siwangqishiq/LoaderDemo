package com.xinlan.loaderdemo.core.net;

/**
 * 
 * @Title:
 * @Description:
 * @Author:Administrator
 * @Since:2013-5-2
 * @Version:
 */
public interface DataProtocol<D> // �����������ݻص��ӿ�
{// ������
    public D handle(String content) throws ZLNetworkException;// �׳������쳣
}
