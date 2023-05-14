public class Caesar extends Cipher{
    int keynumber;

    /**
     * Constructor reads vey value from caesar-key.txt
     */
    public Caesar(){
        key.setFilename("caesar-key.txt");
        key = new Key();
        keynumber = key.parseAsInt();
    }

    /**
     * as the caesar takes an integer key, this function gives exception handling to the
     * conversion
     */
    public void updateKeyNumber(){
        try{
            keynumber = key.parseAsInt();
        }catch (Exception e){
            System.err.println("Key must be an integer. Key value has not been changed.");
        }

    }

    /**
     * Encrypts plaintext using the caesar cipher method
     * @return
     */

    public String encrypt(){
        ciphertext = "";
        for (char character: plaintext.toCharArray()) {
            if (Character.isUpperCase(character)) {
                character = (char) ((character + keynumber - 65) % 26 + 65);
            }
            else if (Character.isLowerCase(character)) {
                character = (char) ((character + keynumber - 97) % 26 + 97);
            }
            ciphertext += character;
        }
        return ciphertext;
    }

    /**
     * Decrypts using caesar cipher method
     * @return
     */
    public String decrypt(){
        plaintext = "";
        for (char character: ciphertext.toCharArray()) {
            if (Character.isUpperCase(character)) {
                character = (char) ((character - keynumber + 26 - 65) % 26 + 65);
            } else if (Character.isLowerCase(character)) {
                character = (char) ((character - keynumber + 26 - 97) % 26 + 97);
            }
            plaintext += character;
        }
        System.out.println(plaintext);
        return plaintext;
    }

    /**
     * edits the key and changed keynumber with exception handling
     */
    public void setKeyValue(){
        key.edit();
        updateKeyNumber();
    }

}
