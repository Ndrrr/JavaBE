package Homework13.exception;

public class FamilyOverflowException extends RuntimeException{
    public FamilyOverflowException(String errorMessage){
        super(errorMessage);
    }
}
