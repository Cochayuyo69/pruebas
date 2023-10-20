package metodos;

import java.util.Vector;
import egresado.Egresado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javaapplication40.NewJFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    Vector vPrincipal = new Vector();
    
    //Procedimiento para guardar datos
    
    public void guardar(Egresado unEgresado){
        vPrincipal.addElement(unEgresado);
    }
    
    //PROCEDIMIENTO PARA GUARDAR EN UN ARCHIVO TXT
    
    public void guardarArchivo(Egresado egresado){
        try {
            FileWriter fw = new FileWriter("Egresados.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.printf(egresado.getCodigo());
            pw.printf("|" + egresado.getNombre());
            pw.printf("|" + egresado.getCorreo());
            pw.printf("|" + egresado.getTelefono());
            pw.printf("|" + egresado.getLabura());

            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //FUNCION PARA MOSTRARLO EN UN JTABLE
    
    public DefaultTableModel listaEgresados(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("Código de estudiante");
        cabeceras.addElement("Apellidos y nombres");
        cabeceras.addElement("Correo electrónico");
        cabeceras.addElement("Número telefónico");
        cabeceras.addElement("Estado laboral");
        //CREAMOS UN VECTOR QUE TENGA LA CABECERA
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);
        
        try {
            FileReader fr = new FileReader("Egresados.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null){
                StringTokenizer dato = new StringTokenizer(d, "|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                     x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        } catch (Exception e) {
        }
        return mdlTabla;
        
    }
    
    public void textosdeegresados(NewJFrame j) {
        try {
            FileReader fr = new FileReader("Egresados.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "|");
                if (dato.countTokens() >= 5) { // Asumiendo cinco tokens para cada uno de los campos
                    String codigo = dato.nextToken();
                    String nombres = dato.nextToken();
                    String correo = dato.nextToken();
                    String telefono = dato.nextToken();
                    boolean labura = Boolean.valueOf(dato.nextToken());
                    System.out.println(labura);

                    // Llamar al método setValues en la instancia de NewJFrame para establecer los valores en los campos de texto
                    j.setValues(codigo, nombres, correo, telefono, labura);
                }
            }
        } catch (Exception e) {
            // Manejo de excepciones, puedes agregar un mensaje de error para notificar al usuario
        }
    }
    
    
    public String laburaString(boolean l){
        String labura;
        if(l==true){
            labura = "Sí";
        }
        else{
            labura = "No" ;
        }
        
        return labura;
    }
}
