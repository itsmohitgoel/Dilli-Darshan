package com.example.mohitgoel.dillidarshan.adapters.utils;

import android.content.Context;

import com.example.mohitgoel.dillidarshan.R;
import com.example.mohitgoel.dillidarshan.models.Attraction;

import java.util.ArrayList;

/**
 * Created by Mohit Goel on 14-Oct-18.
 */

public class ContentManager {
    private static volatile ContentManager INSTANCE;
    private ArrayList<Attraction> mPopularPlaces;
    private ArrayList<Attraction> mEvents;
    private ArrayList<Attraction> mBars;
    private ArrayList<Attraction> mRestaurants;
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
        mEvents = new ArrayList<>();
        mBars = new ArrayList<>();
        mRestaurants = new ArrayList<>();

    }

    public ArrayList<Attraction> getAttractions(int pageNumber) {
        switch (pageNumber) {
            case 1:
                return getPopularPlaces();
            case 2:
                return getEvents();
            case 3:
                return getBars();
            case 4:
                return getRestaurants();
            default:
                break;
        }

        return null;
    }

    private ArrayList<Attraction> getPopularPlaces() {
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
                R.drawable.img_place_7, R.drawable.img_place_8, R.drawable.img_place_9,
                R.drawable.img_place_10};

        for (int i = 0; i < placeTitles.length; i++) {
            Attraction place = new Attraction();
            place.setTitle(placeTitles[i]);
            place.setDescription(placeDescriptions[i]);
            place.setImageResId(placesImageResources[i]);
            mPopularPlaces.add(place);
        }

        return mPopularPlaces;
    }

    private ArrayList<Attraction> getEvents() {
        if (mEvents != null && mEvents.size() > 0) {
            return mEvents;
        }

        String[] eventTitles = mContext.getResources()
                .getStringArray(R.array.title_events_array);
        String[] eventDescriptions = mContext.getResources()
                .getStringArray(R.array.description_events_array);
        int[] eventsImageResources = new int[]{
                R.drawable.img_event_1, R.drawable.img_event_2, R.drawable.img_event_3,
                R.drawable.img_event_4};

        for (int i = 0; i < eventTitles.length; i++) {
            Attraction event = new Attraction();
            event.setTitle(eventTitles[i]);
            event.setDescription(eventDescriptions[i]);
            event.setImageResId(eventsImageResources[i]);
            mEvents.add(event);
        }

        return mEvents;
    }

    private ArrayList<Attraction> getBars() {
        if (mBars != null && mBars.size() > 0) {
            return mBars;
        }

        String[] barTitles = mContext.getResources()
                .getStringArray(R.array.title_bars_array);
        String[] barDescriptions = mContext.getResources()
                .getStringArray(R.array.description_bars_array);
        int[] barImageResources = new int[]{
                R.drawable.img_bar_1, R.drawable.img_bar_2, R.drawable.img_bar_3,
                R.drawable.img_bar_4};

        for (int i = 0; i < barTitles.length; i++) {
            Attraction bar = new Attraction();
            bar.setTitle(barTitles[i]);
            bar.setDescription(barDescriptions[i]);
            bar.setImageResId(barImageResources[i]);
            mBars.add(bar);
        }

        return mBars;
    }

    private ArrayList<Attraction> getRestaurants() {
        if (mRestaurants != null && mRestaurants.size() > 0) {
            return mRestaurants;
        }

        String[] restaurantTitles = mContext.getResources()
                .getStringArray(R.array.title_restaurants_array);
        String[] restaurantDescriptions = mContext.getResources()
                .getStringArray(R.array.description_restaurants_array);
        int[] restaurantImageResources = new int[]{
                R.drawable.img_restaurant_1, R.drawable.img_restaurant_2, R.drawable.img_restaurant_3,
                R.drawable.img_restaurant_4, R.drawable.img_restaurant_5};

        for (int i = 0; i < restaurantTitles.length; i++) {
            Attraction restaurant = new Attraction();
            restaurant.setTitle(restaurantTitles[i]);
            restaurant.setDescription(restaurantDescriptions[i]);
            restaurant.setImageResId(restaurantImageResources[i]);
            mRestaurants.add(restaurant);
        }

        return mRestaurants;
    }
}
