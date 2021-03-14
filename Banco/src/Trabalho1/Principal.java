package Trabalho1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame implements ActionListener{

    //botoes
    JLabel label = new JLabel("Selecione a opção desejada");
    JButton saque = new JButton("Saque");
    JButton deposito = new JButton("Depósito");
    JButton transferencia = new JButton("Transferência");
    JButton reajuste = new JButton("Reajustar");
    JButton saldo = new JButton("Ver saldos");
    JButton sair = new JButton("Sair");
    
    public Principal() {
        setLayout(new FlowLayout());
        add(label);
        add(saque);
        saque.addActionListener(this);
        add(deposito);
        deposito.addActionListener(this);
        add(transferencia);
        transferencia.addActionListener(this);
        add(reajuste);
        reajuste.addActionListener(this);
        add(saldo);
        saldo.addActionListener(this);
        add(sair);
        sair.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
        this.setSize(252, 162); 
        this.setLocationRelativeTo(null); 
        this.setResizable(false); 
        this.setTitle("Contas");   
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == sair) {
           System.exit(0);
        }else if(e.getSource() == saldo){
            JOptionPane.showMessageDialog(null, "Saldo Conta Comum: " + CadastrarContas.cm.getSaldo() +
                    "\nSaldo Conta Poupança: " + CadastrarContaPoupanca.cp.getSaldo() +
                    "\nSaldo Conta Especial: " + CadastrarContaEspecial.ce.getSaldo());
        }else if(e.getSource() == reajuste){
            Reajustar reajuste = new Reajustar();
        }else if(e.getSource() == transferencia){
            Transferir transferencia = new Transferir();
        }else if(e.getSource() == deposito){
            Depositar deposito = new Depositar();
        }else if(e.getSource() == saque){
            Sacar saque = new Sacar();
        }
    }

    public static void main(String[] args) throws IOException {
      
        String name = JOptionPane.showInputDialog("Digite seu nome");
        JOptionPane.showMessageDialog(null, "Bem vindo(a) ao mundo bancário " + name);
        CadastrarContas conta = new CadastrarContas();
    }
}