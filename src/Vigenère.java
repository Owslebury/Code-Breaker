public class Vigenère extends KeyedCaesar{
    int head = -1;

    /**
     * Constructor reads key value from vigenere-key.txt
     */
    public Vigenère(){
        key.setFilename("vigenere-key.txt");
        key = new Key();
    }

    /**
     * Encrypts plaintext using vigenere method
     * @return
     */
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

    /**
     * Decrypts ciphertext using vigenere method
     * @return
     */
    public String decrypt(){
        String decryptedText = new String();
        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = ciphertext.charAt(i);
            char keyChar = key.getValue().toUpperCase().charAt(i % key.getValue().length());
            int shift = (int) keyChar - 65;

            String newAlphabet = shiftAlphabet(shift);
            int decryptedCharIndex = newAlphabet.indexOf(ciphertextChar);
            char decryptedChar = (decryptedCharIndex != -1) ? alphabet.charAt(decryptedCharIndex) : ciphertextChar;
            decryptedText += decryptedChar;
        }
        return decryptedText;
    }
    private String shiftAlphabet(int shift) {
        String shiftedAlphabet = alphabet.substring(shift) + alphabet.substring(0, shift);
        return shiftedAlphabet;
    }
}
