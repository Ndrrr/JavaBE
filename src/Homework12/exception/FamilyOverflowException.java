package Homework12.exception;

public class FamilyOverflowException extends RuntimeException{
    public FamilyOverflowException(String errorMessage){
        super(errorMessage);
    }
}
