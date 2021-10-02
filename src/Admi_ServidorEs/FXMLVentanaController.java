/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admi_ServidorEs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class FXMLVentanaController implements Initializable {
    
    @FXML
    private TextField report_1;
    @FXML
    private Button buttonIngresos;
    @FXML
    private Button buttonEstado;
    
    @FXML
    private void mostrarReport() {
        report_1.setText(ADMI_SERVIDORES.reporte_Text);
    }
    
    @FXML
    private void pedirReporteIngresos(ActionEvent event) {
        try {
            System.out.println("ButtonIngresos");
            
            Socket pideReporte = new Socket("192.168.1.41", 9999);
            
            DataOutputStream pedirReporte = new DataOutputStream(pideReporte.getOutputStream());
            pedirReporte.writeUTF("Report_Ingresos");
            pedirReporte.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLVentanaController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    private void pedirReporteEstado(ActionEvent event) {
        try {
            System.out.println("ButtonEstado");
            
            Socket pideReporte = new Socket("192.168.1.41", 9999);
            
            DataOutputStream pedirReporte = new DataOutputStream(pideReporte.getOutputStream());
            pedirReporte.writeUTF("Report_Estado");
            pedirReporte.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLVentanaController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
