import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    VentanaFrame vp1 = new VentanaFrame("Juego");
                }
            });
        } catch (RuntimeException e) {
            System.err.println("Se ha producido un error: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.err.println("Se ha producido un error: " + e.getClass().getSimpleName());
        }
    }
}
