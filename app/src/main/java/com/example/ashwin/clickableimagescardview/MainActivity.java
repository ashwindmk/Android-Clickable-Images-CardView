package com.example.ashwin.clickableimagescardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Image> imagesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ImagesAdapter(imagesList);
        mRecyclerView.setAdapter(mAdapter);

        prepareImagesData();

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Image image = imagesList.get(position);
                Toast.makeText(getApplicationContext(), image.getRes() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SelectedImageActivity.class);
                intent.putExtra("res", image.getRes());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Image image = imagesList.get(position);
                Toast.makeText(getApplicationContext(), image.getRes() + " is selected!\nAwesome", Toast.LENGTH_LONG).show();
            }
        }));
    }

    private void prepareImagesData() {
        Image img = new Image(R.drawable.image1);
        imagesList.add(img);

        img = new Image(R.drawable.image2);
        imagesList.add(img);

        img = new Image(R.drawable.image3);
        imagesList.add(img);

        img = new Image(R.drawable.image4);
        imagesList.add(img);

        img = new Image(R.drawable.image5);
        imagesList.add(img);

        mAdapter.notifyDataSetChanged();
    }
}
