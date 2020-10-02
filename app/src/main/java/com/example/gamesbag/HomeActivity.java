package com.example.gamesbag;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends Activity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);

        initRecyclerView();

//        ArrayList<Item> itemList = new ArrayList<Item>();
//
//        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, itemList);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(itemArrayAdapter);
//
//        // Populating list items
//        for(int i=0; i<10; i++) {
//            itemList.add(new Item("Item " + i,getResources().getDrawable(R.drawable.ic_launcher_background)));
//        }

    }

    private void initRecyclerView() {
//New line added by sonal
//trialBySonal
        //Create dummy data for RecyclerView
        int listSize = 50;
        int ITEM = 0;
        int NATIVE_AD = 1;
        ArrayList<Item> data = new ArrayList<>();
        int[] viewTypes = new int[listSize];
        for (int i = 0; i < listSize; i++) {

            Item item = new Item();
            item.setName("Name");
            item.setImg(getResources().getDrawable(R.drawable.logo3));
            data.add(item);
            //insert native ads once in five items
            if (i > 1 && i % 5 == 0) {
                viewTypes[i] = ITEM;
            } else {
//                viewTypes[i] = ITEM;
                viewTypes[i] = ITEM;
            }
        }
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rec);
        ItemArrayAdapter adapter = new ItemArrayAdapter(R.layout.row_item,data, viewTypes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
