/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.view;

import CentroDeDistribuicao.dao.ClientePessoaFisicaDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Vinicius
 */
public class CadastrarClientePessoaFisicaGUI extends JFrame{
    
    ArrayList <JPanel> panel = new ArrayList<JPanel>();
    ArrayList <JLabel> label = new ArrayList<JLabel>();
    JButton b1;
    int num=23;
    JTextField txtRg = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtLogradouro = new JTextField();
        JTextField txtNumero = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtUf = new JTextField();
    
    public CadastrarClientePessoaFisicaGUI() throws HeadlessException {
        super("Cadastrar Cliente Pessoa Fisica");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 100, 1000, 700);
        this.setLocationRelativeTo(null);
        iniciarPaineis();
        iniciarLabels();
        iniciarBotoes();
        iniciarCampoTexto();
        this.setVisible(true);
    }

    private void iniciarPaineis() {
        JPanel pagina = new JPanel();
        this.getContentPane().add(pagina);
        pagina.setBackground(Color.white);
        pagina.setPreferredSize(new Dimension(1000, 800));
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(1000, 800));
        for (int i = 0; i<this.num;i++){
            this.panel.add(new JPanel());
            pagina.add(this.panel.get(i));
            if (i == 0 || i % 2 == 0){
                this.panel.get(i).setBackground(Color.yellow);
            }else{
                this.panel.get(i).setBackground(Color.white);
            }
        }
        scroll.setViewportView(pagina);
        this.getContentPane().add(scroll);
        pagina.setLayout(new BoxLayout(pagina, BoxLayout.Y_AXIS));
    }

    private void iniciarLabels() {
        this.label.add(new JLabel("Rg:"));
        this.label.add(new JLabel("Cpf:"));
        this.label.add(new JLabel("Nome:"));
        this.label.add(new JLabel("E-mail:"));
        this.label.add(new JLabel("Telefone:"));
        this.label.add(new JLabel("CEP:"));
        this.label.add(new JLabel("Logradouro:"));
        this.label.add(new JLabel("Numero:"));
        this.label.add(new JLabel("Bairro:"));
        this.label.add(new JLabel("Cidade:"));
        this.label.add(new JLabel("UF:"));
        
        this.panel.get(0).add(this.label.get(0));
        this.panel.get(2).add(this.label.get(1));
        this.panel.get(4).add(this.label.get(2));
        this.panel.get(6).add(this.label.get(3));
        this.panel.get(8).add(this.label.get(4));
        this.panel.get(10).add(this.label.get(5));
        this.panel.get(12).add(this.label.get(6));
        this.panel.get(14).add(this.label.get(7));
        this.panel.get(16).add(this.label.get(8));
        this.panel.get(18).add(this.label.get(9));
        this.panel.get(20).add(this.label.get(10));
        
        Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
        for (int i = 0; i<11;i++){
            this.label.get(i).setFont(f1);
        }
    }

    private void iniciarBotoes() {
        ButtonHandler buttonHandler=new ButtonHandler();
        this.b1 = new JButton("Cadastrar Cliente");
        this.panel.get(22).add(this.b1);
        this.b1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        b1.setBackground(Color.white);
        b1.addActionListener(buttonHandler);
    }

    private void iniciarCampoTexto() {
        
        
        
        this.txtRg.setColumns(7);
        this.txtCpf.setColumns(11);
        this.txtNome.setColumns(60);
        this.txtEmail.setColumns(50);
        this.txtTelefone.setColumns(14);
        this.txtCep.setColumns(8);
        this.txtLogradouro.setColumns(50);
        this.txtNumero.setColumns(8);
        this.txtBairro.setColumns(40);
        this.txtCidade.setColumns(40);
        this.txtUf.setColumns(2);
        
        this.panel.get(1).add(txtRg);
        this.panel.get(3).add(txtCpf);
        this.panel.get(5).add(txtNome);
        this.panel.get(7).add(txtEmail);
        this.panel.get(9).add(txtTelefone);
        this.panel.get(11).add(txtCep);
        this.panel.get(13).add(txtLogradouro);
        this.panel.get(15).add(txtNumero);
        this.panel.get(17).add(txtBairro);
        this.panel.get(19).add(txtCidade);
        this.panel.get(21).add(txtUf);
    }
    class ButtonHandler implements ActionListener{
    
    public void actionPerformed(ActionEvent ae){

    if (ae.getSource() == b1){
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado Com Sucesso");
    }
  }
}
}
