package Homework1;

public abstract class AbstractGameManager {
    protected AbstractGame game;

    public void Start(){
        Awake();
        boolean isFinished = false;
        while(!isFinished) {
            isFinished = !Update();
        }
        Finalize();
    }
    protected abstract void Awake();
    protected abstract boolean Update();
    protected abstract void Finalize();

}
