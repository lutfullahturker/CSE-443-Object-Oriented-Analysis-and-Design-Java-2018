public class MainStore extends TAIStore{
    /**
     * Factory Method
     * @param model hangi model TPX alınacak ise onu tutan string
     * @return istenen modele göre Plane objesi return edilir.
     */
    @Override
    protected Plane createTPX(String model) {
        if (model.equals("TPX 100"))
            return new TPX100();
        else if (model.equals("TPX 200"))
            return new TPX200();
        else if (model.equals("TPX 300"))
            return new TPX300();
        else
            return null;
    }
}
