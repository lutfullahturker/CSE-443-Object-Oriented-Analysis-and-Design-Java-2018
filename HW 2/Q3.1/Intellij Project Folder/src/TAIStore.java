public abstract class TAIStore {
    /**
     * Factory Method'dur ve alt sınıflarda implement edilmesi için abstract olarak tanımlı.
     * @param model hangi model TPX alınacak ise onu tutan string
     * @return istenen modele göre Plane objesi return edilir.
     */
    protected abstract Plane createTPX(String model);

    /**
     *
     * @param model hangi model TPX alınacak ise onu tutan string
     * @return istenen modele göre Plane objesi üretilip hazırlanıp return edilir.
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
