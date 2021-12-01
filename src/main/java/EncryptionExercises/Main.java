package EncryptionExercises;

import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Mikołaj Noga, Szymon Jakóbiak
 */

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide key for encrypting/decrypting: ");
        final String KEY = scanner.next();
        File testFolder = new File("src/main/java/EncryptionExercises/TestingFiles");

        System.out.println("Choice encryption algorithm.\n1.AES\n2.DES\n3.3DES");
        int choice = scanner.nextInt();
        String encryptDecryptChoice = "";
        switch (choice){
            case 1:
                System.out.println("Choose 1 to encrypt files, or 2 to decrypt");
                encryptDecryptChoice  = scanner.next();
                if (encryptDecryptChoice.equals("1")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        try {
                            AES.encrypt(file, KEY);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else if (encryptDecryptChoice.equals("2")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        try {
                            AES.decrypt(file, KEY);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else
                    System.out.println("You entered wrong number");
                break;
            case 2:
                System.out.println("Choose 1 to encrypt files, or 2 to decrypt");
                encryptDecryptChoice  = scanner.next();
                if (encryptDecryptChoice.equals("1")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        DES des = new DES(KEY);
                        try{
                            AES.writeStringToFile(des.encrypt(AES.getStringFromFile(file)), file);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (encryptDecryptChoice.equals("2")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        DES des = new DES(KEY);
                        try{
                            AES.writeStringToFile(des.decrypt(AES.getStringFromFile(file)), file);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                } else
                    System.out.println("You entered wrong number");
                break;
            case 3:
                System.out.println("Choose 1 to encrypt files, or 2 to decrypt");
                encryptDecryptChoice  = scanner.next();
                if (encryptDecryptChoice.equals("1")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        IDEA idea = new IDEA(KEY);
                        try{
                            AES.writeStringToFile(idea.encrypt(AES.getStringFromFile(file)), file);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (encryptDecryptChoice.equals("2")){
                    for(final File file: Objects.requireNonNull(testFolder.listFiles())) {
                        IDEA idea = new IDEA(KEY);
                        try{
                            AES.writeStringToFile(idea.decrypt(AES.getStringFromFile(file)), file);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                } else
                    System.out.println("You entered wrong number");
                break;
            default:
                System.out.println("You entered wrong number");
        }

    }
}
