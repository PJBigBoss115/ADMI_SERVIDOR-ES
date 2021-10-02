/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admi_ServidorEs;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class ADMI_SERVIDORES extends Application implements Runnable{
    
    static public String reporte_Text;
    
    @Override
    public void start(Stage stage) throws Exception {
        Thread ejecuta_1 = new Thread(this);
        ejecuta_1.start();
        
        Parent root = FXMLLoader.load(getClass().getResource("/Admi_ServidorVentanas/FXMLVentana.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        try {  
            ServerSocket recibirReporte = new ServerSocket(8911);
            
            while(true) {
                Socket enviarReporte=recibirReporte.accept();
            
                DataInputStream recibeElReporte = new DataInputStream(enviarReporte.getInputStream());
            
                String reporteTexto=recibeElReporte.readUTF();
            
                reporte_Text = reporteTexto;
            
                enviarReporte.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ADMI_SERVIDORES.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
