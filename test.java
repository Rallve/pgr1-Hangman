import javax.swing.*;

public class test {
    public static void main(String[] args) {
        double image = 0.0;
        int fel = 1;
        int felAnt = 3;
        image = Math.floor(Double.valueOf(fel) / Double.valueOf(felAnt));
        JOptionPane.showMessageDialog(null, image);
        fel += 1;
        image = ((double) fel / felAnt) * 10 ;
        JOptionPane.showMessageDialog(null, Math.ceil(image));
    }
}