package good;

/**
 * 
 * ������ ������ ������ �Ӽ��� �����ϴ� ��ü
 * 
 */
public class Good {
	private String gid;// ������ ���̵�

	private String gname;// ������ �̸�

	private long price;// ������ ����

	private String detail;// ������ ����

	private String image;// ������ �̹��� ������ �̸�

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
