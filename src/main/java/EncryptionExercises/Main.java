package EncryptionExercises;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide key for encrypting/decrypting: ");
        final String KEY = scanner.next();
        File testFolder = new File("src/main/java/EncryptionExercises/TestingFiles");

        System.out.println("Choice encryption algorithm.\n1.AES\n2.DES\n3.3DES");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("Choose 1 to encrypt files, or 2 to decrypt");
                String choice1  = scanner.next();
                if (choice1.equals("1")){
                    for(final File fileEntry: testFolder.listFiles()) {
                        try {
                            writeStringToFile(AES.encrypt(getStringFromFile(fileEntry), KEY),fileEntry);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else if (choice1.equals("2")){
                    for(final File fileEntry: testFolder.listFiles()) {
                        try {
                            writeStringToFile(AES.decrypt(getStringFromFile(fileEntry), KEY),fileEntry);
                        } catch (IOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }else
                    System.out.println("You entered wrong number");
                break;
            default:
        }

    }

    /**
     * This method is getting the string from a file
     *
     * @param  file file where from where String is read
     *
     * @return stringBuilder.toString();
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */

    private static String getStringFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        //if (stringBuilder.length() >= 1)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        return stringBuilder.toString();
    }

    /**
     * This method is writing the string to a file
     *
     * @param  file file from where String is read
     * @param  str string value in a file
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     */

    private static void writeStringToFile(String str, File file) throws  IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(str);
        printWriter.close();
    }
}