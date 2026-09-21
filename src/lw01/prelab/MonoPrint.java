package lw01.prelab;

public class MonoPrint extends PrintJob { 

    private static final int RATE_PER_PAGE = 500;

    public MonoPrint(String id, int pages) {
        super(id, pages); //keyword utk manggil sub dr supperclass/parentclass
    }

    @Override
    public int calculateCharge() {
        return getPages() * RATE_PER_PAGE; //bisa langsung dikali 500
    }

    @Override //penanda jika terjadi terjadi error method
    public String label() {
        return "Mono";
    }
}
