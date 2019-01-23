public abstract class Plane {
    protected String modelName;
    protected String engine;
    protected String skeleton;
    protected int    seatNum;
    protected String purpose;
    protected Engine engineInjectionType;
    protected Seat seatingCover;
    protected PlaneIngredientFactory ingredientFactory;

    /**
     * Skeleton üretimi simülasyonu için ekrana Skeleton üretildiğini yazar.
     */
    public void constructSkeleton(){
        System.out.println("The skeleton is being constructed with "+getSkeleton()+" .");
    }
    /**
     * Uçağa engine yerleştirilme durumu için  ekrana bu aşamayı yazar.
     */
    public void placeEngines(){
        System.out.println(getEngine()+" "+engineInjectionType.getEngines()+" Jet Engines are being placed .");
    }
    /**
     * Seat leri yerleştirir ve bildirir.
     */
    public void placeSeats(){
        System.out.println(getSeatNum()+" "+seatingCover.getSeats() +" Seats are being placed .");
    }

    public String getModelName() {
        return modelName;
    }

    public String getEngine() {
        return engine;
    }

    public String getSkeleton() {
        return skeleton;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getPurpose() {
        return purpose;
    }
}
