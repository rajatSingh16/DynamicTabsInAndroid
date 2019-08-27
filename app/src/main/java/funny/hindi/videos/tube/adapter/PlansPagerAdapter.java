package funny.hindi.videos.tube.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import funny.hindi.videos.tube.fragment.DynamicFragment;

public class PlansPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    ArrayList<String> tabTitle;

    public PlansPagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> tabTitle) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {


        return new DynamicFragment().newInstance(tabTitle.get(position));

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}