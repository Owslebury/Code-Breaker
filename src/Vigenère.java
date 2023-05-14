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
            ciphertext+=(newalphabet.charAt((int)key.getValue().charAt(head) - 65));
        }
        System.out.println(ciphertext);
        return ciphertext;
    }

    /**
     * Decrypts ciphertext using vigenere method
     * @return
     */
    public String decrypt(){
        for (int i = 0; i < ciphertext.length(); i++) {
            newalphabet = alphabet;
            //shifts the alphabet as the Vigenere table does
            shift = (int)ciphertext.charAt(i) - (int)key.getValue().charAt(i % key.getValue().length());
            newalphabet = shiftalphabet();
            plaintext += newalphabet.charAt((int)alphabet.indexOf(ciphertext.charAt(i)));
        }
        System.out.println(plaintext);
        return plaintext;
    }
}
