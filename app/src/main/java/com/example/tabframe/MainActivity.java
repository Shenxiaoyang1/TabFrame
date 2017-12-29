package com.example.tabframe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tabframe.fragment.Elaborate;
import com.example.tabframe.fragment.Project;
import com.example.tabframe.fragment.Add;
import com.example.tabframe.fragment.Find;
import com.example.tabframe.fragment.Mine;
import com.hjm.bottomtabbar.BottomTabBar;


public class MainActivity extends AppCompatActivity {
    BottomTabBar bottomtabbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomtabbar = findViewById(R.id.bottomTabBar);
        bottomtabbar.init(getSupportFragmentManager())
                .setImgSize(40, 40)
                .setFontSize(20)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.BLACK)
                .addTabItem("精选", R.drawable.ic_discovery_gray, Elaborate.class)
                .addTabItem("专题", R.drawable.ic_library_gray, Project.class)
                .addTabItem("发布",R.drawable.lingdang, Mine.class)
                .addTabItem("发现", R.drawable.ic_more_gray, Add.class)
                .addTabItem("我的", R.drawable.ic_news_gray, Find.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }
}
