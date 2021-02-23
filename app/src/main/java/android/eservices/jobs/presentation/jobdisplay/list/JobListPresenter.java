package android.eservices.jobs.presentation.jobdisplay.list;

import android.eservices.jobs.data.api.model.Job;
import android.eservices.jobs.data.repository.jobdisplay.JobDisplayRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class JobListPresenter implements JobListContract.Presenter {

    private JobDisplayRepository jobDisplayRepository;
    private JobListContract.View view;
    private CompositeDisposable compositeDisposable;


    public JobListPresenter(JobDisplayRepository jobDisplayRepository) {
        this.jobDisplayRepository = jobDisplayRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void searchJobs() {
        compositeDisposable.clear();
        compositeDisposable.add(jobDisplayRepository.getJobs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Job>>() {

                    @Override
                    public void onSuccess(List<Job> jobs) {
                        // work with the resulting todo
                        view.displayJobs(jobs);

                    }

                    @Override
                    public void onError(Throwable e) {
                        // handle the error case
                        System.out.println(e.toString());
                    }
                }));

    }
    
    @Override
    public void attachView(JobListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        compositeDisposable.dispose();
        view = null;
    }




}
