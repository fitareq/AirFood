package com.airmoll.airfood;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.airmoll.airfood.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    PreferenceManager preferenceManager;

    int[] images = {R.drawable.menu,R.drawable.order,R.drawable.menu};
    TextView[] bottomBars;
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(v);

        mViewPagerAdapter = new ViewPagerAdapter(images,this);
        binding.viewpager.setAdapter(mViewPagerAdapter);
        preferenceManager = new PreferenceManager(this);

        /*if (!preferenceManager.FirstLaunch())
        {
            launchMain();
            finish();
        }*/
        ColoredBars(0);

        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ColoredBars(position);
                /*if (position==0)
                    binding.back.setVisibility(View.GONE);
                else
                    binding.back.setVisibility(View.VISIBLE);*/
                if (position==images.length-1)
                    binding.next.setText(R.string.get_started);
                else binding.next.setText(R.string.next);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        binding.next.setOnClickListener(v12 -> {
            String s = binding.next.getText().toString();
            if (s.equalsIgnoreCase("get started"))
                launchMain();
            int i = binding.viewpager.getCurrentItem();
            binding.viewpager.setCurrentItem(i+1);
        });
        binding.skip.setOnClickListener(v1 -> {
            launchMain();
        });

       /* binding.back.setOnClickListener(v1 -> {`
            int i = binding.viewpager.getCurrentItem();
            binding.viewpager.setCurrentItem(i-1);
        });*/





    }

    private void launchMain()
    {
        preferenceManager.setFirstLaunch(false);
        startActivity(new Intent(IntroActivity.this,MainActivity.class));
        finish();
    }

    private void ColoredBars(int thisScreen)
    {
        int ColorsInactive = getResources().getColor(R.color.dot_on_page_not_active);
        int colorsActive = getResources().getColor(R.color.dot_on_page_active);
        bottomBars = new TextView[images.length];
        binding.layoutBars.removeAllViews();
        for (int i = 0; i<bottomBars.length; i++)
        {
            bottomBars[i]=new TextView(IntroActivity.this);
            bottomBars[i].setTextSize(50);
            bottomBars[i].setText(Html.fromHtml("-"));
            bottomBars[i].setTextColor(ColorsInactive);
            binding.layoutBars.addView(bottomBars[i]);
        }
        if (bottomBars.length>0)
            bottomBars[thisScreen].setTextColor(colorsActive);
    }
}