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
            ciphertext+=(newalphabet.charAt((int)key.getValue().charAt(head) - 65));
        }
        System.out.println(ciphertext);
        return ciphertext;
    }
    public String decrypt(){
        return "HA";
    }
}
