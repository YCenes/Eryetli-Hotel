package Rezervasyonlar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import AnaSayfa.AnaSayfaFrame;
import RezervasyonInfo.RezervasyonInfo;


public class YeniRezervasyon extends JFrame{
	
	private String id;

	private RezervasyonInfo yenirezs;
	
	ImageIcon logo = new ImageIcon("Eryetlis.png");
	JLabel girislabel;
	JTextField gidisdate;
	JLabel cikislabel;
	JTextField gidisdate2;
	JLabel kisisayilabel;
	JComboBox odaBox;
	JButton geridonbuton;
	JButton olusturbuton;
	JLabel rezervasyonolusturLabel;
	JDateChooser dateChooser1 = new JDateChooser();
	JDateChooser dateChooser2 = new JDateChooser();
	File dosya = new File("rezervasyonlar.txt");
	File dosyarezs = new File("odanumaralari.txt");
	
	private String[] odas = {"Tek Kişilik Oda","Çift Kişilik Oda","Üç Kişilik Oda"};
	
	
	public YeniRezervasyon(String id) {
		
		
		yenirezs = new RezervasyonInfo();
		
		this.id = id;
		
		//Nesne Oluşturma
		girislabel = new JLabel("Giriş Tarihi:");
		gidisdate = new JTextField();
		cikislabel = new JLabel("Çıkış Tarihi:");
		gidisdate2 = new JTextField();
		kisisayilabel = new JLabel("Oda Tipi:");
		odaBox = new JComboBox(odas);
		geridonbuton = new JButton("Geri Dön");
		olusturbuton = new JButton("Oluştur");
		rezervasyonolusturLabel = new JLabel("Rezervasyon Oluşturun");
		
		
		
		
		//Label İşlemleri
		
		girislabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		girislabel.setBounds(59, 168, 156, 98);
		
		cikislabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cikislabel.setBounds(59, 276, 128, 92);
		
		kisisayilabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		kisisayilabel.setBounds(59, 378, 156, 98);
		
		rezervasyonolusturLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rezervasyonolusturLabel.setBounds(388, 10, 494, 103);
	
		
		//TextField  İşlemleri


		dateChooser1.setBounds(225,198,124,35);
		dateChooser2.setBounds(225,302,124,35);
		
		gidisdate.setFont(new Font("TimesRoman",Font.PLAIN,20));
		gidisdate2.setFont(new Font("TimesRoman",Font.PLAIN,20));
		
		
		
		
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
                    String text = gidisdate.getText();
                    
                    if (text.length() == 2 || text.length() == 5) {
                        text += "/";
                        gidisdate.setText(text);
                    }
                    
                });
                
                
                
                
            }
        };
        
        DocumentListener documentListener2 = new DocumentListener() {
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
                    String text = gidisdate2.getText();
                    
                    if (text.length() == 2 || text.length() == 5) {
                        text += "/";
                        gidisdate2.setText(text);
                    }
                    
                });
                
                
                
                
            }
        };
        
        gidisdate2.getDocument().addDocumentListener(documentListener2);
        
        gidisdate.getDocument().addDocumentListener(documentListener);
        
        
        gidisdate.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (gidisdate.getText().length() >= 10) {
					e.consume();
			}
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				
			}
	}
		);
        
        gidisdate2.addKeyListener((KeyListener) new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (gidisdate2.getText().length() >= 10) {
					e.consume();
			}
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				
			}
	}
		);
	
		
		
		//ComboBox İşlemleri
		odaBox.setBounds(225, 405, 124, 35);
		
		
		
		//Buton İşlemleri
		geridonbuton.setBounds(376, 537, 255, 133);
		olusturbuton.setBounds(671, 235, 255, 133);
		
		
		geridonbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		geridonbuton.setFocusPainted(false);
		geridonbuton.setBorderPainted(false);
		geridonbuton.setForeground(Color.yellow);
		geridonbuton.setBackground(Color.black);
		
		
		geridonbuton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                setVisible(false);
            
                AnaSayfaFrame anasayfaelif = new AnaSayfaFrame(id);

          	  
          	  
             }
        
        
        });
		
		geridonbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));	geridonbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	geridonbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	geridonbuton.setBackground(Color.black);
            }

        });
		
		olusturbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		olusturbuton.setFocusPainted(false);
		olusturbuton.setBorderPainted(false);
		olusturbuton.setForeground(Color.yellow);
		olusturbuton.setBackground(Color.black);
		
		
		
		
		olusturbuton.setFont(new Font("Times New Roman", Font.PLAIN, 30));	
		olusturbuton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	olusturbuton.setBackground(new Color(35,35,35));
            }

            public void mouseExited(MouseEvent e) {
            	olusturbuton.setBackground(Color.black);
            }

        });
		
		//TXT İŞLEMLERİ

		
		olusturbuton.addActionListener(new ActionListener() {

            boolean musaitmi;
            int arrayindex = 1;
            boolean odalardolumu = false;
            boolean gidisdonussorgu = false;
            @Override
            public void actionPerformed(ActionEvent e) {
            	



				try (BufferedReader reader = new BufferedReader(new FileReader(dosyarezs))) {


					String line2;
					String[] strArray2;


					while ((line2 = reader.readLine()) != null) {

						strArray2 = line2.split(",");

						if(((String)odaBox.getSelectedItem()).equals(strArray2[0])){
							yenirezs.setOdanumarasi(strArray2[arrayindex]);




						}



					}


				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

				}
            	
            	
                if(e.getSource()==olusturbuton) {

					Date currentDate = new Date();


					if (dateChooser1.getDate().before(currentDate)) {

						JOptionPane.showMessageDialog(null, "Geçmiş Tarihden Oda Tutamazsınız.");


					} else {


						if (dateChooser1.isValid() || dateChooser2.isValid()) {

							JOptionPane.showMessageDialog(null, "Boşlukların Hepsini Doldurmalısınız !");


						} else {


                            Date date = dateChooser1.getDate();
                            Date date2 = dateChooser2.getDate();
                            String strDate = DateFormat.getDateInstance().format(date);
                            String strDate2 = DateFormat.getDateInstance().format(date2);

                            if (date.after(date2)) {
                                JOptionPane.showMessageDialog(null, "Giriş Tarihi Çıkış Tarihinden Sonra OLAMAZ...");
                                gidisdonussorgu = true;
                            } else {
                                yenirezs.setGirisTarihi(strDate);
                                yenirezs.setCikisTarihi(strDate2);
                                yenirezs.setOdatürü((String) odaBox.getSelectedItem());
                                yenirezs.setId(id);

                                do {

                                    musaitmi = true;
                                    try (BufferedReader reader = new BufferedReader(new FileReader(dosya))) {


                                        String line;
                                        String[] strArray;


                                        while ((line = reader.readLine()) != null) {

                                            strArray = line.split(",");

                                            if (strArray[4].equals(yenirezs.getOdanumarasi())) {

                                                String girisdatetxt = strArray[1];
                                                String cikisdatetetxt = strArray[2];
                                                String girisdatemusteri = yenirezs.getGirisTarihi();
                                                String cikisdatemusteri = yenirezs.getCikisTarihi();

                                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

                                                try {
                                                    LocalDate girisdate = LocalDate.parse(girisdatetxt, formatter);
                                                    LocalDate cikisdate = LocalDate.parse(cikisdatetetxt, formatter);
                                                    LocalDate girismusteri = LocalDate.parse(girisdatemusteri, formatter);
                                                    LocalDate cikismusteri = LocalDate.parse(cikisdatemusteri, formatter);

                                                    //while

                                                    if ((girisdate.isEqual(girismusteri) || cikisdate.isEqual(cikismusteri)) || (girisdate.isBefore(girismusteri) && cikisdate.isAfter(cikismusteri)) || (girismusteri.isBefore(girisdate) && cikismusteri.isAfter(cikisdate)))  {
                                                        musaitmi = false;

                                                        try (BufferedReader reader2 = new BufferedReader(new FileReader(dosyarezs))) {


                                                            String line3;
                                                            String[] strArray3;


                                                            while ((line3 = reader2.readLine()) != null) {

                                                                strArray3 = line3.split(",");

                                                                if (((String) odaBox.getSelectedItem()).equals(strArray3[0])) {
                                                                    arrayindex++;
                                                                    yenirezs.setOdanumarasi(strArray3[arrayindex]);

                                                                    if (yenirezs.getOdanumarasi().equals("dolu")) {
                                                                        odalardolumu = true;
                                                                        JOptionPane.showMessageDialog(null, "Seçtiğiniz Tarihler Arasında Hiç Bir" + yenirezs.getOdatürü() + "Müsait Değil...");

                                                                    }

                                                                }


                                                            }


                                                        } catch (Exception e2) {

                                                            JOptionPane.showMessageDialog(null, "Dosyada bir hata var.");

                                                        }

                                                    }


                                                } catch (DateTimeParseException e1) {
                                                    e1.printStackTrace();
                                                }


                                            }


                                        }


                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                } while (musaitmi == false);
                            }

                            if (odalardolumu == false && gidisdonussorgu == false) {
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosya, true))) {

                                    writer.write(yenirezs.getId() + ",");
                                    writer.write(yenirezs.getGirisTarihi() + ",");
                                    writer.write(yenirezs.getCikisTarihi() + ",");
                                    writer.write(yenirezs.getOdatürü() + ",");
                                    writer.write(yenirezs.getOdanumarasi() + ",");
                                    writer.write("\n");


                                    setVisible(false);
                                    AnaSayfaFrame ana1 = new AnaSayfaFrame(id);
                                    JOptionPane.showMessageDialog(null, "Rezervasyonunuz Başarıyla Oluşturuldu !");


                                } catch (Exception e2) {
                                    JOptionPane.showMessageDialog(null, "Rezervasyon Oluşturulamadı...");
                                }
                            }


                        }

						}

					}
				}
            });
		
		
		
		
		
		
		
		
		
		
		
		
		//Frame ile ilgili Kısımlar
		
		this.setBounds(100, 100, 1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(girislabel);
		this.getContentPane().add(dateChooser1);
		this.getContentPane().add(cikislabel);
		this.getContentPane().add(dateChooser2);
		this.getContentPane().add(kisisayilabel);
		this.getContentPane().add(odaBox);
		this.getContentPane().add(olusturbuton);
		this.getContentPane().add(rezervasyonolusturLabel);
		this.getContentPane().add(geridonbuton);
		this.getContentPane().setBackground(Color.lightGray);
		this.setIconImage(logo.getImage());
		this.setTitle("Eryetli Hotel / Rezervasyon Oluştur");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
}
