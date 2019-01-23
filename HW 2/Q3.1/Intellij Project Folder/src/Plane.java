public abstract class Plane {
    protected String modelName;
    protected String engine;
    protected String skeleton;
    protected int    seatNum;
    protected String purpose;

    /**
     * Skeleton üretimi simülasyonu için ekrana Skeleton üretildiğini yazar.
     */
    public void constructSkeleton(){
        System.out.println("Constructing Skeleton with "+getSkeleton()+".");
    }
    /**
     * Uçağa engine yerleştirilme durumu için  ekrana bu aşamayı yazar.
     */
    public void placeEngines(){
        System.out.println("Placing "+getEngine()+" Jet Engine.");
    }
    /**
     * Seat leri yerleştirir ve bildirir.
     */
    public void placeSeats(){
        System.out.println("Placing "+getSeatNum()+" Seats.");
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
