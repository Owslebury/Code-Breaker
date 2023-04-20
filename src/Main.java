import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    static Integer cipherChoice;
    public static void main(String[] args) {
        menu();
    }
    private static void menu(){
        System.out.println("WELCOME TO CODEBREAKER!\n");
        int input;
        do{
         System.out.println(
                "Please select an option:\n" +
                "1. Choose a Cipher\n" +
                "2. Edit the key\n" +
                "3. Display the key\n" +
                "4. Input a text file\n" +
                "5. Encrypt the text\n" +
                "6. Display the cipher text\n" +
                "7. ");
        Scanner scanner;
        input = 0;
        do {
            scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input <1 || input > 9){
                do{
                    System.out.println("Please only enter an option between 1 and _");
                    input = scanner.nextInt();
                }while (input <1 || input > 9);
            }
        }
        else{
            System.out.println("Please enter a number");
        }
        }while (input == 0);
        switch(input){
            case 1:
               cipherChoice = Cipher();
        }
    }while (input != 9);
    }
    private static Integer Cipher(){
        System.out.println("Which cipher would you like to use?\n\n" +
                "1. Caesar\n" +
                "2. Keyed Caesar\n" +
                "3. Vigenere");
        Scanner scanner = new Scanner(System.in);
        Integer choice = 0;
        do {
            try {
                choice = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Please only enter a number 1-3");
            }
            if (choice < 1 || choice > 3){
                System.out.println("Please only enter a number 1-3");
            }
        }while (choice < 1 || choice > 3);
        return choice;
    }




}