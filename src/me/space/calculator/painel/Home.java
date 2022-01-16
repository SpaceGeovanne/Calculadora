package me.space.calculator.painel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
	
	private JPanel contentPane;
	private static Home home;
	
	
	public static void openPanel() {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					Home.access$0(new Home());
					Home.home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Home() {
		this.setResizable(false);
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(3);
        this.setBounds(180, 180, 280, 380);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        
        JLabel label_title = new JLabel("INÍCIO");
        label_title.setHorizontalAlignment(0);
        label_title.setFont(new Font("Segoe UI", 1, 16));
        label_title.setBounds(10, 6, 244, 28);
        this.contentPane.add(label_title);
        
        JLabel label_desc = new JLabel("Selecione um tipo de cálculo");
        label_desc.setHorizontalAlignment(0);
        label_desc.setFont(new Font("Segoe UI", 1, 12));
        label_desc.setBounds(10, 25, 244, 28);
        this.contentPane.add(label_desc);
        
        JButton eq2g = new JButton("Equação do 2° grau");
        
        eq2g.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EquaçãoMenu.openPanel();
			}
		});
        
        eq2g.setFont(new Font("Segoe UI", 1, 13));
        eq2g.setBounds(10, 60, 242, 30);
        this.contentPane.add(eq2g);
        
        JButton juros = new JButton("Juros Simples");
        
        juros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Juros.openPanel();
			}
		});
        
        juros.setFont(new Font("Segoe UI", 1, 13));
        juros.setBounds(10, 100, 242, 30);
        this.contentPane.add(juros);
	}
	
	static /* synthetic */ void access$0(final Home home) {
        Home.home = home;
    }
	

}
