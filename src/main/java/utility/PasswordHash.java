package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

class PasswordHashGenerate {
    String hashedPassword;
    byte[] salt;

    PasswordHashGenerate(String hashedPassword, byte[] salt) {
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }
}

public class PasswordHash {
    /**
     * To avoid the below warning, adding the private empty constructor Add a
     * private constructor to hide the implicit public one.sonarlint(java:S1118)
     */
    private PasswordHash() {
    }

    /**
     * 
     * @param passwordToHash - Password string that you want to hash
     * @param salt           - salt to add to hash value so that, later on password
     *                       it can be identified
     * @return - hashed password is returned
     */
    public static String getSHA256SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * getSalt method is used to get a unique salt
     * 
     * @return - salt is returned
     * @throws NoSuchAlgorithmException - This exception is thrown when a particular
     *                                  cryptographic algorithm is requested but is
     *                                  not available in the environment.
     */
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    /**
     * generateHashedPassword method is used to create a hashed password
     * 
     * @param password - String type password which you want to hash
     * @return - Map<String, Object> is return where the Map will have salt and the
     *         hashed_password
     * @throws NoSuchAlgorithmException - This exception is thrown when a particular
     *                                  cryptographic algorithm is requested but is
     *                                  not available in the environment.
     */
    public static PasswordHashGenerate generateHashedPassword(String password) throws NoSuchAlgorithmException {
        byte[] salt = getSalt();
        String hashedPassword = getSHA256SecurePassword(password, salt);
        // HashMap<String, Object> map = new HashMap<String, Object>();
        // HashMap<String, Object> map = new HashMap<>(); // Another way doing what's
        // done in the line above
        PasswordHashGenerate value = new PasswordHashGenerate(hashedPassword, salt);
        return value;
    }

    /**
     * equals method will be used to compare a String type password to a
     * hashed_password to check if the hash of given password is equal to the other
     * hashed_password.
     * 
     * @param password       - String type password which you want to validate
     * @param hashedPassword - String type hashed_password which you want to
     *                       validate with
     * @param salt           - Salt that was added to the hashedPassword, which now
     *                       will be added to password after hashing it
     * @return - boolean type is returned, passwords are equal or not
     */
    public static boolean equals(String password, String hashedPassword, byte[] salt) {
        String hashedGivenPassword = getSHA256SecurePassword(password, salt);

        // Returning true if hash values are equal, if not then return false
        return (hashedGivenPassword != null && hashedGivenPassword.equals(hashedPassword)) ? true : false;
    }
}
