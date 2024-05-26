package AnaSayfa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import GirisEkrani.SifremiUnuttumFrame;

public class OdaTipleriFrame extends JFrame{

	ImageIcon logo = new ImageIcon("Eryetli.png");

	private String id;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	
	
	private JLabel topLabel;
	

	private JButton birkisiodaButon;
	private JButton ikikisiodaButon;
	private JButton uckisiodaButon;
	private JButton geridonbuton;
	
	
	
	
	
	
	
	
	
	
	public OdaTipleriFrame(String id) {
		
		this.id = id;
		
		//Nesne Oluşturma 
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();
		
		topLabel = new JLabel("Odaları İncelemek İçin Butonlara Tıklayınız");
		
		birkisiodaButon = new JButton("Tek Kişilik Oda");
		ikikisiodaButon = new JButton("Çift Kişilik Oda");
		uckisiodaButon = new JButton("Üç Kişilik Oda");
		geridonbuton = new JButton("Geri Dön");
		
		
		//Label İşlemleri
		
		topLabel.setFont(new Font("TimesRoman",Font.ITALIC,45));
		topLabel.setForeground(Color.yellow);
		
		
		
		
		//Buton İşlemleri
		geridonbuton.setPreferredSize(new Dimension(200,100));
		birkisiodaButon.setPreferredSize(new Dimension(300,120));
		ikikisiodaButon.setPreferredSize(new Dimension(300,120));
		uckisiodaButon.setPreferredSize(new Dimension(300,120));
		
		
		
		geridonbuton.setFocusPainted(false);
		birkisiodaButon.setFocusPainted(false);
		ikikisiodaButon.setFocusPainted(false);
		uckisiodaButon.setFocusPainted(false);
		
		birkisiodaButon.setBorderPainted(false);
		ikikisiodaButon.setBorderPainted(false);
		uckisiodaButon.setBorderPainted(false);
		geridonbuton.setBorderPainted(false);
		
		geridonbuton.setForeground(Color.yellow);
		birkisiodaButon.setForeground(Color.yellow);
		ikikisiodaButon.setForeground(Color.yellow);
		uckisiodaButon.setForeground(Color.yellow);
		
		geridonbuton.setBackground(Color.black);
		birkisiodaButon.setBackground(Color.black);
		ikikisiodaButon.setBackground(Color.black);
		uckisiodaButon.setBackground(Color.black);
		
		
		geridonbuton.setFont(new Font("TimesRoman",Font.PLAIN,25));
		birkisiodaButon.setFont(new Font("TimesRoman",Font.PLAIN,25));
		ikikisiodaButon.setFont(new Font("TimesRoman",Font.PLAIN,25));
		uckisiodaButon.setFont(new Font("TimesRoman",Font.PLAIN,25));
		
		
		
		geridonbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	geridonbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	geridonbuton.setBackground(Color.black);
            }

        });
		birkisiodaButon.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	birkisiodaButon.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	birkisiodaButon.setBackground(Color.black);
            }

        });
		ikikisiodaButon.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	ikikisiodaButon.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	ikikisiodaButon.setBackground(Color.black);
            }

        });
		uckisiodaButon.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	uckisiodaButon.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	uckisiodaButon.setBackground(Color.black);
            }

        });
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               AnaSayfaFrame anasayfa = new AnaSayfaFrame(id);

          	  
          	  
             }
        
        
        });
		birkisiodaButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
                BirKisilikOdaFrame birkisilikodaframe = new BirKisilikOdaFrame(id);
              

          	  
          	  
             }
        
        
        });
		ikikisiodaButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
                CiftKisilikOdaFrame ciftkisilikodaframe = new CiftKisilikOdaFrame(id);

          	  
          	  
             }
        
        
        });
		uckisiodaButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
                UcKisilikOdaFrame oda3 = new UcKisilikOdaFrame(id);
               
          	  
          	  
             }
        
        
        });
		
		
		
		
		
		//Panel İşlemleri
		
		topPanel.add(topLabel);
		middlePanel.add(birkisiodaButon);
		middlePanel.add(ikikisiodaButon);
		middlePanel.add(uckisiodaButon);
		
		topPanel.setBackground(Color.lightGray);
		middlePanel.setBackground(Color.lightGray);
		bottomPanel.setBackground(Color.lightGray);
		
		
		
		
		
		
		//Düzen İşlemleri
		this.setLayout(new GridLayout(3,1));
		middlePanel.setLayout(new FlowLayout());
		bottomPanel.add(geridonbuton);
		
		
		
		
		
		
		
		
		
		//Frame İşlemleri
		
		
		
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);
		
		this.setSize(1024,768);
		this.setIconImage(logo.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Oda Tipleri Sayfası");
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
	}
	
	
	
	
	
}
