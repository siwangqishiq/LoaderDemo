package com.xinlan.loaderdemo;

import android.content.Context;

import com.xinlan.loaderdemo.core.net.HttpRequestLoader;
import com.xinlan.loaderdemo.core.net.ZLNetworkException;
import com.xinlan.loaderdemo.core.net.ZLNetworkRequest;

public class NetLoader extends HttpRequestLoader<String>
{

    public NetLoader(Context context, ZLNetworkRequest _HttpRequest)
    {
        super(context, _HttpRequest);
    }

    @Override
    public String handle(String content) throws ZLNetworkException
    {
        return content;
    }
}//end class
