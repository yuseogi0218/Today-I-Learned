package springbook.user.service;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

public class UserService {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMEND_FOR_GOLD = 30;

    UserDao userDao;

    // 수정자 주입
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            if (canUpgradeLevel(user)) {
                upgradeLevel(user);
            }
//            Boolean changed = null;
//            if (user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
//                user.setLevel(Level.SILVER);
//                changed = true;
//            } else if (user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
//                user.setLevel(Level.GOLD);
//                changed = true;
//            } else if (user.getLevel() == Level.GOLD) {
//                changed = false;
//            } else {
//                changed = false;
//            }
//
//            if (changed) {
//                userDao.update(user);
//            }
        }
    }

    private Boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }

    private void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }
}
