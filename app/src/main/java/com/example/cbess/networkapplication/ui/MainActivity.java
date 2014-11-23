package com.example.cbess.networkapplication.ui;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;

import com.example.cbess.networkapplication.R;
import com.example.cbess.networkapplication.model.ImageItem;
import com.example.cbess.networkapplication.network.ApiClient;


public class MainActivity extends Activity implements ImageItemFragment.OnFragmentInteractionListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        ApiClient.useContext(this);

        if (savedInstanceState == null) {
            ImageItemFragment fragment = ImageItemFragment.newInstance();
            fragment.setFragmentInteractionListener(this);

            // show the main fragment
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(ImageItem item) {
        Log.d(TAG, "Clicked: " + item.getTitle());
    }
}
