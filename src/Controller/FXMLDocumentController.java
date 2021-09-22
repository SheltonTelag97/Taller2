/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Punto2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;

/**
 *
 * @author shelt
 */
public class FXMLDocumentController implements Initializable {

    GraphicsContext g, c;
    int contador;
    double xf[];
    double yf[];
    boolean e4, e5, e6;
    LinkedList<Punto2D> listaPuntos;
    HashMap<String, LinkedList<Punto2D>> lp;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;

    @FXML
    private Canvas canvas;

    @FXML
    private Label t2D;

    @FXML
    private MenuBar asd;

    @FXML
    private ColorPicker qwe;

    @FXML
    private ColorPicker rellenof;

    @FXML
    private ColorPicker rellenob;

    @FXML
    private Label porcentajeT;

    @FXML
    private Label porcentajeG;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Button guardarC;

    @FXML
    private void estrella5(ActionEvent event) {
        e5 = true;
        e6 = false;

    }

    @FXML
    private void estrella6(ActionEvent event) {
        e6 = true;
        e5 = false;

    }

    @FXML
    private void limpiar(ActionEvent event) {
        double w = g.getCanvas().getWidth();
        double h = g.getCanvas().getHeight();

        g.clearRect(5, 5, w, h);
    }

    @FXML
    private void dibujarFigura(MouseEvent event) {

        if (e5) {

            double x = event.getX();
            double y = event.getY();

            xf = new double[10];
            yf = new double[10];
            g.setFill(rellenof.getValue());
            g.setStroke(rellenob.getValue());
            g.strokePolygon(xf, yf, 10);
            g.setLineWidth(1);
            double grosor = slider2.getValue();
            double roundg = Math.round(grosor * 100.0) / 100.0;
            porcentajeG.setText(String.valueOf(roundg));
            g.setLineWidth(grosor);
            contador = 0;
            double radio = slider1.getValue();
            double roundr = Math.round(radio * 100.0) / 100.0;
            porcentajeT.setText(String.valueOf(roundr));
            //int radio = 40;

            xf[0] = (x + radio);
            yf[0] = y;

            xf[1] = x + (radio * Math.cos(2 * Math.PI / 10) * 2);
            yf[1] = y - (radio * Math.sin(2 * Math.PI / 10) * 2);

            xf[2] = x + (radio * Math.cos(2 * 2 * Math.PI / 10));
            yf[2] = y - (radio * Math.sin(2 * 2 * Math.PI / 10));

            xf[3] = x + (radio * Math.cos(3 * 2 * Math.PI / 10) * 2);
            yf[3] = y - (radio * Math.sin(3 * 2 * Math.PI / 10) * 2);

            xf[4] = x + (radio * Math.cos(4 * 2 * Math.PI / 10));
            yf[4] = y - (radio * Math.sin(4 * 2 * Math.PI / 10));

            xf[5] = x + (radio * Math.cos(5 * 2 * Math.PI / 10) * 2);
            yf[5] = y - (radio * Math.sin(5 * 2 * Math.PI / 10) * 2);

            xf[6] = x + (radio * Math.cos(6 * 2 * Math.PI / 10));
            yf[6] = y - (radio * Math.sin(6 * 2 * Math.PI / 10));

            xf[7] = x + (radio * Math.cos(7 * 2 * Math.PI / 10) * 2);
            yf[7] = y - (radio * Math.sin(7 * 2 * Math.PI / 10) * 2);

            xf[8] = x + (radio * Math.cos(8 * 2 * Math.PI / 10));
            yf[8] = y - (radio * Math.sin(8 * 2 * Math.PI / 10));

            xf[9] = x + (radio * Math.cos(9 * 2 * Math.PI / 10) * 2);
            yf[9] = y - (radio * Math.sin(9 * 2 * Math.PI / 10) * 2);

            g.fillPolygon(xf, yf, 10);
            g.strokePolygon(xf, yf, 10);

            listaPuntos = new LinkedList<>();
            for (int i = 0; i < xf.length; i++) {
                Punto2D punto1 = new Punto2D(xf[i], yf[i]);
                listaPuntos.add(punto1);
            }
            lp.put("Estrella Cinco Puntas " + contador, listaPuntos);
            contador++;
        }

        if (e6) {

            double x = event.getX();
            double y = event.getY();
            xf = new double[12];
            yf = new double[12];
            g.setFill(rellenof.getValue());
            g.setStroke(rellenob.getValue());
            g.strokePolygon(xf, yf, 12);
            g.setLineWidth(1);
            double grosor = slider2.getValue();
            double roundg = Math.round(grosor * 100.0) / 100.0;
            porcentajeG.setText(String.valueOf(roundg));
            g.setLineWidth(grosor);
            contador = 0;
            double radio = slider1.getValue();
            double roundr = Math.round(radio * 100.0) / 100.0;
            porcentajeT.setText(String.valueOf(roundr));
            //int radio = 40;

            xf[0] = (x + radio);
            yf[0] = y;

            xf[1] = x + (radio * Math.cos(2 * Math.PI / 12) * 2);
            yf[1] = y - (radio * Math.sin(2 * Math.PI / 12) * 2);

            xf[2] = x + (radio * Math.cos(2 * 2 * Math.PI / 12));
            yf[2] = y - (radio * Math.sin(2 * 2 * Math.PI / 12));

            xf[3] = x + (radio * Math.cos(3 * 2 * Math.PI / 12) * 2);
            yf[3] = y - (radio * Math.sin(3 * 2 * Math.PI / 12) * 2);

            xf[4] = x + (radio * Math.cos(4 * 2 * Math.PI / 12));
            yf[4] = y - (radio * Math.sin(4 * 2 * Math.PI / 12));

            xf[5] = x + (radio * Math.cos(5 * 2 * Math.PI / 12) * 2);
            yf[5] = y - (radio * Math.sin(5 * 2 * Math.PI / 12) * 2);

            xf[6] = x + (radio * Math.cos(6 * 2 * Math.PI / 12));
            yf[6] = y - (radio * Math.sin(6 * 2 * Math.PI / 12));

            xf[7] = x + (radio * Math.cos(7 * 2 * Math.PI / 12) * 2);
            yf[7] = y - (radio * Math.sin(7 * 2 * Math.PI / 12) * 2);

            xf[8] = x + (radio * Math.cos(8 * 2 * Math.PI / 12));
            yf[8] = y - (radio * Math.sin(8 * 2 * Math.PI / 12));

            xf[9] = x + (radio * Math.cos(9 * 2 * Math.PI / 12) * 2);
            yf[9] = y - (radio * Math.sin(9 * 2 * Math.PI / 12) * 2);

            xf[10] = x + (radio * Math.cos(10 * 2 * Math.PI / 12));
            yf[10] = y - (radio * Math.sin(10 * 2 * Math.PI / 12));

            xf[11] = x + (radio * Math.cos(11 * 2 * Math.PI / 12) * 2);
            yf[11] = y - (radio * Math.sin(11 * 2 * Math.PI / 12) * 2);

            g.fillPolygon(xf, yf, 12);
            g.strokePolygon(xf, yf, 12);

            listaPuntos = new LinkedList<>();
            for (int i = 0; i < xf.length; i++) {
                Punto2D punto1 = new Punto2D(xf[i], yf[i]);
                listaPuntos.add(punto1);
            }
            lp.put("Estrella Seis Puntas " + contador, listaPuntos);
            contador++;

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
