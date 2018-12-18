package logic;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.ItemDao;
import dao.SaleDao;
import dao.SaleItemDao;
import dao.UserDao;
import exception.ShopException;
import util.CiperUtil;

/*
 * @Service = @Component(�� ���� Ŭ����) + Service ���(Controller�� Repository ������ �߰� ��ü) �ο�.
 */
@Service
public class ShopService {
	@Autowired // ��ü ����
	private ItemDao itemDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private SaleDao saleDao;

	@Autowired
	private SaleItemDao saleItemDao;

	@Autowired
	private BoardDao boardDao;

	public List<Item> getItemList() {
		return itemDao.list();
	}

	public Item getItem(Integer id) {
		return itemDao.getItemById(id);
	}

	/*
	 * 2���� ���� 1. item���̺� ���� insert�ϱ� 2. item ��ü�� picture ������ ���Ϸ� �����ϱ�
	 */
	public void itemCreate(Item item, HttpServletRequest request) {
		// ���ε�� �̹����� �ִ� ���
		if (item.getPicture() != null && !item.getPicture().isEmpty()) {
			uploadFileCreate(item.getPicture(), request, "picture"); // picture�� ������ ���Ϸ� �����ϴ� �޼���
			// db�� ������ �̸��� ����
			item.setPictureUrl(item.getPicture().getOriginalFilename());
		}
		itemDao.insert(item);
	}

	public void itemEdit(Item item, HttpServletRequest request) {

		if (item.getPicture() != null && !item.getPicture().isEmpty()) {
			uploadFileCreate(item.getPicture(), request, "picture");
			item.setPictureUrl(item.getPicture().getOriginalFilename());
		}
		itemDao.update(item);
	}

	private void uploadFileCreate(MultipartFile picture, HttpServletRequest request, String path) {
		String uploadPath = request.getServletContext().getRealPath("/") + "/" + path + "/";
		String orgFile = picture.getOriginalFilename();// ���� �̸�
		try {
			// transferTo : ������ ������ (uploadPath + orgFile)�� ���Ͽ� ����.
			picture.transferTo(new File(uploadPath + orgFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void itemDelete(Integer id) {
		itemDao.delete(id);
	}

	public void userCreate(User user) {
		String ciperemail = CiperUtil.encrypt(user.getEmail(), user.getUserId());
		user.setEmail(ciperemail);
		user.setPassword(getHashValue(user.getPassword()));
		userDao.insertUser(user);

	}

	public User selectUser(String userId) {
		User user = userDao.selectUser(userId);
		user.setEmail(CiperUtil.decrypt(user.getEmail(), user.getUserId()));
		return user;
	}

	public Sale checkEnd(User loginUser, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(saleDao.getMaxSaleId()); // �ֹ���ȣ �ڵ� ����
		sale.setUser(loginUser);// ��ǰ ���� �� ����
		sale.setUpdateTime(new Date()); // ���� ����
		List<ItemSet> itemList = cart.getItemSetList();
		// cart�� itemSet ������ saleItem ������ ��ȯ
		int i = 0;
		for (ItemSet is : itemList) {
			int saleItemId = ++i;
			SaleItem saleItem = new SaleItem(sale.getSaleId(), saleItemId, is, sale.getUpdateTime());
			sale.getItemList().add(saleItem);
		}
		saleDao.insert(sale); // sale ���̺� ���ڵ� �߰�
		List<SaleItem> saleItemList = sale.getItemList();
		for (SaleItem is : saleItemList) {
			saleItemDao.insert(is); // �ֹ���ǰ������ saleitem ���̺� �߰�
		}
		return sale;
	}

	public List<Sale> SaleList(String id) {
		return saleDao.Salelist(id);
	}

	public List<SaleItem> SaleItemlist(Integer saleId) {
		return saleItemDao.SaleItemlist(saleId);
	}

	public void update(User user) {
		String ciperemail = CiperUtil.encrypt(user.getEmail(), user.getUserId());
		user.setEmail(ciperemail);
		userDao.update(user);

	}

	public void deleteUser(String userId) {
		userDao.deleteUser(userId);

	}

	public List<User> userList() {
		List<User> list = userDao.userList();
		for(User u : list) {
			u.setEmail(CiperUtil.decrypt(u.getEmail(), u.getUserId()));
		}
		return list;
	}

	public List<User> userList(String[] idchks) {
		List<User> list =  userDao.userList(idchks);
		for(User u : list) {
			u.setEmail(CiperUtil.decrypt(u.getEmail(), u.getUserId()));
		}
		return list;
	}

	public Board selectBoard(Integer num) {
		return boardDao.selectBoard(num);
	}

	public List<Board> boardList(String searchType, String searchContent, Integer pageNum, int limit) {
		return boardDao.list(searchType, searchContent, pageNum, limit);
	}

	public int boardcount(String searchType, String searchContent) {

		return boardDao.count(searchType, searchContent);
	}

	public void write(Board board, HttpServletRequest request) { // �۾���� ��� ��� ���� ���
		int num = boardDao.maxNum();
		int ref = board.getRef();
		int reflevel = board.getReflevel();
		int refstep = board.getRefstep();
		board.setNum(++num);
		if (request.getRequestURI().contains("write")) { // �۾���(write)
			board.setRef(num);
		}
		if (request.getRequestURI().contains("reply")) { // ���(reply)
			boardDao.updateAboutRef(ref, refstep);
			board.setRef(ref);
			board.setReflevel(++reflevel);
			board.setRefstep(++refstep);
		}
		if (board.getFile1() != null && !board.getFile1().isEmpty()) {
			uploadFileCreate(board.getFile1(), request, "file");
			board.setFileurl(board.getFile1().getOriginalFilename());
		}
		boardDao.write(board);

	}

//write���� reply �и��ؼ� ��� ��
	public void reply(Board board, HttpServletRequest request) {
		int num = boardDao.maxNum();
		int ref = board.getRef();
		int reflevel = board.getReflevel();
		int refstep = board.getRefstep();
		boardDao.updateAboutRef(ref, refstep);
		board.setNum(++num);
		board.setRef(ref);
		board.setReflevel(++reflevel);
		board.setRefstep(++refstep);
		boardDao.write(board);
	}

//	public void replys(Board board, HttpServletRequest request) {
//		Board b1 = boardDao.selectBoard(board.getNum());
//		int num = boardDao.maxNum();
//		int ref=board.getRef();
//		int reflevel = board.getReflevel();
//		int refstep = board.getRefstep();
//		boardDao.updateAboutRef(ref,refstep);
//		board.setNum(++num);
//		board.setRef(ref);
//		board.setReflevel(++reflevel);
//		board.setRefstep(++refstep);
//		boardDao.write(board);
//	}
	public int maxNum() {
		return boardDao.maxNum();
	}

	public void reatCnt(int num) {
		boardDao.readcnt(num);
	}

	public void updateboard(Board board, HttpServletRequest request) {
		if (board.getFile1() != null && !board.getFile1().isEmpty()) {
			uploadFileCreate(board.getFile1(), request, "file");
			board.setFileurl(board.getFile1().getOriginalFilename());
		}
		boardDao.updateboard(board);
		
	}

	public void deleteboard(Integer num) {
		boardDao.deleteBoard(num);
		
	}

	public String getHashValue(String password){
		MessageDigest md;
		String hashvalue="";
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] plain=password.getBytes();
			byte[] hash=md.digest(plain);
			for(byte b : hash) {
				hashvalue+=String.format("%02x", b);
			}
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new ShopException("����ο� ��ȭ ���","../login.shop");
		}
		return hashvalue;
	}

}
