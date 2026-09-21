package lw01.unguided;

public abstract class Rental implements Chargeable { 

    private String id; //pake private karena simbolnya minus (priavte)
    private int days;
    private int copies;

    protected Rental(String id, int days, int copies) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive"); //tidak boleh null
        }
        if (copies <=0) {
            throw new IllegalArgumentException("copies must be positive");
        }
        this.id = id;
        this.days = days;
        this.copies = copies;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge(); //menimpa method yg sudah ada

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("copies must be positive");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() { //return sesuai yg ada di soal
        return id + " | " + label() + " | " + calculateCharge();
    }
}
