package Chapter3.ch13.domain.userinfo.dao.mysql;

import Chapter3.ch13.domain.userinfo.UserInfo;
import Chapter3.ch13.domain.userinfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into MySQL DB user ID = " + userInfo.getUserID());

    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update into MySQL DB user ID = " + userInfo.getUserID());

    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete into MySQL DB user ID = " + userInfo.getUserID());

    }
}
