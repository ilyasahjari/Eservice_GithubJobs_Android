package android.eservices.jobs.presentation.jobdisplay;

import android.content.Intent;
import android.eservices.jobs.R;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * It is the second activity that display a detail for a specific job
 */

public class job_activity extends AppCompatActivity {

    private ImageView thumbnailImageView;
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView typeTextView;
    private TextView companyNameTextView;
    private TextView descriptionTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_activity);

        Intent intent = getIntent();

        nameTextView = findViewById(R.id.name);
        locationTextView = findViewById(R.id.location);
        typeTextView = findViewById(R.id.type);
        companyNameTextView = findViewById(R.id.companyName);
        thumbnailImageView = findViewById(R.id.image);
        descriptionTextView= findViewById(R.id.description);

        String name = intent.getExtras().getString("name");
        String location = intent.getExtras().getString("location");
        String urlPoster = intent.getExtras().getString("thumbnail");
        String type = intent.getExtras().getString("type");
        String companyName = intent.getExtras().getString("companyName");
        String description = intent.getExtras().getString("description");

        nameTextView.setText(name);
        locationTextView.setText(location);
        typeTextView.setText(type);
        companyNameTextView.setText(companyName);
        descriptionTextView.setText(Html.fromHtml(description));
        if(urlPoster!= null) {
            Glide.with(nameTextView.getContext())
                    .load(Uri.parse(urlPoster))
                    .into(thumbnailImageView);
        }
    }

}
