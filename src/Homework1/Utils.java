package Homework1;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static int GetRandomInt(int bound){
        return rand.nextInt(bound);
    }
    public static int GetRandomInt(){
        return rand.nextInt();
    }
    private static boolean checkInt(String tmp){
        if(tmp == null) return false;
        try{
            int tmpInt = Integer.parseInt(tmp);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    public static int GetCorrectInt(){
        String tmp = sc.next();
        boolean check = checkInt(tmp);
        if(check){
            return Integer.parseInt(tmp);
        }
        System.out.print("Please enter a valid number: ");
        return GetCorrectInt();
    }
}
