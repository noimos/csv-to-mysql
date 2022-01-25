package org.noimos.csv2mysql.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Test {

    static double RATIO = 0.9;
    static Random RANDOM = new Random();
    // variables = starting balance
    // output = max trades, max balance, max balance step

    public static void main(String[] args) throws Exception {
        File file = new File("trades.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Start\tSteps\tBalance\tMax\tMax Step");
        bw.newLine();
        for (int start = 1; start <= 1000; start++) {
            for (int i = 0; i < 100; i++) {
                double balance = start;
                int step = 1;
                double bid = 1.0;
                double max = balance;
                int maxStep = 1;
                while (balance >= 1) {
                    if (balance < bid) {
                        bid = 1.0;
                    }
                    boolean win = RANDOM.nextBoolean();
                    if (win) {
                        balance += (bid * RATIO);
                        bid = 1.0;
                    } else {
                        balance -= bid;
                        bid *= 2;
                    }
                    if (balance > max) {
                        max = balance;
                        maxStep = step;
                    }
                    step++;
                }
                bw.write((int) start + "\t" + step + "\t" + (int) balance + "\t" + (int) max + "\t" + maxStep);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
