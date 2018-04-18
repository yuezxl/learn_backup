package test.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 酷购首页二级类目下商品封装<br/>
 *
 * @version  v1.0
 * @author   张小亮 zhangxiaoliang@jd.com <br/>
 * 2016年5月31日 下午4:31:59 创建
 */
public class SmartNextCoolBuyGoodsWrap implements Serializable{

	private static final long serialVersionUID = -8549614185479850707L;
	
	/**
	 * 商品是否有下一页
	 *
	 * @since CodingExample Ver 1.0
	 */
	private Boolean next = false;
	
	/**
	 * 商品列表
	 *
	 * @since CodingExample Ver 1.0
	 */
	private List<GoodsWrap> goodsList = new ArrayList<>();

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}

	public List<GoodsWrap> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsWrap> goodsList) {
		this.goodsList = goodsList;
	}

}
