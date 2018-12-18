package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;

public class IndexController {
	private ShopService shopService;	// shopService : shop-1-servlet.xml���� shopServiceImpl ������ ����. 

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping	// index.shop ��û�� ȣ���� �޼��带 �����ϴ� ������̼�
	public ModelAndView itemList() {
		// itemList : (db�� ����Ǿ��ִ�) item ���̺��� ��� ���ڵ带 ����
		
		List<Item> itemList = shopService.getItemList();	// db���� �ҷ��� ���� ����
		
		ModelAndView mav = new ModelAndView("index");	// view �̸��� index�� ����. /WEB-INF/view/index.jsp
		// ModelAndView Ŭ������ @see ViewResolver ������̼��� ��������
		// �ڵ����� �����̳ʿ��� viewResolver�� ã�Ƽ� ����
		// ModelAndView : View�� �����ϱ�, View�� ������ ������ ����
		
		mav.addObject("itemList", itemList);	// ������ ����
		return mav;
	}
}
