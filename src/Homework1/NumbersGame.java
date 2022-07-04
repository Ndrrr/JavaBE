package Homework1;

import java.util.Arrays;

public class NumbersGame implements Game {
    private int hiddenNumber;
    private int[] userNumbers = new int[1000];
    private int currentIndex = 0;
    private String username;
    public NumbersGame(){
        this.hiddenNumber = Utils.GetRandomInt(100);
    }
    public void Start(String username){
        this.username=username;
        System.out.println("Let the game begin!");
        while(true){
            System.out.print("Please enter the number: ");
            int userNumber = Utils.GetCorrectInt();
            userNumbers[currentIndex++] = userNumber;
            if(userNumber < hiddenNumber){
                System.out.println("Your number is too small. Please, try again.");
                showUserNumbers();
            }
            else if(userNumber > hiddenNumber){
                System.out.println("Your number is too big. Please, try again");
                showUserNumbers();
            }
            else{
                this.Win();
                return;
            }
        }
    }
    private void reverseSort(){
        Arrays.sort(userNumbers,0, currentIndex);
        for (int i = 0; i < currentIndex/2 ; i++) {
            int tmp = userNumbers[i];
            userNumbers[i] = userNumbers[currentIndex-i-1];
            userNumbers[currentIndex-i-1] = tmp;
        }
    }
    private void showUserNumbers(){
        reverseSort();
        System.out.print("Your Numbers: ");
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(userNumbers[i] +" ");
        }
        System.out.println();
    }
    public void Win(){
        System.out.println("Congratulations, " + username +"!");
    }

}
