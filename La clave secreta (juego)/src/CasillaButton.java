import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CasillaButton extends JButton{
    private IValidaciones iValidaciones;
    private Font fuente = new Font("Comic Sans MS", Font.BOLD, 16);

    public CasillaButton(String letra) {
        super(letra);
        setFont(fuente);
        setBackground(Color.CYAN);
        addMouseListener(new Receptor());
    }

    public void setIClave(IValidaciones iValidaciones) {
        this.iValidaciones = iValidaciones;
    }

    private class Receptor extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            if (iValidaciones != null) {
                if(iValidaciones.validarClave(getText()))
                    setBackground(Color.GREEN);
                else
                    setBackground(Color.RED);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(Color.CYAN);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            iValidaciones.ratonClickado(getText());
        }
    }

}
