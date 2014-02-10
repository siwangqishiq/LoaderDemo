package com.xinlan.loaderdemo;

import com.xinlan.loaderdemo.core.net.DefaultNetworkRequest;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

public class NetRequest implements LoaderCallbacks<String>
{
    private MainActivity mMainActivity;
    public NetRequest(MainActivity mMainActivity){
        this.mMainActivity = mMainActivity;
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle bundle)
    {
        System.out.println("id--->"+id);
        DefaultNetworkRequest mHttpRequest = new DefaultNetworkRequest(
                "http://www.baidu.com");
        NetLoader netLoader = new NetLoader(mMainActivity,mHttpRequest);
        netLoader.setExceptionHandler(null);
        netLoader.setIdentit(MainActivity.NET_WORK);
        return netLoader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data)
    {
        mMainActivity.updateUI(MainActivity.NET_WORK, data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader)
    {   
        
    }
}//end class
