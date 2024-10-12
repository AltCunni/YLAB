package com.yourapp.HabitStatisticsExample;



import java.util.Date;
import java.text.SimpleDateFormat;

import com.yourapp.Habit.Habit;
import com.yourapp.HabitStatistics.HabitStatistics;
public class HabitStatisticsExample {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        Date startDate = formatter.parse("2023-01-01");
        Date endDate = formatter.parse("2023-10-01");



        System.out.println("Success rate from " + formatter.format(startDate) + " to " + formatter.format(endDate) + "%");
    }
}
