public interface PlaneIngredientFactory {
    /**
     *
     * @return Local Market secimine gore dogru engine tipini return eder.
     */
    public Engine createEngines();
    /**
     *
     * @return Local Market secimine gore dogru Seat tipini return eder.
     */
    public Seat createSeats();

    /**
     * Skeleton malzemesi sabit oldugu icin suanki sistemde islevsiz bir fonksiyon. Fakat Skeleton da local'e gore degisirse kullanilabilir.
     * @return Skeleton tipi
     */
    public String createSkeleton();
}
