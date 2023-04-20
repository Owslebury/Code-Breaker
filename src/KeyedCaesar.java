public class KeyedCaesar extends Cipher{
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String key = "LEMON";
    String newalphabet = new String();
    int shift = 4;

    public void setShift(int shift) {
        this.shift = shift;
    }


    public void encrypt(){
        newalphabet += key;
        for (char character: alphabet.toCharArray()) {
            if (newalphabet.indexOf(character) == -1){
                newalphabet += character;
            }
        }
        System.out.println(newalphabet);
        shiftalphabet();
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
        //System.out.println(newalphabet);
        return newalphabet;
    }
    //add option for the shift to go the other way for minus numbers
}
