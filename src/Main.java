import java.util.Scanner;

public class Main {
    static Text plaintext = new Text();
    static Text ciphertext = new Text();
    static Cipher cipher;
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
                        "5. Display the plain text file\n"+
                "6. Encrypt the text\n" +
                "7. Display the cipher text\n" +
                "8. Save the cipher text\n" +
                        "9. Input the cipher text file\n" +
                        "10. Decrypt the ciphertext\n" +
                        "11. Exit");
        Scanner scanner;
        input = 0;
        do {
            scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input <1 || input > 11){
                do{
                    System.out.println("Please only enter an option between 1 and _");
                    input = scanner.nextInt();
                }while (input <1 || input > 11);
            }
        }
        else{
            System.out.println("Please enter a number");
        }
        }while (input == 0);
        switch(input){
            case 1:
               cipherChoice = getCipherChoice();
               switch (cipherChoice){
                   case 1:
                       cipher = new Caesar();
                       break;
                   case 2:
                       cipher = new KeyedCaesar();
                       break;
                   case 3:
                       cipher = new Vigenère();
                       break;
                   default:
                       System.err.println("Error: Invalid cipher choice");
                       break;
            }
               break;
            case 2:
                cipher.setKeyValue();
                break;
            case 3:
                cipher.printKey();
                break;
            case 4:
                plaintext.readFile();
                cipher.setPlaintext(plaintext.getPlaintext());
                break;
            case 5:
                plaintext.printValue();
                break;
            case 6:
                    ciphertext.setValue(cipher.encrypt());
                break;
            case 7:
                ciphertext.printValue();
                break;
            case 8:
                ciphertext.saveToFile();
        }
    }while (input != 11);
    }
    private static Integer getCipherChoice(){
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