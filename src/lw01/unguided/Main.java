package lw01.unguided;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List; //menyimpan list yg ada di job
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Rental> jobs = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("rental.txt"))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();

                if (type.equalsIgnoreCase("LAPTOP")) {
                    jobs.add(new LaptopRental(id, days));
                } else if (type.equalsIgnoreCase("PROJECTOR")) {
                    jobs.add(new ProjectorRental(id, days));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("rental.txt not found.");
            return;
        }

        for (Rental job : jobs) {
            System.out.println(job.summary());
        }
    }
}
