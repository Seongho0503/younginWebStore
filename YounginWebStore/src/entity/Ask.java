package entity;
public class Ask {
	private int id; //������ȣ
	private String regNo; //����
	private Dept dept; //ǰ��
	private Code status; //ó������
	private String name; //�а��̸�
	private String dat;//��¥
	private String details;
	private String writer;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Code getStatus() {
		return status;
	}
	public void setStatus(Code status) {
		this.status = status;
	}

}
