package com.example.cbess.networkapplication.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.cbess.networkapplication.BR;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Represents an Image item model.
 */
public class ImageItem extends BaseObservable {
    private String mId;
    private String mTitle;
    private String mImageUrlString;

    public static ArrayList<ImageItem> getImageItemsFromJson(JSONArray objects) {
        ArrayList<ImageItem> items = new ArrayList<>();

        try {
            // build concrete objects from the json
            for (int idx = 0; idx < objects.length(); ++idx) {
                ImageItem imageItem = new ImageItem(objects.getJSONObject(idx));
                items.add(imageItem);
            }
        } catch (JSONException ex) {
            return null;
        }

        return items;
    }

    public ImageItem(JSONObject jsonObject) throws JSONException {
        loadJson(jsonObject);
    }

    protected void loadJson(JSONObject jsonObject) throws JSONException {
        mId = jsonObject.getString("_id");
        mTitle = jsonObject.getString("title");
        mImageUrlString = jsonObject.getString("imageUrl");
    }

    public void setImageUrlString(String imageUrlString) {
        mImageUrlString = imageUrlString;
        notifyPropertyChanged(BR.imageUrlString);
    }

    @Bindable
    public String getImageUrlString() {
        return mImageUrlString;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }
}
