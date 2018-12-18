package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;

public class DetailController {
	private ShopService shopService;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping
	public ModelAndView detailItem(Integer id) { // Spring�� �Ķ���͸��� ���������� ����ϸ�ȴ�.
		Item item = shopService.getItemById(id); // item : �Ķ���� id�� �ش��ϴ� ������ db���� �о Item��ü�� ����
		ModelAndView mav = new ModelAndView("detail");
		mav.addObject("item", item);
		return mav;
	}
}
