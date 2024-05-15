package DAO;

import model.hopDong;
import java.util.ArrayList;

public class hopDongDAO implements DAOinterface<hopDong> {
	public static hopDongDAO getInstance() {
		return new hopDongDAO();
	}

	@Override
	public hopDong selectByID(hopDong t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<hopDong> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertT(hopDong t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateT(hopDong t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteT(hopDong t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int seq_num() {
		// TODO Auto-generated method stub
		return 0;
	}

}
