package Homework3;

public class WeekPlanner {
    private String[][] schedule = new String[7][2];

    public WeekPlanner(){
        fillSchedule();
    }
    public String getDay(int day){
        return schedule[day][0];
    }
    public String getTaskForDay(int day){
        return schedule[day][1];
    }
    public String modifyTaskForDay(int day, String task){
        return schedule[day][1] = task;
    }
    private void fillSchedule(){
        schedule[0][0] = "Sunday";
        schedule[1][0] = "Monday";
        schedule[2][0] = "Tuesday";
        schedule[3][0] = "Wednesday";
        schedule[4][0] = "Thursday";
        schedule[5][0] = "Friday";
        schedule[6][0] = "Saturday";
        schedule[0][1] = "Task 1";
        schedule[1][1] = "Task 2";
        schedule[2][1] = "Task 3";
        schedule[3][1] = "Task 4";
        schedule[4][1] = "Task 5";
        schedule[5][1] = "Task 6";
        schedule[6][1] = "Task 7";
    }
}
