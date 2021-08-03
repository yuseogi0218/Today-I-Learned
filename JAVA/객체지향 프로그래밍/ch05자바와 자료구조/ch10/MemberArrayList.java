package Chapter5.ch10;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<>();
    }

    public MemberArrayList(int size) {
        arrayList = new ArrayList<>(size);
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberId) {
//        for (int i = 0; i<arrayList.size(); i++) {
//            Member member = arrayList.get(i);
//
//            int tempId = member.getMemberId();
//            if (tempId == memberId) {
//                arrayList.remove(i);
//                return true;
//            }
//        }

        // Iterator 활용
        Iterator<Member> ir = arrayList.iterator();

        while (ir.hasNext()) {
            Member m = ir.next();

            int tempId = m.getMemberId();
            if (tempId == memberId) {
                arrayList.remove(m);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {

        for (Member m : arrayList) {
            System.out.println(m);
        }
        System.out.println();
    }
}
