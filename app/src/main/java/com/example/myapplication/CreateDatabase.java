package com.example.myapplication;
import com.example.myapplication.Database.DatabaseInterface;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
@Database(entities = {EventData.class}, version = 1)
public abstract class CreateDatabase extends RoomDatabase {

        private static CreateDatabase instance;

        public abstract DatabaseInterface Dao();

        public static synchronized CreateDatabase getInstance(Context context) {

            if (instance == null) {
                instance =
                        Room.databaseBuilder(context.getApplicationContext(),
                                CreateDatabase.class, "alarm_db")
                                .fallbackToDestructiveMigration()
                                .addCallback(roomCallback)
                                .allowMainThreadQueries()
                                .build();
            }
            return instance;
        }

        private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                new PopulateDbAsyncTask(instance).execute();
            }
        };

        private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
            PopulateDbAsyncTask(CreateDatabase instance) {
                DatabaseInterface dao = instance.Dao();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        }
    }
