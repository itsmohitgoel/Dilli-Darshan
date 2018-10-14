package com.example.mohitgoel.dillidarshan.adapters.utils;

import android.content.Context;

import com.example.mohitgoel.dillidarshan.R;
import com.example.mohitgoel.dillidarshan.models.PopularPlace;

import java.util.ArrayList;

/**
 * Created by Mohit Goel on 14-Oct-18.
 */

public class ContentManager {
    private static final String TAG = ContentManager.class.getSimpleName();

    private static volatile ContentManager INSTANCE;
    private ArrayList<PopularPlace> mPopularPlaces;
    private Context mContext;

    public static ContentManager getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ContentManager.class) {
                if (INSTANCE == null)
                    INSTANCE = new ContentManager(context);
            }
        }

        return INSTANCE;
    }

    private ContentManager(Context context) {
        mContext = context;
        mPopularPlaces = new ArrayList<>();

    }

    public ArrayList<PopularPlace> getPopularPlaces() {
        if (mPopularPlaces != null && mPopularPlaces.size() > 0) {
            return mPopularPlaces;
        }

        String[] placeTitles = mContext.getResources()
                .getStringArray(R.array.title_popular_places_array);
        String[] placeDescriptions = mContext.getResources()
                .getStringArray(R.array.description_popular_places_array);
        int[] placesImageResources = new int[]{
                R.drawable.img_place_1, R.drawable.img_place_2, R.drawable.img_place_3,
                R.drawable.img_place_4, R.drawable.img_place_5, R.drawable.img_place_6,
                R.drawable.img_place_7,R.drawable.img_place_8, R.drawable.img_place_9,
                R.drawable.img_place_10};

        for (int i = 0; i < placeTitles.length; i++) {
            PopularPlace place = new PopularPlace();
            place.setTitle(placeTitles[i]);
            place.setDescription(placeDescriptions[i]);
            place.setImageResId(placesImageResources[i]);
            mPopularPlaces.add(place);
        }

        return mPopularPlaces;
    }
}
