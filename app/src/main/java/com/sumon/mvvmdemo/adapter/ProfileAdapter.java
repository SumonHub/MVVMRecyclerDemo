package com.sumon.mvvmdemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sumon.mvvmdemo.R;
import com.sumon.mvvmdemo.db.ProfileModel;

import java.util.List;
import java.util.Random;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    private Context mContext;
    private List<ProfileModel> albumList;
    private final int[] backgroundColors = {
            R.color.google_teal,
            R.color.google_green,
            R.color.google_blue_grey,
            R.color.google_cyan};


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public RelativeLayout relativeLayout;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            relativeLayout = view.findViewById(R.id.recycler_view);

        }
    }


    public ProfileAdapter(Context mContext, List<ProfileModel> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        ProfileModel profileModel = albumList.get(position);
        holder.title.setText(profileModel.getA() + "// position " + position);

        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        int bgColor = ContextCompat.getColor(mContext, backgroundColors[position % 4]);
        holder.relativeLayout.setBackgroundColor(bgColor);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}