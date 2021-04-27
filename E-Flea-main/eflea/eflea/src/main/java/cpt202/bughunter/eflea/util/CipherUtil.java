package cpt202.bughunter.eflea.util;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.NoSuchAlgorithmException;

public class CipherUtil {
    private static String KEY = "cpt202bughunter!";

    private static String IV = "cpt202bughunter!";

    public static String encrypt(String data) throws Exception{
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if(plaintextLength % blockSize != 0){
                plaintextLength = plaintextLength + (blockSize-(plaintextLength%blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes,0,plaintext,0,dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(KEY.getBytes(),"AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new Base64().encodeToString(encrypted);

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data) throws Exception{
        try {
            byte[] encrypted = new Base64().decode(data);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(KEY.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted);
            String originalString = new String(original);
            return originalString.trim();


        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
