
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aluno
 */
public class Form extends JFrame implements ActionListener {

    private JButton btnUm = new JButton("1");

    private final JButton btnDois = new JButton("2");
    private final JButton btnTres = new JButton("3");
    private final JButton btnQuatro = new JButton("4");
    private final JButton btnCinco = new JButton("5");
    private final JButton btnSeis = new JButton("6");
    private final JButton btnSete = new JButton("7");
    private final JButton btnOito = new JButton("8");
    private final JButton btnNove = new JButton("9");
    private final JButton btnZero = new JButton("0");
    private final JButton btnmais = new JButton("+");
    private final JButton btnmenos = new JButton("-");
    private final JButton btnvezes = new JButton("*");
    private final JButton btnrazao = new JButton("/");
    private final JButton btnvirgula = new JButton(".");
    private final JButton btnC = new JButton("=");
    private final JPanel pnlBotoes = new JPanel();
    private final JTextField calc = new JTextField();
    double somador = 0;
    double mult=1;
    char sinal;

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Form() {
        super("calculadora java simples");
        setLayout(new BorderLayout());
        pnlBotoes.setLayout(new GridLayout(4, 4, 7, 7));
        pnlBotoes.add(btnUm);
        btnUm.addActionListener(this);
        pnlBotoes.add(btnDois);
        btnDois.addActionListener(this);
        pnlBotoes.add(btnTres);
        btnTres.addActionListener(this);
        pnlBotoes.add(btnQuatro);
        btnQuatro.addActionListener(this);
        pnlBotoes.add(btnCinco);
        btnCinco.addActionListener(this);
        pnlBotoes.add(btnSeis);
        btnSeis.addActionListener(this);
        pnlBotoes.add(btnSete);
        btnSete.addActionListener(this);
        pnlBotoes.add(btnOito);
        btnOito.addActionListener(this);
        pnlBotoes.add(btnNove);
        btnNove.addActionListener(this);
        pnlBotoes.add(btnZero);
        btnZero.addActionListener(this);
        pnlBotoes.add(btnmais);
        btnmais.addActionListener(this);
        pnlBotoes.add(btnmenos);
        btnmenos.addActionListener(this);
        pnlBotoes.add(btnvezes);
        btnvezes.addActionListener(this);
        pnlBotoes.add(btnrazao);
        btnrazao.addActionListener(this);
        pnlBotoes.add(btnvirgula);
        btnvirgula.addActionListener(this);
        pnlBotoes.add(btnC);
        btnC.addActionListener(this);
        add(pnlBotoes, BorderLayout.SOUTH);
        add(calc, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent evento) {

        if (isNumeric(((JButton) evento.getSource()).getText())) {

            if (btnmais.isEnabled()&& btnmenos.isEnabled()&&btnvezes.isEnabled()&&btnrazao.isEnabled()) {
                calc.setText(calc.getText() + ((JButton) evento.getSource()).getText());
            } else {
                calc.setText(((JButton) evento.getSource()).getText());
            }

            btnmais.setEnabled(true);
            btnmenos.setEnabled(true);
            btnvezes.setEnabled(true);
            btnrazao.setEnabled(true);
            btnC.setEnabled(true);

        } else if (evento.getSource() == btnmais) {
            somador = somador + Double.parseDouble(calc.getText());
            btnmais.setEnabled(false);
            btnvirgula.setEnabled(true);
            btnC.setEnabled(false);
            sinal = '+';
        }  else if (evento.getSource() == btnmenos) {
            somador = somador + (somador==0?1:-1)*Double.parseDouble(calc.getText());
            btnmenos.setEnabled(false);
            btnvirgula.setEnabled(true);
            btnC.setEnabled(false);
            sinal = '-';
        } else if (evento.getSource() == btnvezes) {
            mult = mult * Double.parseDouble(calc.getText());
            btnvezes.setEnabled(false);
            btnvirgula.setEnabled(true);
            btnC.setEnabled(false);
            sinal = '*';
        } else if (evento.getSource() == btnrazao) {
            mult = mult==1?Double.parseDouble(calc.getText()):mult/Double.parseDouble(calc.getText());
            btnrazao.setEnabled(false);
            btnvirgula.setEnabled(true);
            btnC.setEnabled(false);
            sinal = '/';
        }else if (evento.getSource() == btnvirgula) {
            btnvirgula.setEnabled(false);
            calc.setText(calc.getText() + ((JButton) evento.getSource()).getText());
        } else if (evento.getSource() == btnC) {

            if (sinal == '+') {
                somador = somador + Double.parseDouble(calc.getText());
                calc.setText("" + somador);
                somador = 0;
                btnvirgula.setEnabled(true);
            }else
            if (sinal == '-') {
                somador = somador - Double.parseDouble(calc.getText());
                calc.setText("" + somador);
                somador = 0;
                btnvirgula.setEnabled(true);
            }else
            if (sinal == '*') {
                mult = mult *Double.parseDouble(calc.getText());
                calc.setText("" + mult);
                mult = 1;
                btnvirgula.setEnabled(true);
            }else if (sinal == '/') {
                mult = mult / Double.parseDouble(calc.getText());
                calc.setText("" + mult);
                mult = 1;
                btnvirgula.setEnabled(true);
            }


        }

    }
}
