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

public class Controller implements Initializable{

    @FXML
    private Button addNewEdge;
    @FXML
    private Button solveButton;
    @FXML
    private Label mst;
    @FXML
    private Label errorLabel; //Hata durumunda pasif olan bu label de Kirmizi renkte hata mesaji yazar.
    @FXML
    private ComboBox numOfVertexes; // Sistemdeki toplam denklem sayisini tutan ComboBox
    @FXML
    private TextField src;
    @FXML
    private TextField dst;
    @FXML
    private TextField wgh;
    @FXML
    private Label matrix;

    private ArrayList<Edge> edges;
    private int equaCount; // Toplam girilmis olan denklem sayisini tutup ona gore kullaniciyi bilgilendirdigimiz count
    private  double[] roots = null;

    /**
     * Denklem katsayilari girildikten sonra denklemi sisteme kaydetmek icin
     * basilan butonun onClick fonksiyonudur.
     * Denklemi sisteme kaydeder ve geriye kac denklem girilmesi gerektigini bildirir.
     * @param event
     */
    @FXML
    private void handleAddNewEdge(ActionEvent event) {
        errorLabel.setText("");

        if(numOfVertexes.getValue() == null){
            errorLabel.setText("Please Select the number of Vertexes in graph and add a new Edge.");
            return;
        }
        int vertexNum = Integer.parseInt((String)numOfVertexes.getValue());
        try{
            if (Integer.parseInt((String)src.getText()) >= vertexNum || Integer.parseInt((String)dst.getText()) >= vertexNum){
                errorLabel.setText("Source and destination vertex must be smaller than number of vertexes.");
                return;
            }
            numOfVertexes.setDisable(true);

            Edge edge = new Edge(Integer.parseInt(src.getText()),Integer.parseInt(dst.getText()),Integer.parseInt(wgh.getText()));
            edges.add(edge);
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
        if (numOfVertexes.getValue() == null){
            errorLabel.setText("Choose the number of vertexes and try again.");
            return;
        }
        errorLabel.setText("");
        Graph graph = new Graph(edges.toArray(new Edge[0]),Integer.parseInt((String)numOfVertexes.getValue()));
        GraphAlgorithms graphAlgorithms = new GraphAlgorithms();
        Graph MST = graphAlgorithms.getMinimumSpanningTree(graph);
        double[][] incMatrix = graphAlgorithms.getIncidenceMatrix(graph);
        StringBuilder str = new StringBuilder();
        for (double[] row : incMatrix) {
            for (double e : row)
                str.append(e).append(" ");
            str.append("\n");
        }
        matrix.setText(str.toString());
        mst.setText(MST.toString());
        handleResetButton(null);
    }

    /**
     * Denklem sisteminin cozumu tamamlandiginda kullanici yeni bir denklem sistemi ile hesap
     * yapmak istedigi takdirde varolan sistemi silip programi ilk konumuna getiren fonksiyondur.
     * @param event
     */
    @FXML
    private void handleResetButton(ActionEvent event) {
        if(event != null){
            mst.setText("");
            matrix.setText("");
            numOfVertexes.setDisable(false);
            addNewEdge.setDisable(false);
        } else{
            numOfVertexes.setDisable(true);
            addNewEdge.setDisable(true);
        }
        edges.clear();
        src.setText("");
        dst.setText("");
        wgh.setText("");
        errorLabel.setText("");
    }

    /**
     * Arayuz olusturuldugunda ilk cagrilan fonksiyondur.
     * Burada gerekli ilklendirmeler ve ComboBox lar icine yazilacak veriler ayarlaniyor.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        edges = new ArrayList<>();



        numOfVertexes.getItems().clear();
        numOfVertexes.getItems().addAll(
                "1","2","3","4","5","6","7","8","9","10");
    }

}
