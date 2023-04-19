import java.lang.annotation.Inherited;

public class Cipher {
    String plaintext;
    int key;
    String ciphertext = new String();


    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }
}
