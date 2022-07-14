package Homework3;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeekPlanner weekPlanner = new WeekPlanner();
        while (true) {
            System.out.print("Please, input the day of the week: ");
            String[] response = sc.nextLine().trim().split(" ",2);


//            if(Objects.equals(response[0], "") && response.length>1){ // if the user input comes after spaces
//                response = response[1].trim().split(" ",2);
//            }
            response[0] = response[0].trim().toLowerCase();

            if(response.length>1){
                response[1] = response[1].trim().toLowerCase();
            }
            if (response[0].equals("exit")) {
                break;
            }
            if(response[0].equals("change")||response[0].equals("reschedule")){
                if(response.length <2){
                    System.out.println("Syntax for change/reschedule: change <day> | reschedule <day>");
                    continue;
                }
                System.out.println("Please enter task for " + response[1] );
                String newTask = sc.nextLine();
                switch (response[1]){
                    case "sunday" -> weekPlanner.modifyTaskForDay(0, newTask);
                    case "monday" -> weekPlanner.modifyTaskForDay(1, newTask);
                    case "tuesday" -> weekPlanner.modifyTaskForDay(2, newTask);
                    case "wednesday" -> weekPlanner.modifyTaskForDay(3, newTask);
                    case "thursday" -> weekPlanner.modifyTaskForDay(4, newTask);
                    case "friday" -> weekPlanner.modifyTaskForDay(5, newTask);
                    case "saturday" -> weekPlanner.modifyTaskForDay(6, newTask);
                    default -> System.out.println("Invalid day of the week");
                }
            }
            else {
                switch (response[0]) {
                    case "sunday" -> System.out.println("The task for " + weekPlanner.getDay(0) + " is: " + weekPlanner.getTaskForDay(0));
                    case "monday" -> System.out.println("The task for " + weekPlanner.getDay(1) + " is: " + weekPlanner.getTaskForDay(1));
                    case "tuesday" -> System.out.println("The task for " + weekPlanner.getDay(2) + " is: " + weekPlanner.getTaskForDay(2));
                    case "wednesday" -> System.out.println("The task for " + weekPlanner.getDay(3) + " is: " + weekPlanner.getTaskForDay(3));
                    case "thursday" -> System.out.println("The task for " + weekPlanner.getDay(4) + " is: " + weekPlanner.getTaskForDay(4));
                    case "friday" -> System.out.println("The task for " + weekPlanner.getDay(5) + " is: " + weekPlanner.getTaskForDay(5));
                    case "saturday" -> System.out.println("The task for " + weekPlanner.getDay(6) + " is: " + weekPlanner.getTaskForDay(6));
                    default -> System.out.println("Sorry, I don't understand you, please try again");
                }
            }
        }
    }
}
