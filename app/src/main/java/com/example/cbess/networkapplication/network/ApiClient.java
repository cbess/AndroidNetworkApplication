package com.example.cbess.networkapplication.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.cbess.networkapplication.R;
import com.example.cbess.networkapplication.model.ImageItem;

import org.json.JSONArray;

import java.util.List;

/**
 * Represents the API consumer object.
 */
public class ApiClient {
    private Context mContext;
    private RequestQueue mRequestQueue;
    private static ApiClient mApiClient;

    static {
        mApiClient = new ApiClient();
    }

    /**
     * Get shared ApiClient instance using default values.
     * @return Shared ApiClient instance.
     */
    public static ApiClient getDefault() {
        return mApiClient;
    }

    /**
     * Store the default context for the ApiClient shared instance.
     * @param context An application or activity context.
     */
    public static void useContext(Context context) {
        getDefault().mContext = context;
        getDefault().mRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * Request image items from the remote server.
     * @param listHandler The handler for the request.
     */
    public void requestImageItems(final ApiResponseListHandler<ImageItem> listHandler) {
        final String url = mContext.getResources().getString(R.string.images_items_url);
        mRequestQueue.add(new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // build items list
                List<ImageItem> imageItems = ImageItem.getImageItemsFromJson(response);
                listHandler.onSuccess(imageItems);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listHandler.onError(error.getLocalizedMessage());
            }
        }));
    }

    public interface ApiResponseListHandler<T> {
        abstract void onSuccess(List<T> objects);
        abstract void onError(String errorMessage);
    }
}
