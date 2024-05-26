package AnaSayfa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UcKisilikOdaFrame extends JFrame{

	
	ImageIcon oda1Image = new ImageIcon("uckisilikoda.jpg");
	ImageIcon oda2Image = new ImageIcon("uckisioda2.jpeg");
	ImageIcon odaozellikler = new ImageIcon("uckisiozellik.jpeg");
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JButton geridonbuton;
	
	private JPanel panel;
	
	private String id;
	
	
	public UcKisilikOdaFrame(String id) {
		
		this.id = id;
		
		//Nesne Oluşturma
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		
		panel = new JPanel();
		
		geridonbuton = new JButton("Geri Dön");
		
		
		
		
		
		//Label özellikleri
		
		label1.setIcon(oda1Image);
		label1.setBounds(0, 0, 518, 381);
		
		label2.setIcon(oda2Image);
		label2.setBounds(437, 0, 573, 381);
		
		label3.setIcon(odaozellikler);
		label3.setBounds(519, 380, 493, 442);
		
		
		
		
		//Panel Özellikleri
		
		panel.setBounds(0, 380, 560, 351);
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);
		
		
		
		panel.add(geridonbuton);
		
		//Buton Özellikleri
		
		geridonbuton.setBounds(134, 110, 250, 130);
		
		geridonbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		geridonbuton.setFocusPainted(false);
		geridonbuton.setBorderPainted(false);
		geridonbuton.setForeground(Color.yellow);
		geridonbuton.setBackground(Color.black);
	
		
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               OdaTipleriFrame oda1 = new OdaTipleriFrame(id);

          	  
          	  
             }
        
        
        });
		
		geridonbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	geridonbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	geridonbuton.setBackground(Color.black);
            }

        });
		
		//Frame özellikleri
		
		
		
		this.getContentPane().add(label1);
		this.getContentPane().add(label2);
		this.getContentPane().add(label3);
		this.getContentPane().add(panel);
		
		this.setBounds(100, 100, 1024,768 );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
		
	}
	
}
