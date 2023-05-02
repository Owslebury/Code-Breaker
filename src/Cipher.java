import java.lang.annotation.Inherited;

public abstract class Cipher {
    String plaintext;
    protected static Key key;
    String ciphertext = new String();

    public abstract String encrypt();


    public String getPlaintext() {
        return plaintext;
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

