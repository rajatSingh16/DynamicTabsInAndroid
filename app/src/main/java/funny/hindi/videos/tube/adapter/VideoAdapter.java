package funny.hindi.videos.tube.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import funny.hindi.videos.tube.BuildConfig;
import funny.hindi.videos.tube.R;
import funny.hindi.videos.tube.activity.DetailActivity;
import funny.hindi.videos.tube.mode.VideoModel;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    Context context;
    String operator;
    private ArrayList<VideoModel> videoModels;
    int NORMAL = 1;
    int AD = 0;
    InterstitialAd mInterstitialAd;
    int count = 0;

    public VideoAdapter(Context context, ArrayList<VideoModel> circleArrayList) {
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

    OnBottomReachedListener onBottomReachedListener;

    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_video, parent, false);
        return new VideoAdapter.MyViewHolder(view);
    }

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener) {

        this.onBottomReachedListener = onBottomReachedListener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

       

    }

    @Override
    public int getItemCount() {
        return 0;
    }

 

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        AdView adView;
        CardView tap;
        TextView desc, title;


        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.imageView);
            adView = itemView.findViewById(R.id.adView);
            tap = itemView.findViewById(R.id.tap);

        }
    }
}

