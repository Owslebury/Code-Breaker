import java.util.Scanner;

public class Main {
    static Text plaintext = new Text();
    static Text ciphertext = new Text();
    static Cipher cipher;
    static Key key;
    static Integer cipherChoice;
    static Boolean cipherNeedsPlaintext = false;
    static Boolean cipherNeedsCiphertext = false;
    public static void main(String[] args) {
        menu();
    }

    /**
     * Menu takes user input 1-11 and calls functions for each of the selected options. cipher variable
     * is a global variable and most options just call its public functions.
     */
    private static void menu(){
        System.out.println("WELCOME TO CODEBREAKER!\n");
        int input;
        do{
         System.out.println(
                "Please select an option:\n" +
                "1. Choose a Cipher\n" +
                "2. Edit the key\n" +
                "3. Display the key\n" +
                "4. Input a plain text file\n" +
                        "5. Display the plain text file\n"+
                "6. Encrypt the plain text\n" +
                "7. Display the cipher text\n" +
                "8. Save the cipher text to a user specified file\n" +
                        "9. Input the cipher text file\n" +
                        "10. Decrypt the cipher text\n" +
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
                System.out.println("Cipher set");
               break;
            case 2:
                if (checkCipher(true)){
                    cipher.setKeyValue();
                }
                break;
            case 3:
                if (checkCipher(true)){
                    cipher.printKey();
                }
                break;
            case 4:
                plaintext.readFile();
                if (checkCipher(false)){
                    cipher.setPlaintext(plaintext.getText());
                    System.out.println("Plaintext set");
                }
                else{
                    cipherNeedsPlaintext = true;
                }
                break;
            case 5:
                plaintext.printValue();
                break;
            case 6:
                cipher.setCiphertext("");
                if (checkCipher(true)){
                    if (cipher.getPlaintext() == null){
                        System.err.println("You have not added any plaintext");
                    }
                    else{
                        ciphertext.setValue(cipher.encrypt());
                        System.out.println("Plaintext has been encrypted");
                    }
                }
                break;
            case 7:
                ciphertext.printValue();
                break;
            case 8:
                try{
                    ciphertext.saveToFile();
                }
                catch (Exception e){
                    System.err.println("Filename error saving cipher text to file");
                }
            case 9:
                ciphertext.readFile();
                if (checkCipher(false)){
                    cipher.setCiphertext(ciphertext.getText());
                    System.out.println("Ciphertext set");
                }
                else{
                    cipherNeedsCiphertext = true;
                }
                break;
            case 10:
                cipher.setPlaintext("");
                if (checkCipher(true)){
                    plaintext.setValue(cipher.decrypt());
                }
                System.out.println(plaintext.getText());

        }
    }while (input != 11);
    }

    /**
     * Gets the choice of cipher and sets the cipher abstract class to the cipher class
     * @return
     */
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

    /**
     * This function checks if the cipher is null
     * and if there is pending plaintext/ciphertext to be added, it adds it to the cipher
     * @param printErrorMessage
     * @return
     */
    private static boolean checkCipher(boolean printErrorMessage){
        if (cipher == null){
            if (printErrorMessage){
                System.err.println("Please set the cipher first");
            }
            return false;
        }
        else{
            if (cipherNeedsPlaintext){
                cipher.setPlaintext(plaintext.getText());
                cipherNeedsPlaintext = false;
            }
            if (cipherNeedsCiphertext){
                cipher.setCiphertext(ciphertext.getText());
                cipherNeedsCiphertext = false;
            }
            return true;
        }
    }




}