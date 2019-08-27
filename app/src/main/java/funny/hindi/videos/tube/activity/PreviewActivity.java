package funny.hindi.videos.tube.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import funny.hindi.videos.tube.BuildConfig;
import funny.hindi.videos.tube.R;

public class PreviewActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.imageDraw)
    ImageView imageDraw;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.share)
    Button share;
    @BindView(R.id.adView)
    AdView adView;
    String titleString, descString, urlString, nameString, commentString, imageUrl;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(PreviewActivity.this);
        imageDraw.setVisibility(View.GONE);
        toolbarTitle.setText("Preview");
        toolbarTitle.setTextColor(getResources().getColor(R.color.black));
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleString = getIntent().getStringExtra("title");
        descString = getIntent().getStringExtra("desc");
        urlString = getIntent().getStringExtra("url");
        nameString = getIntent().getStringExtra("name");
        commentString = getIntent().getStringExtra("comment");
        imageUrl = getIntent().getStringExtra("imageUrl");
        String[] link = urlString.split("=");
        id = link[1];
        Log.i(">>id", "onCreate: " + id);
        title.setText(titleString);
        comment.setText(commentString);
        Picasso.with(PreviewActivity.this).load(imageUrl).into(image);


        if (!BuildConfig.FLAVOR.equalsIgnoreCase("paid")) {
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
            adView.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);
                    adView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    adView.setVisibility(View.VISIBLE);
                }
            });
        }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
