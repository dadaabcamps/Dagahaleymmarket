package com.dadaabcamps.mmarket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by DAU ICT on 8/3/2016.
 */
public class RV_ItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mListener;
    //create click listener interface
    public interface OnItemClickListener {
        public void onItemClick(View view, int i);
    }
    /** Add class constructor, initialise listener and instantiate gesture detertor */
    GestureDetector mGestureDetector;
    public RV_ItemClickListener(Context c, OnItemClickListener onItemClickListener) {
        mListener = onItemClickListener;
        mGestureDetector = new GestureDetector(c, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;

            }
        });


    }
@Override
public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){
        View mChildView=rv.findChildViewUnder(e.getX(),e.getY());
        if((mChildView!=null&&mListener!=null&&mGestureDetector.onTouchEvent(e))){
        mListener.onItemClick(mChildView,rv.getChildAdapterPosition(mChildView));
        return true;
        }
        return false;
 }
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {  }


} //Ends RV_ItemClickListener class
