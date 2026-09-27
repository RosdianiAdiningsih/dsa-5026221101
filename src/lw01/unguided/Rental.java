package lw01.unguided;

public abstract class Rental implements Chargeable { 

    private String id; //pake private karena simbolnya minus (priavte)
    private int days;
    private int unit;

    protected Rental(String id, int days, int unit) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive"); //tidak boleh null
        }
        if (unit <=0) {
            throw new IllegalArgumentException("unit must be positive");
        }
        this.id = id;
        this.days = days;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge(); //menimpa method yg sudah ada

    public int calculateCharge(int unit) {
        if (unit <= 0) {
            throw new IllegalArgumentException("unit must be positive");
        }
        return unit * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() { //return sesuai yg ada di soal
        return id + " | " + label() + " | " + calculateCharge();
    }
}
