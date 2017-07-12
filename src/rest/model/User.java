package rest.model;

public class User {
	private int id;
	private String issuer;
	private String subject;
	private long ttlMillis;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIssuer() {
		
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getTtlMillis() {
		return ttlMillis;
	}
	public void setTtlMillis(long ttlMillis) {
		this.ttlMillis = ttlMillis;
	}
	
	
	

}
