public class TPX100 extends Plane {
    /**
     * modelName,Engine,SeatNum,Skeleton ve Purpose değişkenleri constructor da doldurulur ve diğer yöntemler ve getter'lar bunları kullanır.
     */
    public TPX100() {
        modelName = "TPX 100";
        engine  = "Single";
        seatNum = 50;
        skeleton= "Aluminum Alloy";
        purpose = "Domestic Flights";
    }
}
