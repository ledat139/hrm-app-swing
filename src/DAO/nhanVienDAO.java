package DAO;

import model.nhanVien;
import model.phongBan;
import model.taiKhoan;
import view.errView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.databaseConnection;

public class nhanVienDAO implements DAOinterface<nhanVien> {
	public static nhanVienDAO getInstance() {
		return new nhanVienDAO();
	}

	public ArrayList<nhanVien> selectSortByMANV() {
		ArrayList<nhanVien> nhanVienQuery = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM NHANVIEN NV INNER JOIN PHONGBAN PB ON NV.MAPB = PB.MAPB ORDER BY MANV";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maNV = rs.getInt("MANV");
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");
				Date ngSinh = rs.getDate("NGSINH");
				String sdt = rs.getString("SDT");
				String email = rs.getString("EMAIL");
				String diaChi = rs.getString("DIACHI");
				String cccd = rs.getString("CCCD");
				String capBac = rs.getString("CAPBAC");

				phongBan phongBanReal = new phongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getDate("NGTHANHLAP"),
						rs.getInt("MATRUONGPHONG"), rs.getDate("NGAYNHANCHUC"));

				nhanVien nv = new nhanVien(maNV, hoTen, gioiTinh, ngSinh, sdt, email, diaChi, cccd, capBac,
						phongBanReal);
				nhanVienQuery.add(nv);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVienQuery;
	}

	public ArrayList<nhanVien> selectByLike(String t) {
		ArrayList<nhanVien> nhanVienQuery = new ArrayList<>();
		try {
			t = t.toUpperCase();
			t = "%" + t + "%";

			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM NHANVIEN NV INNER JOIN PHONGBAN PB ON NV.MAPB = PB.MAPB WHERE UPPER(HOTEN) LIKE ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, t);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maNV = rs.getInt("MANV");
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");
				Date ngSinh = rs.getDate("NGSINH");
				String sdt = rs.getString("SDT");
				String email = rs.getString("EMAIL");
				String diaChi = rs.getString("DIACHI");
				String cccd = rs.getString("CCCD");
				String capBac = rs.getString("CAPBAC");

				phongBan phongBanReal = new phongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getDate("NGTHANHLAP"),
						rs.getInt("MATRUONGPHONG"), rs.getDate("NGAYNHANCHUC"));

				nhanVien nv = new nhanVien(maNV, hoTen, gioiTinh, ngSinh, sdt, email, diaChi, cccd, capBac,
						phongBanReal);
				nhanVienQuery.add(nv);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanVienQuery;
	}

	@Override
	public nhanVien selectByID(nhanVien t) {
		// TODO Auto-generated method stub
		nhanVien nv = null;

		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM NHANVIEN NV INNER JOIN PHONGBAN PB ON NV.MAPB = PB.MAPB WHERE MANV = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, t.getMaNV());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maNV = rs.getInt("MANV");
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");
				Date ngSinh = rs.getDate("NGSINH");
				String sdt = rs.getString("SDT");
				String email = rs.getString("EMAIL");
				String diaChi = rs.getString("DIACHI");
				String cccd = rs.getString("CCCD");
				String capBac = rs.getString("CAPBAC");

				phongBan phongBanReal = new phongBan(rs.getInt("MAPB"), rs.getString("TENPB"), rs.getDate("NGTHANHLAP"),
						rs.getInt("MATRUONGPHONG"), rs.getDate("NGAYNHANCHUC"));

				nv = new nhanVien(maNV, hoTen, gioiTinh, ngSinh, sdt, email, diaChi, cccd, capBac, phongBanReal);
			}
			databaseConnection.closeDatabaseConnection(c);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nv;
	}

	@Override
	public ArrayList<nhanVien> selectAll() {
		ArrayList<nhanVien> arr_nv = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM NHANVIEN";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maNV = rs.getInt("MANV");
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");
				Date ngSinh = rs.getDate("NGSINH");
				String sdt = rs.getString("SDT");
				String email = rs.getString("EMAIL");
				String diaChi = rs.getString("DIACHI");
				String cccd = rs.getString("CCCD");
				String capBac = rs.getString("CAPBAC");
				int maPB = rs.getInt("MAPB");

				phongBan pb_tmp = phongBanDAO.getInstance().selectByID(new phongBan(maPB, "", null, 0, null));

				nhanVien nv = new nhanVien(maNV, hoTen, gioiTinh, ngSinh, sdt, email, diaChi, cccd, capBac, pb_tmp);
				arr_nv.add(nv);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_nv;
	}

	@Override
	public int insertT(nhanVien t) {
		int cnt = 0;
//		try {
//			Connection c = databaseConnection.getDatabaseConnection();
//
//			String sql = "INSERT INTO NHANVIEN VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			PreparedStatement st = c.prepareStatement(sql);
////			st.setInt(1, nhanVienDAO.getInstance().seq_num());
////			st.setString(2, t.getHoTen());
////			st.setString(3, t.getGioiTinh());
////			st.setDate(4, t.getNgSinh());
////			st.setString(5, t.getSoDienThoai());
////			st.setString(6, t.getEmail());
////			st.setString(7, t.getDiaChi());
////			st.setString(8, t.getCccd());
////			st.setString(9, t.getCapBac());
////			phongBan pb_tmp = new phongBan(t.getPhongBan().getMaPB())
//
//			if (st.execute()) {
//				cnt = 1;
//			} else {
//				cnt = 0;
//			}
//
//			databaseConnection.closeDatabaseConnection(c);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			errView errView = new errView();
//			errView.setVisible(true);
//			// errView.getLblNewLabel().setText("Không thể xóa phòng ban vì có nhân viên
//			// đang trực thuộc phòng ban này!");
//		}
		return cnt;

	}

	@Override
	public int updateT(nhanVien t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteT(nhanVien t) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, t.getMaNV());
			if (st.execute()) {
				cnt = 1;
			} else {
				cnt = 0;
			}

			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			errView errView = new errView();
			errView.setVisible(true);
			errView.getLblNewLabel().setText("Không thể xóa nhân viên là trưởng phòng trong công ty!");
		}
		return cnt;
	}

	@Override
	public int seq_num() {
		// TODO Auto-generated method stub
		return 0;
	}

}
