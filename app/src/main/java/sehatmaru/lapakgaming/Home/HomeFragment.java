package sehatmaru.lapakgaming.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import sehatmaru.lapakgaming.Helper.Slider.FragmentSlider;
import sehatmaru.lapakgaming.Helper.Slider.SliderIndicator;
import sehatmaru.lapakgaming.Helper.Slider.SliderPagerAdapter;
import sehatmaru.lapakgaming.Helper.Slider.SliderView;
import sehatmaru.lapakgaming.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = (SliderView) view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();

        return view;
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("pubg"));
        fragments.add(FragmentSlider.newInstance("mlbb"));
        fragments.add(FragmentSlider.newInstance("pb"));
        fragments.add(FragmentSlider.newInstance("steam"));

        mAdapter = new SliderPagerAdapter(this.getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
