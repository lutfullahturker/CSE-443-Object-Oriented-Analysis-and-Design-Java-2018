/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author osboxes
 */
public class SystemOfLinearEquations {
    private EquationSolvingMethod method; // Strategy Design Pattern'ini uygulayarak method dinamik olarak belirleniyor
    private final ArrayList<ArrayList<Double>> system;
    
    /**
     * Constructor'da denklem sistemini olusturuyoruz.
     */
    public SystemOfLinearEquations(){
        system = new ArrayList<>();
        system.add(new ArrayList<>());
    }
    /**
     * Denklem sistemini cozum methodunu uygulayan class a gonderir ve cozum sonucunu alip return eder.
     * @return roots array
     */
    public double[] solve(){
        if (method == null)
            return null;
        ArrayList<ArrayList<Double>> tempSystem = new ArrayList<>();
        for(int i=0;i<system.size();++i){
            ArrayList<Double> equ = new ArrayList<>();
            for(int j=0;j<system.get(i).size();++j){
                equ.add(system.get(i).get(j));
            }
            tempSystem.add(equ);
        }
        method.setSystemOfEquations(tempSystem);
        double [] roots = method.solveSystemofEquations();
        return roots;
    }
    
    
    /**
     * cozum yontemini degistirmek icin kullanilir.
     * @param method Sistemin hangi metod ile cozulecegini parametre olarak alir.
     */
    public void setMethod(EquationSolvingMethod method){
        this.method = method;
    }
    /**
     * sisteme yeni bir denklem ekler.
     * @param equation Denklem alir ve sisteme ekler
     */
    public void addNewEquation(ArrayList<Double> equation){
        system.add(equation);
    }
    
    /**
     * denklem sistemini return eder.
     * @return denklem sistemi
     */
    public ArrayList<ArrayList<Double>> getEquationSystem(){
        return system;
    }
    /**
     * denklem sistemini ve cozum yontemini sifirlar.
     */
    public void clearSystemofEquations(){
        system.clear();
        system.add(new ArrayList<>());
        this.method = null;
    }
    
    
    
}
