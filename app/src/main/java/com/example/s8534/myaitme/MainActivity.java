package com.example.s8534.myaitme;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView myhome,classify,order,homepage;

WebView webfeilei,webdingdan;

RelativeLayout fenlei,mein;

ConstraintLayout sousuolan,homepages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉默认的标题栏
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)actionBar.hide();

        //找到主页和分类所在的有搜索栏的布局的id和
        //主页和分类的布局的id
        //订单web的id
        //个人中心的布局的id
        sousuolan=findViewById(R.id.yousuosou);
        homepages=findViewById(R.id.shouye);
        fenlei=findViewById(R.id.fenlei_webs);
        webdingdan=findViewById(R.id.webdingdans);
        mein=findViewById(R.id.mein);

        //找到在分类布局下的分类web的id
        webfeilei=findViewById(R.id.webfenlei);

        //设置主页和分类布局所在的大布局为可见
        //大布局为可见初始主页布局为可见
        //分类布局为不可见
        //订单web为不可见
        //个人中心布局为不可见
        sousuolan.setVisibility(View.VISIBLE);
        homepages.setVisibility(View.VISIBLE);
        fenlei.setVisibility(View.GONE);
        webdingdan.setVisibility(View.GONE);
        mein.setVisibility(View.GONE);

        //设置分类web的js功能可以使用
        //设置分类web的打开方式为内置在app打开
        webfeilei.getSettings().setJavaScriptEnabled(true);
        webfeilei.setWebViewClient(new WebViewClient());

        //设置订单web的js功能可以使用
        //设置订单web的打开方式为内置在app打开
        webdingdan.getSettings().setJavaScriptEnabled(true);
        webdingdan.setWebViewClient(new WebViewClient());

        //点击主页返回到主页就是把其他布局全部隐藏
        homepage=findViewById(R.id.home_page);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sousuolan.setVisibility(View.VISIBLE);
                homepages.setVisibility(View.VISIBLE);
                fenlei.setVisibility(View.GONE);
                webdingdan.setVisibility(View.GONE);
                mein.setVisibility(View.GONE);
            }
        });
        //点击分类进入到分类网页把其他布局全部隐藏
        classify=findViewById(R.id.classification);
        classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webfeilei.loadUrl("http://spk18384229726.gz01.bdysite.com/html/class/index.htm");
                sousuolan.setVisibility(View.VISIBLE);
                homepages.setVisibility(View.GONE);
                fenlei.setVisibility(View.VISIBLE);
                webdingdan.setVisibility(View.GONE);
                mein.setVisibility(View.GONE);
            }
        });
        //点击订单进入到订单网页把其他布局全部隐藏
        order=findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webdingdan.loadUrl("http://spk18384229726.gz01.bdysite.com/html/RollCall/RollCall.html");
                sousuolan.setVisibility(View.GONE);
                homepages.setVisibility(View.GONE);
                fenlei.setVisibility(View.GONE);
                webdingdan.setVisibility(View.VISIBLE);
                mein.setVisibility(View.GONE);
            }
        });

        //设置打开个人中心把其他布局全部隐藏
        myhome=findViewById(R.id.My);
        myhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sousuolan.setVisibility(View.GONE);
                homepages.setVisibility(View.GONE);
                fenlei.setVisibility(View.GONE);
                webdingdan.setVisibility(View.GONE);
                mein.setVisibility(View.VISIBLE);
            }
        });
    }
}
