package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;

public class IndexController {
	private ShopService shopService;	// shopService : shop-1-servlet.xml에서 shopServiceImpl 주입한 상태. 

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	@RequestMapping	// index.shop 요청시 호출할 메서드를 지정하는 어노테이션
	public ModelAndView itemList() {
		// itemList : (db에 저장되어있는) item 테이블의 모든 레코드를 저장
		
		List<Item> itemList = shopService.getItemList();	// db에서 불러온 내용 저장
		
		ModelAndView mav = new ModelAndView("index");	// view 이름을 index로 저장. /WEB-INF/view/index.jsp
		// ModelAndView 클래스에 @see ViewResolver 어노테이션이 적혀있음
		// 자동으로 컨테이너에서 viewResolver를 찾아서 주입
		// ModelAndView : View를 결정하기, View에 전달할 데이터 저장
		
		mav.addObject("itemList", itemList);	// 데이터 저장
		return mav;
	}
}
