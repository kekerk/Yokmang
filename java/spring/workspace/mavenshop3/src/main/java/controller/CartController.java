package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Sale;
import logic.ShopService;
import logic.User;

@Controller
public class CartController {
	@Autowired
	ShopService service;
	
	@RequestMapping("cart/cartAdd")
	public ModelAndView add(Integer id, Integer quantity, HttpSession session) { //cart�� �������κ��� ���
		// selectedItem : ��ǰID������ Item ��ü�� db���� �о Item ���� ����
		
		Item selectedItem = service.getItem(id);
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null) { //��ϵ� ��ٱ��� ��ǰ�� ����.
			cart = new Cart();
			session.setAttribute("CART", cart); //empty Cart ��ü�� session�� ����
		}
		cart.push(new ItemSet(selectedItem,quantity));  
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message",selectedItem.getName()+" "+quantity+"���� ��ٱ��Ͽ� �߰�");
		mav.addObject("cart",cart);
		return mav;
	
	
	}
	@RequestMapping("cart/cancel")
	public ModelAndView cancel(Integer index, HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART");
		ModelAndView mav = new ModelAndView("cart/cart");
		int idx = index;
		ItemSet delete = null;
		try {
			delete = cart.getItemSetList().remove(idx);
			mav.addObject("message",delete.getItem().getName()+"��ǰ�� ��ٱ��Ͽ��� ������");
		}catch(Exception e) {
			mav.addObject("message","��ǰ�� ��ٱ��Ͽ��� ���� ����");
		}
		mav.addObject("cart",cart);
		return mav;
	}
	
	@RequestMapping("cart/cartView")
	public ModelAndView cartView(HttpSession session) throws CartEmptyException {
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null || cart.isEmpty()) { //��ϵ� ��ٱ��� ��ǰ�� ����.
			throw new CartEmptyException ("��ٱ��Ͽ� item�� �����ϴ�.","../item/list.shop");
		}
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart",cart);
		mav.addObject("message","��ٱ��Ͽ� �����߽��ϴ�.");
		return mav;
	}
	/*
	 * checkout : view���� checkout���� ������.
	 */
	@RequestMapping("cart/checkout")
	public String checkout(HttpSession session) {	//CartAspect AOP ����� �Ǵ� �ٽ� �޼���
		return "cart/checkout";
		
	}
	//�ֹ� Ȯ��
	//1. �ֹ����̺� �ش� ���� ����
	//2. ��ٱ����� ��ǰ ����
	@RequestMapping("cart/end") 
	public ModelAndView checkend(HttpSession session) { //CartAspect AOP ����� �Ǵ� �ٽ� �޼���
		ModelAndView mav = new ModelAndView();
		Cart cart = (Cart) session.getAttribute("CART");
		User loginUser = (User) session.getAttribute("loginUser");
		// sale : ���Ű�����, ���Ż�ǰ���� ���� ������ ��ü
		Sale sale = service.checkEnd(loginUser,cart);//�ֹ���ǰ�� db�� �����ϱ�
		List<ItemSet> itemSetList = cart.getItemSetList();
		int tot = cart.getTotalAmount();
		cart.clearAll(session);//��ٱ��� ����
		mav.addObject("sale",sale);
		mav.addObject("totalAmount", tot);
		return mav;
	}
}
