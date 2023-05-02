public class Caesar extends Cipher{
    int keynumber = key.parseAsInt();

    public void encrypt(){

        for (char character: plaintext.toCharArray()) {
            if (Character.isUpperCase(character)) {
                character = (char) ((character + keynumber - 65) % 26 + 65);
            }
            else if (Character.isLowerCase(character)) {
                character = (char) ((character + keynumber - 97) % 26 + 97);
            }
            ciphertext += character;
        }
        System.out.println(ciphertext);
    }

}
