package customer;

public class Customer {
	private String m_name;
	private String m_id;
	private String m_pw;
	private String email;
	private String address;
	private String dept;
	private String s_no;
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getS_no() {
		return s_no;
	}
	public void setS_no(String sNo) {
		s_no = sNo;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String mName) {
		m_name = mName;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String mId) {
		m_id = mId;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String mPw) {
		m_pw = mPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}