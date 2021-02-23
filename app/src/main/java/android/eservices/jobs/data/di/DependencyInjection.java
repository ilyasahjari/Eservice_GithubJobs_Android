package android.eservices.jobs.data.di;

import android.content.Context;
import android.eservices.jobs.data.api.JobDisplayService;
import android.eservices.jobs.data.db.JobDatabase;
import android.eservices.jobs.data.repository.jobdisplay.JobDisplayDataRepository;
import android.eservices.jobs.data.repository.jobdisplay.JobDisplayRepository;
import android.eservices.jobs.data.repository.jobdisplay.mapper.JobToJobEntityMapper;
import android.eservices.jobs.data.repository.jobdisplay.remote.JobDisplayRemoteDataSource;

import androidx.room.Room;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DependencyInjection {
    private static JobDisplayService jobDisplayService;
    private static Retrofit retrofit;
    private static Gson gson;
    private static JobDisplayRepository jobDisplayRepository;
    private static JobDatabase jobDatabase;
    private static Context applicationContext;

    public static JobDisplayRepository getJobDisplayRepository() {
        if (jobDisplayRepository == null) {
            jobDisplayRepository = new JobDisplayDataRepository(
                    new JobDisplayRemoteDataSource(getJobDisplayService()),
                    new JobToJobEntityMapper()
            );
        }
        return jobDisplayRepository;
    }

    public static JobDisplayService getJobDisplayService() {
        if (jobDisplayService == null) {
            jobDisplayService = getRetrofit().create(JobDisplayService.class);
        }
        return jobDisplayService;
    }


    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jobs.github.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
        return retrofit;
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static void setContext(Context context) {
        applicationContext = context;
    }

    public static JobDatabase getJobDatabase() {
        if (jobDatabase == null) {
            jobDatabase = Room.databaseBuilder(applicationContext,
                    JobDatabase.class, "job-database").build();
        }
        return jobDatabase;
    }
}
