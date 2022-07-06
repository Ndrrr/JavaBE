package Homework2;

import Homework1.AbstractGameManager;
import Homework1.Utils;

public class GameManager extends AbstractGameManager {

    private static GameManager instance;
    private GameManager(){
    }

    public static GameManager GetInstance(){
        if(instance==null){
            instance = new GameManager();
        }
        return instance;
    }
    @Override
    protected void Awake() {

    }

    @Override
    protected boolean Update() {
        System.out.print("[0] - Exit, [1] - Shoot the square, [2] - Shoot the rectangle : ");
        int gameId = Utils.GetCorrectInt(); // Asks value until user provides valid int

        if (gameId == 0){
            System.out.println("Have a good day " + "!");
            return false;
        }
        else if (gameId == 1) {
            this.game = new Game();
            this.game.Start(null);
        } else if (gameId == 2) {
            this.game = new Game(true);
            this.game.Start(null);
        }
        return true;
    }

    @Override
    protected void Finalize() {

    }
}
