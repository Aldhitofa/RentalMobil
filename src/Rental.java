class Rental {
    private Car car;
    private int rentDays;
    private double total;
    private boolean withInsurance;

    private static final int MIN_RENT_DAYS_FOR_DISCOUNT = 5;
    private static final double INSURANCE_COST = 100000;

    public Rental(Car car, int rentDays, boolean withInsurance) {
        this.car = car;
        this.rentDays = rentDays;
        this.withInsurance = withInsurance;
    }

    private double calculateDiscount(double total) {
        if (rentDays > MIN_RENT_DAYS_FOR_DISCOUNT) {
            return total * Car.getDiscountRate();
        } else {
            return 0;
        }
    }

    public void calculateTotalPayment() {
        total = car.getRentPrice() * rentDays;
        total -= calculateDiscount(total);

        // Tambahkan biaya asuransi
        if (withInsurance) {
            total += INSURANCE_COST;
        }
    }

    public void showRentalDetail() {
        car.showCarInfo();
        System.out.println("Rent days: " + rentDays);
        System.out.println("Pakai Asuransi: " + (withInsurance ? "Ya" : "Tidak"));
        System.out.println("Total Payment: Rp " + total);
    }
}
