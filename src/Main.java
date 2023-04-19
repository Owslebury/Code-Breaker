import java.util.*;
public class Main {
    public static void main(String[] args) {
        Cipher lol = new Cipher();
        lol.decode();
    }
    private static void menu(){
        System.out.println("WELCOME TO CODEBREAKER!" +
                "" +
                "Please select an option:\n" +
                "1. Choose a Cipher\n" +
                "2. Edit the key\n" +
                "3. Display the key\n" +
                "4. Input a text file\n" +
                "5. Encrypt the text\n" +
                "6. Display the cipher text\n" +
                "7. ");
        Scanner scanner;
        int input = 0;
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

        }
    }

}