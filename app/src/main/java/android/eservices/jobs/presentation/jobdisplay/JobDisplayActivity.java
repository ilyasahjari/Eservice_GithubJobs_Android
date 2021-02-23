package android.eservices.jobs.presentation.jobdisplay;

import android.eservices.jobs.R;
import android.eservices.jobs.presentation.jobdisplay.list.fragment.ListFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


/**
 * It is the main activity and entry point of our application
 */

public class JobDisplayActivity extends AppCompatActivity {

    private ViewPager viewPager;
    ListFragment listFragment = ListFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);


        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                    return listFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                    return ListFragment.TAB_NAME;
            }

            @Override
            public int getCount() {
                return 1;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_favorite:
                listFragment.changeLayout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}


