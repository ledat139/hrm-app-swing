package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.databaseConnection;
import model.nhanVien;
import model.phongBan;
import view.errView;

public class phongBanDAO implements DAOinterface<phongBan> {
	public static phongBanDAO getInstance() {
		return new phongBanDAO();
	}

	public phongBan selectMaPBByTenPB(String tenPBcantim) {
		phongBan pb = null;
		tenPBcantim = tenPBcantim.toUpperCase();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN WHERE UPPER(TENPB) = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, tenPBcantim);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pb;
	}

	public ArrayList<phongBan> selectSortByMAPB() {
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN ORDER BY MAPB";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	public ArrayList<phongBan> selectSortByTENPB() {
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN ORDER BY TENPB";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	public ArrayList<phongBan> selectSortByNGTHANHLAP() {
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN ORDER BY NGTHANHLAP";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	public ArrayList<phongBan> selectSortByMATRUONGPHONG() {
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN ORDER BY MATRUONGPHONG";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	public ArrayList<phongBan> selectSortByNGNHANCHUC() {
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN ORDER BY NGAYNHANCHUC";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	@Override
	public phongBan selectByID(phongBan t) {
		// TODO Auto-generated method stub
		phongBan pb = null;

		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN WHERE MAPB = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, t.getMaPB());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pb;
	}

	public ArrayList<phongBan> selectByLike(String t) {
		ArrayList<phongBan> phongBanQuery = new ArrayList<>();
		try {
			t = t.toUpperCase();
			t = "%" + t + "%";

			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN WHERE UPPER(TENPB) LIKE ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, t);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maNV = rs.getInt("MATRUONGPHONG");
				nhanVien nvQuery = nhanVienDAO.getInstance()
						.selectByID(new nhanVien(maNV, "", "", null, "", "", "", "", "", null));
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				phongBanQuery.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phongBanQuery;
	}

	@Override
	public ArrayList<phongBan> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<phongBan> arr_pb = new ArrayList<>();
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "SELECT * FROM PHONGBAN";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int maPB = rs.getInt("MAPB");
				String tenPB = rs.getString("TENPB");
				Date ngThanhLap = rs.getDate("NGTHANHLAP");
				int maNV = rs.getInt("MATRUONGPHONG");
				nhanVien nvQuery = nhanVienDAO.getInstance()
						.selectByID(new nhanVien(maNV, "", "", null, "", "", "", "", "", null));
				int maTruongPhong = rs.getInt("MATRUONGPHONG");
				Date ngNhanChuc = rs.getDate("NGAYNHANCHUC");
				phongBan pb = new phongBan(maPB, tenPB, ngThanhLap, maTruongPhong, ngNhanChuc);
				arr_pb.add(pb);
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr_pb;
	}

	@Override
	public int insertT(phongBan t) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "INSERT INTO PHONGBAN VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = c.prepareStatement(sql);
			if (t.getMaTruongPhong() == 0 || t.getNgNhanChuc() == null) {
				st.setInt(1, t.getMaPB());
				st.setString(2, t.getTenPB());
				st.setDate(3, t.getNgThanhLap());
				st.setObject(4, null);
				st.setDate(5, null);
			} else {
				st.setInt(1, t.getMaPB());
				st.setString(2, t.getTenPB());
				st.setDate(3, t.getNgThanhLap());
				st.setInt(4, t.getMaTruongPhong());
				st.setDate(5, t.getNgNhanChuc());
			}
			if (st.execute()) {
				cnt = 1;
			} else {
				cnt = 0;
			}

			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errView errView = new errView();
			errView.setVisible(true);
			// errView.getLblNewLabel().setText("Không thể xóa phòng ban vì có nhân viên
			// đang trực thuộc phòng ban này!");
		}
		return cnt;

	}

	@Override
	public int updateT(phongBan t) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "UPDATE PHONGBAN SET TENPB = ?, NGTHANHLAP = ?, MATRUONGPHONG = ?, NGAYNHANCHUC = ?"
					+ "WHERE MAPB = ?";
			PreparedStatement st = c.prepareStatement(sql);
			if (t.getMaTruongPhong() != 0 || t.getNgNhanChuc() != null) {
				st.setString(1, t.getTenPB());
				st.setDate(2, t.getNgThanhLap());
				st.setInt(3, t.getMaTruongPhong());
				st.setDate(4, t.getNgNhanChuc());
				st.setInt(5, t.getMaPB());
			} else {
				st.setString(1, t.getTenPB());
				st.setDate(2, t.getNgThanhLap());
				st.setObject(3, null);
				st.setObject(4, null);
				st.setInt(5, t.getMaPB());
			}
			if (st.execute()) {
				cnt = 1;
			} else {
				cnt = 0;
			}

			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errView errView = new errView();
			errView.setVisible(true);
			// errView.getLblNewLabel().setText("Không thể xóa phòng ban vì có nhân viên
			// đang trực thuộc phòng ban này!");
		}
		return cnt;
	}

	@Override
	public int deleteT(phongBan t) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			Connection c = databaseConnection.getDatabaseConnection();

			String sql = "DELETE FROM PHONGBAN WHERE MAPB = ?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, t.getMaPB());
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
			errView.getLblNewLabel().setText("Không thể xóa phòng ban vì có nhân viên đang trực thuộc phòng ban này!");
		}
		return cnt;
	}

	@Override
	public int seq_num() {
		// TODO Auto-generated method stub
		int cnt = 0;

		try {
			Connection c = databaseConnection.getDatabaseConnection();
			String sql = "SELECT * FROM PHONGBAN";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				cnt += 1;
			}
			databaseConnection.closeDatabaseConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cnt;
	}

}
