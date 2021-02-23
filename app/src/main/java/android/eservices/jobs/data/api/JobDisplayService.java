package android.eservices.jobs.data.api;

import android.eservices.jobs.data.api.model.Job;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JobDisplayService {

    /**
     * @return
     */
    @GET("positions.json?page=1")
    Single<List<Job>> getJobs();

    /**
     * @param id  for a specific github job proposition
     * @return a detailed job application
     */
    @GET("positions/{id}.json")
    Single<Job> getJob(@Path("id") String id);

}
