package android.eservices.jobs.presentation.jobdisplay.list;

import android.eservices.jobs.data.api.model.Job;

import java.util.List;

/**
 * It is an interface that represent job contract
 */

public class JobListContract {

    public interface View {
        void displayJobs(List<Job> jobItemViewModelList);
    }

    public interface Presenter {
        void searchJobs();

        void attachView(View view);

        void detachView();
    }
}
