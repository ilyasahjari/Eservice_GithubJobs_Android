package android.eservices.jobs.presentation.jobdisplay.list.fragment;

import android.eservices.jobs.R;
import android.eservices.jobs.data.api.model.Job;
import android.eservices.jobs.data.di.DependencyInjection;
import android.eservices.jobs.presentation.jobdisplay.list.JobListContract;
import android.eservices.jobs.presentation.jobdisplay.list.JobListPresenter;
import android.eservices.jobs.presentation.jobdisplay.list.adapter.JobAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements JobListContract.View {
    public static String TAB_NAME = "Jobs";
    private View rootView;
    JobListContract.Presenter jobListPresenter;
    private RecyclerView recyclerView;
    private JobAdapter jobAdapter;
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
    List<Job> jobs = new ArrayList<>();
    private CoordinatorLayout coordinatorLayout;

    public ListFragment() {
    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }
    /**
     * This method allows us to display a message when a job is deleted
     *
     * @param message to display
     */
    public void displaySnackBar(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .show();
    }

    /**
     * This method allows us to change display format for listing jobs
     */
    public void changeLayout() {
        if (layoutManager instanceof GridLayoutManager) {
            layoutManager = new LinearLayoutManager(getContext());
        } else {
            layoutManager = new GridLayoutManager(getContext(), 2);
        }
        recyclerView.setLayoutManager(layoutManager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        jobAdapter = new JobAdapter();
        recyclerView.setAdapter(jobAdapter);
        jobListPresenter = new JobListPresenter(DependencyInjection.getJobDisplayRepository());
        jobListPresenter.attachView(this);
        coordinatorLayout = rootView.findViewById(R.id.coordinator_layout);
        setupRecyclerView();

    }

    public void setupRecyclerView() {
        recyclerView.setLayoutManager(layoutManager);
        jobListPresenter.searchJobs();
    }

    @Override
    public void displayJobs(List<Job> jobItemViewModelList) {
        jobs = jobItemViewModelList;
        jobAdapter.bindViewModels(jobItemViewModelList);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        jobListPresenter.detachView();
    }
}