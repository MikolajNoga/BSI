package EncryptionExercises;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Based on https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
 */

public class AES {

    private static SecretKeySpec secretKey;

    protected static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    protected static void encrypt(File file, String secret) throws IOException {
        String strToEncrypt = getStringFromFile(file);
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            writeStringToFile(Base64.getEncoder().
                    encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))), file);
        }
        catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
    }

    protected static void decrypt(File file, String secret) throws IOException {
        String strToDecrypt = getStringFromFile(file);
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // I need to change original getDecoder() to getMimeDecoder() to resolve problems with IllegalArgumentExceptions
            writeStringToFile(new String(cipher.doFinal(Base64.getMimeDecoder().decode(strToDecrypt))) ,file);
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
    }

    /**
     * This method is getting the string from a file
     *
     * @param  file file where from where String is read
     *
     * @return String value of data in file
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */

    protected static String getStringFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        if (stringBuilder.length() >= 1)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        return stringBuilder.toString();
    }

    /**
     * This method is writing the string to a file
     *
     * @param  file file to write in to
     * @param  str string value which will be stored in file
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */

    protected static void writeStringToFile(String str, File file) throws  IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(str);
        printWriter.close();
    }
}
