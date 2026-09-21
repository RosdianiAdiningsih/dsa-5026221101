package lw01.prelab;

public class ColourPrint extends PrintJob {

    private static final int TIER_LIMIT = 10;
    private static final int TIER1_RATE = 1500;
    private static final int TIER2_RATE = 1000;
    private static final int SETUP_FEE = 2000;

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int pages = getPages();
        int pageCost;
        if (pages <= TIER_LIMIT) {
            pageCost = pages * TIER1_RATE;
        } else {
            pageCost = (TIER_LIMIT * TIER1_RATE) + ((pages - TIER_LIMIT) * TIER2_RATE); //10 hlm pertama plus sisanya
        }
        return pageCost + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Colour"; //utk colour print
    }
}
