package com.example.efti.intralot_interview_project.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.efti.intralot_interview_project.Presenters.RepositoryPresenter;
import com.example.efti.intralot_interview_project.R;


public class RepositoryFragment extends Fragment {


    private RecyclerView recyclerView;
    private RepositoryPresenter presenter;


    public RepositoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RepositoryPresenter(this);

    }

    public static RepositoryFragment newInstance()
    {
        return new RepositoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repository,container,false);
        recyclerView =  view.findViewById(R.id.repository_listview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.initRecyclerView();

        return view ;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

}
