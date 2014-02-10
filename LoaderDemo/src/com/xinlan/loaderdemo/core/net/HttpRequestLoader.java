package com.xinlan.loaderdemo.core.net;

import com.xinlan.loaderdemo.MainActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.AsyncTaskLoader;
import android.view.View;
import android.widget.Toast;

/**
 * ����������
 * 
 * @Title:
 * @Description:
 * @Author:11120500
 * @Since:2013-4-24
 * @Version:
 */
public abstract class HttpRequestLoader<D> extends AsyncTaskLoader<D> implements
        DataProtocol<D>
{
    D mData;
    private ZLNetworkRequest httpRequest;
    private ExceptionHandler exceptionHandler;
    private int identity;
    private boolean mIsImage = false;
    private MainActivity mContext;

    public HttpRequestLoader(Context context, ZLNetworkRequest _HttpRequest)
    {
        super(context);
        mContext = (MainActivity) context;
        this.httpRequest = _HttpRequest;
        this.identity = this.getId();
    }

    public static boolean isConnect(Context context)
    {
        // ��ȡ�ֻ��������ӹ�����󣨰�����wi-fi,net�����ӵĹ���
        try
        {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null)
            {
                // ��ȡ�������ӹ���Ķ���
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected())
                {
                    // �жϵ�ǰ�����Ƿ��Ѿ�����
                    if (info.getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        catch (Exception e)
        {

        }
        return false;
    }

    @Override
    public D loadInBackground()
    {
        if (isConnect(mContext))
        {
            try
            {
                Object object = (D) ZLNetworkManager.Instance().perform(
                        httpRequest, this,  false);
                return (D) object;
            }
            catch (ZLNetworkException e)
            {
                handleException(identity, e);
            }
        }
        else
        {
            handleException(identity, new ZLNetworkException(
                    ZLNetworkException.NETWORK_DISCONNECT));
        }
        return null;
    }

    /**
     * ����һ���µ�ֵ�ύ���ͻ���ʱ���ô˷��� �ڸ����н�ά������ύֵ; ��������д����һЩ��Դ�ͷŵ��߼�
     */
    @Override
    public void deliverResult(D data)
    {
        if (isReset())
        {

            if (data != null)
            {
                onReleaseResources(data);
            }
        }
        D oldData = mData;
        mData = data;

        if (isStarted())
        {
            super.deliverResult(data);
        }

        if (oldData != null)
        {
            onReleaseResources(oldData);
        }
    }

    /**
     * ��������������
     */
    @Override
    protected void onStartLoading()
    {
        if (mData != null)
        {
            // �������һ����Ч�Ľ���������ύ��
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null)
        {
            // ������Ѿ����ص�ʱ�俪ʼ�иı���ߵ�ǰ�Ľ���ֵ��Ч������һ��������
            forceLoad();
        }
    }

    /**
     * ����һ��ֹͣ���ص�����
     */
    @Override
    protected void onStopLoading()
    {
        // ȡ����ǰ��������
        cancelLoad();
    }

    /**
     * ����ȡ������
     */
    @Override
    public void onCanceled(D data)
    {
        super.onCanceled(data);

        // �ͷ���Դ �������Ҫ��
        onReleaseResources(data);
    }

    /**
     * ����ȫ������
     */
    @Override
    protected void onReset()
    {
        super.onReset();

        // ȷ���������Ѿ�ֹͣ
        onStopLoading();

        // �ͷ���Դ �������Ҫ��
        if (mData != null)
        {
            onReleaseResources(mData);
            mData = null;
        }
    }

    /**
     * �ͷ���Դ
     */
    protected void onReleaseResources(D data)
    {
        // ������Դ�ͷ� �� cursor �� �� �Ĺر�
    }

    protected void handleException(int _identity, Exception e)
    {
        if (null != exceptionHandler)
        {

            exceptionHandler.handleException(_identity, e);

        }
    }

    public ZLNetworkRequest getHttpRequest()
    {
        return httpRequest;
    }

    public void setHttpRequest(ZLNetworkRequest httpRequest)
    {
        this.httpRequest = httpRequest;
    }

    public ExceptionHandler getExceptionHandler()
    {
        return exceptionHandler;
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler)
    {
        this.exceptionHandler = exceptionHandler;
    }

    public int getIdentit()
    {
        return identity;
    }

    public void setIdentit(int identit)
    {
        this.identity = identit;
    }

}
