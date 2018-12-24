package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterractor implements Interractor {
    private Scanner scanner = new Scanner(System.in);
    private  final String INCORRECTINPUTMSG = "Incorrect enter. Please try again.";
    public void print(String string){
        System.out.print(string);
    }
    public void printWithNewLine(String string){
        System.out.println(string);
    }
    public String  entetString(){
        return scanner.nextLine();
    }
    public void print(Object object){
        this.print(object.toString());
    }
    public int enterInt(){
        boolean isInt;
        int out = 0;
        while (true){
            isInt = true;
            try {
                out = Integer.parseInt(this.entetString());
            }
            catch (NumberFormatException e){
                this.printWithNewLine(INCORRECTINPUTMSG);
                isInt = false;
            }
            if (isInt){
                return out;
            }
        }
    }
}
