package com.xinlan.loaderdemo.core.net;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @Title:
 * @Description:
 * @Author:Administrator
 * @Since:2013-5-2
 * @Version:
 */
public class DefaultNetworkRequest extends ZLNetworkRequest
{

    public DefaultNetworkRequest(String url)
    {
        this(url, null, null, false);
    }

    public DefaultNetworkRequest(String url, boolean quiet)
    {
        this(url, null, null, quiet);
    }

    public DefaultNetworkRequest(String url, String postData)
    {
        this(url, null, postData, false);
    }

    public DefaultNetworkRequest(String url, String sslCertificate,
            String postData)
    {
        this(url, sslCertificate, postData, false);
    }

    public DefaultNetworkRequest(String url, String sslCertificate,
            String postData, boolean quiet)
    {
        super(url, sslCertificate, postData, quiet);

    }

    @Override
    public void handleStream(InputStream inputStream, int length)
            throws IOException, ZLNetworkException
    {

    }

}
