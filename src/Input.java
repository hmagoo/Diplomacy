import javax.swing.*;

public class Input extends JComponent {

    public Input() {
    }

    @Override
    public void remove() {
        super.setVisible(false);
    }

    @Override
    public void add() {
        super.setVisible(true);
    }
}
