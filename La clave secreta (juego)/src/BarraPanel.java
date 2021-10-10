import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BarraPanel extends JPanel{
    private ArrayList<JLabel> etiquetas;
    private JButton validar;
    private JButton limpiar;
    private int clicksCorrectos;
    private int clicksIncorrectos;
    private String[] claveSecreta = {"*", "*", "*"};
    private String[] claveIntentada = {"-", "-", "-"};
    private String[] clave;
    private HashMap<Integer, String> claveHashMap;

    public BarraPanel(String[] clave) {
        inicializarEtiquetas();
        inicializarBotones();
        this.clave = clave;
    }

    private void inicializarBotones() {
        validar = new JButton("Validar");
        validar.setBounds(70, 200, 75, 30);
        validar.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        validar.setBackground(Color.LIGHT_GRAY);
        validar.setForeground(Color.MAGENTA);
        validar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Arrays.toString(claveIntentada).equals(Arrays.toString(clave))) {
                    JOptionPane.showMessageDialog(null, "¡Genial! Has acertado\nLa clave secreta" +
                                    " es " + Arrays.toString(clave), "¡Lo conseguiste!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Vaya! Has fallado", "Perdiste",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        limpiar = new JButton("Borrar todo");
        limpiar.setBounds(200, 200, 120, 30);
        limpiar.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        limpiar.setBackground(Color.LIGHT_GRAY);
        limpiar.setForeground(Color.MAGENTA);
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < claveIntentada.length; i++) {
                    claveIntentada[i] = "-";
                }
                etiquetas.get(2).setText("CLAVE INTENTADA: " + Arrays.toString(claveIntentada));
            }
        });
        add(validar);
        add(limpiar);
    }

    private void inicializarEtiquetas() {
        etiquetas = new ArrayList<>();
        etiquetas.add(new JLabel("Clicks correctos: " + clicksCorrectos));
        etiquetas.add(new JLabel("Clicks incorrectos: " + clicksIncorrectos));
        etiquetas.add(new JLabel("CLAVE INTENTADA: " + Arrays.toString(claveIntentada)));
        etiquetas.add(new JLabel("CLAVE SECRETA: " + Arrays.toString(claveSecreta)));
        for (int i = 0; i < etiquetas.size(); i++) {
            add(etiquetas.get(i));
        }
    }

    public void setText(boolean correcta, String letra) {
        if (correcta) {
            etiquetas.get(0).setText("Clicks correctos: " + ++clicksCorrectos);
            modificarClaveIntentada(letra);
            etiquetas.get(2).setText("CLAVE INTENTADA: " + Arrays.toString(claveIntentada));
        } else
            etiquetas.get(1).setText("Clicks incorrectos: " + ++clicksIncorrectos);
    }

    private void modificarClaveIntentada(String letra) {
        boolean existe = false;
        for (int i = 0; i < claveIntentada.length; i++) {
            if (claveIntentada[i] == "-") {
                if (!Arrays.asList(claveIntentada).contains(letra))
                    claveIntentada[i] = letra;
            }
        }
    }
}
