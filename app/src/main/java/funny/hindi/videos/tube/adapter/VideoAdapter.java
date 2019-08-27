package funny.hindi.videos.tube.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import funny.hindi.videos.tube.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    Context context;
    String operator;
    private ArrayList<String> videoModels;
    int NORMAL = 1;
    int AD = 0;

    int count = 0;

    public VideoAdapter(Context context, ArrayList<String> circleArrayList) {
        this.videoModels = circleArrayList;
        this.context = context;

        Log.i(">>id", "VideoAdapter: " + operator + "-");
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 8 == 0) {
            return AD;
        } else {
            return NORMAL;
        }
    }


    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_video, parent, false);
        return new VideoAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        if (listPosition == 0) {
            holder.changeColor.setBackgroundColor(context.getResources().getColor(R.color.red));
        } else if (listPosition == 1) {
            holder.changeColor.setBackgroundColor(context.getResources().getColor(R.color.green));
        } else if (listPosition == 2) {
            holder.changeColor.setBackgroundColor(context.getResources().getColor(R.color.grey));
            holder.changeColor.setText("Vacant");
            holder.changeColor.setTextColor(context.getResources().getColor(R.color.black));
        } else if (listPosition == 3) {
            holder.changeColor.setBackgroundColor(context.getResources().getColor(R.color.green));
        } else if (listPosition == 4) {
            holder.changeColor.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView changeColor;


        public MyViewHolder(View itemView) {
            super(itemView);
            changeColor = itemView.findViewById(R.id.changeColor);


        }
    }
}

