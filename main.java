import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> asci = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        List<String> ord = new ArrayList<>(Arrays.asList("multidimensional", "declaration", "metric", "subtract", "assembly", "construction", "array", "string", "variable"));
        List<String> boksGiss = new ArrayList<>(Arrays.asList(" "));
        char gissning = '\0';
        String längd = "";
        double image = 0.0;
        String rättOrd = ord.get((int) (Math.random() * ord.size()));
        int felAnt = Integer.parseInt(JOptionPane.showInputDialog("Antal tillåtna fel?"));
        int fel = -1;
        boolean c = false;
        boolean rätt = false;
        boolean ogiltig = false;
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
                    }
                c = false;
            }
            if (rätt == false) {
                fel += 1;
            }
            rätt = false;
            image = ((double) fel / felAnt) * 10;
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
            boksGiss.add(String.valueOf(gissning));
        }
    }
}
/* Kvar att göra:
Funktionalitet för att gissa på hela ordet.
ASCII bilder. */