import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JogoSolo extends JFrame {
    private JPanel painelJogo;
    private JButton btnPos0;
    private JButton btnPos1;
    private JButton btnPos2;
    private JButton btnPos3;
    private JButton btnPos4;
    private JButton btnPos5;
    private JButton btnPos6;
    private JButton btnPos7;
    private JButton btnPos8;
    private JLabel lblInformacao;

    ActionListener evento = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isWinner = false;
            JButton btn = (JButton) e.getSource();
            if (!checkOccupied(btn)) {
                btn.setText("X");
                isWinner = checkWinnerPlayer();
            }
            if(isWinner) {
                return;
            }

            //Simulate the computer's move
            Random random = new Random();
            int pos = random.nextInt(9);
            JButton btnComputer = (JButton) painelJogo.getComponent(pos);
            while (checkOccupied(btnComputer)) {
                pos = random.nextInt(9);
                btnComputer = (JButton) painelJogo.getComponent(pos);
            }
            btnComputer.setText("O");
            checkWinnerComputer();
        }
    };

    public JogoSolo() {
        this.setContentPane(painelJogo);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.pack();

        for (int i = 0; i < 9; i++) {
            JButton btn = (JButton) painelJogo.getComponent(i);
            btn.setText("");
        }

        btnPos0.addActionListener(evento);
        btnPos1.addActionListener(evento);
        btnPos2.addActionListener(evento);
        btnPos3.addActionListener(evento);
        btnPos4.addActionListener(evento);
        btnPos5.addActionListener(evento);
        btnPos6.addActionListener(evento);
        btnPos7.addActionListener(evento);
        btnPos8.addActionListener(evento);
    }

    public static void main(String[] args) {
        new JogoSolo();
    }

    public int checkWinner() {
        if(checkHorizontal() || checkVertical() || checkDiagonal() ){
            return 1;
        }

        return 0;
    }

    private boolean checkWinnerPlayer() {
        int result = checkWinner();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "You win!");
            this.dispose();
        }
        return result == 1;
    }

    private void checkWinnerComputer() {
        int result = checkWinner();
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Computer Won!");
            this.dispose();
        }
    }

    private boolean checkLine(JButton btn1, JButton btn2, JButton btn3) {
        return btn1.getText().equals(btn2.getText()) && btn2.getText().equals(btn3.getText()) && !btn1.getText().isEmpty();
    }

    private boolean checkHorizontal() {
        return checkLine(btnPos0, btnPos1, btnPos2) || checkLine(btnPos3, btnPos4, btnPos5) || checkLine(btnPos6, btnPos7, btnPos8);
    }

    private boolean checkVertical() {
        return checkLine(btnPos0, btnPos3, btnPos6) || checkLine(btnPos1, btnPos4, btnPos7) || checkLine(btnPos2, btnPos5, btnPos8);
    }

    private boolean checkDiagonal() {
        return checkLine(btnPos0, btnPos4, btnPos8) || checkLine(btnPos2, btnPos4, btnPos6);
    }

    private boolean checkOccupied(JButton btn) {
        return btn.getText().equals("X") || btn.getText().equals("O");
    }
}
