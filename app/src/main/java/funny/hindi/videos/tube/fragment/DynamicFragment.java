package funny.hindi.videos.tube.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import funny.hindi.videos.tube.R;
import funny.hindi.videos.tube.adapter.VideoAdapter;

public class DynamicFragment extends Fragment {

    View view;
    @BindView(R.id.list)
    RecyclerView list;

    public static DynamicFragment newInstance(String val) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString("someValue", val);
        fragment.setArguments(args);
        return fragment;
    }

    DatabaseReference mDatabase;
    ArrayList<String> videoModelArrayList = new ArrayList<>();
    String node;
    VideoAdapter videoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        node = getArguments().getString("someValue");
        ButterKnife.bind(DynamicFragment.this, view);


        videoModelArrayList.clear();
        videoAdapter = new VideoAdapter(getActivity(), videoModelArrayList);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(videoAdapter);
        final CollapsibleCalendar collapsibleCalendar = view.findViewById(R.id.calendarView);
        collapsibleCalendar.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDaySelect() {
                Day day = collapsibleCalendar.getSelectedDay();

                Log.i(">>data", "Selected Day: "


                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());
            }

            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });

        return view;
    }
}
