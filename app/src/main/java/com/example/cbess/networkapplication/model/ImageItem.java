package com.example.cbess.networkapplication.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Represents an Image item model.
 */
public class ImageItem {
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
