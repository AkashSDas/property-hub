package utility;

public class PasswordHashGenerate {
    public String hashedPassword;
    public byte[] salt;

    PasswordHashGenerate(String hashedPassword, byte[] salt) {
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }
}
