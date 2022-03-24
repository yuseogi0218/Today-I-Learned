package springbook.user.dao;

public class DaoFactory {
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());

        return userDao;
    }

//    public AccountDao accountDao() {
//        AccountDao accountDao = new AccountDao(connectionMaker());
//
//        return accountDao;
//    }
//
//    public MessageDao messageDao() {
//        MessageDao messageDao = new MessageDao(connectionMaker());
//
//        return messageDao;
//    }

    public ConnectionMaker connectionMaker() {
        // 분리해서 중복을 제거한 ConnectionMaker 타입 오브젝트 생성 코드
        return new DConnectionMaker();
    }
}
