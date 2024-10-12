package com.yourapp.Habit;



import com.yourapp.HabitDAO.HabitDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Habit {
    private String name;
    private List<Date> completionDates;
    private String description;
    private String frequency;


    public Habit(String name, String description, String frequency) {
        this.name = name;
        this.completionDates = new ArrayList<>();
        this.description = description;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public void markAsCompleted() {
        completionDates.add(new Date()); // Добавляем текущую дату
    }

    public List<Date> getCompletionDates() {
        return completionDates;
    }
    private static void markHabitAsCompleted(HabitDAO habitDAO, Scanner scanner) {
        System.out.println("Enter habit name:");
        String habitName = scanner.next();
        Habit habit = habitDAO.getHabit(habitName);

        if (habit != null) {
            habit.markAsCompleted();
            habitDAO.updateHabit(habit); // Обновляем привычку в базе данных
            System.out.println("Habit marked as completed!");
        } else {
            System.out.println("Habit not found.");
        }
    }


}
