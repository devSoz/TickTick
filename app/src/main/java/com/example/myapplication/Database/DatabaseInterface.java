package com.example.myapplication.Database;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.EventData;
import com.example.myapplication.EventData;
import java.util.List;

import java.util.List;

    @androidx.room.Dao
    public interface DatabaseInterface {

        @Insert
        void insert(EventData model);

        @Update
        void update(EventData model);

        @Delete
        void delete(EventData model);

        @Query("DELETE FROM AlarmTable WHERE id = :eId")
        void deleteById(Integer eId);

        @Query("select * from AlarmTable ORDER BY id ASC")
        List<EventData> getAlarmList();

        @Query("select * from AlarmTable WHERE time = :time")
        EventData getAlarm(Long time);

        //@Query("SELECT * FROM FaveDoge ORDER BY id ASC")
        //LiveData<List<favDoge>> getFavDoge();
    }



