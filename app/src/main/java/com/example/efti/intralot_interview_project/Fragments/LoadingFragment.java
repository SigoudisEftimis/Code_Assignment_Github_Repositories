package com.example.efti.intralot_interview_project.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.efti.intralot_interview_project.Presenters.LoadingPresenter;
import com.example.efti.intralot_interview_project.R;


public class LoadingFragment extends Fragment {

    private ProgressBar progressBar ;
    private LoadingPresenter presenter;


    public LoadingFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoadingPresenter(this);
        presenter.startFetchingData();

    }

    public static LoadingFragment newInstance()
    {
        return new LoadingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_loading,container,false);
        progressBar  = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        return view ;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }



}
