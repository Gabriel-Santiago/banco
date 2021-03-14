package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Reajustar extends JFrame implements ActionListener{

    JLabel msgNumeroReajustar = new JLabel("Número da conta:");
    JTextField entradaNumeroReajustar = new JTextField(12);
    JLabel msgValorReajustar = new JLabel("Valor do reajuste:");
    JTextField entradaValorReajustar = new JTextField(13);
    JButton okReajustar = new JButton("Ok");
    JButton cancelarReajustar = new JButton("Cancelar");
    
    public Reajustar(){
        setLayout(new FlowLayout());
        add(msgNumeroReajustar);
        add(entradaNumeroReajustar);
        add(msgValorReajustar);
        add(entradaValorReajustar);
        add(cancelarReajustar);
        add(okReajustar);
        okReajustar.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
        this.setSize(216, 180); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Reajuste"); 
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int xReajustar = Integer.parseInt(entradaNumeroReajustar.getText());
        double pReajustar = Double.parseDouble(entradaValorReajustar.getText());
        if(e.getSource() == okReajustar){
            if(xReajustar == CadastrarContaPoupanca.cp.numero){
                CadastrarContaPoupanca.cp.reajustar(pReajustar);
                this.dispose();  
            }else{
                JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            }
        }else if(e.getSource() == cancelarReajustar){
            JOptionPane.showMessageDialog(null, "O botão CANCELAR foi clicado");
            this.dispose();
        }
    }
}