package Homework13.log;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private final String path = "application.log";
    private Logger(){
    }
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    private void log(String message, Status status){
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + " [" + status + "] " + message + "\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void info(String message){
        log(message, Status.DEBUG);
    }
    public void error(String message){
        log(message, Status.ERROR);
    }
    enum Status{
        DEBUG, ERROR
    }
}
