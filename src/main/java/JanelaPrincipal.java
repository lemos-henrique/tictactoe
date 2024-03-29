import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame{
    private JPanel painelPrincipal;
    private JLabel lblJogo;
    private JPanel painelOpc;
    private JPanel painelSolo;
    private JPanel painelMulti;
    private JButton btnJogarSolo;
    private JButton btnJogarMulti;

    public JanelaPrincipal(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(painelPrincipal);
        this.pack();

        btnJogarSolo.addActionListener(this::btnJogarSoloActionPerformed);
        btnJogarMulti.addActionListener(this::btnJogarMultiActionPerformed);
    }

    private void btnJogarSoloActionPerformed(ActionEvent e) {
        new JogoSolo();
    }

    private void btnJogarMultiActionPerformed(ActionEvent e) {
        new JogoSolo();
    }

    public static void main(String[] args) {
        new JanelaPrincipal("Tic Tac Toe").setVisible(true);
    }
}
