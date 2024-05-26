package Rezervasyonlar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import AnaSayfa.AnaSayfaFrame;

public class RezervasyonlarımFrame extends JFrame {




	private JTable table;
	private MyTableModel model;
	private ImageIcon logo = new ImageIcon("Eryetlis.png");
	private JButton geridonbuton;
	private static String tempid;

	File dosya;
	String dosyayolu;


	public RezervasyonlarımFrame(String id) {

		tempid = id;
		//Nesne Oluşturma

		geridonbuton = new JButton("Geri Dön");
		dosya = new File("rezervasyonlar.txt");
		dosyayolu = "rezervasyonlar.txt";


		//JTable İşlemleri


		List<String[]> data = null;
		try {

			data = FileHelper.readLinesFromFile(dosyayolu);
		} catch (IOException e) {
			e.printStackTrace();
		}


		String[] columnNames = {"ID", "Giris Tarihi", "Cikis Tarihi", "Oda Türü", "Oda Numarası"};
		model = new MyTableModel(columnNames, data);
		table = new JTable(model);
		table.getColumn("Rez. İptal").setCellRenderer(new ButtonRenderer());
		table.getColumn("Rez. İptal").setCellEditor(new ButtonEditor(table, dosyayolu));


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 10, 600, 600);

		table.getTableHeader().setReorderingAllowed(false);

		//Buton İşlemleri

		geridonbuton.setBounds(390, 610, 250, 100);
		geridonbuton.setFocusPainted(false);
		geridonbuton.setBorderPainted(false);
		geridonbuton.setForeground(Color.yellow);
		geridonbuton.setBackground(Color.black);
		geridonbuton.setFont(new Font("TimesRoman", Font.PLAIN, 25));


		geridonbuton.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				geridonbuton.setBackground(new Color(35, 35, 35));
			}

			public void mouseExited(MouseEvent e) {
				geridonbuton.setBackground(Color.black);
			}

		});


		//TABLE BUTON


		geridonbuton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				AnaSayfaFrame anasayfa = new AnaSayfaFrame(id);


			}


		});
		JButton addButton = new JButton("Add Data from Another File");
		addButton.addActionListener(e -> {
			try {
				List<String[]> newData = FileHelper.readLinesFromFile("another_data.txt"); // Yeni txt dosyasının yolu
				model.addData(newData);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		//TXT İŞLEMLERİ


		//Frame ile ilgili kısımlar
		this.add(addButton);
		this.add(geridonbuton);
		this.setIconImage(logo.getImage());
		this.add(scrollPane);
		this.setSize(1024, 768);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Eryetli Hotel / Rezervasyonlarım");
		this.getContentPane().setBackground(Color.lightGray);
		this.setVisible(true);

		this.setLocationRelativeTo(null);


	}



	class FileHelper {
		public static List<String[]> readLinesFromFile(String filePath) throws IOException {
			List<String[]> lines = new java.util.ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
				String line;
				String[] strArray2;
				while ((line = br.readLine()) != null) {
					strArray2 = line.split(",");

					if(strArray2[0].equals(tempid)){

						lines.add(line.split(","));
					}



				}
			}
			return lines;
		}

		public static void writeLinesToFile(String filePath, List<String[]> lines) throws IOException {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
				for (String[] line : lines) {
					bw.write(String.join(",", line));
					bw.newLine();
				}
			}
		}
	}





	class MyTableModel extends AbstractTableModel {
		private final String[] columnNames;
		private final List<String[]> data;

		public MyTableModel(String[] columnNames, List<String[]> data) {
			this.columnNames = columnNames;
			this.data = data;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length + 1; // Sil butonu için ek bir sütun
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex < columnNames.length) {
				return data.get(rowIndex)[columnIndex];
			} else {
				return "İptal Et";
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return columnIndex == columnNames.length; // Sadece sil butonu düzenlenebilir
		}

		@Override
		public String getColumnName(int column) {
			if (column < columnNames.length) {
				return columnNames[column];
			} else {
				return "Rez. İptal";
			}
		}

		public void removeRow(int rowIndex) {
			data.remove(rowIndex);
			fireTableRowsDeleted(rowIndex, rowIndex);
		}

		public void addData(List<String[]> newData) {
			int rowCount = getRowCount();
			for (String[] row : newData) {
				data.add(row);
			}
			fireTableRowsInserted(rowCount, getRowCount() - 1);
		}
	}


	class ButtonRenderer extends JButton implements TableCellRenderer {
		public ButtonRenderer() {
			setOpaque(true);
			setText("İptal Et");
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return this;
		}
	}


	class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
		private final JButton button;
		private int row;
		private JTable table;
		private String filePath;

		public ButtonEditor(JTable table, String filePath) {
			this.table = table;
			this.filePath = filePath;
			button = new JButton("İptal Et");
			button.setOpaque(true);
			button.addActionListener(this);
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			this.row = row;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			return "İptal Et";
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			fireEditingStopped();
			MyTableModel model = (MyTableModel) table.getModel();
			JOptionPane.showMessageDialog(null, "Rezervasyonunuz Başarıyla İptal Edildi ! ");
			model.removeRow(row);

			try {

				List<String[]> lines = FileHelper.readLinesFromFile(filePath);
				lines.remove(row); // Satırı doğru indekste kaldırmak için düzeltilmiş
				FileHelper.writeLinesToFile(filePath, lines);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public boolean isCellEditable(EventObject e) {
			return true;
		}
	}


}

























