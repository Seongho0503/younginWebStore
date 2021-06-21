package counter;

public class Counter {
	private String access_time;
	private String session_id;
	private String login_count;
	private String member_name;
	private String email;
	private String dept;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String memberName) {
		member_name = memberName;
	}
	public String getAccess_time() {
		return access_time;
	}
	public void setAccess_time(String accessTime) {
		access_time = accessTime;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String sessionId) {
		session_id = sessionId;
	}
	public String getLogin_count() {
		return login_count;
	}
	public void setLogin_count(String loginCount) {
		login_count = loginCount;
	}
	
}