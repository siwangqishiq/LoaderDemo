package com.xinlan.loaderdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
{
    public static final int NET_WORK=1;
    private ExpandableListView mExpandListView;
    private TextView mTextView;
    private ExpandableListAdapter mAdapter;
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    
    private void init(){
        mTextView = (TextView)findViewById(R.id.title);
        mWebView = (WebView)findViewById(R.id.web);
        WebSettings mWebSettings = mWebView.getSettings(); 
        mWebSettings.setJavaScriptEnabled(true); 
        mWebSettings.setBuiltInZoomControls(true); 
        mWebSettings.setSupportZoom(true); 
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebView.setHapticFeedbackEnabled(false); 
//        mExpandListView = (ExpandableListView)findViewById(R.id.expandListView);
        getSupportLoaderManager().restartLoader(NET_WORK, null, new NetRequest(this));
    }
    
    public void updateUI(int identity, Object data){
        String content = (String)data;
        mTextView.setText(content);
        mWebView.loadDataWithBaseURL(null,content, "text/html", "utf-8",null);
    }
}//end class
