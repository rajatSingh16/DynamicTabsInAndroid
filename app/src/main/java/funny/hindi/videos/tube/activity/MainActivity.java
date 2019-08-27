package funny.hindi.videos.tube.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import funny.hindi.videos.tube.BuildConfig;
import funny.hindi.videos.tube.R;
import funny.hindi.videos.tube.adapter.PlansPagerAdapter;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabs)
    TabLayout tab;
    @BindView(R.id.frameLayout)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    ArrayList<String> tabTitle = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        tabTitle.clear();
        setSupportActionBar(toolbar);
        for (int l = 0; l < 6; l++) {

            tab.addTab(tab.newTab().setText("Pitch-" + l));
            tabTitle.add("P - " + l);
        }
        PlansPagerAdapter adapter = new PlansPagerAdapter
                (getSupportFragmentManager(), tab.getTabCount(), tabTitle);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        menu.findItem(R.id.removeAds).setVisible(!BuildConfig.FLAVOR.equalsIgnoreCase("paid"));
        return true;
    }

    Intent intent;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rate:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                startActivity(intent);
                return true;
            case R.id.share:

                return true;
            case R.id.removeAds:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName() + ".full"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
