public class EurasiaIngredientFactory implements PlaneIngredientFactory {
    @Override
    public Engine createEngines() {
        return new TurbofanEngine();
    }

    @Override
    public Seat createSeats() {
        return new LinenSeat();
    }

    @Override
    public String createSkeleton() {
        return "Default Skeleton";
    }
}
