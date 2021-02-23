package android.eservices.jobs.data.repository.jobdisplay;

import android.eservices.jobs.data.api.model.Job;

import java.util.List;

import io.reactivex.Single;

public interface JobDisplayRepository {

    Single<List<Job>> getJobs();

}
