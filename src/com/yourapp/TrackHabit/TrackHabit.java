package com.yourapp.TrackHabit;

import com.yourapp.HabitStatistics.HabitStatistics;

import java.util.Date;

public class TrackHabit {
    private String habitName;
    private Date trackDate;
    private boolean isCompleted;

    public TrackHabit(String habitName, Date trackDate, boolean isCompleted) {
        this.habitName = habitName;
        this.trackDate = trackDate;
        this.isCompleted = isCompleted;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
