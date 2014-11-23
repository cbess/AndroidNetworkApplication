package com.example.cbess.networkapplication.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cbess.networkapplication.R;
import com.example.cbess.networkapplication.model.ImageItem;
import com.squareup.picasso.Picasso;

/**
 * Represents the image item row view.
 */
public class ImageItemRowView extends LinearLayout {
    private ImageItem mImageItem;

    public ImageItemRowView(Context ctx) {
        super(ctx);
    }

    public ImageItemRowView(Context ctx, ImageItem imageItem) {
        this(ctx);

        LayoutInflater.from(ctx).inflate(R.layout.view_image_item_row, this, true);
        setImageItem(imageItem);
    }

    private void loadView() {
        // title
        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(getImageItem().getTitle());
        titleTextView.setSelected(true);

        // image
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Picasso picasso = Picasso.with(getContext());
        picasso.load(getImageItem().getImageUrlString())
                .into(imageView);
    }

    public void setImageItem(ImageItem imageItem) {
        mImageItem = imageItem;
        loadView();
    }

    public ImageItem getImageItem() {
        return mImageItem;
    }
}
