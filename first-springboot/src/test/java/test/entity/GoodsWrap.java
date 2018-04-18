package test.entity;

import java.io.Serializable;

/**
 * 商品信息包装
 * 
 * @author zhangxiaoliang 2016年5月23日下午5:51:27
 */
public class GoodsWrap implements Serializable {

	private static final long serialVersionUID = 165503280669074501L;

	// 商品名称
	private String title;
	// 商品图片
	private String imgUrl;
	private Long sku;
	//京东M端价格
	private Double price;
	//令牌促销价格
	private Double salePrice;
	// 标签
	private String label;
	//库存状态 true:有货，false:无货
	private Boolean stockState;
	//商品状态 true:上柜， false:非上柜
	private Boolean state;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Boolean getStockState() {
		return stockState;
	}
	public void setStockState(Boolean stockState) {
		this.stockState = stockState;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
}
