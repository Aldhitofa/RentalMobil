import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM RENTAL MOBIL ===");
        System.out.print("Masukkan nama pelanggan: ");
        String customerName = input.nextLine();

        // Pilihan mobil
        Car[] cars = {
                new Car("Toyota Avanza", "MPV", 350000, true),
                new Car("Honda Brio", "Hatchback", 300000, true),
                new Car("Mitsubishi Pajero", "SUV", 500000, true),
                new Car("Suzuki Ertiga", "MPV", 320000, true)
        };

        System.out.println("\nPilih Mobil yang Ingin Disewa:");
        for (int i = 0; i < cars.length; i++) {
            System.out.println((i + 1) + ". " + cars[i].getCarName() + " (" + cars[i].getType() + ") - Rp " + cars[i].getRentPrice() + "/hari");
        }

        System.out.print("Masukkan pilihan (1-" + cars.length + "): ");
        int choice = input.nextInt();

        if (choice < 1 || choice > cars.length) {
            System.out.println("Pilihan sangat tidak valid!");
            return;
        }

        Car selectedCar = cars[choice - 1];
        System.out.print("Masukkan lama sewa (hari): ");
        int days = input.nextInt();

        // Tambahan fitur asuransi
        System.out.print("Apakah ingin menambah asuransi? (y/n): ");
        char insuranceChoice = input.next().charAt(0);
        boolean withInsurance = (insuranceChoice == 'y' || insuranceChoice == 'Y');

        // Proses rental
        Rental rental = new Rental(selectedCar, days, withInsurance);
        rental.calculateTotalPayment();

        System.out.println("\n=== NOTA PEMBAYARAN ===");
        System.out.println("Nama Pelanggan: " + customerName);
        rental.showRentalDetail();

        input.close();
    }
}
