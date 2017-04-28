/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author fbonet
 */
public class Projecte {

    public static final int MAX_SERIES = 5;
    private static Serie[] array = new Serie[MAX_SERIES];
    private static int opcio;
    static File f = new File("series.db");

    public static Serie[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());
    }

    public static int inicialitzarVariables() {
        Serie p = null;
        int i = 0;
        if (f.exists()) {
            boolean acabar = false;
            ObjectInputStream lectura = null;
            try {
                lectura = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
                while (true) {
                    array[i] = (Serie) lectura.readObject();
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println("Atenció, no caben tots els objectes. Si continues pots perdre dades. Vols continuar?(S/N):");
                Scanner ent = new Scanner(System.in);
                char siNo = ' ';
                do {
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'N') {
                    acabar = true;
                }
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
            } finally {
                try {
                    if (lectura != null) {
                        lectura.close();
                    }
                } catch (IOException ex) {
                }
                if (acabar) {
                    System.exit(0);
                }
            }
        }
        int resultat = i;
        for (; i < array.length; i++) {
            array[i] = new Serie();
            array[i].setOmplert(false);
        }
        return resultat;
    }

    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        do {
            System.out.println(" ____________________");
            System.out.println("|        Menú        |");
            System.out.println("| 0. Sortir          |");
            System.out.println("| 1. Afegir          |");
            System.out.println("| 2. Borrar          |");
            System.out.println("| 3. Modificar       |");
            System.out.println("| 4. Llistar         |");
            System.out.println("| 5. Recuperar       |");
            System.out.println("|____________________|\n");
            try {
                opcio = Integer.valueOf(ent.skip("[\r\n]*").nextLine());
            } catch (java.lang.NumberFormatException e) {
                opcio = -1;
                System.out.println("Opció incorrecta.");
            }
        } while (opcio > 5 || opcio < 0);
    }

    public static void tractarOpcio() {
        switch (opcio) {
            case 0:
                finalitzar();
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
        }
    }

    public static boolean opcioFinal() {
        return opcio == 0;
    }

    public static void finalitzar() {
        ObjectOutputStream escriptura = null;
        try {
            escriptura = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

            for (int i = 0; i < array.length; i++) {
                if (array[i].isOmplert()) {
                    escriptura.writeObject(array[i]);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error en desar les dades.");
        } finally {
            try {
                if (escriptura != null) {
                    escriptura.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    public static void introduirSerie() {
        Scanner ent = new Scanner(System.in);
        int i;
        for (i = 0; i < array.length && array[i].isOmplert(); i++);
        if (i != array.length) {
            System.out.println("Introdueix el nom:");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix el gènere:");
            array[i].setGenere(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix una petita descripció:");
            array[i].setDescripcio(ent.skip("[\r\n]*").nextLine());
            do {
                System.out.println("Introdueix el número de capítols vists:");
                try {
                    array[i].setNumCapitols(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Opció incorrecta.");
                    array[i].setNumCapitols(-1);
                }
            } while (array[i].getNumCapitols() < 0);
            do {
                System.out.println("Introdueix la duració dels capítols (minuts):");
                try {
                    array[i].setDuracioCapitols(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Opció incorrecta.");
                    array[i].setDuracioCapitols(-1);
                }
            } while (array[i].getDuracioCapitols() < 0);
            do {
                System.out.println("Introdueix l'any d'emissió:");
                try {
                    array[i].setAnyEmissio(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Opció incorrecta.");
                    array[i].setAnyEmissio(-1);
                }
            } while (array[i].getAnyEmissio() < 0);
            do {
                System.out.println("Assigna-li una nota:");
                try {
                    array[i].setNota(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Opció incorrecta.");
                    array[i].setNota(-1);
                }
            } while (array[i].getNota() < 0);
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
        boolean existeix = false;
        char siNo = 'N';
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
        boolean existeix = false;
        char siNo = 'N';
        int compt = 1;
        int i;
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (array[i].isOmplert()) {
                System.out.format("\nSerie " + compt++ + ":\n");
                System.out.println(array[i]);
                do {
                    System.out.println("\nVols modificar la serie(S/N) o finalitzar la busqueda(F)?");
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
                do {
                    System.out.println("Vols modificar el nom \"" + array[i].getNom() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou nom: ");
                    array[i].setNom(ent.skip("[\r\n]*").nextLine());
                }
                do {
                    System.out.println("\nVols modificar el gènere \"" + array[i].getGenere() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nou gènere: ");
                    array[i].setGenere(ent.skip("[\r\n]*").nextLine());
                }
                do {
                    System.out.println("\nVols modificar la descripció \"" + array[i].getDescripcio() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    System.out.print("Nova descripció: ");
                    array[i].setDescripcio(ent.skip("[\r\n]*").nextLine());
                }
                do {
                    System.out.println("\nVols modificar el número de capítols vists \"" + array[i].getNumCapitols() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    do {
                        System.out.print("Nou número de capítols vists: ");
                        try {
                            array[i].setNumCapitols(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                        } catch (java.lang.NumberFormatException e) {
                            System.out.println("Opció incorrecta.");
                            array[i].setNumCapitols(-1);
                        }
                    } while (array[i].getNumCapitols() < 0);
                }
                do {
                    System.out.println("\nVols modificar la duració dels capítols \"" + array[i].getDuracioCapitols() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    do {
                        System.out.print("Nova duració dels capítols: ");
                        try {
                            array[i].setDuracioCapitols(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                        } catch (java.lang.NumberFormatException e) {
                            System.out.println("Opció incorrecta.");
                            array[i].setDuracioCapitols(-1);
                        }
                    } while (array[i].getDuracioCapitols() < 0);
                }
                do {
                    System.out.println("\nVols modificar l'any d'emissió \"" + array[i].getAnyEmissio() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    do {
                        System.out.print("Nou any d'emissió: ");
                        try {
                            array[i].setAnyEmissio(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                        } catch (java.lang.NumberFormatException e) {
                            System.out.println("Opció incorrecta.");
                            array[i].setAnyEmissio(-1);
                        }
                    } while (array[i].getAnyEmissio() < 0);
                }
                do {
                    System.out.println("\nVols modificar la nota \"" + array[i].getNota() + "\" (S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (siNo == 'S') {
                    do {
                        System.out.print("Nova nota: ");
                        try {
                            array[i].setNota(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                        } catch (java.lang.NumberFormatException e) {
                            System.out.println("Opció incorrecta.");
                            array[i].setNota(-1);
                        }
                    } while (array[i].getNota() < 0);
                }
                do {
                    System.out.println("\nVols modificar si l'has acabat \"" + array[i].isAcabat() + "\" (S/N)?");
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
        boolean existeix = true;
        char siNo = 'N';
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i].isOmplert()) {
                System.out.println(array[i]);
                do {
                    System.out.println("\nVols llistar més series(S/N)?");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (siNo != 'S' && siNo != 'N');
                if (!array[i + 1].isOmplert()) {
                    existeix = false;
                }
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
        boolean existeix = false;
        char siNo = 'N';
        int compt = 0;
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
