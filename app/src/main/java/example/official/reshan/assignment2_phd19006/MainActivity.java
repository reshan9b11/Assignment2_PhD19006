package example.official.reshan.assignment2_phd19006;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
//    public List<String> name11=new ArrayList<>();
//    public List<String> number11=new ArrayList<>();
//    public List<Contact> lstContact=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getDetails();

        tabLayout=(TabLayout) findViewById(R.id.tablayout_id);
        viewPager=(ViewPager) findViewById(R.id.viewpager_id);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentCall(),"");
        adapter.AddFragment(new FragmentContact(),"");
        adapter.AddFragment(new FragmentFav(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_person);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_star);
    }


//    public List<String> GetList_Name(){
//
//        return name11;
//    }
//    public List<String> GetList_Number(){
//
//        return number11;
//    }
}
