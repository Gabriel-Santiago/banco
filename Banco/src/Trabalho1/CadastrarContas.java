package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarContas extends JFrame implements ActionListener{

        static Contas cm = new Contas();
        
        JLabel msgTitularComum = new JLabel(" Titular:");
        JTextField entradaTitularComum = new JTextField(18);
        JLabel msgNumeroComum = new JLabel(" Número da conta:");
        JTextField entradaNumeroComum = new JTextField(12);
        JLabel msgSaldoComum = new JLabel("Saldo:");
        JTextField entradaSaldoComum = new JTextField(18);
        JButton contaComumOk = new JButton("Ok");
                
        public CadastrarContas(){
            
            setLayout(new FlowLayout());
            add(msgTitularComum);
            add(entradaTitularComum);
            add(msgNumeroComum);
            add(entradaNumeroComum);
            add(msgSaldoComum);
            add(entradaSaldoComum);
            add(contaComumOk);
            contaComumOk.addActionListener(this);
            this.setTitle("Conta Comum");
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setSize(270, 162);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }         

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == contaComumOk){
            cm.setNome(entradaTitularComum.getText());
            cm.setNumero(Integer.parseInt(entradaNumeroComum.getText()));
            cm.setSaldo(Float.parseFloat(entradaSaldoComum.getText()));
            CadastrarContaPoupanca contapoup = new CadastrarContaPoupanca();
            this.dispose();
        }
    }    
}