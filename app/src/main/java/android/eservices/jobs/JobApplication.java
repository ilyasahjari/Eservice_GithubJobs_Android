package android.eservices.jobs;

import android.app.Application;
import android.eservices.jobs.data.di.DependencyInjection;

import com.facebook.stetho.Stetho;

public class JobApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DependencyInjection.setContext(this);
    }
}
