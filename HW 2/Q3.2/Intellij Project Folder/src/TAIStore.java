public abstract class TAIStore {
    protected PlaneIngredientFactory ingredientFactory;

    /**
     *
     * @param model hangi model TPX alınacak ise onu tutan string
     * @return istenen modele göre Plane objesi return edilir.
     */
    protected Plane createTPX(String model) {
        if (model.equals("TPX 100"))
            return new TPX100(ingredientFactory);
        else if (model.equals("TPX 200"))
            return new TPX200(ingredientFactory);
        else if (model.equals("TPX 300"))
            return new TPX300(ingredientFactory);
        else
            return null;
    }

    /**
     * Satin almak uzere Plane i hazirlar ve return eder.
     * @param model hangi model TPX alınacak ise onu tutan string
     * @return istenen modele göre Plane objesi createTPX den alinarak return edilir.
     */
    public Plane orderTPX(String model){
        Plane plane;
        plane = createTPX(model);

        System.out.println(plane.getModelName()+" order is preparing  for "+plane.getPurpose()+".");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        System.out.println("Your order is ready.\nRedirecting to Main Menu ...\n\n");
        return plane;
    }
}
