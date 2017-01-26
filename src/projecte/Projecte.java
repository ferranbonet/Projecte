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

    // Número màxim de caselles de l'array
    private static final int MAX_SERIES = 2;
    // Array on guardarem la informació
    private static Serie[] array = new Serie[MAX_SERIES];

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //
        Scanner ent = new Scanner(System.in);
        int opcio, i;
        char siNo;

        for (int j = 0; j < array.length; j++) {
            array[j] = new Serie();
            array[j].setOmplert(false);
        }

        String nom = "";
        String genere = "";
        String descripcio = "";
        int numCapitols = 0;
        int duracioCapitols = 0;
        int anyEmissio = 0;
        double nota = 0.0;
        boolean acabat = false;
        boolean omplert = false;
        char acabatChar;

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
                    // Buscar una casella buida al vector
                    for (i = 0; i < array.length && array[i].isOmplert(); i++);
                    //
                    if (i != array.length) {
                        System.out.println("Introdueix el nom:");
                        array[i].setNom(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix el gènere:");
                        array[i].setGenere(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix una petita descripció:");
                        array[i].setDescripcio(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix el número de capítols vists:");
                        array[i].setNumCapitols(ent.skip("[\n\n]*").nextInt());
                        System.out.println("Introdueix la duració dels capítols:");
                        array[i].setDuracioCapitols(ent.skip("[\n\n]*").nextInt());
                        System.out.println("Introdueix l'any d'emissió");
                        array[i].setAnyEmissio(ent.skip("[\n\n]*").nextInt());
                        System.out.println("Assigna-li una nota:");
                        array[i].setNota(ent.skip("[\n\n]*").nextInt());
                        System.out.println("L'has acabat? (S/N)");
                        array[i].setAcabatChar(ent.skip("[\n\n]*").nextLine().toUpperCase().charAt(0));
                        do {
                            switch (array[i].getAcabatChar()) {
                                case 'S':
                                    array[i].setAcabat(true);
                                    break;
                                case 'N':
                                    array[i].setAcabat(false);
                                    break;
                                default:
                                    System.out.println(array[i].getAcabatChar() + " no és una opció vàlida.\n");
                                    System.out.println("L'has acabat? (S/N)");
                                    array[i].setAcabatChar(ent.skip("[\n\n]*").nextLine().toUpperCase().charAt(0));
                                    break;
                            }
                        } while (array[i].getAcabatChar() != 'S' && array[i].getAcabatChar() != 'N');
                        array[i].setOmplert(true);
                    } else {
                        System.out.println("No caben més series.");
                    }
                    break;
                case 2:
                    for (i = 0; i < array.length; i++) {
                        if (array[i].isOmplert()) {
                            System.out.println(array[i]);
                            if (array[i].isAcabat()) {
                                System.out.println("Acabat: Sí");
                            } else {
                                System.out.println("Acabat: No");
                            }
                            
                            do {
                                System.out.println("\nVols esborrar le serie? (S/N)");
                                siNo = ent.skip("[\n\n]*").nextLine().toUpperCase().charAt(0);
                            } while (siNo != 'S' && siNo != 'N');
                            if (siNo == 'S') {
                                array[i].setOmplert(false);
                                System.out.println("Serie esborrada correctament.");
                            }
                        } else {
                            if (i == (array.length - 1)) {
                                System.out.println("No hi han dades per esborrar.");
                            }
                        }
                    }
//                    if (omplert) {
//                        System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
//                        siNo = ent.next().charAt(0);
//                        do {
//                            switch (siNo) {
//                                case 'S':
//                                case 's':
//                                    System.out.println("Nom: " + nom);
//                                    System.out.println("Gènere: " + genere);
//                                    System.out.println("Descripció: " + descripcio);
//                                    System.out.println("Número de capítols: " + numCapitols);
//                                    System.out.println("Duració dels capítols: " + duracioCapitols);
//                                    System.out.println("Any d'emissió: " + anyEmissio);
//                                    System.out.println("Nota: " + nota);
//                                    if (acabat == true) {
//                                        System.out.println("Acabat: Sí");
//                                    } else {
//                                        System.out.println("Acabat: No");
//                                    }
//                                    siNo = 'N';
//                                    break;
//                                case 'N':
//                                case 'n':
//                                    break;
//                                default:
//                                    System.out.println(siNo + " no és una opció vàlida.\n");
//                                    System.out.println("Vols veure les dades abans d'esborrar-les? (S/N)");
//                                    siNo = ent.next().charAt(0);
//                                    break;
//                            }
//                        } while (siNo != 'N' && siNo != 'n');
//                        System.out.println("\nEstàs segur que vols esborrar les dades? (S/N)");
//                        siNo = ent.next().charAt(0);
//                        do {
//                            switch (siNo) {
//                                case 'S':
//                                case 's':
//                                    omplert = false;
//                                    siNo = 'N';
//                                    break;
//                                case 'N':
//                                case 'n':
//                                    System.out.println("Operació cancel·lada.\n");
//                                    break;
//                                default:
//                                    System.out.println(siNo + " no és una opció vàlida.\n");
//                                    System.out.println("Estàs segur que vols esborrar les dades? (S/N)");
//                                    siNo = ent.next().charAt(0);
//                                    break;
//                            }
//                        } while (siNo != 'N' && siNo != 'n');
//                    } else {
//                        System.out.println("No hi han dades enregistrades.");
//                    }
                    break;
                case 3:
                    if (omplert) {
                        System.out.println("Vols veure les dades abans de modificar-les? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
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
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans de modificar-les? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("\nVols modificar el nom? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el nom:");
                                    nom = ent.next();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el nom? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("\nVols modificar el gènere? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el gènere:");
                                    genere = ent.next();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el gènere? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("\nVols modificar la descripció? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix una petita descripció:");
                                    descripcio = ent.next();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la descripció? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("Vols modificar el número de capítols vists? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix el número de capítols vists:");
                                    numCapitols = ent.nextInt();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar el número de capítols vists? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("Vols modificar la duració dels capítols? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix la duració dels capítols:");
                                    duracioCapitols = ent.nextInt();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la duració dels capítols? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("Vols modificar l'any d'emissió? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix l'any d'emissió");
                                    anyEmissio = ent.nextInt();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar l'any d'emissió? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("Vols modificar l'any d'emissió? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Introdueix l'any d'emissió");
                                    anyEmissio = ent.nextInt();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar l'any d'emissió? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("Vols modificar la nota? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    System.out.println("Assigna-li una nota:");
                                    nota = ent.nextDouble();
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols modificar la nota? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
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
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
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
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Vols veure les dades abans de recuperar-les? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
                        System.out.println("\nEstàs segur que vols recuperar les dades? (S/N)");
                        siNo = ent.next().charAt(0);
                        do {
                            switch (siNo) {
                                case 'S':
                                case 's':
                                    omplert = true;
                                    siNo = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Operació cancel·lada.\n");
                                    break;
                                default:
                                    System.out.println(siNo + " no és una opció vàlida.\n");
                                    System.out.println("Estàs segur que vols recuperar les dades? (S/N)");
                                    siNo = ent.next().charAt(0);
                                    break;
                            }
                        } while (siNo != 'N' && siNo != 'n');
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
