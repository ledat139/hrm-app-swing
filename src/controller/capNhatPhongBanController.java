package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import DAO.nhanVienDAO;
import DAO.phongBanDAO;
import model.nhanVien;
import model.phongBan;
import view.mainView;
import view.errView;
import view.capNhatPhongBanView;

public class capNhatPhongBanController implements ActionListener {
	private capNhatPhongBanView capNhatPhongBanView;

	public capNhatPhongBanController(capNhatPhongBanView capNhatPhongBanView) {
		this.capNhatPhongBanView = capNhatPhongBanView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Cập nhật")) {
			try {

				String tenPB = this.capNhatPhongBanView.getTenPhongBanTextField().getText();
				int maPB = Integer.parseInt(this.capNhatPhongBanView.getMaPBPhongBanTextField().getText());
				System.out.println(this.capNhatPhongBanView.getNgThanhLapTF().getText());
				Date ngayThanhLap = Date.valueOf(this.capNhatPhongBanView.getNgThanhLapTF().getText());

				String maTP = this.capNhatPhongBanView.getMaTruongPhongTF().getText();
				String ngNhanChuc = this.capNhatPhongBanView.getNgNhanChucTF().getText();
				System.out.println(ngNhanChuc + " " + ngayThanhLap);
				if (maTP.trim().equals("") || maTP.equals("null") || ngNhanChuc.equals("null")) {

					phongBanDAO.getInstance().updateT(new phongBan(maPB, tenPB, ngayThanhLap, 0, null));

					this.capNhatPhongBanView.dispose();

					mainView mainView = new mainView();
					mainView.setTabPhongBan();
					mainView.setVisible(true);
					errView errView = new errView();
					errView.getLblNewLabel().setText("Cập nhật thành công");
					errView.setVisible(true);
				} else {
					phongBanDAO.getInstance().updateT(
							new phongBan(maPB, tenPB, ngayThanhLap, Integer.parseInt(maTP), Date.valueOf(ngNhanChuc)));

					this.capNhatPhongBanView.dispose();

					mainView mainView = new mainView();
					mainView.setTabPhongBan();
					mainView.setVisible(true);
					errView errView = new errView();
					errView.getLblNewLabel().setText("Cập nhật thành công");
					errView.setVisible(true);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();

				this.capNhatPhongBanView.dispose();
				mainView mainView = new mainView();
				mainView.setTabPhongBan();
				mainView.setVisible(true);
				errView errView = new errView();
				errView.getLblNewLabel().setText("Lỗi cập nhật");
				errView.setVisible(true);
			}

		} else if (e.getActionCommand().equals("Hủy")) {
			System.out.println("cancel");
			this.capNhatPhongBanView.dispose();
			mainView mainView = new mainView();
			mainView.setTabPhongBan();
			mainView.setVisible(true);
		}

	}

}
