package Homework2;

import java.util.Random;
import java.util.Scanner;

import static Homework1.Utils.CheckInt;

public class Utils {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static int GetCorrectIntForMap(){
        String tmp = sc.next();
        boolean check = CheckInt(tmp);  // checks if entered string is parseable to int
        if(check){
            int res = Integer.parseInt(tmp);
            if(res>=1 && res<=5)
                return res;
        }
        System.out.print("Please enter a valid number between 1-5: ");
        return GetCorrectIntForMap();
    }

}
