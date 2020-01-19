package com.example.efti.intralot_interview_project.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import com.example.efti.intralot_interview_project.Fragments.FailFragment;
import com.example.efti.intralot_interview_project.Fragments.LoadingFragment;
import com.example.efti.intralot_interview_project.Fragments.RepositoryFragment;
import com.example.efti.intralot_interview_project.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        hideNotificationBar();
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initialFragment()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, LoadingFragment.newInstance());
        transaction.commit();
    }

    @Override
    protected void onStart()
    {

        super.onStart();
        initialFragment();

    }

    private void hideNotificationBar()
    {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void RepositoryFragment()
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, RepositoryFragment.newInstance());
        transaction.commit();
    }

    public void FailFragment() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, FailFragment.newInstance());
        transaction.commit();
    }
}
