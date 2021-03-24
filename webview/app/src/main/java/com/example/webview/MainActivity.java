package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "https://www.naver.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        //자바스크립트 허용
        webView.getSettings().setJavaScriptEnabled(true);
        //불러올 url설정
        webView.loadUrl(url);
        //크롬 환경에 맞춰주는 설정
        webView.setWebChromeClient(new WebChromeClient());

        //일반 웹뷰 설정
        webView.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //뒤로가기가 가능한 경우 뒤로가기.
        if((keyCode == KeyEvent.KEYCODE_BACK)&&(webView.canGoBack())){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //해당 함수 설정
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //해당 뷰에 url을 넣는다.
            view.loadUrl(url);
            return true;
        }
    }
}