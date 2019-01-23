

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
public class MatrixInversion implements EquationSolvingMethod {
   private ArrayList<ArrayList<Double>> equations ; // Denklem sistemi
   
   /*
   	https://www.sanfoundry.com
   	adresinden yararlanilmistir.
   */
    /**
     * denklem sistemini cozer ve koklerini return eder.
     * @return roots denklem sisteminin koklerini bulunduran roots arrayini return eder.
     */
    @Override
    public double[] solveSystemofEquations() {
        double[] results = new double[equations.size()];
        ArrayList<Double> y = new ArrayList<>();
        for(int i=1;i<equations.size();++i){
           y.add(equations.get(i).get(equations.get(i).size()-1));
           equations.get(i).remove(equations.get(i).size()-1);
           equations.get(i).remove(0);
        }
        equations.remove(0);
        
        double[][] invertedMat = matInverse();
        for (int i = 0; i < equations.size(); i++) 
        {
                for (int j = 0;j < equations.size(); j++)
                {	 
                    results[i+1] = results[i+1] + invertedMat[i][j] * y.get(j);
                }
        }
        
        return results;
    }

    @Override
    public void setSystemOfEquations(ArrayList<ArrayList<Double>> system) {
        this.equations = system;
    }
    
    private double[][] matInverse() 
    {
        int n = equations.size();
        double x[][] = new double[n][n];
        double mat[][] = new double[n][n];
        int index[] = new int[n];
        for (int k=0; k<n; ++k) 
            mat[k][k] = 1;
 
        upperTri(index);
 
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    mat[index[j]][k] -= equations.get(index[j]).get(i)*mat[index[i]][k];
 
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = mat[index[n-1]][i]/equations.get(index[n-1]).get(n-1);
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = mat[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= equations.get(index[j]).get(k)*x[k][i];
                }
                x[j][i] /= equations.get(index[j]).get(j);
            }
        }
        return x;
    }
    /**
     * matrisi upper Triangle hale donusturur.
     * @param index 
     */
    private void upperTri(int index[]) 
    {
        int n = index.length;
        double d[] = new double[n];
 
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
        for (int i=0; i<n; ++i) 
        {
            double d1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double d0 = Math.abs(equations.get(i).get(j));
                if (d0 > d1) d1 = d0;
            }
            d[i] = d1;
        }
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pivot1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pivot0 = Math.abs(equations.get(index[i]).get(j));
                pivot0 /= d[index[i]];
                if (pivot0 > pivot1) 
                {
                    pivot1 = pivot0;
                    k = i;
                }
            }
            int temp = index[j];
            index[j] = index[k];
            index[k] = temp;
            for (int i=j+1; i<n; ++i) 	
            {
                double pivotJ = equations.get(index[i]).get(j)/equations.get(index[j]).get(j);
                equations.get(index[i]).set(j, pivotJ);
                for (int l=j+1; l<n; ++l)
                    equations.get(index[i]).set(l,equations.get(index[i]).get(l) - pivotJ*equations.get(index[j]).get(l));
            }
        }
    }
    
}
