package com.example.lab8;

import java.io.Serializable;

public class TimeClass implements Serializable {
    private int hours,min,sec;
    TimeClass(int h,int m,int s){
        this.hours=h;
        this.min=m;
        this.sec=s;
    }
    public void setHours(int h){
        this.hours=h;
    }
    public void setMin(int m){
        this.min=m;
    }
    public void setSec(int s){
        this.sec=s;
    }
    public int getHours(){
        return this.hours;
    }
    public int getMin(){
        return this.min;
    }
    public int getSec(){
        return this.sec;
    }

    public String getTime(){
        return ""+hours+":"+min+":"+sec;
    }
}
