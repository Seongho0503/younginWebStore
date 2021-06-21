package buy;
import customer.Customer;
import good.Good;

public class Buy {
  private long buyNum;
  private long buyId;
  private Good good;
  private long qty;
  private long buyPrice;
  private String buyDate;
  private Customer customer;
  
public String getBuyDate() {
	return buyDate;
}
public void setBuyDate(String buyDate) {
	this.buyDate = buyDate;
}
public long getBuyId() {
	return buyId;
}
public void setBuyId(long buyId) {
	this.buyId = buyId;
}
public long getBuyNum() {
	return buyNum;
}
public void setBuyNum(long buyNum) {
	this.buyNum = buyNum;
}
public long getBuyPrice() {
	return buyPrice;
}
public void setBuyPrice(long buyPrice) {
	this.buyPrice = buyPrice;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Good getGood() {
	return good;
}
public void setGood(Good good) {
	this.good = good;
}
public long getQty() {
	return qty;
}
public void setQty(long qty) {
	this.qty = qty;
}
}
