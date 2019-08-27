package funny.hindi.videos.tube.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import funny.hindi.videos.tube.R;
import funny.hindi.videos.tube.activity.PreviewActivity;
import funny.hindi.videos.tube.mode.CommentsModel;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    Context context;
    String operator;
    private ArrayList<CommentsModel> videoModels;
    String titleString;
    String descString;
    String urlString;
    String formattedDate;
    String actualYear;

    public CommentsAdapter(Context context, ArrayList<CommentsModel> circleArrayList, String titleString, String descString, String urlString) {
        this.videoModels = circleArrayList;
        this.context = context;
        this.titleString = titleString;
        this.descString = descString;
        this.urlString = urlString;
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);
        String[] da = formattedDate.split("-");

        actualYear = da[2];
    }


    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_comment, parent, false);
        return new CommentsAdapter.MyViewHolder(view);
    }

    String _DATE;

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        holder.name.setText(videoModels.get(listPosition).getName());
        holder.comment.setText(videoModels.get(listPosition).getComments());
        _DATE = videoModels.get(listPosition).getDate();
        String[] da = _DATE.split("-");
        String dataYear = da[2];
        if (Integer.valueOf(dataYear) < Integer.valueOf(actualYear)) {
            holder.date.setText("1 actualYear ago");
        } else {
            holder.date.setText(_DATE);
        }

        Picasso.with(context).load(videoModels.get(listPosition).getProfile()).into(holder.image);
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("name", videoModels.get(listPosition).getName());
                intent.putExtra("comment", videoModels.get(listPosition).getComments());
                intent.putExtra("imageUrl", videoModels.get(listPosition).getProfile());
                intent.putExtra("title", titleString);
                intent.putExtra("desc", descString);
                intent.putExtra("url", urlString);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        TextView name, comment, share, date;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            comment = itemView.findViewById(R.id.comment);
            image = itemView.findViewById(R.id.image);
            share = itemView.findViewById(R.id.share);
            date = itemView.findViewById(R.id.date);

        }
    }
}

