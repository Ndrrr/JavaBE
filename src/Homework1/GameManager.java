package Homework1;

import jdk.jshell.execution.Util;

import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private Game game;
    private String username;
    private static GameManager instance;
    private GameManager(){
    }

    public static GameManager GetInstance(){
        if(instance==null){
            instance = new GameManager();
        }
        return instance;
    }
    public void Start(){
        username = GetUsername();
        while(true) {
            System.out.print("[0] - Exit, [1] - Number Guess Game, [2] - Quiz Game: ");
            int gameId = Utils.GetCorrectInt();
            if (gameId == 0){
                break;
            }
            else if (gameId == 1) {
                this.game = new NumbersGame();
                this.game.Start(username);
            } else if (gameId == 2) {
                // Quizz game will be here
            }
        }
    }
    private String GetUsername(){
        System.out.print("Please enter you username: ");
        return Utils.sc.next();
    }
}
