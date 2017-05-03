
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class exform {
    public static void main(String args[]){
        Form form=new Form();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tamanhoTela=Toolkit.getDefaultToolkit().getScreenSize();
		form.setSize(new Dimension(600,200));
		form.setLocation((tamanhoTela.width-400)/2,(tamanhoTela.height-200)/2);
		form.setVisible(true);
    }
}
