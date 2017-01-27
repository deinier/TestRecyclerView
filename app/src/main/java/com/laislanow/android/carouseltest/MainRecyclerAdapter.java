package com.laislanow.android.carouseltest;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dmorales on 1/23/2017.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<Item> mItems;

    Context mContext;

    public MainRecyclerAdapter(Context context, List<Item> objects) {

        mContext = context;

        mItems = objects;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;

        public TextView mTitleTextView;

        public TextView mDescriptionTextView;

        public View rootView;

        public ViewHolder(View itemView) {

            super(itemView);

            rootView = itemView;

            mImageView =(ImageView)itemView.findViewById(R.id.image);

            mTitleTextView =(TextView)itemView.findViewById(R.id.title);

            mDescriptionTextView =(TextView)itemView.findViewById(R.id.description);
        }
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = mItems.get(position);

//		Picasso.with(mContext).load(item.getImageUri()).into(holder.mImageView);
//		int drawableResourceId = mContext.getResources().getIdentifier(item.getImageUri(), "drawable", mContext.getPackageName());

        Picasso.with(mContext).load(item.getResId()).into(holder.mImageView);

        holder.mTitleTextView.setText(item.getTitle());

        holder.mDescriptionTextView.setText(item.getDescription());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View convertView = inflater.inflate(R.layout.item, parent, false);

        return new ViewHolder(convertView);
    }
}
