package android.eservices.jobs.data.repository.jobdisplay.remote;

import android.eservices.jobs.data.api.JobDisplayService;
import android.eservices.jobs.data.api.model.Job;

import java.util.List;

import io.reactivex.Single;

public class JobDisplayRemoteDataSource {

    private JobDisplayService jobDisplayService;

    public JobDisplayRemoteDataSource(JobDisplayService jobDisplayService) {
        this.jobDisplayService = jobDisplayService;
    }

    /**
     * @return a job from remote database through web service
     */
    public Single<List<Job>> getJobs() {
        return jobDisplayService.getJobs();
    }

    /**
     * @param idJob
     * @return a detail job from remote database through web service
     */
    public Single<Job> getJob(String idJob) {
        return jobDisplayService.getJob(idJob);
    }

}
