package com.example.efti.intralot_interview_project.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.efti.intralot_interview_project.Listeners.RepositoryListener;
import com.example.efti.intralot_interview_project.R;
import com.example.efti.intralot_interview_project.models.Repository;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.PlaceHolder>
{

    private List<Repository> repositoryList;
    private Context context;
    private RepositoryListener listener;

    public RepositoryAdapter() {
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.repository,parent,false);
        return  new PlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder placeHolder, int i) {

        Repository repository = repositoryList.get(i);
        placeHolder.rep_name.setText(repository.getName());
        placeHolder.rep_descripiton.setText(repository.getDescription());
        placeHolder.bind(listener,repository);

    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public void setRepositoryList(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setListener(RepositoryListener listener) {
        this.listener = listener;
    }

    class PlaceHolder extends RecyclerView.ViewHolder {

      TextView rep_name, rep_descripiton ;

      PlaceHolder(@NonNull View itemView)
      {
          super(itemView);

          rep_name = itemView.findViewById(R.id.name);
          rep_descripiton = itemView.findViewById(R.id.description);


      }

        void bind(final RepositoryListener listener, final Repository repository)
        {
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  listener.setRepositoryFields(repository);
               }
           });
        }
  }


}
