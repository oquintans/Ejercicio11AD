/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oracle
 */
public class Aleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            RandomAccessFile raf = new RandomAccessFile("texto1.txt", "rw");
            Product p;
            String code = "";
            String desc = "";
            String[] cod = {"p1", "p2", "p3"};
            String[] descr = {"parafusos", "cravos ", "tachas"};
            int[] price = {3, 4, 5};

            for (int i = 0; i < cod.length; i++) {
                raf.writeChars(String.format("%-3s", cod[i]).replace(' ', '*'));
                raf.writeChars(String.format("%-10s", descr[i]).replace(' ', '*'));
                raf.writeInt(price[i]);
            }
            int reg = Integer.parseInt(JOptionPane.showInputDialog("Nº Registro."));
            raf.seek((reg - 1) * 30);

            for (int i = 0; i < 13; i++) {
                if (i < 3) {
                    code += raf.readChar();
                } else {
                    desc += raf.readChar();
                }
            }

            p = new Product(code.replace("*", ""), desc.replace("*", ""), raf.readInt());
            System.out.println(p);
            raf.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
