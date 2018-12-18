package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("item/list")
	public ModelAndView list() {
		List<Item> itemList = itemService.getItemList(); 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}

	@RequestMapping("item/create")
	public ModelAndView create() {
		return new ModelAndView("create");
	}
	
	@RequestMapping("item/detail")
	public ModelAndView detail(Integer id) {
		Item item = itemService.getItemByItemId(id);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("item", item);
		ModelAndView modelAndView = new ModelAndView("detail");
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
	
}
