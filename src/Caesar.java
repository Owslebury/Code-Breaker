public class Caesar extends Cipher{
    int key;

    public void setKey(int key) {
        this.key = key;
    }

    public void encrypt(){

        for (char character: plaintext.toCharArray()) {
            if (Character.isUpperCase(character)) {
                character = (char) ((character + key - 65) % 26 + 65);
            }
            else if (Character.isLowerCase(character)) {
                character = (char) ((character + key - 97) % 26 + 97);
            }
            ciphertext += character;
        }
        System.out.println(ciphertext);
    }
}
