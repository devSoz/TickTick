package com.example.myapplication;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AlarmTable")
public class EventData {

    @PrimaryKey(autoGenerate = true)
    private int id;
    /*    int itr;
        int ehour;
    int emin;
    int eday;
    int emonth;
    int eyear;*/
    private long time;
    private String eventName;
    private boolean notify;

        public EventData(Long time, String eventName, boolean notify)
        {//int itr ,int ehour, int emin, int eday, int emonth, int eyear, String eventName, boolean isnotify) {
            //this.itr = itr;
            //this.ehour = ehour;
            //this.emin = emin;
            //this.eday = eday;
            //this.emonth = emonth;
            //this.eyear = eyear;
            this.time = time;
            this.eventName = eventName;
            this.notify = notify;
        }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setTime(Long eTime)
    {
        this.time = eTime;
    }


    public String getEventName() {
        return this.eventName;
    }

   public long getTime()
   {
       return this.time;
   }

    public Boolean getNotify() {
        return this.notify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
