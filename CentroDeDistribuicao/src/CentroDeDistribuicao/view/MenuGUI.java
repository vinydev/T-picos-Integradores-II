/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroDeDistribuicao.view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Vinicius
 */
public class MenuGUI extends JFrame{
        
    
        public MenuGUI() throws HeadlessException {
        super();
        //Dimension d = new Dimension(500,500);
        //this.setSize(d);
        this.setJMenuBar(createMenuBar());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocation(400, 100);
        this.setBounds(0, 0, 1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
        public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rdmi;
        JCheckBoxMenuItem cbmi;
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the File Menu.
        menu = new JMenu("Cadastrar");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Cadastros");
        menuBar.add(menu);
 
        menuItem = new JMenuItem("Cadastrar Cliente Pessoa Física");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                CadastrarClientePessoaFisicaGUI ccpfGUI = new CadastrarClientePessoaFisicaGUI();
            }
        });
        
        menuItem = new JMenuItem("Cadastrar Cliente Pessoa Jurídica");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                CadastrarClientePessoaJuridicaGUI ccpjGUI = new CadastrarClientePessoaJuridicaGUI();
            }
        });
        
        menuItem = new JMenuItem("Cadastrar Funcionário");
        menuItem.setMnemonic(KeyEvent.VK_P);
        menu.add(menuItem);
         menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                CadastrarFuncionarioGUI cfGUI = new CadastrarFuncionarioGUI();
            }
        });
        
        menuItem = new JMenuItem("Cadastrar Fornecedor");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                CadastrarFornecedorGUI cfGUI = new CadastrarFornecedorGUI();
            }
        });
        
        menuItem = new JMenuItem("Novo Pedido");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                FazerPedidoGUI npGUI = new FazerPedidoGUI();
            }
        });
        
        menuItem = new JMenuItem("Novo Produto");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                CadastrarProdutoGUI npGUI = new CadastrarProdutoGUI();
            }
        });
        
        menu = new JMenu("Mais");
        menu.setMnemonic(KeyEvent.VK_E);
        menu.getAccessibleContext().setAccessibleDescription(
                "Relatorios");
        menuBar.add(menu);
        
        
        menuItem = new JMenuItem("Relatorios");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                dispose();
                RelatoriosGUI rGUI = new RelatoriosGUI();
            }
        });
        return menuBar;
        }
}
