public class DomesticIngredientFactory implements PlaneIngredientFactory {
    @Override
    public Engine createEngines() {
        return new TurbojetEngine();
    }

    @Override
    public Seat createSeats() {
        return new VelvetSeat();
    }

    @Override
    public String createSkeleton() {
        return "Default Skeleton";
    }
}
