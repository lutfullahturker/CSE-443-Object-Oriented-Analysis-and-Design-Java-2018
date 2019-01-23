/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import static java.lang.Math.max;


/**
 *
 * @author osboxes
 */
public class GaussianElimination implements EquationSolvingMethod {
    
    private ArrayList<ArrayList<Double>> equations ; // Denklem sistemi
    private ArrayList<Double> b = new ArrayList<>(); // denklemdeki Y sabit sayilarini tutan ArrayList
    private double [] x; // roots array
    private int size;
    
    /**
     * sistemi cozer ve koklerini return eder.
     * @return roots denklem sisteminin koklerini bulunduran roots arrayini return eder.
     */
    @Override
    public double[] solveSystemofEquations() {
        /*
        * Sayısal analiz HW2'den
        *  yardım alınmıştır.
        */
       size = equations.size();
       x = new double[size];
       double smax,r,t;
       int k,kp,l,i,j,n=size-1;
       
       ArrayList<Integer> p = new ArrayList<>();
       ArrayList<Double> s = new ArrayList<>();
       s.add(0.0); 
       p.add(0);
       b.add(0.0);
       for(i=1;i<equations.size();++i){
           b.add(equations.get(i).get(equations.get(i).size()-1));
           equations.get(i).remove(equations.get(i).size()-1);
       }
       
       for (i=1;i<size;++i){
           p.add(i);
           smax = 0;
           for(j=1;j<size;++j)
               smax = max(smax,Math.abs(equations.get(i).get(j)));
           s.add(smax);
       }
       for(k=1;k<=n-1;++k){
           r = Math.abs((equations.get(p.get(k)).get(k))/(s.get(p.get(k))));
           kp = k;
           for(i=k+1;i<=n;++i){
               t= Math.abs((equations.get(p.get(i)).get(k))/(s.get(p.get(i))));
               if(t>r){
                   r=t;
                   kp=i;
               }
           }
           l=p.get(kp);
           p.set(kp, p.get(k));
           p.set(k,l);
           for(i=k+1;i<=n;++i){
               equations.get(p.get(i)).set(k,equations.get(p.get(i)).get(k)/(equations.get(p.get(k)).get(k)));
               for(j=k+1;j<=n;++j){
                   equations.get(p.get(i)).set(j,equations.get(p.get(i)).get(j)-equations.get(p.get(i)).get(k)*equations.get(p.get(k)).get(j));
               }
           }
       }
       ArrayList<Double> y = new ArrayList<>();
       y.add(0.0);
       y.add(b.get(p.get(1)));
       for (i=2;i<=n;++i){
           y.add(b.get(p.get(i)));
           for(j=1;j<=i-1;++j)
               y.set(i,y.get(i) - equations.get(p.get(i)).get(j)*y.get(j)); 
       }

       x[n] = y.get(n)/equations.get(p.get(n)).get(n);
       for (i=n-1;i>=1;--i){
           x[i] = y.get(i);
           for(j=i+1;j<=n;++j){
               x[i] = x[i] - equations.get(p.get(i)).get(j)*x[j];
           }
           x[i] = x[i]/equations.get(p.get(i)).get(i);
       }
       return x;
    }

    /**
     * Gelen sistemi Class daki sisteme atama yapar.
     * @param system Denklem sistemini tutan degisken
     */
    @Override
    public void setSystemOfEquations(ArrayList<ArrayList<Double>> system) {
        this.equations = system;
    }
    
}
