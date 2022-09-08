package Homework13.consoleview;

import Homework13.model.Abstract.AbstractHuman;
import Homework13.model.Concrete.Man;
import Homework13.model.Concrete.Woman;
import Homework13.Context;
import Homework13.log.Logger;

import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleUtils {
    static Scanner sc = Context.getInstance().getScanner();
    public static boolean checkInt(String tmp){
        if(tmp == null) return false;
        try{
            Integer.parseInt(tmp);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    public static int getCorrectInt(){
        String tmp = sc.next();
        if(checkInt(tmp)){
            sc.nextLine();
            return Integer.parseInt(tmp);
        }
        System.out.print("Please enter a valid number: ");
        return getCorrectInt();
    }
    public static int getCorrectInt(Predicate<Integer> predicate, String errorMessage){
        String tmp = sc.next();
        if(checkInt(tmp)){
            int parsed = Integer.parseInt(tmp);
            if(predicate.test(parsed)) {
                sc.nextLine();
                return Integer.parseInt(tmp);
            }
            else{
                System.out.println(errorMessage);
            }
        }
        System.out.print("Please enter a valid number: ");
        return getCorrectInt(predicate, errorMessage);
    }
    public static int askSingleInt(){
        System.out.print("Please specify value: ");
        return getCorrectInt();
    }

    public static AbstractHuman askHumanData(boolean gender){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Please enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Please enter birth year: ");
        int birthYear = getCorrectInt(year -> year > 1900 && year < 2022,"Almost impossible birth year :D\nBirth year must be between 1900 and 2022\n");
        System.out.print("Please enter birth month in number[1-12]: ");
        int monthId = getCorrectInt(month -> month > 0 && month < 13, "Month value must be between 1 and 12");
        System.out.print("Please enter birth day: ");
        int birthDay = getCorrectInt(day -> day > 0 && day < 32, "Day of month must be between 1 and 31");
        String birthDate = birthDay + "/" + monthId + "/" + birthYear;
        System.out.print("Please enter iq: ");
        int iq = getCorrectInt();
        if(gender)
            return new Woman(firstName, lastName, birthDate, iq);
        else
            return new Man(firstName, lastName, birthDate, iq);

    }
}
