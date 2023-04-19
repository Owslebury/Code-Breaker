public class Cipher {
    String plaintext = "zzzzZZZZzzz";
    int key = 1;
    String ciphertext = new String();
    public void decode(){
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
