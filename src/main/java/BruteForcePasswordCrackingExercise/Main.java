package BruteForcePasswordCrackingExercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runnable[] runners = new Runnable[10];
        Thread[] threads = new Thread[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadz hasło");
        String password = scanner.next();

        for(int i=0; i<10; i++) {
            runners[i] = new MyThread(password);
            threads[i] = new Thread(runners[i]);
        }

        for(int i=0; i<10; i++) {
            threads[i].start();
        }
    }
}

