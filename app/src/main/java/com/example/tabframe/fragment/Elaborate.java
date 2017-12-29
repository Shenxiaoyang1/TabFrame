package com.example.tabframe.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tabframe.R;
import com.example.tabframe.app.FragmentAdater;
import com.example.tabframe.app.ViewPagerIndicator;

import java.util.ArrayList;

/**
 * Created by 申晓杨 on 2017/12/28.
 */

public class Elaborate extends Fragment {

    private ViewPagerIndicator mIndicator;//导航栏指示器
    private TextView live;
    private TextView video;
    private TextView sameCity;
    Live zhiBo;
    Video shiPin;
    SameCity tongCheng;
    ViewPager mViewPager ;
    ArrayList<Fragment> flist;
    FragmentPagerAdapter mAdapter;
    //定义两个颜色和大小
    private int colorA = Color.parseColor("#ff00ff");//选中的颜色
    private int colorB = Color.WHITE;//默认的颜色
    private float sizeA = 19f;//选中大小
    private float sizeB = 16f;//默认大小
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.elaborate,container,false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mIndicator = (ViewPagerIndicator) view.findViewById(R.id.id_indicator);
        live = (TextView) view.findViewById(R.id.live);
        video = (TextView) view.findViewById(R.id.video);
        sameCity = (TextView) view.findViewById(R.id.sameCity);
        FragmentManager man = getActivity().getSupportFragmentManager();
        flist=new ArrayList<Fragment>();
        flist.add(zhiBo);
        flist.add(shiPin);
        flist.add(tongCheng);
        initViews();
        setListener();
        return view;
    }
    private void initViews() {
        //3个标题
        shiPin = new Video();
        zhiBo = new Live();
        tongCheng = new SameCity();
        flist = new ArrayList<>();
        flist.add(shiPin);
        flist.add(zhiBo);
        flist.add(tongCheng);
        mAdapter = new FragmentAdater(getChildFragmentManager(),flist);
        mViewPager.setAdapter(mAdapter);
        //设置默认页面和颜色
        mViewPager.setCurrentItem(0);
        setTextAttribute(colorA,colorB,colorB,sizeA,sizeB,sizeB);
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mViewPager.setCurrentItem(0);
               // Toast.makeText(getActivity(), "wode", Toast.LENGTH_SHORT).show();
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mViewPager.setCurrentItem(1);
               // Toast.makeText(getActivity(), "wode1", Toast.LENGTH_SHORT).show();
            }
        });
        sameCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });
    }

    private void setListener() {
        //ViewPager的监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //让indicator和ViewPager联动
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setTextAttribute(colorA,colorB,colorB,sizeA,sizeB,sizeB);
                        break;
                    case 1:
                        setTextAttribute(colorB,colorA,colorB,sizeB,sizeA,sizeB);
                        break;
                    case 2:
                        setTextAttribute(colorB,colorB,colorA,sizeB,sizeB,sizeA);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
    /**
     * 自己定义一个给textView设置属性的方法
     */
    private void setTextAttribute(int color1, int color2, int color3,  float size1, float size2, float size3){
        live.setTextColor(color1);
        video.setTextColor(color2);
        sameCity.setTextColor(color3);
        live.setTextSize(size1);
        video.setTextSize(size2);
        sameCity.setTextSize(size3);

    }
}
