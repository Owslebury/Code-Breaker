import java.util.Scanner;
public class KeyedCaesar extends Cipher{
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String newalphabet = new String();
    int shift = 4;

    public KeyedCaesar(){
        key.setFilename("keyed-caesar-key.txt");
        key = new Key();

    }

    public void setShift(int shift) {
        this.shift = shift;
    }


    public String encrypt(){
        System.out.println("Please enter a shift value");
        Scanner scanner = new Scanner(System.in);
        shift = scanner.nextInt() % 26;

        newalphabet += removePunctuation(key.getValue().toUpperCase());
        for (char character: alphabet.toCharArray()) {
            if (newalphabet.indexOf(character) == -1){
                newalphabet += character;
            }
        }
        //return newalphabet;
        shiftalphabet();
        System.out.println("Adjusted alphabet = " + newalphabet);
        //System.out.println("Custom shift:");
        //System.out.println(customShift());
        return customShift();
    }
    public String decrypt(){
        plaintext = "";
        System.out.println("Please enter a shift value");
        Scanner scanner = new Scanner(System.in);
        shift = scanner.nextInt();

        newalphabet += removePunctuation(key.getValue().toUpperCase());
        for (char character: alphabet.toCharArray()) {
            if (newalphabet.indexOf(character) == -1){
                newalphabet += character;
            }
        }
        //return newalphabet;
        shiftalphabet();
        for (char character: ciphertext.toCharArray()) {
            plaintext += alphabet.charAt(newalphabet.indexOf(character));
        }
        return plaintext;
    }
    public String shiftalphabet(){
        String shiftAlphabet = new String();
        for (int i = shift; i < newalphabet.length(); i++){
            shiftAlphabet += newalphabet.charAt(i);
        }
        for (int i = 0; i < shift; i++){
            shiftAlphabet += newalphabet.charAt(i);
        }
        newalphabet = shiftAlphabet;
        return newalphabet;
    }
    private String customShift (){
        for (char character: plaintext.toCharArray()) {
            ciphertext += (newalphabet.charAt(alphabet.indexOf(character)));
        }
        return ciphertext;
    }
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
    //add option for the shift to go the other way for minus numbers
}
