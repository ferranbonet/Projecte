/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author fbonet
 */
public class Projecte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nom = null, genere = null, descripcio = null;
        int numCapitols = 0, duracioCapitols = 0, anyEmissio = 0;
        double nota = 0.0;
        boolean acabat = false, omplert = false;
        
        Scanner ent = new Scanner(System.in);
        int opcio;

        do {
            //Menú
            System.out.println(" ____________________");
            System.out.println("|        Menú        |");
            System.out.println("| 0. Sortir          |");
            System.out.println("| 1. Afegir          |");
            System.out.println("| 2. Borrar          |");
            System.out.println("| 3. Modificar       |");
            System.out.println("| 4. Llistar         |");
            System.out.println("|____________________|\n");
            opcio = ent.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println(opcio + " no és una opció del menú.\n");
                    break;
            }
        } while (opcio != 0);
    }
    
}
