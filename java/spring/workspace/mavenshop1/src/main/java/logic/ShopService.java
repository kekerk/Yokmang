package logic;

import java.util.List;

public interface ShopService {
	List<Item> getItemList();

	Item getItemById(Integer id);
}
