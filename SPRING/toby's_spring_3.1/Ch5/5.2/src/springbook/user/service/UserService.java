package springbook.user.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

public class UserService {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMEND_FOR_GOLD = 30;

    private UserDao userDao;
    private PlatformTransactionManager transactionManager;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }

    public void upgradeLevels() throws Exception {
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
//        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
//        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
//        TransactionSynchronizationManager.initSynchronization();
//        Connection c = DataSourceUtils.getConnection(dataSource);
//        c.setAutoCommit(false); // 트랜잭션 시작

        try {
            List<User> users = userDao.getAll();

            for (User user : users) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }
//            c.commit(); // 정상적으로 작업을 마치면 트랜잭션 커밋
            this.transactionManager.commit(status);
        } catch (Exception e) {
//            c.rollback(); // 예외가 발생한다면 롤백한다.
            this.transactionManager.rollback(status);
            throw e;
        }
//        finally {
//            DataSourceUtils.releaseConnection(c, dataSource);
//            TransactionSynchronizationManager.unbindResource(this.dataSource);
//            TransactionSynchronizationManager.clearSynchronization();
//        }

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

    protected void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }
}
