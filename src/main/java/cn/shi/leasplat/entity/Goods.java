package cn.shi.leasplat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Goods implements Serializable{
	private Integer id;
	
	private String name;						//��Ʒ����
	
	private BigDecimal price;					//��Ʒ�۸����磺5Ԫ/�죩
	
	private Integer userId;						//�û�id
	
//	private Integer goodsImageId;				//��ƷͼƬid
	
	private Integer basicUnit;					//��Ʒ������λ��0���죬1���£�2���꣩
	
	private Integer goodsClassId;				//��Ʒ���id
	
	private Date createTime = new Date();		//����ʱ��
	
	private Integer isDelete = 0; 				//�Ƿ�ɾ��
	
	private String goodsMessage;
	
	
	// ���������ݿ��е����ԣ���ҪĿ������ʾ
	private String goodsClassName;				// ��Ʒ�������
	private User user;					//�û���
	private List<GoodsImage> imagePath;			//ͼƬ·��
	private Integer imageId;					// ����һ����Ʒ��id
	
	
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getGoodsMessage() {
		return goodsMessage;
	}

	public void setGoodsMessage(String goodsMessage) {
		this.goodsMessage = goodsMessage;
	}

	public String getGoodsClassName() {
		return goodsClassName;
	}

	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GoodsImage> getImagePath() {
		return imagePath;
	}

	public void setImagePath(List<GoodsImage> imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

//	public Integer getGoodsImageId() {
//		return goodsImageId;
//	}
//
//	public void setGoodsImageId(Integer goodsImageId) {
//		this.goodsImageId = goodsImageId;
//	}

	public Integer getBasicUnit() {
		return basicUnit;
	}

	public void setBasicUnit(Integer basicUnit) {
		this.basicUnit = basicUnit;
	}

	public Integer getGoodsClassId() {
		return goodsClassId;
	}

	public void setGoodsClassId(Integer goodsClassId) {
		this.goodsClassId = goodsClassId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", userId=" + userId + ", basicUnit="
				+ basicUnit + ", goodsClassId=" + goodsClassId + ", createTime=" + createTime + ", isDelete=" + isDelete
				+ ", goodsMessage=" + goodsMessage + ", goodsClassName=" + goodsClassName + ", user=" + user
				+ ", imagePath=" + imagePath + "]";
	}

	
}
