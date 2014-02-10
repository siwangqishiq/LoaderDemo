package com.xinlan.loaderdemo.core.net;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class ZLNetworkRequest
{
    String URL;
    public final String SSLCertificate;
    public final String PostData;
    public final Map<String, String> PostParameters = new HashMap<String, String>();
    public final Map<String, String> heads = new HashMap<String, String>();

    private final boolean myIsQuiet;

    protected ZLNetworkRequest(String url)
    {
        this(url, null, null, false);
    }

    protected ZLNetworkRequest(String url, boolean quiet)
    {
        this(url, null, null, quiet);
    }

    protected ZLNetworkRequest(String url, String sslCertificate,
            String postData)
    {
        this(url, null, null, false);
    }

    protected ZLNetworkRequest(String url, String sslCertificate,
            String postData, boolean quiet)
    {
        URL = url;
        SSLCertificate = sslCertificate;
        PostData = postData;
        myIsQuiet = quiet;
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public void addPostParameter(String name, String value)
    {
        PostParameters.put(name, value);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public void addHead(String name, String value)
    {
        heads.put(name, value);
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public String getURL()
    {
        return URL;
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public boolean isQuiet()
    {
        return myIsQuiet;
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public void doBefore() throws ZLNetworkException
    {
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public abstract void handleStream(InputStream inputStream, int length)
            throws IOException, ZLNetworkException;

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public void doAfter(boolean success) throws ZLNetworkException
    {
    }

    /**
     * 
     * @Description:
     * @Author Administrator
     * @Date 2013-4-29
     */
    public void setURL(String uRL)
    {
        URL = uRL;
    }
}
