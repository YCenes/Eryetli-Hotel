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

import GirisEkrani.GirisEkranıFrame;

public class BirKisilikOdaFrame extends JFrame{

	
	ImageIcon tekkisilikodaImage1 = new ImageIcon("tekkisilikOdaey.png");
	ImageIcon tekkisilikodaImage2 = new ImageIcon("tekkisilikOda3ey.png");
	ImageIcon tekkisilikodaImage3 = new ImageIcon("odaözellikleri1.jpeg");
	
	private String id;
	
	
	JLabel label1;
	JLabel label2;
	JLabel label3;
	
	JPanel panel;
	
	
	
	JButton geridonbuton;
	
	
	
	public BirKisilikOdaFrame(String id) {
		
		this.id = id;
		
		
		//Nesne Oluşturma
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		
		panel = new JPanel();
		
		geridonbuton = new JButton("Geri Dön");
		
		
		
		//JLabel İşlemleri
		
		
		label1.setIcon(tekkisilikodaImage1);
		label1.setBounds(0, 0, 512, 344);
		
		
		label2.setIcon(tekkisilikodaImage2);
		label2.setBounds(512, 0, 498, 342);
		
		label3.setIcon(tekkisilikodaImage3);
		label3.setBounds(512, 337, 498, 468);
		
		
		
		
		
		
		//Buton İşlemleri
		
		geridonbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		geridonbuton.setFocusPainted(false);
		geridonbuton.setBorderPainted(false);
		geridonbuton.setForeground(Color.yellow);
		geridonbuton.setBackground(Color.black);
		geridonbuton.setBounds(134, 128, 250, 130);
		
		
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
		
		
				
		//Panel İşlemleri
		
		panel.add(geridonbuton);
		
		panel.setBackground(Color.lightGray);
		
		panel.setBounds(0, 343, 512, 388);
		
		panel.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		//Frame İşlemleri
		
		
		
		this.pack();
		this.setBackground(Color.lightGray);
		this.setTitle("Tek Kişilik Oda Özellikleri");
		this.setBounds(100, 100, 1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(label1);
		this.getContentPane().add(label2);
		this.getContentPane().add(label3);
		this.getContentPane().add(panel);
	
		
		this.setResizable(false);
		this.setVisible(true);
		
		this.setLocationRelativeTo(null);
		
	}
	
	
	
	
}
