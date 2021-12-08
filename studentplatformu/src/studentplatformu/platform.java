package studentplatformu;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class platform extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField surnametxt;
	private JTextField departmenttxt;
	private JTextField coursetxt;
	private JTextField degree;
	DefaultTableModel model;
	private Object[] rows;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					platform frame = new platform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public platform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("STUDENT INFORMATION");
		lblNewLabel.setBounds(143, 0, 288, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(60, 60, 46, 22);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setBounds(35, 93, 71, 22);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setBounds(10, 126, 96, 22);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setBounds(33, 159, 73, 22);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Degree");
		lblNewLabel_5.setBounds(35, 192, 71, 22);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_5);

		nametxt = new JTextField();
		nametxt.setBounds(116, 63, 86, 20);
		contentPane.add(nametxt);
		nametxt.setColumns(10);

		surnametxt = new JTextField();
		surnametxt.setBounds(116, 96, 86, 20);
		contentPane.add(surnametxt);
		surnametxt.setColumns(10);

		departmenttxt = new JTextField();
		departmenttxt.setBounds(116, 129, 86, 20);
		contentPane.add(departmenttxt);
		departmenttxt.setColumns(10);

		coursetxt = new JTextField();
		coursetxt.setBounds(116, 162, 86, 20);
		contentPane.add(coursetxt);
		coursetxt.setColumns(10);

		degree = new JTextField();
		degree.setBounds(116, 195, 86, 20);
		contentPane.add(degree);
		degree.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(35, 250, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nametxt.getText().equals(" ") || surnametxt.getText().equals("")
						|| departmenttxt.getText().equals("") || coursetxt.getText().equals("")
						|| degree.getText().equals("")) {
					JOptionPane.showMessageDialog(null, " Please fill complete information ");
				} else {

					rows[0] = nametxt.getText();
					rows[1] = surnametxt.getText();
					rows[2] = departmenttxt.getText();
					rows[3] = coursetxt.getText();
					rows[4] = degree.getText();
					model.addRow(rows);

					nametxt.setText("");
					surnametxt.setText("");
					departmenttxt.setText("");
					coursetxt.setText("");
					degree.setText("");
					JOptionPane.showMessageDialog(null, " Saved successfuly ");
				}
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, " Deleted successfuly ");
				} else {
					JOptionPane.showMessageDialog(null, " Please select a row first ");
				}
			}
		});
		btnNewButton_1.setBounds(136, 250, 89, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 294, 321, -240);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBounds(283, 58, 321, 247);
		contentPane.add(table);
		model = new DefaultTableModel();
		Object[] column = { "Name", "Surname", "Department", "Course", "Degree" };
		rows = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		JButton btnNewButton_2 = new JButton("Export(Excel)");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream exceBOU = null;
				XSSFWorkbook excelJTableExporter = null;

				// choose location for Excel File
				JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\lenovo\\Desktop\\Yazilim tasarimi");
				excelFileChooser.setDialogTitle("save as");
				FileNameExtensionFilter fnet = new FileNameExtensionFilter("EXCEL FILES", "XLS", "XLSX", "XLSM");
				excelFileChooser.setFileFilter(fnet);
				int excelChooser = excelFileChooser.showSaveDialog(null);

				if (excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
						excelJTableExporter = new XSSFWorkbook();
						XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Sheet");
						for (int i = 0; i < model.getRowCount(); i++) {
							XSSFRow excelRow = excelSheet.createRow(i);
							for (int j = 0; j < model.getColumnCount(); j++) {
								XSSFCell excelCell = excelRow.createCell(j);
								excelCell.setCellValue(model.getValueAt(i, j).toString());
							}
						}
					
						excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
						exceBOU = new BufferedOutputStream(excelFOU);
						excelJTableExporter.write(exceBOU);
						JOptionPane.showMessageDialog(null, "exporting seccessfully ");
						
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						try {
							if (exceBOU != null) {
								exceBOU.close();
							}
							if (excelFOU != null) {
								excelFOU.close();
							}
							if (excelJTableExporter != null) {
								excelJTableExporter.close();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}
		});

		// ========================
		btnNewButton_2.setBounds(63, 282, 113, 23);
		contentPane.add(btnNewButton_2);
	}}
