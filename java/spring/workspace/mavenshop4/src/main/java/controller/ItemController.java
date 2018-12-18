package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ShopService;
// �ϳ��� Controller �ȿ��� @RequestMapping�� ���� ���� Controller ��� ���
/*
 * @Controller = @Component(���� ��üȭ) + Controller ��� �ο�.
 */
@Controller
public class ItemController {
	@Autowired
	private ShopService service;

	
	@RequestMapping("item/list")
	public ModelAndView list() {
		// itemList  : Item ���̺��� ��� ���ڵ带 �����ϰ� �ִ� List ��ü
		List<Item> itemList = service.getItemList(); 
		//��ü�� view������ ����
		ModelAndView mav = new ModelAndView(); //view ��� ���� : "item/list"�� �⺻ view 
		// /WEB-INF/view/item/list.jsp
		mav.addObject("itemList",itemList);
		return mav;
	}

	// @RequestMapping("item/*") 
	@RequestMapping("item/*") //itemController�� �˻��Ͽ� detail �κ� �޼��带 ã��.
	public ModelAndView detail(Integer id) { //id �Ķ���� ���� ������.(�Ķ���� �̸��� �Ű����� �̸��� ���ƾ� ��)
		/*
		 * �Ű������� HttpServletRequest request�� �����ϸ� 
		 * String id = request.getParameter("id");�� request��ü�� id��� ������ ���� �� �ʱ�ȭ�� �ؾ��Ѵ�.
		 */
		Item item = service.getItem(id);
		ModelAndView mav = new ModelAndView(); //view ��� ���� : "item/detail"�� �⺻ view 
		// /WEB-INF/view/item/detail.jsp
		mav.addObject("item",item);//setAttribute ���
		return mav;
	}
	
	@RequestMapping("item/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("item/add"); //Mapping��� method���� �ٸ��Ƿ�  new ModelAndView("item/add") �� �Ѵ�.
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping("item/register")
	public ModelAndView register(@Valid Item item, BindingResult bindResult, HttpServletRequest request) {
		// item ��ü : �Ķ���� ������ ���ε�� ���� ������ ����
		// @Valid : ��ȿ�� ����. Item Ŭ������ ���ǵ� �������� ������ ��. @Valid ������̼��� �������� ������ ��ȿ�� ������ ���� ����.
		ModelAndView mav = new ModelAndView("item/add"); 
		if(bindResult.hasErrors()) {
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		service.itemCreate(item,request); //upload ��ġ������ request ������
		mav.setViewName("redirect:/item/list.shop");
		return mav;
	}
	
	@RequestMapping("item/update")
	public ModelAndView update(@Valid Item item, BindingResult bindResult, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("item/edit"); 
		if(bindResult.hasErrors()) {
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		service.itemEdit(item,request); 
		mav.setViewName("redirect:/item/list.shop");
		return mav;
	}
	
	@RequestMapping("item/delete")
	public ModelAndView delete(Integer id) {
		ModelAndView mav = new ModelAndView(); 
		service.itemDelete(id); 
		mav.setViewName("redirect:/item/list.shop");
		return mav;
	}
	
}
