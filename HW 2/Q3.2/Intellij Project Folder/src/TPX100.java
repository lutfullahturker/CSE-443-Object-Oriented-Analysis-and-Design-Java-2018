public class TPX100 extends Plane {
    /**
     * modelName,Engine,SeatNum,Skeleton,Purpose ve ingredient değişkenleri constructor da doldurulur ve diğer yöntemler ve getter'lar bunları kullanır.
     * @param ingredientFactory Local'e gore farkli malzemeler kullanilarak uretilecegi icin bu parametre ile Local market bilgisi alinir.
     */
    public TPX100(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        modelName = "TPX 100";
        engine  = "Single";
        seatNum = 50;
        skeleton= "Aluminum Alloy";
        purpose = "Domestic Flights";
    }
}
