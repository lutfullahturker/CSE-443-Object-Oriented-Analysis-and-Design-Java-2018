public class TPX300 extends Plane {
    /**
     * modelName,Engine,SeatNum,Skeleton,Purpose ve ingredient değişkenleri constructor da doldurulur ve diğer yöntemler ve getter'lar bunları kullanır.
     * @param ingredientFactory Local'e gore farkli malzemeler kullanilarak uretilecegi icin bu parametre ile Local market bilgisi alinir.
     */
    public TPX300(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        modelName = "TPX 300";
        engine  = "Quadro";
        seatNum = 250;
        skeleton= "Titanium Alloy";
        purpose = "Transatlantic Flights";
    }
}
