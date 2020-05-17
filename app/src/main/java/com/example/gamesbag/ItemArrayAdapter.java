package com.example.gamesbag;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Item> itemList;
    private static final int ITEM = 0;
    private static final int NATIVE_AD = 1;
    int[] viewTypes;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Item> itemList, int[] viewTypes) {
        listItemLayout = layoutId;
        this.itemList = itemList;
        this.viewTypes = viewTypes;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    @Override
    public int getItemViewType(int position) {
        return viewTypes[position];
    }

    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (viewType == ITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
            ViewHolder myViewHolder = new ViewHolder(view);
            return myViewHolder;
        } else if (viewType == NATIVE_AD) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_ad, parent, false);
//            ViewHolder myViewHolder = new ViewHolder(view);
//            return myViewHolder;
        }

        return  null;

    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int listPosition) {


        if (viewHolder.getItemViewType() == ITEM) {
            ViewHolder holder = (ViewHolder) viewHolder;
            TextView item = holder.item;
            ImageView img = holder.img;
            item.setText(itemList.get(listPosition).getName());
            img.setImageDrawable(itemList.get(listPosition).getImg());
        } else if (viewHolder.getItemViewType() == NATIVE_AD) {
//            AdViewHolder holder = (AdViewHolder) viewHolder;
//            //Load the Ad
//            AdRequest request = new AdRequest.Builder()
//                    .build();
//            holder.adView.loadAd(request);
        }

    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.textView);
            img = (ImageView) itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }
    }

//    class AdViewHolder extends ViewHolder {
//        NativeExpressAdView adView;
//
//        public AdViewHolder(View v) {
//            super(v);
//            adView = (NativeExpressAdView)v.findViewById(R.id.nativeAdView);
//        }
//    }

}
