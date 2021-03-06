package com.example.ecologicalfootprintapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private DrawerLayout navDrawer;
    private ActionBarDrawerToggle navToggle;
    private ActionBar actionBar;

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    public Questionaire questionaire;

    public ProgressDialog progressDiag;
    public TextView resultText;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.fragmentContainer);
        // setting up the pager
        setupViewPager(mViewPager);

        navDrawer = (DrawerLayout) findViewById(R.id.navDrawerLayout);
        navToggle = new ActionBarDrawerToggle(this, navDrawer, R.string.open, R.string.close);
        navDrawer.addDrawerListener(navToggle);
        navDrawer.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        navToggle.syncState();
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.colorPrimaryDark)));
        actionBar.setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        //setting up questionaire variable
        Log.d(TAG, "questionaire completed");
        questionaire = new Questionaire(this);



        Log.d(TAG, "questionaire completed: "+(questionaire.getCompleted()+""));
        Log.d(TAG, "questionaire completed");

    }


    private void setupViewPager(ViewPager viewPager)
    {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentHome(), "FragmentHome"); // 0
        adapter.addFragment(new FragmentAbout(), "FragmentAbout"); // 1
        adapter.addFragment(new FragmentScoreBreakdown(), "FragmentBreakdown"); // 2
        adapter.addFragment(new FragmentScoreTracking(), "FragmentTracking"); // 3
        adapter.addFragment(new FragmentCorvallisResources(), "FragmentCorvallis"); // 4
        adapter.addFragment(new FragmentQuestionaire1(), "FragmentQ1"); // 5
        adapter.addFragment(new FragmentQuestionaire2(), "FragmentQ2"); // 6
        adapter.addFragment(new FragmentQuestionaire3(), "FragmentQ3"); // 7
        adapter.addFragment(new FragmentQuestionaire4(), "FragmentQ4"); // 8
        adapter.addFragment(new FragmentQuestionaire5(), "FragmentQ5"); // 9
        adapter.addFragment(new FragmentQuestionaire6(), "FragmentQ6"); // 10
        adapter.addFragment(new FragmentQuestionaire7(), "FragmentQ7"); // 11
        adapter.addFragment(new FragmentQuestionaire8(), "FragmentQ8"); // 12
        adapter.addFragment(new FragmentQuestionaire9(), "FragmentQ9"); // 13
        adapter.addFragment(new FragmentQuestionaire10(), "FragmentQ10"); // 14
        adapter.addFragment(new FragmentQuestionaire11(), "FragmentQ11"); // 15
        adapter.addFragment(new FragmentQuestionaire12(), "FragmentQ12"); // 16
        adapter.addFragment(new FragmentQuestionaire13(), "FragmentQ13"); // 17
        adapter.addFragment(new FragmentQuestionaire14(), "FragmentQ14"); // 18
        adapter.addFragment(new FragmentQuestionaire15(), "FragmentQ15"); // 19
        adapter.addFragment(new FragmentQuestionResDuplicate(), "FragmentResDuplicate"); // 20
        adapter.addFragment(new FragmentQuestionRes(), "FragmentRes"); // 21
        adapter.addFragment(new FragmentCorvallisResourcesWater(), "CorvallisWater"); // 22
        adapter.addFragment(new FragmentCorvallisResourcesEnergy(), "CorvallisEnergy"); // 23
        adapter.addFragment(new FragmentCorvallisAgriculture(), "CorvallisAgriculture"); // 24
        adapter.addFragment(new FragmentCorvallisResourcesRecycling(), "CorvallisRecycling"); // 25

        // copy and repeat this line for all fragments, first fragment will be loaded at start
        viewPager.setAdapter(adapter);
    }

    // sets the current fragment within the view pager
    public void setViewPager(int fragmentNumber)
    {
        mViewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(navToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    //handles what happens when a navigation item is pressed
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        Intent startNewActivity;

        if(id == R.id.home)
        {
            Toast.makeText(this,"Clicked Home", Toast.LENGTH_SHORT).show();
            mViewPager.setCurrentItem(0);
            navDrawer.closeDrawers();
        }
        if(id == R.id.scoreBreakdown)
        {
            Toast.makeText(this, "Clicked Score Breakdown", Toast.LENGTH_SHORT).show();
            mViewPager.setCurrentItem(2);
            navDrawer.closeDrawers();

        }
        if(id == R.id.scoreTracking)
        {
            Toast.makeText(this,"Clicked Score Tracking", Toast.LENGTH_SHORT).show();
            // for moving to a new activity
            //startNewActivity = new Intent(this, ScoreTracking.class);
            // startNewActivity.putExtra(EXTRA_MESSAGE, message);
            //startActivity(startNewActivity);
            mViewPager.setCurrentItem(3);
            navDrawer.closeDrawers();
        }
        if(id == R.id.corvallisResources)
        {
            Toast.makeText(this,"Clicked Corvallis Resources", Toast.LENGTH_SHORT).show();
            mViewPager.setCurrentItem(4);
            navDrawer.closeDrawers();

        }
        if(id == R.id.about)
        {
            Toast.makeText(this,"Clicked About", Toast.LENGTH_SHORT).show();
            mViewPager.setCurrentItem(1);
            navDrawer.closeDrawers();

        }

        return false;
    }

}


