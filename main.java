import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> asci = new ArrayList<>(Arrays.asList("", "============", "|\n|\n|\n|\n|\n============", "+-----------+\n|\n|\n|\n|\n|\n============", "+-----------+\n|                 |\n|\n|\n|\n|\n============", "+-----------+\n|                 |\n|                O\n|\n|\n|\n============", "+-----------+\n|                 |\n|                O\n|                 |\n|\n|\n============", "+-----------+\n|                 |\n|                O\n|               / |\n|\n|\n============", "+-----------+\n|                 |\n|                O\n|               / | \\ \n|\n|\n============", "+-----------+\n|                 |\n|                O\n|               / | \\ \n|               /\n|\n============", "+-----------+\n|                 |\n|                O\n|               / | \\ \n|               /   \\ \n|\n============"));
        List<String> ord = new ArrayList<>(Arrays.asList("multidimensional", "declaration", "metric", "subtract", "assembly", "construction", "array", "string", "variable"));
        List<String> boksGiss = new ArrayList<>(Arrays.asList(" "));
        char gissning = '\0';
        String längd = "";
        double image = 0.0;
        String rättOrd = ord.get((int) (Math.random() * ord.size()));
        boolean c = false;
        boolean rätt = false;
        boolean ogiltig = false;
        boolean vinn = false;
        int fel = -1;
        int felAnt = 0;
        while (true) {
            felAnt = Integer.parseInt(JOptionPane.showInputDialog("Antal tillåtna fel? (Max 10)"));
            if (felAnt > 10) {
                JOptionPane.showMessageDialog(null, "Talet du skrev in är högre än 10, vänligen skriv in ett nytt tal.");
            }
            else {
                break;
            }
        }
        while (true) {
            for (int i = 0; i < rättOrd.length(); i++) {
                for (int n = 0; n < boksGiss.size(); n++) {
                    if (boksGiss.get(n).equals(String.valueOf(rättOrd.charAt(i)))) {
                        längd += rättOrd.charAt(i) + " ";
                        c = true;
                        }
                    }
                    if (String.valueOf(gissning).equals(String.valueOf(rättOrd.charAt(i)))) {
                        rätt = true;
                    }
                if (c == false) {
                    längd += "_ ";
                    vinn = false;
                    }
                c = false;
            }
            if (vinn == true) {
                JOptionPane.showMessageDialog(null, asci.get((int) image) + "\n" + längd + "\n" + boksGiss + "\nDu vann!");
                break;
            }
            if (rätt == false) {
                fel += 1;
            }
            rätt = false;
            image = ((double) fel / felAnt) * 10;
            if (image >= 10) {
                JOptionPane.showMessageDialog(null, asci.get((int) 10) + "\n" + längd + "\n" + boksGiss + "\nDu förlorade :(");
                break;
            }
            while (true) {
                gissning = JOptionPane.showInputDialog(asci.get((int) image) + "\n" + längd + "\n" + boksGiss + "\nGissa på en bokstav.").charAt(0);
                for (int i = 0; i < boksGiss.size(); i++) {
                    if (boksGiss.get(i).equals(String.valueOf(gissning))) {
                        ogiltig = true;
                    }
                }
                if (ogiltig == true) {
                    JOptionPane.showMessageDialog(null, "Du har redan gissat på den bokstaven förut.");
                    ogiltig = false;
                }
                else {
                    break;
                }
            }
            längd = "";
            vinn = true;
            boksGiss.add(String.valueOf(gissning));
        }
    }
}