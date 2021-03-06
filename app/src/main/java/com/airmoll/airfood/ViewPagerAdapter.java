package com.airmoll.airfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    int[] images;
    String[] text = {"Your Favourite Food delivery Partner", "Giving your Hunger a new Option", "Why starve when you have us?"};
    Context context;
    LayoutInflater mLayoutInflater;

    public ViewPagerAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.slider,container,false);
        ImageView imageView = itemView.findViewById(R.id.slider_image);
        TextView textView = itemView.findViewById(R.id.slider_text);
        imageView.setImageResource(images[position]);
        textView.setText(text[position]);
        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}
