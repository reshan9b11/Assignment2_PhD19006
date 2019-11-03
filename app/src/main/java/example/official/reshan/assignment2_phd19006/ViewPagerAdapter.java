package example.official.reshan.assignment2_phd19006;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);

    }


    private final List<Fragment> lstFragment=new ArrayList<>();
    private final List<String> lstTitle=new ArrayList<>();
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitle.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitle.get(position);
    }


    public void AddFragment(Fragment fragment,String title){
        lstFragment.add(fragment);
        lstTitle.add(title);
    }
}
