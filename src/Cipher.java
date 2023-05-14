import java.lang.annotation.Inherited;

public abstract class Cipher {
    /**
     * This class has default methods and attributes used by all cipher classes
     */
    String plaintext;
    protected static Key key;
    String ciphertext = new String();

    public abstract String encrypt();
    public abstract String decrypt();


    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public static void setKey(Key key) {
        Cipher.key = key;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }
    public void printKey(){
        System.out.println(key.getValue());
    }
    public void setKeyValue(){
        key.edit();
    }
}

