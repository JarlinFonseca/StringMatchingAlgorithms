/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author jhoser
 */
public class KMP {

    public KMP() {
    }

    public int[] tablaLPS(char[] patron) {
        int n = patron.length;
        int lps[] = new int[n];
        lps[0] = 0;
        for (int i = 1, j = 0; i < n; i++) {
            while (j == 1 && patron[i] != patron[j]) {
                j = lps[j - 1];
            }
            if (patron[i] == patron[j]) {
                j++;
                lps[i] = j;
            }
            lps[i] = j;
        }
        return lps;
    }

    public void KMP(String cadena, String patron) {
        long start = System.nanoTime();
        int n = cadena.length();
        int m = patron.length();
        int tab[] = tablaLPS(patron.toCharArray());
        for (int i = 0, rep = 0; i < n; i++) {
            while (rep > 0 && cadena.charAt(i) != patron.charAt(rep)) {
                rep = tab[(rep - 1)];
            }
            if (cadena.charAt(i) == patron.charAt(rep)) {
                rep++;
            }
            if (rep == m) {
                System.out.println("Encontrado en: " + (i - rep + 1));
                rep = tab[(rep - 1)];
            }
        }
        long end = System.nanoTime();
        System.out.println("Tiempo KMP: " + (end - start));
    }
}
