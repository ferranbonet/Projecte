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
        int numCapitols = 0, duracioCapitols = 0, anyEmissio = 0, opcio;
        double nota = 0.0;
        boolean acabat = false, omplert = false;
        char sino = 0, sino2;

        Scanner ent = new Scanner(System.in);

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
                    if (!omplert) {
                        System.out.println("Introdueix el nom:");
                        nom = ent.next();
                        System.out.println("Introdueix el gènere:");
                        genere = ent.next();
                        System.out.println("Introdueix una petita descripció:");
                        descripcio = ent.next();
                        System.out.println("Introdueix el número de capítols vists:");
                        numCapitols = ent.nextInt();
                        System.out.println("Introdueix la duració dels capítols:");
                        duracioCapitols = ent.nextInt();
                        System.out.println("Introdueix l'any d'emissió");
                        anyEmissio = ent.nextInt();
                        System.out.println("Assigna-li una nota:");
                        nota = ent.nextDouble();
                        System.out.println("L'has acabat? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino){
                                case 'S': case 's':
                                    acabat = (sino == 'S');
                                    break;
                                case 'N': case 'n':
                                    acabat = (sino == 'N');
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("L'has acabat? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino!='S' && sino != 's'&& sino!='N'&&sino!='n');
                        omplert = true;
                    } else {
                        System.out.println("Ja hi han dades introduïdes, si en vols introduïr de noves tens que esborrar les antigues.");
                    }
                    break;
                case 2:
                    if (omplert) {
                        System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
                        sino2 = ent.next().charAt(0);
                        do {
                            switch (sino2) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom: " + nom);
                                    System.out.println("Gènere: " + genere);
                                    System.out.println("Descripció: " + descripcio);
                                    System.out.println("Número de capítols: " + numCapitols);
                                    System.out.println("Duració dels capítols: " + duracioCapitols);
                                    System.out.println("Any d'emissió: " + anyEmissio);
                                    System.out.println("Nota: " + nota);
                                    System.out.println("Acabat: " + sino);
                                    sino2 = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino2 + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
                                    sino2 = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino2 != 'N' && sino2 != 'n');
                        System.out.println("\nEstàs segur que vols esborrar les dades? (S/N)");
                        sino2 = ent.next().charAt(0);
                        do {
                        switch (sino2) {
                            case 'S':
                            case 's':
                                numCapitols = 0;
                                duracioCapitols = 0;
                                anyEmissio = 0;
                                nota = 0.0;
                                acabat = false;
                                omplert = false;
                                System.out.println("Dades esborrades.\n");
                                sino2 = 'N';
                                break;
                            case 'N':
                            case 'n':
                                System.out.println("Operació cancel·lada.\n");
                                break;
                            default:
                                System.out.println(sino2 + " no és una opció vàlida.\n");
                                System.out.println("Estàs segur que vols esborrar les dades? (S/N)");
                                sino2 = ent.next().charAt(0);
                                break;
                        }
                        } while (sino2 != 'N' && sino2 != 'n');
                    } else {
                        System.out.println("No hi han dades introduïdes.");
                    }
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
