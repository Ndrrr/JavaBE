package Homework1;

import java.util.Arrays;

public class NumbersGame extends AbstractGame {
    private int hiddenNumber;
    private int[] userNumbers = new int[3000];
    private int currentIndex = 0;
    private String username;
    private boolean historyBoost = false;
    private String[][] questionArray = new String[2500][1000];
    public NumbersGame(){
        this.hiddenNumber = Utils.GetRandomInt(100);
    }
    public NumbersGame(boolean historyBoost){
        this.historyBoost = historyBoost;
        this.hiddenNumber = getAvailableYear();
    }
    public void Start(String username){
        this.username=username;

        hardcodedInitialize(); //

        System.out.println("Let the game begin!");

        // main game loop
        while(true){
            System.out.print("Please enter the number: ");
            if(historyBoost){
                System.out.println('\n' + getHint());
            }
            int userNumber = Utils.GetCorrectInt(); // Asks value until user gives valid int

            userNumbers[currentIndex++] = userNumber; // Stores numbers user entered

            if(userNumber < hiddenNumber){
                System.out.println("Your number is too small. Please, try again.");
                showUserNumbers();  // Displays previously entered numbers
            }
            else if(userNumber > hiddenNumber){
                System.out.println("Your number is too big. Please, try again");
                showUserNumbers();  // Displays previously entered numbers
            }
            else{
                this.Win(); //
                return;
            }
        }
    }
    public void Win(){
        System.out.println("Congratulations, " + username +"!");
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
    private void hardcodedInitialize(){
        questionArray[1918][0] = "When did the WW I ended?";
        questionArray[1918][1] = "When did the Azerbaijan declared independence?";
        questionArray[1914][0] = "When did the WW I begin?";
        questionArray[1939][0] = "When did the WW II begin?";
        questionArray[1945][0] = "When did the WW II ended?";
    }
    private int getAvailableYear(){
        int tmp = Utils.GetRandomInt();
        if(tmp%5==0 || tmp%19==0) return 1945;
        if(tmp%7==0 || tmp% 23 ==0) return 1914;
        if(tmp%13==0 || tmp%11==0) return 1939;
        else return 1918;
    }
    private String getHint(){
        int questionCount = 0;
        for(int i = 0; i < 1000;i++){
            if(questionArray[hiddenNumber][i]==null){
                break;
            }
            questionCount++;
        }
        return questionArray[hiddenNumber][currentIndex%questionCount];
    }
}
