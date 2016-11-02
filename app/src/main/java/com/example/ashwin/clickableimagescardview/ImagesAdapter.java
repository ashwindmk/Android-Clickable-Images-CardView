package com.example.ashwin.clickableimagescardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ashwin on 2/11/16.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {

    private List<Image> imagesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    public ImagesAdapter(List<Image> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.images_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Image image = imagesList.get(position);
        holder.mImageView.setImageResource(image.getRes());
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

}
