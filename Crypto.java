import java.lang.*;
import java.security.*;
import java.util.*;
import javax.crypto.*;

public class Crypto{
  public static final String SHA256(String password, String... saltArg) {
    try {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        String salt = "";

        if (saltArg.length > 0){
          if (saltArg[0] != null){
            salt = saltArg[0];
          }
        }

        String passWithSalt = password + salt;
        byte[] passBytes = passWithSalt.getBytes();
        byte[] passHash = sha256.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< passHash.length ;i++) {
            sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));
        }
        String generatedPassword = sb.toString();
        return generatedPassword;
    } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
    return null;
  }
}
