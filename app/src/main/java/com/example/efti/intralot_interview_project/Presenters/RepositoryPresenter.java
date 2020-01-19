package com.example.efti.intralot_interview_project.Presenters;

import android.support.v4.app.Fragment;

import com.example.efti.intralot_interview_project.Adapters.RepositoryAdapter;
import com.example.efti.intralot_interview_project.Fragments.RepositoryFragment;
import com.example.efti.intralot_interview_project.Helpers.BufferHelper;
import com.example.efti.intralot_interview_project.Listeners.RepositoryListener;

public class RepositoryPresenter extends BasePresenter{

    private RepositoryFragment fragment;

    public RepositoryPresenter (Fragment fragment)
    {
        super(fragment);
        this.fragment = (RepositoryFragment) fragment;


    }

    public void initRecyclerView()
    {

        RepositoryAdapter adapter = this.getFactory().getNewRepositoryAdapter();
        adapter.setContext(fragment.getActivity());
        adapter.setRepositoryList(BufferHelper.getBufferList());
        adapter.setListener(new RepositoryListener(fragment.getContext()));
        fragment.getRecyclerView().setAdapter(adapter);

    }
}
