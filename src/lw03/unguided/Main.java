package lw03.unguided;

import java.io.File;
import java.util.*;

public class Main {

    static String dir = "src/lw03/unguided/";

    public static void main(String[] args) throws Exception {
        Map<String, Integer> listMap = new LinkedHashMap<>(); // supaya urutan sesuai
        List<String> checks = new ArrayList<>(); // hasil check sesuai urutan input
        int rejected = 0;
        Scanner sc = new Scanner(new File(dir + "enrollment.txt"));

        while (sc.hasNext()) {
            String type = sc.next();
            String courseCode = sc.next();

            if (type.equals("REGISTER")) {
                int count = sc.nextInt();
                if (count <= 0) {
                    rejected++;
                } else if (listMap.containsKey(courseCode)) { // cek apakah course sudah ada
                    listMap.put(courseCode, listMap.get(courseCode) + count);
                } else {
                    listMap.put(courseCode, count); // kalau belum ada, masukkan course dan count
                }
            } else if (type.equals("WITHDRAW")) {
                int count = sc.nextInt();
                if (count <= 0) {
                    rejected++; 
                } else if (listMap.containsKey(courseCode) && listMap.get(courseCode) >= count) { 
                    listMap.put(courseCode, listMap.get(courseCode) - count);
                } else {
                    rejected++; 
                }
            } else if (type.equals("CHECK")) {
                if (listMap.containsKey(courseCode)) {
                    checks.add(courseCode + ": " + listMap.get(courseCode) + " students");
                } else {
                    checks.add(courseCode + ": Not found"); 
                }
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < checks.size(); i++) {
            System.out.println(checks.get(i));
        }

        System.out.println("\n===== Final Enrollment =====");
        for (String key : listMap.keySet()) {
            System.out.println(key + ": " + listMap.get(key) + " students");
        }
        System.out.println("\nRejected operations: " + rejected);
    }
}