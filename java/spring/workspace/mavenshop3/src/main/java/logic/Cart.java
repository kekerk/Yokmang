package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class Cart {
	private List<ItemSet> itemSetList = new ArrayList<ItemSet>(); // ��ǰ ���

	public List<ItemSet> getItemSetList() {
		return itemSetList; //���� ��ٱ��Ͽ� ��ϵ� ���
	}

	public void push(ItemSet itemSet) { //��ٱ��Ͽ� ���� ���
		for (ItemSet is : itemSetList) {
			if (is.getItem().getId() == itemSet.getItem().getId()) { //�߰� ���� ���� ���
				is.setQuantity(is.getQuantity() + itemSet.getQuantity());
				return;
			}
		}
		itemSetList.add(itemSet);
	}

	public void deleteitem(ItemSet itemSet) {
		itemSetList.remove(itemSet);
	}

	public boolean isEmpty() {
		
		return itemSetList == null || itemSetList.size()==0;
	}

	public void setItemSetList(List<ItemSet> itemSetList) {
		this.itemSetList = itemSetList;
	}
	
	
	public int getTotalAmount() {
		int sum = 0;
		for(ItemSet is : itemSetList) {
			sum = sum + (is.getQuantity()*is.getItem().getPrice());
		}
		return sum;
	}

	public void clearAll(HttpSession session) {
		itemSetList = new ArrayList<ItemSet>();
		session.setAttribute("CART", this);
	}
}
