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
        char acabatChar = 0, sino;

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
            System.out.println("| 5. Recuperar       |");
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
                        acabatChar = ent.next().charAt(0);
                        do {
                            switch (acabatChar) {
                                case 'S':
                                case 's':
                                    acabat = true;
                                    break;
                                case 'N':
                                case 'n':
                                    acabat = false;
                                    break;
                                default:
                                    System.out.println(acabatChar + " no és una opció vàlida.\n");
                                    System.out.println("L'has acabat? (S/N)");
                                    acabatChar = ent.next().charAt(0);
                                    break;
                            }
                        } while (acabatChar != 'S' && acabatChar != 's' && acabatChar != 'N' && acabatChar != 'n');
                        omplert = true;
                    } else {
                        System.out.println("Ja hi han dades enregistrades, si en vols introduïr de noves tens que esborrar les antigues.");
                    }
                    break;
                case 2:
                    if (omplert) {
                        System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom: " + nom);
                                    System.out.println("Gènere: " + genere);
                                    System.out.println("Descripció: " + descripcio);
                                    System.out.println("Número de capítols: " + numCapitols);
                                    System.out.println("Duració dels capítols: " + duracioCapitols);
                                    System.out.println("Any d'emissió: " + anyEmissio);
                                    System.out.println("Nota: " + nota);
                                    if (acabat == true) {
                                        System.out.println("Acabat: Sí");
                                    } else {
                                        System.out.println("Acabat: No");
                                    }
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("\nEstàs segur que vols esborrar les dades? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    omplert = false;
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Operació cancel·lada.\n");
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Estàs segur que vols esborrar les dades? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                    } else {
                        System.out.println("No hi han dades enregistrades.");
                    }
                    break;
                case 3:
                    if (omplert == true) {
                        System.out.println("Vols veure les dades abans de modificar-les? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom: " + nom);
                                    System.out.println("Gènere: " + genere);
                                    System.out.println("Descripció: " + descripcio);
                                    System.out.println("Número de capítols: " + numCapitols);
                                    System.out.println("Duració dels capítols: " + duracioCapitols);
                                    System.out.println("Any d'emissió: " + anyEmissio);
                                    System.out.println("Nota: " + nota);
                                    if (acabat == true) {
                                        System.out.println("Acabat: Sí");
                                    } else {
                                        System.out.println("Acabat: No");
                                    }
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans de modificar-les? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("\nVols modificar el nom? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el nom:");
                                    nom = ent.next();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el nom? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("\nVols modificar el gènere? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el gènere:");
                                    genere = ent.next();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el gènere? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("\nVols modificar la descripció? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix una petita descripció:");
                                    descripcio = ent.next();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la descripció? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("Vols modificar el número de capítols vists? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el número de capítols vists:");
                                    numCapitols = ent.nextInt();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el número de capítols vists? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("Vols modificar la duració dels capítols? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix la duració dels capítols:");
                                    duracioCapitols = ent.nextInt();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la duració dels capítols? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("Vols modificar l'any d'emissió? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix l'any d'emissió");
                                    anyEmissio = ent.nextInt();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar l'any d'emissió? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("Vols modificar l'any d'emissió? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix l'any d'emissió");
                                    anyEmissio = ent.nextInt();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar l'any d'emissió? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("Vols modificar la nota? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Assigna-li una nota:");
                                    nota = ent.nextDouble();
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la nota? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("L'has acabat? (S/N)");
                        acabatChar = ent.next().charAt(0);
                        do {
                            switch (acabatChar) {
                                case 'S':
                                case 's':
                                    acabat = true;
                                    break;
                                case 'N':
                                case 'n':
                                    acabat = false;
                                    break;
                                default:
                                    System.out.println(acabatChar + " no és una opció vàlida.\n");
                                    System.out.println("L'has acabat? (S/N)");
                                    acabatChar = ent.next().charAt(0);
                                    break;
                            }
                        } while (acabatChar != 'S' && acabatChar != 's' && acabatChar != 'N' && acabatChar != 'n');
                        omplert = true;
                    } else {
                        System.out.println("No hi han dades enregistrades.");
                    }
                    break;
                case 4:
                    if (omplert == true) {
                        System.out.println("Series vistes");
                        System.out.println("Nom: " + nom);
                        System.out.println("Gènere: " + genere);
                        System.out.println("Descripció: " + descripcio);
                        System.out.println("Número de capítols: " + numCapitols);
                        System.out.println("Duració dels capítols: " + duracioCapitols);
                        System.out.println("Any d'emissió: " + anyEmissio);
                        System.out.println("Nota: " + nota);
                        if (acabat == true) {
                            System.out.println("Acabat: Sí");
                        } else {
                            System.out.println("Acabat: No");
                        }
                    } else {
                        System.out.println("No hi ha dades per a mostrar.\n");
                    }
                    break;
                case 5:
                    if (!omplert) {
                        System.out.println("Vols veure les dades abans de recuperar-les? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom: " + nom);
                                    System.out.println("Gènere: " + genere);
                                    System.out.println("Descripció: " + descripcio);
                                    System.out.println("Número de capítols: " + numCapitols);
                                    System.out.println("Duració dels capítols: " + duracioCapitols);
                                    System.out.println("Any d'emissió: " + anyEmissio);
                                    System.out.println("Nota: " + nota);
                                    if (acabat == true) {
                                        System.out.println("Acabat: Sí");
                                    } else {
                                        System.out.println("Acabat: No");
                                    }
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans de recuperar-les? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                        System.out.println("\nEstàs segur que vols recuperar les dades? (S/N)");
                        sino = ent.next().charAt(0);
                        do {
                            switch (sino) {
                                case 'S':
                                case 's':
                                    omplert = true;
                                    sino = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Operació cancel·lada.\n");
                                    break;
                                default:
                                    System.out.println(sino + " no és una opció vàlida.\n");
                                    System.out.println("Estàs segur que vols recuperar les dades? (S/N)");
                                    sino = ent.next().charAt(0);
                                    break;
                            }
                        } while (sino != 'N' && sino != 'n');
                    } else {
                        System.out.println("No hi han dades enregistrades.");
                    }
                    break;
                default:
                    System.out.println(opcio + " no és una opció vàlida.\n");
                    break;
            }
        } while (opcio != 0);
    }

}
