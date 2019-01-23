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
public interface EquationSolvingMethod {
    public double[] solveSystemofEquations();
    public void setSystemOfEquations(ArrayList<ArrayList<Double>> system);
}
