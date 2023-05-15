import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
public class Key extends Text{

    static String filename = new String();
    static String value = "";
    public Key(){

        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.err.println(filename + " not found.");
            e.printStackTrace();
        }
        value = content;
    }
    public static void setFilename(String filename) {
        Key.filename = filename;
    }
    public static String getValue() {
        return value;
    }
    public static int parseAsInt(){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Key must be an Integer. Please edit the key.");
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
