package pavankreddy.blogspot.tabnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connect these tabLayout and viewPager to the actual Widgets
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        // Set up the ViewPagerAdapter on the viewPager
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(vpa);

        tabLayout.setupWithViewPager(viewPager);
    }

    // This adapter's work is to connect the fragment pages to the view pager
    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new FirstFragment();
                case 1: return new SecondFragment();
                case 2: return new ThirdFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "FIRST";
                case 1: return "SECOND";
                case 2: return "THIRD";
            }
            return super.getPageTitle(position);
        }
    }
}
