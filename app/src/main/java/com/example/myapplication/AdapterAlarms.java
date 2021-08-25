package com.example.myapplication;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdapterAlarms extends BaseAdapter {

    Context context;
    List<EventData> alarmList = new ArrayList<>();
    TextView tvName, tvDate, tvTime;
    Switch swNotify;

    public AdapterAlarms(List<EventData> alarmList, Context context) {
        this.context = context;
        this.alarmList = alarmList;
        //getEventData();
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int i) {
        return alarmList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alarmList.get(i).getId();
    }

    public void getEventData() {
      /*  SharedPreferences S = context.getSharedPreferences("EventsData", Context.MODE_PRIVATE);
        int count = S.getInt("count", 0);

        events = new ArrayList<EventData>();
        for (int i = 0; i < count; i++) {
            events.add(new EventData(
                    i,
                    S.getInt("hour" + i, 0),
                    S.getInt("min" + i, 0),
                    S.getInt("day" + i, 0),
                    S.getInt("month" + i, 0),
                    S.getInt("year" + i, 0),
                    S.getString("name" + i, ""),
                    S.getBoolean("notify" + i, true)
            ));
        }*/
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        //String.format("%02d:%02d"
        final View V = LayoutInflater.from(context).inflate(R.layout.alarm_list, viewGroup, false);
        ((TextView) V.findViewById(R.id.tvAName)).setText(alarmList.get(i).getEventName());
        ((TextView) V.findViewById(R.id.tvADate)).setText(String.valueOf( alarmList.get(i).getTime()));
        ((TextView) V.findViewById(R.id.tvATime)).setText(String.valueOf( alarmList.get(i).getTime()));
        if (alarmList.get(i).getNotify())
            ((Switch) V.findViewById(R.id.swNotify)).setChecked(true);
        else
            ((Switch) V.findViewById(R.id.swNotify)).setChecked(false);


       /* ((Switch) V.findViewById(R.id.swNotify)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    Intent intent = new Intent(context, Reciever.class);
                    intent.putExtra("id", i);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, i, intent, 0);

                    AlarmManager Al = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Al.cancel(pendingIntent);

                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.HOUR_OF_DAY, hour);
                    cal.set(Calendar.MINUTE, min);
                    cal.set(Calendar.SECOND, 0);

                    String[] days = new String[]{"S", "M", "T", "W", "Th", "F", "Sa"};

                    if (cal.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
                        cal.add(Calendar.DATE, 1);
                    }
                    if (Objects.get(i).repeat) {
                        while (!Objects.get(i).Days.contains("," + days[cal.getTime().getDay()] + ",")) {
                            cal.add(Calendar.DATE, 1);
                        }
                    }
                    Log.d("work", cal.getTime().toString());
                    Al.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                    Toast.makeText(context, "Alarm is Set on " + String.format("%02d:%02d", hour, min) + " on " + new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}[cal.getTime().getDay()], Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(context, Reciever.class);
                    intent.putExtra("id", i);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, i, intent, 0);

                    AlarmManager Al = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    Al.cancel(pendingIntent);
                    Toast.makeText(context, "The Alarm was Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/

        return V;
    }

}
