import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableroPanel extends JPanel {
    private ArrayList<CasillaButton> botones;

    public TableroPanel(String[] letras) {
        inicializarBotones(letras);
    }

    private void inicializarBotones(String[] letras) {
        botones = new ArrayList<>();
        for (int i = 0; i < letras.length; i++) {
            botones.add(new CasillaButton(letras[i]));
            add(botones.get(i));
        }
    }

    public void setClave(IValidaciones iValidaciones) {
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setIClave(iValidaciones);
        }
    }
}
