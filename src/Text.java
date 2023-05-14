import java.io.*;
import java.util.Scanner;

public class Text {
    private String value = new String();

    /**
     * Reads a file and sets value, with exception handling
     */
    public void readFile(){
        System.out.println("Please enter a filename");
        Scanner userinput = new Scanner(System.in);
        String filename;
        Boolean fileFound = false;
        do {
            filename = userinput.nextLine();
            if (filename.toLowerCase().equals("q")){
                fileFound = true;
            }
            else {
                File file = new File(filename);
                try {
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()){
                        value += myReader.nextLine() + "\n";
                    }
                    fileFound = true;
                    System.out.println("File loaded\n");
                } catch (FileNotFoundException e) {
                    System.out.println("Could not find the file, enter another filename or type q to go back to main menu");
                }
            }
        } while (fileFound == false);
    }

    /**
     * Removes punctuation from a line
     * @param line
     * @return
     */
    private static String removePunctuation(String line){
        String newLine = new String();
        char space = ' ';
        for (char character: line.toCharArray()){
            if (Character.isAlphabetic(character) == true ){
                newLine += character;
            }
        }
        return newLine;
    }

    /**
     * Prints a line before and without spaces and to uppercase
     */
    public void printValue(){
        if (value != removePunctuation(value).toUpperCase()){
            System.out.println(value);
            System.out.println("Will be encrypted as: " + removePunctuation(value).toUpperCase());
        }
        else{
            System.out.println(removePunctuation(value).toUpperCase());
        }
    }

    public String getText() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Saves text to file, used for both plaintext and ciphertext
     * @throws IOException
     */
    public void saveToFile() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a file name: ");
        String fileName = reader.readLine();
        File file = new File(fileName);
        while (!file.exists()) {
            System.out.println("File does not exist. Please enter another file name");
            fileName = reader.readLine();
            file = new File(fileName);
        }
        FileWriter writer = new FileWriter(file);
        writer.write(value);
        writer.close();;
    }
}
