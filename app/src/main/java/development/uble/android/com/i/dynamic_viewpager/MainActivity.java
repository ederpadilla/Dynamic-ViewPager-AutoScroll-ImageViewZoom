package development.uble.android.com.i.dynamic_viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    private AutoScrollViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);

        List<MyFragment> fragments = new ArrayList<>();
        fragments.add((MyFragment) MyFragment.newInstance("http://fansports.com.mx/wp-content/uploads/2016/07/Jimena-Sanchez-3.jpg"));
        fragments.add((MyFragment) MyFragment.newInstance("http://cdn.referee.mx/wp-content/uploads/2016/08/jimena-sanchez-9.jpg"));
        fragments.add((MyFragment) MyFragment.newInstance("https://www.elsiglodetorreon.com.mx/m/i/2016/01/785546.jpeg"));
        fragments.add((MyFragment) MyFragment.newInstance("http://cdn.referee.mx/wp-content/uploads/2016/08/Jimena-Sanchez-4.jpg"));
        fragments.add((MyFragment) MyFragment.newInstance("http://www.pueblaonline.com.mx/2015/portal//media/k2/galleries_p/33728/thumb_front/js4.jpg"));

        adapter= new development.uble.android.com.i.dynamic_viewpager.PagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.startAutoScroll();
        viewPager.setDirection(AutoScrollViewPager.RIGHT);
        viewPager.setInterval(2500);
        viewPager.setBorderAnimation(true);

    }
}