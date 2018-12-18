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
	public ModelAndView detailItem(Integer id) { // Spring은 파라미터명을 변수명으로 사용하면된다.
		Item item = shopService.getItemById(id); // item : 파라미터 id에 해당하는 정보를 db에서 읽어서 Item객체로 저장
		ModelAndView mav = new ModelAndView("detail");
		mav.addObject("item", item);
		return mav;
	}
}
