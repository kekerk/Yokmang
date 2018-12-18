package logic;

import dao.UserDao;

public class ShopServiceImpl implements ShopService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void insertUser(User user) {
		userDao.insert(user);
	}

	@Override
	public User loginUser(String userId) {
		
		return userDao.select(userId);
		
	}
	
	
}
