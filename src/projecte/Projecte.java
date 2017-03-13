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
    // Variable on es guarda l'opció escollida
    private static int opcio;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());
    }

    public static void inicialitzarVariables() {
        // Inicialització de l'array
        for (int j = 0; j < array.length; j++) {
            array[j] = new Serie();
            array[j].setOmplert(false);
        }
    }

    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        // Menú
        System.out.println(" ____________________");
        System.out.println("|        Menú        |");
        System.out.println("| 0. Sortir          |");
        System.out.println("| 1. Afegir          |");
        System.out.println("| 2. Borrar          |");
        System.out.println("| 3. Modificar       |");
        System.out.println("| 4. Llistar         |");
        System.out.println("| 5. Recuperar       |");
        System.out.println("|____________________|\n");
        opcio = ent.skip("[\r\n]*").nextInt();
    }

    public static void tractarOpcio() {
        switch (opcio) {
            case 0:
                break;
            case 1:
                introduirSerie();
                break;
            case 2:
                esborrarSerie();
                break;
            case 3:
                modificarSerie();
                break;
            case 4:
                llistarSerie();
                break;
            case 5:
                recuperarSerie();
                break;
            default:
                System.out.println("\nOpció incorrecta.");
        }
    }

    public static boolean opcioFinal() {
        return opcio == 0;
    }

    public static void introduirSerie() {
        Scanner ent = new Scanner(System.in);
        // Buscar una casella buida a l'array
        int i;
        for (i = 0; i < array.length && array[i].isOmplert(); i++);
        // Si troba una casella buida l'omplirem
        if (i != array.length) {
            System.out.println("Introdueix el nom:");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix el gènere:");
            array[i].setGenere(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix una petita descripció:");
            array[i].setDescripcio(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix el número de capítols vists:");
            array[i].setNumCapitols(ent.skip("[\r\n]*").nextInt());
            System.out.println("Introdueix la duració dels capítols:");
            array[i].setDuracioCapitols(ent.skip("[\r\n]*").nextInt());
            System.out.println("Introdueix l'any d'emissió:");
            array[i].setAnyEmissio(ent.skip("[\r\n]*").nextInt());
            System.out.println("Assigna-li una nota:");
            array[i].setNota(ent.skip("[\r\n]*").nextInt());
            do {
                System.out.println("L'has acabat? (S/N)");
                array[i].setAcabatChar(ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));
            } while (array[i].getAcabatChar() != 'S' && array[i].getAcabatChar() != 'N');
            array[i].setAcabat(array[i].getAcabatChar() == 'S');
            array[i].setOmplert(true);
        } else {
            System.out.println("No caben més series.");
        }
    }

    public static void esborrarSerie() {
        Scanner ent = new Scanner(System.in);
        // Variables locals
        boolean existeix = false;
        char siNo = 'N';
        // Buscar caselles plenes a l'array
        int i;
        for (i = 0; i < array.length && siNo != 'F'; i++) {
            if (array[i].isOmplert()) {
                System.out.println(array[i]);
                do {
                    System.out.println("\nVols esborrar la serie(S/N) o finalitzar la busqueda(F)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
                existeix = true;
            }
            if (siNo == 'S') {
                break;
            }
        }
        if (existeix) {
            if (siNo == 'S') {
                array[i].setOmplert(false);
                System.out.println("Serie esborrada correctament.");
            } else {
                System.out.println("No s'ha esborrat cap serie.");
            }
        } else {
            System.out.println("No hi han series per a esborrar.");
        }
    }

    public static void modificarSerie() {
        Scanner ent = new Scanner(System.in);
        // Variables locals
        boolean existeix = false;
        char siNo = 'N';
        int compt = 1;
        // Buscar caselles plenes a l'array
        int i;
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (array[i].isOmplert()) {
                System.out.format("\nSerie " + compt++ + ":\n");
                System.out.println(array[i]);
                do {
                    System.out.println("\\nVols modificar la serie(S/N) o finalitzar la busqueda(F)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
                existeix = true;
            }
            if (siNo == 'S') {
                break;
            }
        }
        if (existeix) {
            if (siNo == 'S') {
                System.out.println("\n" + array[i].getNom());
                do {
                    System.out.println("\nVols modificar el nom(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou nom: ");
                    array[i].setNom(ent.skip("[\r\n]*").nextLine());
                }
                System.out.println("\n" + array[i].getGenere());
                do {
                    System.out.println("\nVols modificar el gènere(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou gènere: ");
                    array[i].setGenere(ent.skip("[\r\n]*").nextLine());
                }
                System.out.println("\n" + array[i].getDescripcio());
                do {
                    System.out.println("\nVols modificar la descripció(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nova descripció: ");
                    array[i].setDescripcio(ent.skip("[\r\n]*").nextLine());
                }
                System.out.println("\n" + array[i].getNumCapitols());
                do {
                    System.out.println("\nVols modificar el número de capítols vists(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou número de capítols vists: ");
                    array[i].setNumCapitols(ent.skip("[\r\n]*").nextInt());
                }
                System.out.println("\n" + array[i].getDuracioCapitols());
                do {
                    System.out.println("\nVols modificar la duració dels capítols(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nova duració dels capítols: ");
                    array[i].setDuracioCapitols(ent.skip("[\r\n]*").nextInt());
                }
                System.out.println("\n" + array[i].getAnyEmissio());
                do {
                    System.out.println("\nVols modificar l'any d'emissió(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou any d'emissió: ");
                    array[i].setAnyEmissio(ent.skip("[\r\n]*").nextInt());
                }
                System.out.println("\n" + array[i].getNota());
                do {
                    System.out.println("\nVols modificar la nota(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nova nota: ");
                    array[i].setNota(ent.skip("[\r\n]*").nextInt());
                }
                System.out.println("\n" + array[i].isAcabat());
                do {
                    System.out.println("\nVols modificar si l'has acabat(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    do {
                        System.out.print("L'has acabat(S/N)? ");
                        array[i].setAcabatChar(ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));
                    } while (array[i].getAcabatChar() != 'S' && array[i].getAcabatChar() != 'N');
                    array[i].setAcabat(array[i].getAcabatChar() == 'S');
                }
                System.out.println("Serie modificada.");
            } else {
                System.out.println("No s'ha seleccionat cap serie per a modificar.");
            }
        } else {
            System.out.println("No hi han series per modificar.");
        }
    }

    public static void llistarSerie() {
        Scanner ent = new Scanner(System.in);
        // Variables locals
        boolean existeix = false;
        char siNo = 'S';
        // Buscar caselles plenes a l'array
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i].isOmplert()) {
                System.out.println(array[i]);
                do {
                    System.out.println("\nVols llistar més series(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                existeix = true;
            }
            if (siNo == 'N') {
                break;
            }
        }
        if (!existeix) {
            System.out.println("\nNo hi han series per a llistar.");
        }
    }

    public static void recuperarSerie() {
        Scanner ent = new Scanner(System.in);
        // Variables locals
        boolean existeix = false;
        char siNo = 'N';
        int compt = 0;
        // Buscar caselles plenes a l'array
        int i;
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (!array[i].isOmplert()) {
                System.out.format("\nSerie " + compt + ":\n");
                System.out.println(array[i]);
                do {
                    System.out.println("\nVols recuperar la serie(S/N) o finalitzar la busqueda(F)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                existeix = true;
            }
            if (siNo == 'S') {
                break;
            }
        }
        if (siNo == 'S') {
            array[i].setOmplert(true);
            System.out.println("Serie recuperada.");
        } else {
            if (existeix) {
                System.out.println("Serie no recuperada.");
            } else {
                System.out.println("No hi han series per a recuperar.");
            }
        }
    }
}
