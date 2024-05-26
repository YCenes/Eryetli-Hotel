package RezervasyonInfo;





public class RezervasyonInfo {

	private String id;
	private String girisTarihi;
	private String cikisTarihi;
	private String odatürü;
	private String odanumarasi;
	
	
	
	public RezervasyonInfo(String girisTarihi,String cikisTarihi,String odatürü,String id,String odanumarasi) {
		
		this.girisTarihi = girisTarihi;
		this.cikisTarihi = cikisTarihi;
		this.odatürü = odatürü;
		this.id = id;
		this.odanumarasi = odanumarasi;
		
		
		
	}
	
	

	public String getOdanumarasi() {
		return odanumarasi;
	}



	public void setOdanumarasi(String odanumarasi) {
		this.odanumarasi = odanumarasi;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RezervasyonInfo() {
		
	}

	public String getGirisTarihi() {
		return girisTarihi;
	}

	public void setGirisTarihi(String girisTarihi) {
		this.girisTarihi = girisTarihi;
	}

	public String getCikisTarihi() {
		return cikisTarihi;
	}

	public void setCikisTarihi(String cikisTarihi) {
		this.cikisTarihi = cikisTarihi;
	}

	public String getOdatürü() {
		return odatürü;
	}

	public void setOdatürü(String odatürü) {
		this.odatürü = odatürü;
	}
	
	
	public String toString() {
		
		return this.id + "," + getGirisTarihi() + "," + this.getCikisTarihi() + "," + this.getOdatürü();
		
		
	}


	
	
}
