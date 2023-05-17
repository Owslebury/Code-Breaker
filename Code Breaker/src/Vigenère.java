public class Vigenère extends KeyedCaesar{
    int head = -1;
    public Vigenère(){
        key.setFilename("vigenere-key.txt");
        key = new Key();
    }
    public String encrypt(){
        String ciphertext = new String();
        //Wraps the key around the plaintext
        for (char character: plaintext.toCharArray()) {
            newalphabet = alphabet;
            //shifts the alphabet as the Vigenere table does
            shift = (int)character - 65;
            newalphabet = shiftalphabet();
            if (head == key.getValue().length() - 1){
                head = 0;
            }
            else{
                head++;
            }
            ciphertext+=(newalphabet.charAt((int)key.getValue().toUpperCase().charAt(head) - 65));
        }
        return ciphertext;
    }
    public String decrypt(){
        String decryptedText = new String();
        char decryptedChar;
        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextPos = ciphertext.charAt(i);
            char keyPos = key.getValue().toUpperCase().charAt(i % key.getValue().length());
            shift = (int) keyPos - 65;

            String newAlphabet = shiftAlphabet(shift);
            head = newAlphabet.indexOf(ciphertextPos);
            if (head != -1) {
                decryptedChar = alphabet.charAt(head);
            } else {
                decryptedChar = ciphertextPos;
            }
            decryptedText += decryptedChar;
        }
        return decryptedText;
    }
    private String shiftAlphabet(int shift) {
        String shiftedAlphabet = alphabet.substring(shift) + alphabet.substring(0, shift);
        return shiftedAlphabet;
    }
}
