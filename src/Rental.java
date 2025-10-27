class Rental {
    private Car car;
    private int rentDays;
    private double total;

    private static final int MIN_RENT_DAYS_FOR_DISCOUNT = 5;

    public Rental(Car car, int rentDays) {
        this.car = car;
        this.rentDays = rentDays;
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
    }

    public void showRentalDetail() {
        System.out.println("\n===== DETAIL SEWA =====");
        car.showCarInfo();
        System.out.println("Lama Sewa: " + rentDays + " hari");
        System.out.println("Total Pembayaran: Rp " + total);
    }
}
