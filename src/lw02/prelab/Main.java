package lw02.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();

        String[] kemungkinanPath = {
            "transactions.txt",
            "src/lw02/prelab/transactions.txt",
            "lw02/prelab/transactions.txt"
        };

        File file = null;
        for (String path : kemungkinanPath) {
            File coba = new File(path);
            if (coba.exists()) {
                file = coba;
                break;
            }
        }

        if (file == null) {
            System.out.println("File transactions.txt tidak ditemukan!");
            return;
        }
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String baris = sc.nextLine().trim();
            if (baris.isEmpty()) continue;

            String[] data = baris.split(" "); // data[0]=nama, data[1]=tipe, data[2]=jumlah
            transaksi.add(data);

            String nama = data[0];
            boolean sudahAda = false;
            for (String[] c : customer) {
                if (c[0].equals(nama)) {
                    sudahAda = true;
                    break;
                }
            }
            if (!sudahAda) {
                customer.add(new String[]{nama, "0"});
            }
        }
        sc.close();

        Queue<String[]> antrian = new LinkedList<>();
        antrian.addAll(transaksi);

        Stack<String[]> gagal = new Stack<>();

        while (!antrian.isEmpty()) {
            String[] t = antrian.poll(); 
            String nama = t[0];
            String tipe = t[1];
            int jumlah = Integer.parseInt(t[2]);
            for (String[] c : customer) {
                if (c[0].equals(nama)) {
                    int saldo = Integer.parseInt(c[1]);

                    if (tipe.equals("DEPOSIT")) {
                        saldo += jumlah;
                        c[1] = String.valueOf(saldo);

                    } else if (tipe.equals("WITHDRAW")) {
                        if (jumlah > saldo) {
                            gagal.push(t);
                        } else {
                            saldo -= jumlah;
                            c[1] = String.valueOf(saldo);
                        }
                    }
                    break; 
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] c : customer) {
            System.out.println(c[0] + " : " + c[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
 
        while (!gagal.isEmpty()) {
            String[] t = gagal.pop();
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}