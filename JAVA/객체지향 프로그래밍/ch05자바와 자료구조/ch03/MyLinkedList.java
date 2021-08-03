package Chapter5.ch03;

public class MyLinkedList {

    private MyListNode head; // 맨 앞부분
    int count; //개수

    public MyLinkedList()
    {
        head = null;
        count = 0;
    }

    // 맨 마지막에 넣기
    public MyListNode addElement( String data )
    {

        MyListNode newNode; // 노드 생성
        if(head == null){  //맨 처음일때
            newNode = new MyListNode(data);
            head = newNode;
        }
        else{
            newNode = new MyListNode(data);
            MyListNode temp = head;
            while(temp.next != null)  //맨 뒤로 가서
                temp = temp.next;
            temp.next = newNode;
        }
        count++;
        return newNode;
    }

    // 중간에 넣기
    public MyListNode insertElement(int position, String data )
    {
        int i;
        // pointer 노드
        MyListNode tempNode = head;
        // 추가할 노드
        MyListNode newNode = new MyListNode(data);

        // 가능한 위치 인지 판별
        if(position < 0 || position > count ){
            System.out.println("추가 할 위치 오류 입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return null;
        }

        // 새로운 노드 넣기
        if(position == 0){  //맨 앞으로 들어가는 경우
            // 기존 head 는 newnode 의 다음 것이 된다.
            newNode.next = head;
            // 새 head 는 newnode가 된다.
            head = newNode;
        }
        else{ // 특정 위치일 경우
            // 이전 노드
            MyListNode preNode = null;
            // preNode 의 위치를 찾음
            for(i=0; i<position; i++){
                preNode = tempNode;
                // tempNode 는 실제 들어갈 위치
                tempNode = tempNode.next;

            }
            // newNode 의 다음꺼는 기존 preNode 의 다음꺼를 가리킴
            newNode.next = preNode.next;
            // 기존 preNode 의 다음꺼는 새로운 노드가 된다.
            preNode.next = newNode;
        }
        count++;
        return newNode;
    }

    public MyListNode removeElement(int position)
    {
        int i;
        MyListNode tempNode = head;

        if(position >= count ){
            System.out.println("삭제 할 위치 오류입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return null;
        }

        if(position == 0){  //맨 앞을 삭제하는
            // 새로운 head 는 기존 head 의 다음 노드
            head = tempNode.next;
        }
        else{
            // 지워질 노드의 이전 노드
            MyListNode preNode = null;
            for(i=0; i<position; i++){
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            // 지워질 노드의 이전 노드의 다음 --> 지워질 노드의 다음 노드
            preNode.next = tempNode.next;
        }
        count--;
        System.out.println(position + "번째 항목 삭제되었습니다.");

        // 삭제되는 노드 return
        return tempNode;
    }

    public String getElement(int position)
    {
        int i;
        MyListNode tempNode = head;

        if(position >= count ){
            System.out.println("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return new String("error");
        }

        if(position == 0){  //맨 앞 인 경우

            return head.getData();
        }

        for(i=0; i<position; i++){
            tempNode = tempNode.next;

        }
        return tempNode.getData();
    }

    public MyListNode getNode(int position)
    {
        int i;
        MyListNode tempNode = head;

        if(position >= count ){
            System.out.println("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return null;
        }

        if(position == 0){  //맨 인 경우

            return head;
        }

        for(i=0; i<position; i++){
            tempNode = tempNode.next;

        }
        return tempNode;
    }

    public void removeAll()
    {
        head = null;
        count = 0;

    }

    public int getSize()
    {
        return count;
    }

    public void printAll()
    {
        if(count == 0){
            System.out.println("출력할 내용이 없습니다.");
            return;
        }

        MyListNode temp = head;
        while(temp != null){
            System.out.print(temp.getData());
            temp = temp.next;
            if(temp!=null){
                System.out.print("->");
            }
        }
        System.out.println("");
    }

    public boolean isEmpty()
    {
        if(head == null) return true;
        else return false;
    }
}
