package GirisEkrani;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.AttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import AnaSayfa.AnaSayfaFrame;
import Müsteri.MüsteriInfo;
import com.toedter.calendar.JDateChooser;

public class UyeOlFrame extends JFrame {

	private String[] cinsiyet = {"Erkek","Kadın"}; 
	
	private File dosya = new File("Bilgiler.txt");
	
	private MüsteriInfo müsteri = new MüsteriInfo();
	
	private int id;
	
	boolean tcsorgu = false;
	
	private JButton uyeolbuton;
	private JButton geridonbuton;
	private JPanel topPanel;
	
	
	private JPanel mainMiddlePanel;
	private JPanel middlePanel1;
	private JPanel middlePanel2;
	private JPanel middlePanel3;
	private JPanel middlePanel4;
	
	private JPanel middlePanel6;
	private JPanel middlePanel7;
	private JPanel middlePanel8;
	private JPanel middlePanel9;
	private JPanel middlePanel10;
	
	
	private JPanel bottomPanel;

	private JLabel dogumtarihilabel;
	private JLabel logoLabel;
	private JLabel adLabel; 
	private JLabel soyadLabel;
	private JLabel telefonnoLabel;
	private JLabel cinsiyetLabel;
	private JLabel emailLabel;
	private JLabel tcLabel;
	private JLabel sifreLabel;
	private JLabel tekrarSifreLabel;

	private JDateChooser tdogumtarih = new JDateChooser();
	private JTextField tdogumtarihi;
	private JTextField tad;
	private JTextField tsoyad;
	private JTextField tTelefonno;
	private JTextField temail;
	private JTextField tTc;
	private JPasswordField tsifre;
	private JPasswordField tTekrarsifre;
	private JComboBox tcinsiyet;
	
	
	
	
	public UyeOlFrame() {
		
		
		
		
		
		
		//Nesne Oluşturma
		logoLabel = new JLabel();
		adLabel = new JLabel("Adınız:");
		soyadLabel = new JLabel("Soyadınız:");
		telefonnoLabel = new JLabel("Telefon No:");
		cinsiyetLabel = new JLabel("Cinsiyetiniz:");
		emailLabel = new JLabel("Email Adresiniz:");
		tcLabel = new JLabel("TC Numaranız:");
		dogumtarihilabel = new JLabel("Doğum Tarihi:");
		sifreLabel = new JLabel("Şifreniz:");
		tekrarSifreLabel = new JLabel("Tekrar Şifreniz:");
		
		
		tad = new JTextField();
		tsoyad = new JTextField();
		tTelefonno = new JTextField();
		temail = new JTextField();
		tTc = new JTextField();
		tdogumtarihi = new JTextField();
		tsifre = new JPasswordField();
		tTekrarsifre = new JPasswordField();
		tcinsiyet = new JComboBox(cinsiyet);
		
		
	tdogumtarih.setPreferredSize(new Dimension(200,30));
		
		
		uyeolbuton = new JButton("Üye Ol");
		geridonbuton = new JButton("Geri Dön");
		
		topPanel = new JPanel();
		
		mainMiddlePanel = new JPanel();
		middlePanel1 = new JPanel();
		middlePanel2 = new JPanel();
		middlePanel3 = new JPanel();
		middlePanel4 = new JPanel();
		
		middlePanel6 = new JPanel();
		middlePanel7 = new JPanel();
		middlePanel8 = new JPanel();
		middlePanel9 = new JPanel();
		
		
		
		bottomPanel = new JPanel();
		
		
		
		
		//Label Özellikleri:
		
		adLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		soyadLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		telefonnoLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		cinsiyetLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		emailLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tcLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		sifreLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tekrarSifreLabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		dogumtarihilabel.setFont(new Font("TimesRoman",Font.ITALIC,25));
		
		
		tsifre.setEchoChar('*');
		tTekrarsifre.setEchoChar('*');

		
		//Panel İşlemleri:
		
		topPanel.add(logoLabel);
		
		middlePanel1.add(adLabel);
		middlePanel1.add(tad);
		middlePanel2.add(soyadLabel);
		middlePanel2.add(tsoyad);
		middlePanel3.add(telefonnoLabel);
		middlePanel3.add(tTelefonno);
		middlePanel4.add(cinsiyetLabel);
		middlePanel4.add(tcinsiyet);
		middlePanel9.add(dogumtarihilabel);
		middlePanel9.add(tdogumtarih);
		
		middlePanel6.add(tcLabel);
		middlePanel6.add(tTc);
		middlePanel7.add(sifreLabel);
		middlePanel7.add(tsifre);
		middlePanel8.add(tekrarSifreLabel);
		middlePanel8.add(tTekrarsifre);
		
		mainMiddlePanel.add(middlePanel1);
		mainMiddlePanel.add(middlePanel2);
		mainMiddlePanel.add(middlePanel3);
		mainMiddlePanel.add(middlePanel4);
		mainMiddlePanel.add(middlePanel9);
		
		mainMiddlePanel.add(middlePanel6);
		mainMiddlePanel.add(middlePanel7);
		mainMiddlePanel.add(middlePanel8);
		
		
		
		
		
		bottomPanel.add(uyeolbuton);
		bottomPanel.add(geridonbuton);
		
		topPanel.setBackground(new Color(166,166,166));
		middlePanel1.setBackground(new Color(166,166,166));
		middlePanel2.setBackground(new Color(166,166,166));
		middlePanel3.setBackground(new Color(166,166,166));
		middlePanel4.setBackground(new Color(166,166,166));
		
		middlePanel6.setBackground(new Color(166,166,166));
		middlePanel7.setBackground(new Color(166,166,166));
		middlePanel8.setBackground(new Color(166,166,166));
		middlePanel9.setBackground(new Color(166,166,166));
		
		bottomPanel.setBackground(new Color(166,166,166));
		
		
		
		//Buton Özellikleri:
		
		uyeolbuton.setPreferredSize(new Dimension(250, 130));
		geridonbuton.setPreferredSize(new Dimension(250,130));
		
		
		uyeolbuton.setFocusPainted(false);
		geridonbuton.setFocusPainted(false);
		
		uyeolbuton.setBorderPainted(false);
		geridonbuton.setBorderPainted(false);
		
		uyeolbuton.setBackground(Color.black);
		geridonbuton.setBackground(Color.black);
		
		
		uyeolbuton.setForeground(Color.yellow);
		geridonbuton.setForeground(Color.yellow);
		
		uyeolbuton.setFont(new Font("TimesRoman",Font.PLAIN,35));
		geridonbuton.setFont(new Font("TimesRoman",Font.PLAIN,35));
		
		uyeolbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                uyeolbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
                uyeolbuton.setBackground(Color.black);
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
		
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
               GirisEkranıFrame girisekran = new GirisEkranıFrame();

          	  
          	  
             }
        
        
        });
		
		
		//TextField İşlemleri:
		
		
		tad.setPreferredSize(new Dimension(200,40));
		tsoyad.setPreferredSize(new Dimension(200,40));
		tTelefonno.setPreferredSize(new Dimension(200,40));
		tcinsiyet.setPreferredSize(new Dimension(200,40));
		tdogumtarihi.setPreferredSize(new Dimension(200,40));
		temail.setPreferredSize(new Dimension(200,40));
		tTc.setPreferredSize(new Dimension(200,40));
		tsifre.setPreferredSize(new Dimension(200,40));
		tTekrarsifre.setPreferredSize(new Dimension(200,40));
		
		
		tad.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tsoyad.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tTelefonno.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tcinsiyet.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tdogumtarihi.setFont(new Font("TimesRoman",Font.ITALIC,25));
		temail.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tTc.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tsifre.setFont(new Font("TimesRoman",Font.ITALIC,25));
		tTekrarsifre.setFont(new Font("TimesRoman",Font.ITALIC,25));
		
		
		tdogumtarihi.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (tdogumtarihi.getText().length() >= 10) {
					e.consume();
			}
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				
			}
	}
		);
		
		tTc.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (tTc.getText().length() >= 11) {
					e.consume();
			}
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				
				
			}
	}
		);
		
		tTelefonno.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (tTelefonno.getText().length() >= 11) {
					e.consume();
			}
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				
			}
	}
		);
		
		
		tad.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				
				char text = e.getKeyChar();
				
				
				
				if(!Character.isAlphabetic(text)) {
					e.consume();
				}
				
				
			}
	}
		);
		
		
		
		tsoyad.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				
				char text = e.getKeyChar();
				
				
				
				if(!Character.isAlphabetic(text)) {
					e.consume();
				}
				
				
			}
	}
		);
		
		
		
		
		
		
		DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                formatText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                formatText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                formatText();
            }

            private void formatText() {
                SwingUtilities.invokeLater(() -> {
                    String text = tdogumtarihi.getText();
                    
                    if (text.length() == 2 || text.length() == 5) {
                        text += "/";
                        tdogumtarihi.setText(text);
                    }
                    
                });
                
                
                
                
            }
        };
        
        tdogumtarihi.getDocument().addDocumentListener(documentListener);
		
		
		
		
		
		
		
		
		//Düzenleme İşlemleri:
		
		this.setLayout(new GridLayout(3,1));
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainMiddlePanel.setLayout(new GridLayout(4,1));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		
		
		//LOGOS:
		ImageIcon kayitol = new ImageIcon("buseferolucak.png");
		logoLabel.setIcon(kayitol);


		
		
		
		
		//TXT İŞLEMLERİ
		
		
		
		
		
		uyeolbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

				boolean dogumsorgu = false;

                if(e.getSource()==uyeolbuton) {

					Date bugun = new Date();

					if(bugun.before(tdogumtarih.getDate())){
						dogumsorgu = true;
					}
                	
                	
                         try(BufferedReader reader = new BufferedReader(new FileReader(dosya))) {


                        	String line;
                        	String[] strArray;
                        
                        	
                         	
                         	while((line = reader.readLine()) != null) {
                         		
                         		strArray = line.split(",");
                         		
                         		
                         		
                         			
                         			int yeniid = Integer.valueOf(strArray[0]) + 1;
                         			
                         			müsteri.setId(yeniid);
                         			
                         			
                         			if(strArray[3].equals(tTc.getText())) {
                         				
                         				tcsorgu = true;
                         				break;
                         			}
                         			else {
                         				tcsorgu = false;
                         				continue;
                         			}
                         			
                         			
                         			
                         			
                         			
                         			
                         		
                         		}
                         	
                         	if(müsteri.getId() == 0) {
                         		müsteri.setId(1);
                         	}
                         	
                         	
                         		
                         	
                         	}
                         
                        
                         	
                         	 
                        catch(Exception e2) {

                     	   JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

                         }
                         
                        



                     }
                	
                	
                	
                	if (tad.getText().isEmpty() || tsoyad.getText().isEmpty() || tTelefonno.getText().isEmpty() || tTc.getText().isEmpty()) {
                		
                		JOptionPane.showMessageDialog(null, "Boşlukların Hepsini Doldurmalısınız !");
                		
                		
                		
                	}
                	else if(tcsorgu) {
                		JOptionPane.showMessageDialog(null, "Bu T.C İle Hesap Zaten Oluşturulmuş!");
                		
                	}
					else if(dogumsorgu == true){
						JOptionPane.showMessageDialog(null, "Gelecek de doğmuş olamazsınız...");
					}
                	
                	
                	else {
                		
                    if(new String(tsifre.getPassword()).equals(new String(tTekrarsifre.getPassword()))) {
 
                    	müsteri.setAd(tad.getText());
                    	müsteri.setSoyad(tsoyad.getText());
                    	müsteri.setTC(tTc.getText());
                    	müsteri.setTelefonno(tTelefonno.getText());
                    	müsteri.setCinsiyet(tcinsiyet.getSelectedItem());
						Date date = tdogumtarih.getDate();
						String strDate = SimpleDateFormat.getDateInstance().format(date);
                    	müsteri.setDogumtarihi(strDate);
                    	müsteri.setSifre(new String(tsifre.getPassword()));	
                    	
                     try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosya,true))){
                    	
                    	 writer.write(müsteri.getId() + ",");
                         writer.write(müsteri.getAd() + ",");
                         writer.write(müsteri.getSoyad() + ",");
                         writer.write(müsteri.getTC() + ",");
                         writer.write(müsteri.getTelefonno() + ",");
                         writer.write(müsteri.getCinsiyet() + ",");
                         writer.write(müsteri.getDogumtarihi() + ",");
                         writer.write(müsteri.getSifre() + ",");
                         writer.write("\n");
                         

                         
                         
                         
                         setVisible(false);
                         GirisEkranıFrame girisekrani = new GirisEkranıFrame();
                         JOptionPane.showMessageDialog(null, "Hesabınız Başarıyla Oluşturuldu !\n ID Numaranız: " + müsteri.getId() + "(SAKIN KAYBETMEYİN !)");
                         
                         
                         
                         
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Üyelik Oluşturulumadı.\nTekrar Deneyiniz.");
                    }



                    }
                    else {
                       
                        JOptionPane.showMessageDialog(null, "Girdiğiniz Şifreler Aynı Değil");
                    }
                	}

                }
            });
		
		
		
		
		
			
		//Frame İşlemleri:
		
		this.add(topPanel);
		this.add(mainMiddlePanel);
		this.add(bottomPanel);
		
		this.setSize(1024,768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("Eryetli Hotel Üye Ol Ekranı");
		this.setIconImage(kayitol.getImage());
		
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
		
	}
	
	
	
	
}
