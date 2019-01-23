public class TPX200 extends Plane {
    /**
     * modelName,Engine,SeatNum,Skeleton,Purpose ve ingredient değişkenleri constructor da doldurulur ve diğer yöntemler ve getter'lar bunları kullanır.
     * @param ingredientFactory Local'e gore farkli malzemeler kullanilarak uretilecegi icin bu parametre ile Local market bilgisi alinir.
     */
    public TPX200(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        modelName = "TPX 200";
        engine  = "Twin";
        seatNum = 100;
        skeleton= "Nickel Alloy";
        purpose = "Domestic and Short International Flights";
    }
}
