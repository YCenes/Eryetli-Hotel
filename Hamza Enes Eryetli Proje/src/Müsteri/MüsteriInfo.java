package Müsteri;

public class MüsteriInfo {

	
	private int id;
	private String dogumtarihi;
	private String ad;
	private String soyad;
	private String telefonno;
	private String cinsiyet;
	private String email;
	private String TC;
	private String sifre;
	
	
	public MüsteriInfo(int id, String dogumtarihi, String ad, String soyad, String telefonno, String cinsiyet,
			String email, String tC, String sifre) {
		
		this.id = id;
		this.dogumtarihi = dogumtarihi;
		this.ad = ad;
		this.soyad = soyad;
		this.telefonno = telefonno;
		this.cinsiyet = cinsiyet;
		this.email = email;
		TC = tC;
		this.sifre = sifre;
	}
	
	public MüsteriInfo() {
		
		
		
		
		
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDogumtarihi() {
		return dogumtarihi;
	}

	public void setDogumtarihi(String dogumtarihi) {
		this.dogumtarihi = dogumtarihi;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTelefonno() {
		return telefonno;
	}

	public void setTelefonno(String telefonno) {
		this.telefonno = telefonno;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Object object) {
		this.cinsiyet = (String) object;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTC() {
		return TC;
	}

	public void setTC(String tC) {
		TC = tC;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
