package com.example.mohitgoel.dillidarshan.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitgoel.dillidarshan.R;
import com.example.mohitgoel.dillidarshan.adapters.utils.ContentManager;
import com.example.mohitgoel.dillidarshan.models.PopularPlace;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for Playlist Screen.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    private ArrayList<PopularPlace> mAllPlaces;
    LayoutInflater mLayoutInflater;

    public CategoryListAdapter(Context context) {
//        mContext = context;
//        this.allMusicItems = MusicManager.getInstance(context).getMusicItems();
        mLayoutInflater = LayoutInflater.from(context);
        mAllPlaces = ContentManager.getInstance(context).getPopularPlaces();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.page_one_list_item, parent, false);

        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bindCategory(mAllPlaces.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mAllPlaces.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.background_image_view)
        ImageView backgroundImageView;
        @BindView(R.id.favourite_button)
        ImageView favouriteButton;
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.description_text_view)
        TextView descriptionTextView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindCategory(PopularPlace placeToVisit, int position) {
//            if (position == 0) {
//                topSeparatorView.setVisibility(View.VISIBLE);
//            }

            titleTextView.setText(placeToVisit.getTitle());
            descriptionTextView.setText(placeToVisit.getDescription());
//            Bitmap tempBitmap = BitmapFactory.decodeResource(mLayoutInflater
//                    .getContext().getResources(), R.drawable.alan_walker);
            Drawable imageDrawable = mLayoutInflater.getContext().getResources()
                    .getDrawable(placeToVisit.getImageResId());
            backgroundImageView.setImageDrawable(imageDrawable);
        }
    }

}
