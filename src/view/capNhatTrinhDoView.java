package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import com.raven.datechooser.DateChooser;

import controller.themPhongBanController;

import com.raven.datechooser.*;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class capNhatTrinhDoView extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField maNVTF;
	private JTextField levelTF;
	private JButton okButton;
	private JButton cancelButton;
	private ActionListener ac;
	
	
	public capNhatTrinhDoView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 803, 402);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(0, 0, 789, 291);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel formPanel = new JPanel();
		formPanel.setBackground(new Color(255, 255, 255));
		formPanel.setBounds(0, 0, 498, 285);
		contentPanel.add(formPanel);
		formPanel.setLayout(null);

		JPanel header = new JPanel();
		header.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		header.setBackground(new Color(102, 205, 170));
		header.setBounds(38, 0, 204, 49);
		formPanel.add(header);
		header.setLayout(null);

		JLabel headerLabel = new JLabel("CẬP NHẬT KỸ NĂNG");
		headerLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 19));
		headerLabel.setBounds(10, 10, 259, 30);
		header.add(headerLabel);

		JLabel maNV = new JLabel("Mã nhân viên:");
		maNV.setHorizontalAlignment(SwingConstants.LEFT);
		maNV.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		maNV.setBounds(38, 93, 127, 26);
		formPanel.add(maNV);

		JLabel tenKyNang = new JLabel("Tên kỹ năng:");
		tenKyNang.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		tenKyNang.setBounds(38, 139, 141, 26);
		formPanel.add(tenKyNang);

		JLabel level = new JLabel("Cấp bậc:");
		level.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		level.setBounds(38, 185, 155, 26);
		formPanel.add(level);

		maNVTF = new JTextField();
		maNVTF.setBorder(new LineBorder(new Color(0, 0, 0)));
		maNVTF.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		maNVTF.setBounds(210, 93, 240, 26);
		formPanel.add(maNVTF);
		maNVTF.setColumns(10);

		levelTF = new JTextField();
		levelTF.setBorder(new LineBorder(new Color(0, 0, 0)));
		levelTF.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		levelTF.setColumns(10);
		levelTF.setBounds(210, 185, 240, 26);
		formPanel.add(levelTF);
		
		String kn[] = {"Tin học", "Tiếng anh"};
		JComboBox kyNangComboBox = new JComboBox(kn);
		kyNangComboBox.setBounds(210, 144, 98, 21);
		formPanel.add(kyNangComboBox);
		
		
		String maPB[] = {"P01", "P02", "..."};
		{
			JPanel imgPanel = new JPanel();
			imgPanel.setBackground(new Color(255, 255, 255));
			imgPanel.setBounds(508, 0, 287, 285);
			contentPanel.add(imgPanel);
			imgPanel.setLayout(null);

			JLabel imgLabel = new JLabel("");
			imgLabel.setIcon(new ImageIcon(capNhatTrinhDoView.class.getResource("/img/decision.png")));
			imgLabel.setBounds(0, 24, 260, 259);
			imgPanel.add(imgLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 301, 788, 69);
			getContentPane().add(buttonPane);
			buttonPane.setOpaque(false);
			buttonPane.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
			{
				okButton = new JButton("Cập nhật");
				okButton.addActionListener(ac);
				okButton.setFocusable(false);
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				okButton.setBounds(590, 20, 83, 29);
				okButton.setBackground(new Color(102, 205, 170));
				okButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
				buttonPane.setLayout(null);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Hủy");
				cancelButton.addActionListener(ac);
				cancelButton.setFocusable(false);
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
				cancelButton.setBounds(680, 20, 68, 29);
				cancelButton.setBackground(new Color(102, 205, 170));
				cancelButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
				buttonPane.add(cancelButton);
			}
		}

		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				mainView mainView = new mainView();
				mainView.setTabPhongBan();

			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
	public JTextField getMaNVTF() {
		return maNVTF;
	}
	public void setMaNVTF(JTextField maNVTF) {
		this.maNVTF = maNVTF;
	}
	public JTextField getSoNgayLamViecTF() {
		return levelTF;
	}
	public void setSoNgayLamViecTF(JTextField soNgayLamViecTF) {
		this.levelTF = soNgayLamViecTF;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	public ActionListener getAc() {
		return ac;
	}
	public void setAc(ActionListener ac) {
		this.ac = ac;
	}

}
