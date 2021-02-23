package android.eservices.jobs.data.db;


import android.eservices.jobs.data.entity.JobEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {JobEntity.class}, version = 1, exportSchema = false)
public abstract class JobDatabase extends RoomDatabase {
}