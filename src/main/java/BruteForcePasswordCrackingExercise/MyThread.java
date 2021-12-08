package BruteForcePasswordCrackingExercise;

import java.util.Random;

public class MyThread implements Runnable {

    private final String password;

    public MyThread(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        guessPassword(password);
        System.exit(0);
    }
    
     /**
     * password guessing method
     *
     * 
     *
     * @author Mikołaj Noga, Szymon Jakóbiak
     *
     */
    
    private static void guessPassword(String password){
        Random rand = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder str = new StringBuilder();

        while (true){
            for (int i = (rand.nextInt(9) + 4); i > 0 ; i--){
                str.append(alphabet[rand.nextInt(26)]);
            }

            if (str.toString().equals(password)){
                System.out.println("Haslo: " + str);
                break;
            }
            str = new StringBuilder();
        }
    }
}
