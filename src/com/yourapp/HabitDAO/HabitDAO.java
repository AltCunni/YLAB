package com.yourapp.HabitDAO;


import com.yourapp.Habit.Habit;
import com.yourapp.HabitStatistics.HabitStatistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HabitDAO {
    private List<Habit> habits;

    public HabitDAO() {
        this.habits = new ArrayList<>();
    }

    public void createHabit(Habit habit) {
        habits.add(habit);
    }

    public Habit getHabit(String name) {
        for (Habit habit : habits) {
            if (habit.getName().equals(name)) {
                return habit;
            }
        }
        return null;
    }

    public void editHabit(Habit habit, String name, String description, String frequency) {
        habit.setName(name);
        habit.setDescription(description);
        habit.setFrequency(frequency);
    }

    public void deleteHabit(Habit habit) {
        habits.remove(habit);
    }

    public List<Habit> getAllHabits() {
        return habits;
    }
    public void updateHabit(Habit habit) {

    }
    private static void generateProgressReport(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String habitName = scanner.next();
        Habit habit = habitDAO.getHabit(habitName);

        if (habit != null) {
            int streak = HabitStatistics.getStreak(habit);
            double successRate = HabitStatistics.getSuccessRate(habit, new Date(), new Date());

            System.out.println("Current streak: " + streak);
            System.out.println("Success rate: " + successRate + "%");
        } else {
            System.out.println("Habit not found.");
        }
    }

}

