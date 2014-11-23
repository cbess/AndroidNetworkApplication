package com.example.cbess.networkapplication.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Image item model.
 */
public class ImageItem {
    private String mId;
    private String mTitle;
    private String mImageUrlString;
    private String mColorName;
    private int mSortOrder;

    public static ArrayList<ImageItem> getImageItemsFromJson(JSONArray objects) {
        ArrayList<ImageItem> items = new ArrayList<ImageItem>();

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
        mSortOrder = jsonObject.getInt("sortOrder");
        mColorName = jsonObject.getString("color");
        mTitle = jsonObject.getString("title");
        mImageUrlString = jsonObject.getString("imageUrl");
    }

    public int getSortOrder() {
        return mSortOrder;
    }

    public String getColorName() {
        return mColorName;
    }

    public String getImageUrlString() {
        return mImageUrlString;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }
}