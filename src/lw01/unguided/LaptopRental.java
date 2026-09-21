package lw01.unguided;

public class LaptopRental extends Rental { 

    private static final int RATE_PER_DAY = 40000;
    private static final int SETUP_LAPTOP_PERUNIT = 10000;

    public LaptopRental(String id, int days, int copies) {
        super(id, days, copies); //keyword utk manggil sub dr supperclass/parentclass
    }

    @Override
    public int calculateCharge() {
        return getDays() * RATE_PER_DAY + SETUP_LAPTOP_PERUNIT; 
    }

    @Override //penanda jika terjadi terjadi error method
    public String label() {
        return "Laptop";
    }
}
