package funny.hindi.videos.tube.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import funny.hindi.videos.tube.BuildConfig;
import funny.hindi.videos.tube.R;
import funny.hindi.videos.tube.adapter.OnBottomReachedListener;
import funny.hindi.videos.tube.adapter.VideoAdapter;
import funny.hindi.videos.tube.mode.VideoModel;

public class DynamicFragment extends Fragment {

    View view;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.noDataLayout)
    LinearLayout noDataLayout;

    public static DynamicFragment newInstance(String val) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString("someValue", val);
        fragment.setArguments(args);
        return fragment;
    }

    DatabaseReference mDatabase;
    ArrayList<VideoModel> videoModelArrayList = new ArrayList<>();
    String node;
    VideoAdapter videoAdapter;
    InterstitialAd mInterstitialAd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        node = getArguments().getString("someValue");
        Log.i(">>val", "onCreateView: " + node);
        ButterKnife.bind(DynamicFragment.this, view);

        return view;
    }
}
