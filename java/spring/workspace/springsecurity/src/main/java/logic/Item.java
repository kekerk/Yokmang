package logic;




import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Item {
	private Integer id;
	@NotEmpty(message="��ǰ���� ����ϼ���") //@NotEmpty : NotNull �ǹ� + �� ���ڿ��� �ǹ�
	private String name;
	@NotNull(message="������ ����ϼ���") // ������ ���̶� NotEmpty ��� �Ұ�
	@Min(value=10, message="������ 10�� �̻� �����մϴ�.")
	@Max(value=5000000, message="������ 500���� ���ϸ� �����մϴ�.") 
	private Integer price;
	@NotEmpty(message="��ǰ ������ ����ϼ���")
	private String description;
	private String pictureUrl;
	// upload�� ������ ������ ���� -> shop-3-servlet.xml�� multipartResolver bean�� ����
	private MultipartFile picture; //<input type="file" name="picture">�� ������ ���� ����

	//getter setter toString
	
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", pictureUrl=" + pictureUrl + "]";
	}

}
