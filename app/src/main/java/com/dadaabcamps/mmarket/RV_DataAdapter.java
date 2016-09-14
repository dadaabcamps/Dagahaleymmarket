package com.dadaabcamps.mmarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DAU ICT on 8/3/2016.
 */
public class RV_DataAdapter extends RecyclerView.Adapter<RV_DataAdapter.ViewHolder>{

    private ArrayList<ProductData> arrayList;
    private Context mcontext;

    //RV_DataAdapter class constructor that initializes the array list
    public RV_DataAdapter(Context context, ArrayList<ProductData> android) {
        this.arrayList = android;
        this.mcontext = context;
    }

    //Adpter displays/inflates the grid products_grid_display1 file with Image and titles
    @Override
    public RV_DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.products_grid_display1,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.textView.setText(arrayList.get(position).getRecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(position).getRecyclerViewImage());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;



        public ViewHolder(View v) {
            super (v);

            textView = (TextView) v.findViewById(R.id.producttext);
            imageView = (ImageView) v.findViewById(R.id.productimage);
        }
    }



}
