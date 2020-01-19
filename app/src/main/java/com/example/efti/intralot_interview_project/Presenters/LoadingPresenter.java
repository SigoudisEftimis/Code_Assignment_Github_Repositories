package com.example.efti.intralot_interview_project.Presenters;


import android.support.v4.app.Fragment;
import android.view.View;
import com.example.efti.intralot_interview_project.Activities.MainActivity;
import com.example.efti.intralot_interview_project.Fragments.LoadingFragment;
import com.example.efti.intralot_interview_project.Helpers.BufferHelper;
import com.example.efti.intralot_interview_project.Listeners.onVolleySuccess;
import com.example.efti.intralot_interview_project.Parsers.VolleyParser;
import com.example.efti.intralot_interview_project.models.Repository;

import java.util.ArrayList;


public class LoadingPresenter extends BasePresenter{

    private LoadingFragment fragment;

    public LoadingPresenter(Fragment fragment)
    {
        super(fragment);
        this.fragment = (LoadingFragment) fragment;

    }

    public void startFetchingData()
    {

        VolleyParser parser = getFactory().getNewJSONParser();
        parser.setPresenter(this);
        parser.fetchData(new onVolleySuccess() {
            @Override
            public void OnSuccess(ArrayList<Repository> repositories_list) {
                BufferHelper.setBufferList(repositories_list);
                movetoRepositoryFragment();
            }

            @Override
            public void onFail() {
                movetoFailFragment();
            }
        });

    }

    private void movetoFailFragment() {
        MainActivity activity = (MainActivity) fragment.getActivity();
        if (activity != null) {
            activity.FailFragment();
        }
    }

    private void movetoRepositoryFragment()
    {
        fragment.getProgressBar().setVisibility(View.INVISIBLE);
        MainActivity activity = (MainActivity) fragment.getActivity();
        if (activity != null) {
            activity.RepositoryFragment();
        }
    }



}
