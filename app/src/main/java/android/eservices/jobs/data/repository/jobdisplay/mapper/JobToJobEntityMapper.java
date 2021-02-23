package android.eservices.jobs.data.repository.jobdisplay.mapper;

import android.eservices.jobs.data.api.model.Job;
import android.eservices.jobs.data.entity.JobEntity;

public class JobToJobEntityMapper {

    public JobEntity map(Job job) {
        JobEntity jobEntity = new JobEntity();

        jobEntity.setId(job.getId());
        jobEntity.setCompany(job.getCompany());
        jobEntity.setCompany_logo(job.getCompany_logo());
        jobEntity.setDescription(job.getDescription());
        jobEntity.setLocation(job.getLocation());
        jobEntity.setTitle(job.getTitle());
        jobEntity.setType(job.getType());
        jobEntity.setUrl(job.getUrl());

        return jobEntity;
    }
}
