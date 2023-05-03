import java.io.*;
import java.util.Scanner;

public class Text {
    private String value = new String();
    public void readFile(){
        System.out.println("Please enter a filename");
        Scanner userinput = new Scanner(System.in);
        String filename;
        Boolean fileFound = false;
        do {
            filename = userinput.nextLine();
            if (filename == "q"){
                fileFound = true;
            }
            else {
                File file = new File(filename);
                try {
                    Scanner myReader = new Scanner(file);
                    while (myReader.hasNextLine()){
                        value += removePunctuation(myReader.nextLine().toUpperCase()) + "\n";
                    }
                    fileFound = true;
                    System.out.println("File loaded\n");
                } catch (FileNotFoundException e) {
                    System.out.println("Could not find the file, enter another filename or type q to go back to main menu");
                }
            }
        } while (fileFound == false);
    }
    private String removePunctuation(String line){
        String newLine = new String();
        char space = ' ';
        for (char character: line.toCharArray()){
            if (Character.isAlphabetic(character) == true || Character.valueOf(character).compareTo(Character.valueOf(space)) ==0 || Character.isWhitespace(character) == true ){
                newLine += character;
            }
        }
        return newLine;
    }
    public void printValue(){
        System.out.println(removePunctuation(value));
    }

    public String getPlaintext() {
        return removePunctuation(value);
    }

    public void setValue(String value) {
        this.value = value;
    }
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
