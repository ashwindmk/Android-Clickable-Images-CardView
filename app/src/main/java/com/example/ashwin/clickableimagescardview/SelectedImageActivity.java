package com.example.ashwin.clickableimagescardview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class SelectedImageActivity extends AppCompatActivity {

    int res;
    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);

        res = getIntent().getIntExtra("res", 0);

        mImageView = (ImageView) findViewById(R.id.selectedImageView);

        Drawable bitmap = getResources().getDrawable(res);
        mImageView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        mAttacher = new PhotoViewAttacher(mImageView);

        mImageView.setImageResource(res);

        // If you later call mImageView.setImageDrawable/setImageBitmap/setImageResource/etc then you just need to call
        mAttacher.update();

    }

}
