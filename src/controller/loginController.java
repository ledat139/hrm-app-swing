package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import DAO.taiKhoanDAO;
import model.taiKhoan;
import view.mainView;
import view.loginView;

public class loginController implements KeyListener, ActionListener {

	private loginView loginView;

	public loginController(loginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Đăng nhập")) {
			String tenDangNhap = loginView.getTextField().getText();
			String matKhau = loginView.getTextField_1().getText();
			taiKhoan tk = new taiKhoan(0, null, tenDangNhap, matKhau, "");
			if (taiKhoanDAO.getInstance().selectByID(tk) != null) {
				loginView.dispose();
				new mainView();
			} else {
				loginView.dispose();
				new loginView();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String tenDangNhap = loginView.getTextField().getText();
			String matKhau = loginView.getTextField_1().getText();
			taiKhoan tk = new taiKhoan(0, null, tenDangNhap, matKhau, "");
			if (taiKhoanDAO.getInstance().selectByID(tk) != null) {
				loginView.dispose();
				new mainView();
			} else {
				loginView.dispose();
				new loginView();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
