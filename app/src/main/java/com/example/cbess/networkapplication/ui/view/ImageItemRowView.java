package com.example.cbess.networkapplication.ui.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.cbess.networkapplication.databinding.ViewImageItemRowBinding;
import com.example.cbess.networkapplication.model.ImageItem;
import com.squareup.picasso.Picasso;

/**
 * Represents the image item row view.
 */
public class ImageItemRowView extends LinearLayout {
    // Generated from view_image_item_row.xml
    private ViewImageItemRowBinding mBinding;

    // When this class is compiled, the BindingAdapter will be available and executed when used.
    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageButton view, String url) {
        Picasso.with(view.getContext()).load(url).into(view);
    }

    public ImageItemRowView(Context ctx) {
        super(ctx);
    }

    public ImageItemRowView(Context ctx, ImageItem imageItem) {
        this(ctx);

        mBinding = ViewImageItemRowBinding.inflate(LayoutInflater.from(ctx), this, true);
        setImageItem(imageItem);
    }

    private void loadView() {
        mBinding.title.setSelected(true);
    }

    public void setImageItem(ImageItem imageItem) {
        mBinding.setItem(imageItem);

        // perform custom updating
        loadView();
    }

}
