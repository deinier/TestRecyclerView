package com.laislanow.android.carouseltest;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    int numOfColumns = 10;

    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feed);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView_row);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        List<Item> listOfItems = new ArrayList<>();

        for(int j = 0 ; j<numOfColumns ; j++){

            int drawableResourceId = this.getResources().getIdentifier("img"+String.valueOf(1+j), "drawable", this.getPackageName());

            Item item = new Item("img" + String.valueOf(j+1), String.valueOf(1+j), drawableResourceId, "Test description");

            listOfItems.add(item);
        }

        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(this, listOfItems);

        mRecyclerView.setAdapter(mainRecyclerAdapter);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, mLayoutManager.getOrientation()) {

                    @Override
                    public void getItemOffsets(Rect outRect, android.view.View view, RecyclerView parent, RecyclerView.State state) {

                        int position = parent.getChildAdapterPosition(view);

                        // hide the divider for the last child
                        if (position == parent.getAdapter().getItemCount() - 1) {
                            outRect.setEmpty();
                        } else {
                            super.getItemOffsets(outRect, view, parent, state);
                        }
                    }
                });
    }
}
