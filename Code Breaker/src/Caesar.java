public class Caesar extends Cipher{
    int keynumber;
    public Caesar(){
        key.setFilename("caesar-key.txt");
        key = new Key();
        keynumber = key.parseAsInt();
    }

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

    public void setKeyValue(){
        key.edit();
        keynumber = key.parseAsInt();
    }

}
