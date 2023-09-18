/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicejpa;
import practicejpa.services.JPAServices;

/**
 *
 * @author Fernando
 */
public class PracticeJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JPAServices jpa = new JPAServices();
        
        jpa.cargarBase();
        jpa.consultas();
    }
    
}
