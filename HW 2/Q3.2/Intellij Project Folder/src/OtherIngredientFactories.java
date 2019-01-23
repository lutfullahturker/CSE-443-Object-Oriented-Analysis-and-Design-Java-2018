public class OtherIngredientFactories implements PlaneIngredientFactory{
    @Override
    public Engine createEngines() {
        return new GearedTurbofanEngine();
    }

    @Override
    public Seat createSeats() {
        return new LeatherSeat();
    }

    @Override
    public String createSkeleton() {
        return "Default Skeleton";
    }
}
