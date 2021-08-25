package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.Database.DatabaseInterface;

import java.util.ArrayList;
import java.util.List;

public class ShowAlarms extends AppCompatActivity {

    private Button btnNew;
    private CreateDatabase createDb;
    private DatabaseInterface dao;
    private ListView alarmListView;
    private List<EventData> alarmList = new ArrayList<>();
    private AdapterAlarms adapterAlarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_alarms);
        alarmListView = findViewById(R.id.listview);
        btnNew = (Button) findViewById(R.id.btnNew) ;
        createNewAlarm();

    }

    @Override
    protected void onResume() {
        showAlarms();
        super.onResume();
    }

    public void createNewAlarm()
    {
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowAlarms.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showAlarms()
    {
        alarmList.clear();
        createDb = CreateDatabase.getInstance(this);
        dao = createDb.Dao();
        alarmList =  dao.getAlarmList();

        adapterAlarms = new AdapterAlarms(alarmList, this);
        alarmListView.setAdapter(adapterAlarms);
    }
}