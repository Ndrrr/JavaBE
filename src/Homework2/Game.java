package Homework2;

import Homework1.AbstractGame;

import static Homework1.Utils.GetRandomInt;

public class Game extends AbstractGame {

    private class Target{
        public int x1, x2, y1, y2;
        public int hp;
        public Target(int x1, int y1, int flag){
            hp = 3;
            this.x1 = x1;
            this.x2 = x1+(1-flag)*2;
            if(this.x2>4) this.x2=0;
            this.y1 = y1;
            this.y2 = y1+flag*2;
            if(this.y2>4) this.y2=0;
        }
        public Target(int x1, int y1){
            hp = 1;
            this.x1 = this.x2 = x1;
            this.y1 = this.y2 = y1;
        }
    }

    private int[][] board = new int[5][5];
    private Target target;
    public Game(){
        target = new Target(GetRandomInt(5),GetRandomInt(5));
    }
    public Game(boolean areaShooting){
        if(!areaShooting)
            target = new Target(GetRandomInt(5),GetRandomInt(5));
        else
            target = new Target(GetRandomInt(5), GetRandomInt(5),GetRandomInt(2));
    }
    @Override
    public void Start(String username) {
        System.out.println("All set. Get ready to rumble!");
        int attackX, attackY;
        while(true){
            this.displayBoard();

            // For debug
            // Shows coordinates of target
            // System.out.println(target.x1+1 + " " + (target.x2+1) +" " + (target.y1+1) + " " + (target.y2+1));

            System.out.print("Please enter the row you want to attack: ");
            attackX = Utils.GetCorrectIntForMap()-1;

            System.out.print("Please enter the column you want to attack: ");
            attackY = Utils.GetCorrectIntForMap()-1;
            if(board[attackX][attackY] != 0){
                System.out.println("You have attacked this coordinates before.\nPlease enter the new coordinates!");
                continue;
            }
            // successfull hit
            if(attackX >= target.x1 && attackX <= target.x2
                    && attackY >= target.y1 && attackY <= target.y2){
                board[attackX][attackY]=1;
                target.hp--;
                if(target.hp==0){
                    Win();
                    break;
                }
            }
            else board[attackX][attackY] = -1; // missed hit
        }
    }

    @Override
    public void Win() {
        System.out.println("Congratulations you have won!");
    }

    private void displayBoard(){
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for(int i = 0; i < 5; i++){
            System.out.print((i+1) + " | ");
            for (int j = 0; j < 5; j++){
                System.out.print(toBoardSymbol(board[i][j])+" | ");
            }
            System.out.println();
        }
    }
    private char toBoardSymbol(int val){
        if(val==0) return '-';  // player didn't shoot yet
        if(val==-1) return '*'; // there was not an enemy at this coordinate
        return 'x';  // there was enemy at this coordinate and player shot him
    }
}
