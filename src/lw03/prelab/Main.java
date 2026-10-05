package lw03.prelab;

import java.io.File;
import java.util.*;

public class Main {

    static String dir = "src/lw03/prelab/";

    public static void main(String[] args) throws Exception {
        problem1();
        problem2();
        problem3();
    }

    // Problem 1: Playlist (List)
    static void problem1() throws Exception {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(dir + "playlist.txt"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] p = line.split(" ", 3); //split jadi maks 3 bagian
            String cmd = p[0]; //comand / operation indeks ke 0

            if (cmd.equals("ADD")) {
                list.add(line.substring(4));
            } else if (cmd.equals("INSERT")) {
                int idx = Integer.parseInt(p[1]);
                if (idx >= 0 && idx <= list.size()) {
                    list.add(idx, p[2]);
                }
            } else if (cmd.equals("REMOVE")) {
                String song = line.substring(7);
                if (list.contains(song)) {
                    list.remove(song); // hanya kemunculan pertama
                }
            }
        }
        sc.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + list.size()); //menghitung jumlah song
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }

    // Problem 2: Peserta 
    static void problem2() throws Exception {
        Set<String> set = new LinkedHashSet<>(); // LinkedHashSet biar urutan set sesuai dg yg diinputkan
        int dup = 0; //duplicate
        Scanner sc = new Scanner(new File(dir + "participants.txt"));

        while (sc.hasNextLine()) {
            String name = sc.nextLine().trim();
            if (name.isEmpty()) continue; // if(!participants.contains(name)) {participants.add(name);} else {dup++;} //cara lain

            if (set.contains(name)) {
                dup++;
            } else {
                set.add(name);
            }
        }
        sc.close();

        System.out.println("\n===== Problem 2 =====");
        System.out.println("Unique participants: " + set.size());
        int no = 1; //atau 0
        for (String s : set) { //string participant //set ga bisa pakai  get
            System.out.println(no + ". " + s);
            no++;
        }
        System.out.println("Duplicate registrations: " + dup);
    }

    // Problem 3: Inventori 
    static void problem3() throws Exception {
        Map<String, Integer> map = new LinkedHashMap<>();
        int fail = 0;
        Scanner sc = new Scanner(new File(dir + "inventory.txt"));

        while (sc.hasNext()) {
            String type = sc.next();
            String product = sc.next();
            int qty = sc.nextInt();

            if (type.equals("ADD")) {
                if (map.containsKey(product)) { //cek apakah product sudah ada di map
                    map.put(product, map.get(product) + qty); 
                } else {
                    map.put(product, qty); //kalau belum ada, masukkan product dan qty
                }
            } else if (type.equals("SELL")) {
                if (map.containsKey(product) && map.get(product) >= qty) { //stok  yg dipunya harus lbh bnyk dr yg dibeli pelanggan
                    map.put(product, map.get(product) - qty); 
                } else {
                    fail++; 
                }
            }
        }
        sc.close();

        System.out.println("\n===== Problem 3 =====");
        for (String key : map.keySet()) { 
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("Failed sales: " + fail);
    }
}