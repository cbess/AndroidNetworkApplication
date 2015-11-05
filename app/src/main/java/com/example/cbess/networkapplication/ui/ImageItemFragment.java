package com.example.cbess.networkapplication.ui;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.cbess.networkapplication.model.ImageItem;
import com.example.cbess.networkapplication.network.ApiClient;
import com.example.cbess.networkapplication.ui.adapter.ImageItemArrayAdapter;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ImageItemFragment extends ListFragment {
    public static final String TAG = ImageItemFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private ImageItemArrayAdapter mItemArrayAdapter;

    public static ImageItemFragment newInstance() {
        return new ImageItemFragment();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ImageItemFragment() {
        // empty
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mItemArrayAdapter == null) {
            fetchImages();
        } else {
            setListAdapter(mItemArrayAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        if (mListener != null) {
            // Notify the active callbacks interface that an item has been selected.
            mListener.onFragmentInteraction(mItemArrayAdapter.getItem(position));
        }
    }

    public void setFragmentInteractionListener(OnFragmentInteractionListener listener) {
        mListener = listener;
    }

    private void fetchImages() {
        getActivity().setProgressBarIndeterminateVisibility(true);

        Log.i(TAG, "Fetching images");

        ApiClient.getDefault().requestImageItems(new ApiClient.ApiResponseListHandler<ImageItem>() {
            @Override
            public void onSuccess(List<ImageItem> objects) {
                mItemArrayAdapter = new ImageItemArrayAdapter(getActivity(), objects);
                setListAdapter(mItemArrayAdapter);

                getActivity().setProgressBarIndeterminateVisibility(false);

                Log.i(TAG, String.format("Done fetching %d images", objects.size()));
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, "Error fetching images: " + errorMessage);
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(ImageItem item);
    }

}
