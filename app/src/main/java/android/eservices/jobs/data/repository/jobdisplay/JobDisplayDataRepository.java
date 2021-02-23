package android.eservices.jobs.data.repository.jobdisplay;

import android.eservices.jobs.data.api.model.Job;
import android.eservices.jobs.data.repository.jobdisplay.mapper.JobToJobEntityMapper;
import android.eservices.jobs.data.repository.jobdisplay.remote.JobDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Single;

public class JobDisplayDataRepository implements JobDisplayRepository{


    private JobDisplayRemoteDataSource jobDisplayRemoteDataSource;
    private JobToJobEntityMapper jobToJobEntityMapper;

    public JobDisplayDataRepository(JobDisplayRemoteDataSource jobDisplayRemoteDataSource,
                                    JobToJobEntityMapper jobToJobEntityMapper) {
        this.jobDisplayRemoteDataSource = jobDisplayRemoteDataSource;
        this.jobToJobEntityMapper = jobToJobEntityMapper;
    }

    @Override
    public Single<List<Job>> getJobs() {
        return jobDisplayRemoteDataSource.getJobs();
    }
}
