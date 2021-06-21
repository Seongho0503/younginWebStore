package good;

/**
 * 
 * 선택한 물건의 정보를 속성에 저장하는 객체
 * 
 */
public class Good {
	private String gid;// 물건의 아이디

	private String gname;// 물건의 이름

	private long price;// 물건의 가격

	private String detail;// 물건의 설명

	private String image;// 물건의 이미지 파일의 이름

	private int gty=1;

	@Override
	public boolean equals(Object obj) {
		boolean equal=false;
		if(obj instanceof Good){
			Good good=(Good)obj;
			if(good.getGid().equals(gid))
				equal=true;
		}
		return equal;
	}

	public int getGty() {
		return gty;
	}

	public void setGty(int gty) {
		this.gty = gty;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
