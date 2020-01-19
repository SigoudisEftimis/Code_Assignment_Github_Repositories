package com.example.efti.intralot_interview_project.Listeners;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.example.efti.intralot_interview_project.R;
import com.example.efti.intralot_interview_project.models.Repository;

public class RepositoryListener implements View.OnClickListener {

    private Context context ;

    public RepositoryListener(Context context)
    {
        this.context = context ;
    }

    @Override
    public void onClick(View v) {

    }

    @SuppressLint("SetTextI18n")
    public void setRepositoryFields(Repository repository){

        TextView node_id , size , stargazers_count , language ;
        TextView issues , has_project  ;
        TextView forks_count , watchers ;

        Resources resourses = context.getResources();

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.repository_other);
        dialog.setTitle(resourses.getString(R.string.title));

        node_id = dialog.findViewById(R.id.node_id);
        size = dialog.findViewById(R.id.size);
        stargazers_count = dialog.findViewById(R.id.stargazers_count);
        language = dialog.findViewById(R.id.language);
        issues = dialog.findViewById(R.id.issues);
        has_project = dialog.findViewById(R.id.has_project);
        forks_count = dialog.findViewById(R.id.forks_count);
        watchers = dialog.findViewById(R.id.watchers);



        String size_str = resourses.getString(R.string.size_str) + " " + Integer.toString(repository.getSize()) ;
        String star_count_str = resourses.getString(R.string.star_count_str) + " " + Integer.toString(repository.getStargazers_count());
        String language_str = resourses.getString(R.string.language_str) + " " + repository.getLanguage();
        String watcher_str = resourses.getString(R.string.watcher_str) + " " + Integer.toString(repository.getWatchers());
        String forks_counts_str = resourses.getString(R.string.forks_counts_str) + " " + Integer.toString(repository.getForks_count()) ;
        String issues_str = resourses.getString(R.string.issues_str) + " " + Integer.toString(repository.getOpen_issues());


        node_id.setText(repository.getNode_id());
        size.setText(size_str);
        stargazers_count.setText(star_count_str);
        language.setText(language_str);
        watchers.setText(watcher_str);
        forks_count.setText(forks_counts_str);
        issues.setText(issues_str);

        if (repository.isHas_projects())
            has_project.setText("Yes");
        else
            has_project.setText("No");

        dialog.show();

    }



}
