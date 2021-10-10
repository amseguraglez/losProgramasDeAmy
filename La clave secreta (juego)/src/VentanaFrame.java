import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class VentanaFrame extends JFrame {
    private String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
    private String[] clave;
    private HashMap<Integer, String> claveHashMap;
    private TableroPanel tablero;
    private BarraPanel barra;

    public VentanaFrame(String cabecera) throws HeadlessException {
        setTitle(cabecera);
        inicializarTablero();
        generarClave();
        inicializarBarra();
        inicializarVentana();
    }

    public HashMap<Integer, String> generarClave() {
        clave = new String[3];
        Collections.shuffle(Arrays.asList(letras));
        for (int i = 0; i < 3; i++) {
            clave[i] = letras[i];
        }
        System.out.println(Arrays.toString(clave));
        HashMap<Integer, String> claveHashMap = new HashMap<>();
        for (int i = 0; i < clave.length; i++) {
            claveHashMap.put(i, clave[i]);
        }
        System.out.println(claveHashMap);
        return claveHashMap;
    }

    private void inicializarBarra() {
        barra = new BarraPanel(clave);
        barra.setLayout(new GridLayout(3, 2));
    }

    private void inicializarTablero() {
        tablero = new TableroPanel(letras);
        tablero.setClave(new ClaseInterna());
        tablero.setLayout(new GridLayout(4, 4));
    }

    private void inicializarVentana() {
        add(tablero, BorderLayout.CENTER);
        add(barra, BorderLayout.SOUTH);
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // clase interna que es "subtipo" de IClave, pues la implementa
    // y según el principio de sustitución, allí donde espere recibirse un tipo (la interfaz como tipo)
    // podrá recibirse un subtipo (la clase que implementa la interfaz)
    private class ClaseInterna implements IValidaciones {
        @Override
        public boolean validarClave(String letra) {
            for (int i = 0; i < clave.length; i++) {
                if (clave[i].equals(letra))
                    return true;
            }
            return false;
        }

        @Override
        public void ratonClickado(String letra) {
            String claveAux = Arrays.toString(clave);
            if (claveAux.contains(letra))
                barra.setText(true, letra);
            else
                barra.setText(false, letra);
        }
    }
}

