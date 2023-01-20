package org.example.customExceptions;

public class InvalidArmorException extends Exception{
    public InvalidArmorException(String str){
        super(str);
    }

}
