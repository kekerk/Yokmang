package logic;

import java.util.List;

import dao.ItemDao;

public class ShopServiceImpl implements ShopService {
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		return itemDao.itemList();
	}

	@Override
	public Item getItemById(Integer id) {
		return itemDao.getItemById(id);
	}

}
