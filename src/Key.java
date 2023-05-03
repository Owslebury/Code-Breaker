import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
public class Key {
    static String filename = "key.txt";
    static String value = "";
    public Key(String filename){

        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = content;
    }
    public static String getValue() {
        return value;
    }
    public static int parseAsInt(){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Key must be an Integer");
            result = -1;
        }
        return result;
    }

    public static void edit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to change the key to?");
        String input = scanner.nextLine();
        try{
            updateFile(input);
        }
        catch (IOException e){
            System.err.println("Could not save key to key file");
        }
        value = input;
    }
    private static void updateFile(String str) throws IOException{
        Files.write(Paths.get(filename), str.getBytes());
    }
    }
