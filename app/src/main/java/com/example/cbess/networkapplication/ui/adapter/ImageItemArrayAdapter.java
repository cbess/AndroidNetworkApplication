package com.example.cbess.networkapplication.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.cbess.networkapplication.model.ImageItem;
import com.example.cbess.networkapplication.ui.view.ImageItemRowView;

import java.util.List;

/**
 * Represents the ImageItem list.
 */
public class ImageItemArrayAdapter extends ArrayAdapter<ImageItem> {
    public ImageItemArrayAdapter(Context context, List<ImageItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageItem imageItem = getItem(position);
        ImageItemRowView rowView = (ImageItemRowView) convertView;

        // create a new row, if needed, otherwise use cached view
        if (rowView == null) {
            rowView = new ImageItemRowView(getContext(), imageItem);
        } else {
            rowView.setImageItem(imageItem);
        }

        return rowView;
    }
}
