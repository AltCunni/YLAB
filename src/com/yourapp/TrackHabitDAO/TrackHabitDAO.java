package com.yourapp.TrackHabitDAO;

import com.yourapp.HabitStatistics.HabitStatistics;
import com.yourapp.TrackHabit.TrackHabit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackHabitDAO {
    private List<TrackHabit> trackHabits;

    public TrackHabitDAO() {
        this.trackHabits = new ArrayList<>();
    }

    public void createTrackHabit(TrackHabit trackHabit) {
        trackHabits.add(trackHabit);
    }

    public TrackHabit getTrackHabit(String habitName, Date trackDate) {
        for (TrackHabit trackHabit : trackHabits) {
            if (trackHabit.getHabitName().equals(habitName) && trackHabit.getTrackDate().equals(trackDate)) {
                return trackHabit;
            }
        }
        return null;
    }

    public void editTrackHabit(TrackHabit trackHabit, boolean isCompleted) {
        trackHabit.setCompleted(isCompleted);
    }

    public void deleteTrackHabit(TrackHabit trackHabit) {
        trackHabits.remove(trackHabit);
    }

    public List<TrackHabit> getAllTrackHabits() {
        return trackHabits;
    }
}
