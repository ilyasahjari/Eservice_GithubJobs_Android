package android.eservices.jobs.presentation.jobdisplay.list.adapter;

import android.content.Context;
import android.content.Intent;
import android.eservices.jobs.R;
import android.eservices.jobs.data.api.model.Job;
import android.eservices.jobs.presentation.jobdisplay.job_activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * It is our adapter that manage displayed github jobs.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    public static class JobViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnailImageView;
        public TextView nameTextView;
        public TextView locationTextView;
        private View v;
        private Job jobItemViewModel;
        CardView cardView;


        public JobViewHolder(View v) {
            super(v);
            nameTextView = v.findViewById(R.id.name_text_view);
            locationTextView = v.findViewById(R.id.location);
            thumbnailImageView = v.findViewById(R.id.thumbnail_image_view);
            cardView = v.findViewById(R.id.card_view_id);
            this.v = v;
        }


        void bind(Job jobItemViewModel) {
            this.jobItemViewModel = jobItemViewModel;
            nameTextView.setText(jobItemViewModel.getTitle());
            locationTextView.setText(jobItemViewModel.getLocation());
            String urlPoster = jobItemViewModel.getCompany_logo();

            if(urlPoster!= null) {
                Glide.with(v.getContext())
                        .load(Uri.parse(urlPoster))
                        .into(thumbnailImageView);
            }
       }

    }

    private List<Job> jobItemViewModelList;
    private Context context;


    // Provide a suitable constructor (depends on the kind of dataset)
    public JobAdapter() {
        jobItemViewModelList = new ArrayList<>();
    }

    public void bindViewModels(List<Job> jobItemViewModelList) {
        this.jobItemViewModelList.clear();
        this.jobItemViewModelList.addAll(jobItemViewModelList);
        notifyDataSetChanged();
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_list_content, parent, false);
        JobViewHolder jobViewHolder = new JobViewHolder(v);
        return jobViewHolder;
    }


    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        holder.bind(jobItemViewModelList.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, job_activity.class);
                intent.putExtra("name",jobItemViewModelList.get(position).getTitle());
                intent.putExtra("description",jobItemViewModelList.get(position).getDescription());
                intent.putExtra("type",jobItemViewModelList.get(position).getType());
                intent.putExtra("thumbnail",jobItemViewModelList.get(position).getCompany_logo());
                intent.putExtra("companyName",jobItemViewModelList.get(position).getCompany());
                intent.putExtra("location",jobItemViewModelList.get(position).getLocation());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobItemViewModelList.size();
    }

}
