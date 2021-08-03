package Chapter5.ch10;

public class MemberArrayListTest {
    public static void main(String[] args) {

        MemberArrayList memberArrayList = new MemberArrayList();

        memberArrayList.addMember(new Member(1001, "이순신"));
        memberArrayList.addMember(new Member(1002, "김유신"));
        memberArrayList.addMember(new Member(1003, "강감찬"));
        memberArrayList.addMember(new Member(1004, "홍길동"));

        memberArrayList.showAllMember();

        memberArrayList.removeMember(1002);
        memberArrayList.showAllMember();
    }
}
