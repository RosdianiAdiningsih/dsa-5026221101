package lw01.unguided;

public class ProjectorRental extends Rental {

    private static final int LIMIT_FIRSTDAY = 3;
    private static final int FIRST3DAY_PER_DAY = 60000;
    private static final int EVERYDAY_BEYOND3 = 45000;
    private static final int SETUP_PROJECTOR_PERUNIT = 20000;

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int dayCost;
        if (days <= LIMIT_FIRSTDAY) {
            dayCost = days * FIRST3DAY_PER_DAY;
        } else {
            dayCost = (LIMIT_FIRSTDAY * FIRST3DAY_PER_DAY) + ((days - LIMIT_FIRSTDAY) * EVERYDAY_BEYOND3);
        }
        return dayCost + SETUP_PROJECTOR_PERUNIT;
    }

    @Override
    public String label() {
        return "Projector";
    }
}