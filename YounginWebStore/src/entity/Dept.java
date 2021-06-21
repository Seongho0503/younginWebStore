package entity;

public class Dept {
	private String name; //품목이름
	private String code; //품목코드
	private String price; //가격
	private int maxAskCnt;	//수량
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getMaxAskCnt() {
		return maxAskCnt;
	}
	public void setMaxAskCnt(int maxAskCnt) {
		this.maxAskCnt = maxAskCnt;
	}

	
	
}
