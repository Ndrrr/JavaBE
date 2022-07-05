package Homework1;

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
            System.out.print("[0] - Exit, [1] - Number Guess Game, [2] - Same Game with historical hints : ");
            int gameId = Utils.GetCorrectInt(); // Asks value until user provides valid int

            if (gameId == 0){
                System.out.println("Have a good day " + username + "!");
                break;
            }
            else if (gameId == 1) {
                this.game = new NumbersGame();
                this.game.Start(username);
            } else if (gameId == 2) {
                // Question set is too small as it is just for testing
                // So repetition is inevitable in this mode
                this.game = new NumbersGame(true);
                this.game.Start(username);
            }
        }
    }
    private String GetUsername(){
        System.out.print("Please enter you username: ");
        return Utils.sc.next();
    }
}
