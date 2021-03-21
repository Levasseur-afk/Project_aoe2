package com.example.project_aoe2.Tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TouchListener implements RecyclerView.OnItemTouchListener{

    private Context context;
    private RecyclerView recyclerView;
    private ITouchListener listener;
    private GestureDetector gestureDetector;

    // Hancle click on recyclerView fragment item
    public TouchListener(Context context, RecyclerView rv, ITouchListener listener) {
        this.context = context;
        this.recyclerView = rv;
        this.listener = listener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                int position = recyclerView.getChildAdapterPosition(child);
                if(child != null && listener!=null){
                    listener.onClick(child, position);
                }
                return super.onSingleTapUp(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public interface ITouchListener{
        public void onClick(View v, int position);
    }
}
