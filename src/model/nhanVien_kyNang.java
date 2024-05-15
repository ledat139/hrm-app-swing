package model;

public class nhanVien_kyNang {
	private kyNang kyNang;
	private nhanVien nhanVien;
	private String capBacKyNang;

	public nhanVien_kyNang(model.kyNang kyNang, model.nhanVien nhanVien, String capBacKyNang) {
		super();
		this.kyNang = kyNang;
		this.nhanVien = nhanVien;
		this.capBacKyNang = capBacKyNang;
	}

	public nhanVien_kyNang() {
		super();
	}

	public kyNang getKyNang() {
		return kyNang;
	}

	public void setKyNang(kyNang kyNang) {
		this.kyNang = kyNang;
	}

	public nhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(nhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getCapBacKyNang() {
		return capBacKyNang;
	}

	public void setCapBacKyNang(String capBacKyNang) {
		this.capBacKyNang = capBacKyNang;
	}

}
