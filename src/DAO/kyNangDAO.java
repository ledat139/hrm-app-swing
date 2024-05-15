package DAO;

import model.kyNang;
import java.util.ArrayList;

public class kyNangDAO implements DAOinterface<kyNang> {
	public static kyNangDAO getInstance() {
		return new kyNangDAO();
	}

	@Override
	public kyNang selectByID(kyNang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<kyNang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertT(kyNang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateT(kyNang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteT(kyNang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int seq_num() {
		// TODO Auto-generated method stub
		return 0;
	}

}
