package controller;

import view.capNhatPhongBanView;
import view.phongBanView;
import view.themPhongBanView;

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

import DAO.phongBanDAO;
import model.phongBan;

public class phongBanController implements ActionListener, MouseListener, KeyListener {
	private phongBanView phongBanView;

	public phongBanController(phongBanView phongBanView) {
		this.phongBanView = phongBanView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int column = this.phongBanView.getTable().columnAtPoint(e.getPoint());
		String headerValue = (String) this.phongBanView.getTable().getColumnModel().getColumn(column).getHeaderValue();
		if (headerValue.equals("Mã PB")) {
			ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectSortByMAPB();
			changeTableData(arr_pb);
		} else if (headerValue.equals("Tên PB")) {
			ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectSortByTENPB();
			changeTableData(arr_pb);
		} else if (headerValue.equals("NgThanhLap")) {
			ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectSortByNGTHANHLAP();
			changeTableData(arr_pb);
		} else if (headerValue.equals("MaTruongPhong")) {
			ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectSortByMATRUONGPHONG();
			changeTableData(arr_pb);
		} else if (headerValue.equals("NgNhanChuc")) {
			ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectSortByNGNHANCHUC();
			changeTableData(arr_pb);
		}

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
			TableModel model = phongBanView.getTable().getModel();

			int maPB = Integer.parseInt((String) model.getValueAt(phongBanView.getTable().getSelectedRows()[0], 0));
			System.out.println(maPB);

			phongBan pb_tmp = new phongBan(maPB, "", null, 0, null);
			phongBanDAO.getInstance().deleteT(pb_tmp);
			ArrayList<phongBan> phongBanData = phongBanDAO.getInstance().selectSortByMAPB();
			phongBanView.setPhongBanData(phongBanData);
			changeTableData(phongBanView.getPhongBanData());

		} else if (e.getActionCommand().equals("Cập nhật")) {
			int selectedRow = this.phongBanView.getTable().getSelectedRow();
			Object[] rowData = new Object[this.phongBanView.getTable().getColumnCount()];
			for (int i = 0; i < this.phongBanView.getTable().getColumnCount(); i++) {
				rowData[i] = this.phongBanView.getTable().getValueAt(selectedRow, i);
			}
			int maPB = Integer.parseInt(String.valueOf(rowData[0]));
			String tenPB = String.valueOf(rowData[1]);
			Date ngThanhLap = Date.valueOf(String.valueOf(rowData[2]));
			int maTP;
			if (rowData[3] != null && !rowData[3].equals("null")) {
				maTP = Integer.parseInt(String.valueOf(rowData[3]));
			} else {
				maTP = 0;
			}

			Date ngayNhanChuc = null;

			if (rowData[4] != null && !rowData[4].equals("null")) {
				ngayNhanChuc = Date.valueOf(String.valueOf(rowData[4]));
			} else {
				ngayNhanChuc = null;
			}

			phongBan phongBan = new phongBan(maPB, tenPB, ngThanhLap, maTP, ngayNhanChuc);
			new capNhatPhongBanView(phongBan);
			this.phongBanView.getmainView().dispose();
		} else if (e.getActionCommand().equals("")) {
			String txt = phongBanView.getTxtTnPhngBan().getText();

			if (txt.equals("") || txt == null) {
				changeTableData(phongBanView.getPhongBanData());
			} else {
				ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectByLike(txt);
				changeTableData(arr_pb);
			}
		} else if (e.getActionCommand().equals("+ Thêm phòng ban")) {
			new themPhongBanView();
			this.phongBanView.getmainView().dispose();
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
			String txt = phongBanView.getTxtTnPhngBan().getText();

			if (txt.trim().equals("") || txt == null) {
				changeTableData(phongBanView.getPhongBanData());
			} else {
				ArrayList<phongBan> arr_pb = phongBanDAO.getInstance().selectByLike(txt);
				changeTableData(arr_pb);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void changeTableData(ArrayList<phongBan> newArr) {
		ArrayList<String[]> data = new ArrayList<>();
		int size = 5;
		String maTruongPhong = "";
		String ngNhanChuc = "";
		for (int i = 0; i < newArr.size(); i++) {
			String[] tmp = new String[size];
			tmp[0] = String.valueOf(newArr.get(i).getMaPB());
			tmp[1] = String.valueOf(newArr.get(i).getTenPB());
			tmp[2] = String.valueOf(newArr.get(i).getNgThanhLap());
			if (phongBanView.getPhongBanData().get(i).getMaTruongPhong() == 0) {
				maTruongPhong = "null";
			} else {
				maTruongPhong = String.valueOf(newArr.get(i).getMaTruongPhong());
			}
			if (phongBanView.getPhongBanData().get(i).getNgNhanChuc() == null) {
				ngNhanChuc = "null";
			} else {
				ngNhanChuc = String.valueOf(newArr.get(i).getNgNhanChuc());
			}
			tmp[3] = maTruongPhong;
			tmp[4] = ngNhanChuc;
			data.add(tmp);
		}

		// Tạo bảng và gắn dữ liệu vào
		String[] columnNames = { "Mã PB", "Tên PB", "NgThanhLap", "MaTruongPhong", "NgNhanChuc" };
		phongBanView.setTableModel(new DefaultTableModel(columnNames, 0));
		for (String[] row : data) {
			phongBanView.getTableModel().addRow(row);
		}

		phongBanView.getTable().setModel(phongBanView.getTableModel());
	}

}
