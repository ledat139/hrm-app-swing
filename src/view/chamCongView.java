package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.nhanVienDAO;
import controller.nhanVienController;
import model.nhanVien;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class chamCongView {
	public JPanel tab3;
	private JTextField tenNVTF;
	private JTable nvTable;
	private JButton tenNVbutton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPopupMenu popupMenu;
	private JPopupMenu popupMenu2;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JScrollPane bangNhanVienScrollPane;
	private JLabel lblNewLabel_3;
	private DefaultTableModel tableModel;
	private JTable chamCongtable;
	private JLabel lblNewLabel_3_2;
	private JTextField maNVTF;


	public chamCongView() {

		tab3 = new JPanel();
		tab3.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		tab3.setFocusTraversalPolicyProvider(true);
		tab3.setFocusable(false);
		tab3.setBackground(Color.WHITE);
		tab3.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 1, 1, 1));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 129, 926, 584);
		tab3.add(panel_1);
		panel_1.setLayout(null);

		popupMenu = new JPopupMenu();
		popupMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItem1 = new JMenuItem("Chấm công");
		menuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		popupMenu.add(menuItem1);

		// Tạo bảng và gắn dữ liệu vào
		String[] columnNames = { "Mã NV", "Họ Tên", "Email", "Địa chỉ", "CCCD", "Cấp bậc",
				"Mã PB" };
		tableModel = new DefaultTableModel(columnNames, 0);
		
		
		popupMenu2 = new JPopupMenu();
		popupMenu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItem2 = new JMenuItem("Sửa");
		menuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		popupMenu2.add(menuItem2);
		menuItem3 = new JMenuItem("Xóa");
		menuItem3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		popupMenu2.add(menuItem3);
		
		
		chamCongtable = new JTable();
		chamCongtable.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chamCongtable.setShowVerticalLines(false);
		chamCongtable.setShowHorizontalLines(false);
		chamCongtable.setRowMargin(0);
		chamCongtable.setFillsViewportHeight(true);
		chamCongtable.setOpaque(false);
		chamCongtable.setEnabled(true);
		chamCongtable.setGridColor(new Color(0, 0, 0));
		chamCongtable.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		chamCongtable.setSelectionBackground(Color.LIGHT_GRAY);
		chamCongtable.setRowHeight(35);
		chamCongtable.setBorder(null);
		chamCongtable.getTableHeader().setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		chamCongtable.getTableHeader().setBackground(new Color(102, 205, 170));
		chamCongtable.getTableHeader().setResizingAllowed(false);
		chamCongtable.getTableHeader().setBorder(new LineBorder(Color.BLACK, 2));
		chamCongtable.setBackground(new Color(255, 255, 255));
		chamCongtable.getTableHeader().setReorderingAllowed(false);
		chamCongtable.setDefaultEditor(Object.class, null);
		chamCongtable.setFocusable(false);
		
		chamCongtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) { // Bấm chuột phải
					int row = chamCongtable.rowAtPoint(e.getPoint());
					if (row != -1) {
						chamCongtable.setRowSelectionInterval(row, row);
						popupMenu2.show(chamCongtable, e.getX(), e.getY());
					}
				}
			}
		});
		
		chamCongtable.setModel(new DefaultTableModel(
				new Object[][] {
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
					{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
				},
				new String[] {
						"Mã chấm công", "Mã nhân viên", "Tháng làm việc", "Số ngày làm", "Số ngày nghỉ", "Số giờ tăng ca",
						"Số ngày đi trễ", "Tổng lương"
				}
			));
		
		chamCongtable.getTableHeader().getColumnModel().getColumn(7).setCellRenderer(new MyCustomRenderer());
		JScrollPane bangChamCongcrollPane_1 = new JScrollPane(chamCongtable);
		bangChamCongcrollPane_1.setViewportBorder(null);
		bangChamCongcrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		bangChamCongcrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		bangChamCongcrollPane_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		bangChamCongcrollPane_1.setBorder(null);
		bangChamCongcrollPane_1.setAutoscrolls(true);
		bangChamCongcrollPane_1.setBounds(31, 328, 871, 233);
		panel_1.add(bangChamCongcrollPane_1);
		
				nvTable = new JTable();
				nvTable.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				nvTable.setShowVerticalLines(false);
				nvTable.setShowHorizontalLines(false);
				nvTable.setRowMargin(0);
				nvTable.setFillsViewportHeight(true);
				nvTable.setOpaque(false);
				nvTable.setEnabled(true);
				nvTable.setGridColor(new Color(0, 0, 0));
				nvTable.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
				nvTable.setSelectionBackground(Color.LIGHT_GRAY);
				nvTable.setRowHeight(35);
				nvTable.setBorder(null);
				nvTable.getTableHeader().setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
				nvTable.getTableHeader().setBackground(new Color(102, 205, 170));
				nvTable.getTableHeader().setResizingAllowed(false);
				nvTable.getTableHeader().setBorder(new LineBorder(Color.BLACK, 2));
				nvTable.setBackground(new Color(255, 255, 255));
				nvTable.getTableHeader().setReorderingAllowed(false);
				nvTable.setDefaultEditor(Object.class, null);
				nvTable.setFocusable(false);
				
						nvTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								if (e.getButton() == MouseEvent.BUTTON3) { // Bấm chuột phải
									int row = nvTable.rowAtPoint(e.getPoint());
									if (row != -1) {
										nvTable.setRowSelectionInterval(row, row);
										popupMenu.show(nvTable, e.getX(), e.getY());
									}
								}
							}
						});
						
						
						nvTable.setModel(new DefaultTableModel(
							new Object[][] {
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
								{123, 123, 123, 123, 123, 123, 123, 123, 123, 123},
							},
							new String[] {
									"Mã NV", "Họ Tên", "Email", "Địa chỉ", "CCCD", "Cấp bậc",
									"Mã PB"
							}
						));
						nvTable.getColumnModel().getColumn(0).setPreferredWidth(100);
						
								nvTable.setBounds(0, 0, 1, 1);
								bangNhanVienScrollPane = new JScrollPane(nvTable);
								bangNhanVienScrollPane.setBounds(31, 10, 871, 233);
								panel_1.add(bangNhanVienScrollPane);
								bangNhanVienScrollPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
								bangNhanVienScrollPane.setBorder(null);
								bangNhanVienScrollPane.setViewportBorder(null);
								bangNhanVienScrollPane.setAutoscrolls(true);
								bangNhanVienScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
								bangNhanVienScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
								
								JLabel lblNewLabel_3_1 = new JLabel("BẢNG CHẤM CÔNG:");
								lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
								lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
								lblNewLabel_3_1.setForeground(Color.BLACK);
								lblNewLabel_3_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
								lblNewLabel_3_1.setBorder(null);
								lblNewLabel_3_1.setBackground(Color.BLACK);
								lblNewLabel_3_1.setBounds(31, 276, 268, 45);
								panel_1.add(lblNewLabel_3_1);
								
								maNVTF = new JTextField();
								maNVTF.setText("Nhập mã nhân viên");
								maNVTF.setForeground(Color.GRAY);
								maNVTF.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
								maNVTF.setColumns(10);
								maNVTF.setBounds(600, 281, 259, 37);
								panel_1.add(maNVTF);
								
								JButton maNvbutton = new JButton("");
								maNvbutton.setIcon(new ImageIcon(chamCongView.class.getResource("/img/search (1).png")));
								maNvbutton.setFocusable(false);
								maNvbutton.setBorder(null);
								maNvbutton.setBackground(Color.WHITE);
								maNvbutton.setBounds(869, 281, 33, 37);
								panel_1.add(maNvbutton);
		
		

		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(102, 205, 170));
		panel_2.setBounds(0, 0, 957, 55);
		tab3.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_3 = new JLabel("QUẢN LÝ CHẤM CÔNG");
		lblNewLabel_3.setBounds(54, 10, 903, 45);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.BOLD, 21));
		lblNewLabel_3.setBorder(null);
		lblNewLabel_3.setBackground(Color.BLACK);

		tenNVTF = new JTextField();
		tenNVTF.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		tenNVTF.setBounds(622, 82, 259, 37);
		tab3.add(tenNVTF);
		tenNVTF.setColumns(10);
		tenNVTF.setText("Nhập tên nhân viên");
		tenNVTF.setForeground(Color.GRAY);
		tenNVTF.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (tenNVTF.getText().equals("Nhập tên nhân viên")) {
					tenNVTF.setText("");
					tenNVTF.setForeground(Color.BLACK);
				}
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				if (tenNVTF.getText().isEmpty()) {
					tenNVTF.setText("Nhập tên nhân viên");
					tenNVTF.setForeground(Color.GRAY);
				}
			}
		});

		tenNVbutton = new JButton("");
		tenNVbutton.setFocusable(false);
		tenNVbutton.setBorder(null);
		tenNVbutton.setBackground(new Color(255, 255, 255));
		tenNVbutton.setIcon(new ImageIcon(mainView.class.getResource("/img/search (1).png")));
		tenNVbutton.setBounds(891, 82, 33, 37);
		tab3.add(tenNVbutton);
		
		lblNewLabel_3_2 = new JLabel("BẢNG NHÂN VIÊN:");
		lblNewLabel_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		lblNewLabel_3_2.setBorder(null);
		lblNewLabel_3_2.setBackground(Color.BLACK);
		lblNewLabel_3_2.setBounds(50, 82, 268, 45);
		tab3.add(lblNewLabel_3_2);
	}
}
