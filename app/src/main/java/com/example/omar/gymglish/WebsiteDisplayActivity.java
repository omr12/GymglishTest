package com.example.omar.gymglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by Omar on 24/03/2016.
 */
public class WebsiteDisplayActivity extends Activity {

    public static final String EXTRA_URL = "WEBSITE_URL";

    private Button backButton;
    private Button forwardButton;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_display);

        webView = (WebView) findViewById(R.id.webView);
        backButton = (Button) findViewById(R.id.button_back);
        forwardButton = (Button) findViewById(R.id.button_forward);

        backButton.setOnClickListener(new BackButtonClickListener());
        forwardButton.setOnClickListener(new ForwardButtonClickListener());

        Intent intent = getIntent();
        String url = intent.getStringExtra(EXTRA_URL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://" + url);
    }

    // INNER CLASSES

    private class BackButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (webView.canGoBack()) {
                webView.goBack();
            }
        }
    } // BackButtonClickListener

    private class ForwardButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (webView.canGoForward()) {
                webView.goForward();
            }
        }
    } // ForwardButtonClickListener

}
