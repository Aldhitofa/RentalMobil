class Car {
    private String carName;
    private String type;
    private double rentPrice;
    private boolean available;

    private static final double DISCOUNT_RATE = 0.1;

    public Car(String carName, String type, double rentPrice, boolean available) {
        this.carName = carName;
        this.type = type;
        this.rentPrice = rentPrice;
        this.available = available;
    }

    public String getCarName() { return carName; }
    public String getType() { return type; }
    public double getRentPrice() { return rentPrice; }
    public boolean isAvailable() { return available; }

    public static double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    public void showCarInfo() {
        System.out.println("Nama Mobil: " + carName);
        System.out.println("Tipe: " + type);
        System.out.println("Harga Sewa per Hari: Rp " + rentPrice);
        System.out.println("Status: " + (available ? "Tersedia" : "Tidak Tersedia"));
    }
}