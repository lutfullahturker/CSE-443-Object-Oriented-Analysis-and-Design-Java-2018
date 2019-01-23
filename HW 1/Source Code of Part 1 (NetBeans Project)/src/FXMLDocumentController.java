/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author osboxes
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button addEquaButton;
    @FXML
    private Button solveButton;
    @FXML
    private Label results;
    @FXML
    private Label errorLabel; //Hata durumunda pasif olan bu label de Kirmizi renkte hata mesaji yazar.
    @FXML
    private ComboBox numOfEquas; // Sistemdeki toplam denklem sayisini tutan ComboBox
    @FXML
    private ComboBox solvingMethod;
    @FXML
    private TextField x1;
    @FXML
    private TextField x2;
    @FXML
    private TextField x3;
    @FXML
    private TextField x4;
    @FXML
    private TextField x5;
    @FXML
    private TextField y;
    @FXML
    private Label matrix;
    @FXML
    private Label equCount;
    
    private ArrayList<TextField> xValues;  // X1,X2 .. degerlerini tek tek almak yerine dongu ile alabilmek icin olusturdugum ArrayList
    private int equaCount; // Toplam girilmis olan denklem sayisini tutup ona gore kullaniciyi bilgilendirdigimiz count
    private  double[] roots = null;
    private SystemOfLinearEquations sysOfEquations; // denklem sistemini tutacagim Class
    
    /**
     * Denklem katsayilari girildikten sonra denklemi sisteme kaydetmek icin
     * basilan butonun onClick fonksiyonudur.
     * Denklemi sisteme kaydeder ve geriye kac denklem girilmesi gerektigini bildirir.
     * @param event 
     */
    @FXML
    private void handleAddEquaButton(ActionEvent event) {
        errorLabel.setText("");
        numOfEquas.setDisable(true);
        if(numOfEquas.getValue() == null || equaCount == Integer.parseInt((String)numOfEquas.getValue())){
            if(numOfEquas.getValue() == null)
                errorLabel.setText("Please Select the number of Equations in system and add a new equation.");
            else
                errorLabel.setText("You have reached maximum number of equations for this system of equations.\nPress \"Solve System\" Button and see results.");
            return;
        }
        ArrayList<Double> equation = new ArrayList<>();
        equation.add(0.0);
        try{
        for (int i=0;i < Integer.parseInt((String)numOfEquas.getValue());++i){
            if(xValues.get(i).getText() == null || xValues.get(i).getText().equals(""))
                equation.add(0.0);
            else
                equation.add(Double.parseDouble(xValues.get(i).getText()));
            xValues.get(i).setText("");
        }
        if(y.getText() == null || y.getText().equals(""))
            equation.add(0.0);
        else
            equation.add(Double.parseDouble(y.getText()));
        y.setText("");
        sysOfEquations.addNewEquation(equation);
        ++equaCount;
        if(Integer.parseInt((String)numOfEquas.getValue()) == equaCount){
            equCount.setText("Press \"Solve System\" Button");
            addEquaButton.setDisable(true);
        } else
            equCount.setText("Need "+ (Integer.parseInt((String)numOfEquas.getValue())-equaCount) +" more equations");
        } catch (Exception e){
            errorLabel.setText("You have entered wrong values.\nPlease enter valid numbers.");
        }
        
    }
    
    /**
     * Denklem sistemi tamamlandigi ve cozum yontemi de belirlendigi takdirde sistemi cozmek icin 
     * gerekli class lari olusturur ve sonucu arayuzde gostermek icin printResultsOnLabel
     * yardimci fonksiyonunu cagirir.
     * Aksi takdirde errorLabel'da denklem sayisinin tamamlanmadigi veya cozum metodu belirtilmedigi
     * gibi durumlarda bu hatalar kullaniciya acikca belirtilir.
     * @param event 
     */
    @FXML
    private void handleSolveSystemButton(ActionEvent event) {
        if (numOfEquas.getValue() == null || equaCount != Integer.parseInt((String)numOfEquas.getValue())){
            errorLabel.setText("Equations are not enough for this system of equations.\nPlease add a new equation and try again.");
            return;
        }
        else if(solvingMethod.getValue() == null){
            errorLabel.setText("Please select a Solving Method and try again.");
            return;
        }
        errorLabel.setText("");
        switch ((String) solvingMethod.getValue()){
            case "Gaussian Elimination" :
                sysOfEquations.setMethod(new GaussianElimination());
                break;
            case "Matrix Inversion" :
                sysOfEquations.setMethod(new MatrixInversion());
                break;
            // can be added new cases
        }
        roots = sysOfEquations.solve();
        printResultsOnLabel();
        handleResetButton(null);
    }
    
    /**
     * Solve butonunun onClick fonksiyonunda denklem sisteminin cozumunu tamamladiginda cagrilir.
     * Denklem sisteminin koklerini ve sisteminin tamamini matris olarak kullaniciya label uzerinde gosterir.
     */
    private void printResultsOnLabel(){
        if (roots == null){
            errorLabel.setText("Solving this System failed. Please try with different System Of Equations.");
            return;
        }
        StringBuilder str = new StringBuilder();
        str.append("Found Roots with ").append((String) solvingMethod.getValue()).append(" method are : \n");
        int count =0;
        for (int i=1;i<roots.length;++i){
            if (Double.isNaN(roots[i]))
                count++;
            else
                str.append("X").append(i).append(" = ").append(roots[i]).append("\t");
        }
        ArrayList<ArrayList<Double>> mat = sysOfEquations.getEquationSystem();
        StringBuilder matStr = new StringBuilder();
        matStr.append("System ==>\n");
        for (int i=1;i<mat.size();++i){
            for(int j=1;j<mat.get(i).size();++j){
                matStr.append(mat.get(i).get(j)).append("\t");
                System.out.print(mat.get(i).get(j)+"   ");
            }
            matStr.append("\n");
            System.out.println();
        }
        System.out.println("Roots => ");
        for (int j=1;j<roots.length;++j){
                System.out.print(roots[j]+"   ");
        }
        System.out.println();
        results.setVisible(true);
        matrix.setVisible(true);
        if (count == roots.length-1)
            results.setText("ERROR  ==>  There is no unique solution to the given system.");
        else
            results.setText(str.toString());
        matrix.setText(matStr.toString());
    }
    
    /**
     * Denklem sisteminin cozumu tamamlandiginda kullanici yeni bir denklem sistemi ile hesap
     * yapmak istedigi takdirde varolan sistemi silip programi ilk konumuna getiren fonksiyondur.
     * @param event 
     */
    @FXML
    private void handleResetButton(ActionEvent event) {
        for(int i =0;i<xValues.size();++i)
            xValues.get(i).setText("");
        y.setText("");
        if(event != null){
            results.setVisible(false);
            matrix.setVisible(false);
            sysOfEquations.clearSystemofEquations();
            equaCount=0;
            numOfEquas.setDisable(false);
            addEquaButton.setDisable(false);
        } else{
            numOfEquas.setDisable(true);
            addEquaButton.setDisable(true);
        }
        errorLabel.setText("");
        equCount.setText("");
        
        roots=null;
    }
    
    /**
     * Arayuz olusturuldugunda ilk cagrilan fonksiyondur.
     * Burada gerekli ilklendirmeler ve ComboBox lar icine yazilacak veriler ayarlaniyor.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equaCount=0;
        sysOfEquations = new SystemOfLinearEquations();
        xValues = new ArrayList<>();
        xValues.add(x1);
        xValues.add(x2);
        xValues.add(x3);
        xValues.add(x4);
        xValues.add(x5);
        
        addEquaButton.setDisable(true);
        
        matrix.setVisible(false);
        results.setVisible(false);
        
        solvingMethod.getItems().clear();
        solvingMethod.getItems().addAll(
            "Gaussian Elimination",
            "Matrix Inversion");
        
        numOfEquas.getItems().clear();
        numOfEquas.getItems().addAll(
            "1","2","3","4","5");
        numOfEquas.valueProperty().addListener(new ChangeListener<String>() {
            
        /**
         * Sistemdeki denklem sayisini belirleyen ComboBox daki verinin degisip degismemesini
         * dinleyen listener fonksiyonudur.
         * Veri degistiginde denklem sayisi ile katsayi sayisi esit olmasi gerektigi icin
         * fazla olan veya eksik olan katsayi TextField leri aktiflestirilir veya disable edilir.
         * @param ov
         * @param oldVal Degismeden onceki String
         * @param newVal Degistikten sonraki guncel String
         */
        @Override
        public void changed(ObservableValue ov, String oldVal, String newVal) {
            addEquaButton.setDisable(false);
            equCount.setText("");
            for(int i =0;i<xValues.size();++i){
                if (i < Integer.parseInt(newVal)){
                    xValues.get(i).setDisable(false);
                } else
                    xValues.get(i).setDisable(true);
            }
        }    
                    
        });
    }
    
}