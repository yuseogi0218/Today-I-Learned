package Chapter2.ch07;

public class UserInfoTest {
    public static void main(String[] args) {

        UserInfo userLee = new UserInfo();
        userLee.userId = "a12345";
        userLee.userPassWord = "gsadfas";
        userLee.userName = "Lee";
        userLee.phoneNumber = "01012345678";
        userLee.userAddress = "Seoul, Korea";

        System.out.println(userLee.showUserInfo());

        UserInfo userKim = new UserInfo("a123456", "shdsfgdsgs", "Kim");
        System.out.println(userKim.showUserInfo());

    }
}
