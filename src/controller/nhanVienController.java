package controller;

import view.nhanVienView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.nhanVienDAO;
import DAO.phongBanDAO;
import model.nhanVien;
import model.phongBan;

public class nhanVienController implements ActionListener, MouseListener, KeyListener {
	private nhanVienView nhanVienView;

	public nhanVienController(nhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		int column = this.nhanVienView.getTable().columnAtPoint(e.getPoint());
//		String headerValue = (String) this.nhanVienView.getTable().getColumnModel().getColumn(column).getHeaderValue();
//		if (headerValue.equals("Mã PB")) {
//			ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectSortByMAPB();
//			changeTableData(arr_pb);
//		} else if (headerValue.equals("Tên PB")) {
//			ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectSortByTENPB();
//			changeTableData(arr_pb);
//		} else if (headerValue.equals("NgThanhLap")) {
//			ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectSortByNGTHANHLAP();
//			changeTableData(arr_pb);
//		} else if (headerValue.equals("MaTruongPhong")) {
//			ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectSortByMATRUONGPHONG();
//			changeTableData(arr_pb);
//		} else if (headerValue.equals("NgNhanChuc")) {
//			ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectSortByNGNHANCHUC();
//			changeTableData(arr_pb);
//		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Xóa")) {
			TableModel model = nhanVienView.getTable().getModel();

			int maNV = Integer.parseInt((String) model.getValueAt(nhanVienView.getTable().getSelectedRows()[0], 0));
			System.out.println(maNV);

			nhanVien nv_tmp = new nhanVien(maNV, "", "", null, "", "", "", "", "", null);
			nhanVienDAO.getInstance().deleteT(nv_tmp);
			ArrayList<nhanVien> nhanVienData = nhanVienDAO.getInstance().selectSortByMANV();
			nhanVienView.setNhanVienData(nhanVienData);
			changeTableData(nhanVienView.getNhanVienData());
		} else if (e.getActionCommand().equals("")) {
			String txt = nhanVienView.getTxtTnPhngBan().getText();

			if (txt.equals("") || txt == null) {
				changeTableData(nhanVienView.getNhanVienData());
			} else {
				ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectByLike(txt);
				changeTableData(arr_pb);
			}
		}

//		} else if (e.getActionCommand().equals("Cập nhật")) {
//			int selectedRow = this.phongBanView.getTable().getSelectedRow();
//			Object[] rowData = new Object[this.phongBanView.getTable().getColumnCount()];
//			for (int i = 0; i < this.phongBanView.getTable().getColumnCount(); i++) {
//				rowData[i] = this.phongBanView.getTable().getValueAt(selectedRow, i);
//			}
//			int maPB = Integer.parseInt(String.valueOf(rowData[0]));
//			String tenPB = String.valueOf(rowData[1]);
//			Date ngThanhLap = Date.valueOf(String.valueOf(rowData[2]));
//			int maTP;
//			if (rowData[3] != null && !rowData[3].equals("null")) {
//				maTP = Integer.parseInt(String.valueOf(rowData[3]));
//			} else {
//				maTP = 0;
//			}
//
//			Date ngayNhanChuc = null;
//
//			if (rowData[4] != null && !rowData[4].equals("null")) {
//				ngayNhanChuc = Date.valueOf(String.valueOf(rowData[4]));
//			} else {
//				ngayNhanChuc = null;
//			}
//
//			phongBan phongBan = new phongBan(maPB, tenPB, ngThanhLap, maTP, ngayNhanChuc);
//			new capNhatPhongBanView(phongBan);
//			this.phongBanView.getQLNVview().dispose();
//		} else if (e.getActionCommand().equals("")) {
//			String txt = phongBanView.getTxtTnPhngBan().getText();
//
//			if (txt.equals("") || txt == null) {
//				changeTableData(phongBanView.getPhongBanData());
//			} else {
//				ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectByLike(txt);
//				changeTableData(arr_pb);
//			}
//		} else if (e.getActionCommand().equals("+ Thêm phòng ban")) {
//			new themPhongBanView();
//			this.phongBanView.getQLNVview().dispose();
//		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String txt = nhanVienView.getTxtTnPhngBan().getText();

			if (txt.trim().equals("") || txt == null) {
				changeTableData(nhanVienView.getNhanVienData());
			} else {
				ArrayList<nhanVien> arr_pb = nhanVienDAO.getInstance().selectByLike(txt);
				changeTableData(arr_pb);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void changeTableData(ArrayList<nhanVien> newArr) {
		ArrayList<String[]> data = new ArrayList<>();
		int size = 10;

		for (int i = 0; i < newArr.size(); i++) {
			String[] tmp = new String[size];
			tmp[0] = String.valueOf(newArr.get(i).getMaNV());
			tmp[1] = String.valueOf(newArr.get(i).getHoTen());
			tmp[2] = String.valueOf(newArr.get(i).getGioiTinh());
			tmp[3] = String.valueOf(newArr.get(i).getNgSinh());
			tmp[4] = String.valueOf(newArr.get(i).getSoDienThoai());
			tmp[5] = String.valueOf(newArr.get(i).getEmail());
			tmp[6] = String.valueOf(newArr.get(i).getDiaChi());
			tmp[7] = String.valueOf(newArr.get(i).getCccd());
			tmp[8] = String.valueOf(newArr.get(i).getCapBac());
			tmp[9] = String.valueOf(newArr.get(i).getPhongBan().getMaPB());
			data.add(tmp);
		}

		// Tạo bảng và gắn dữ liệu vào
		String[] columnNames = { "Mã NV", "Họ Tên", "Giới tính", "Ngsinh", "SDT", "Email", "Địa chỉ", "CCCD", "Cấp bậc",
				"Mã PB" };
		nhanVienView.setTableModel(new DefaultTableModel(columnNames, 0));
		for (String[] row : data) {
			nhanVienView.getTableModel().addRow(row);
		}

		nhanVienView.getTable().setModel(nhanVienView.getTableModel());
	}

}
