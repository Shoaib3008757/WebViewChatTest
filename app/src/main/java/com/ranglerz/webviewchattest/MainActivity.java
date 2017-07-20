package com.ranglerz.webviewchattest;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings mWebSettings = mWebView.getSettings();

        mWebSettings.setJavaScriptEnabled(true);


        mWebView.addJavascriptInterface(new Object() {

            public void startMap() {
                Intent mIntent = new Intent();
                ComponentName component = new ComponentName(
                        "com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity");
                mIntent.setComponent(component);
                startActivity(mIntent);
            }
        }, "demo");

        mWebView.loadUrl("file:///android_asset/chatscript.html");
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mWebView.loadUrl("javascript:fillContent()");
            }
        });
    }

}