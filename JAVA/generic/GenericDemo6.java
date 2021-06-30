package org.opentutorials.javatutorials.generic;
/*
 * ���ʸ��� ����
 * <������ Ÿ�� extends �θ�Ŭ���� or interface>
 *     -> ���ʸ� �ν��Ͻ�ȭ �Ҷ� �θ�Ŭ���� or interface�� �ڽ� or ����ȭ ��Ų Ŭ���� �� ������ Ÿ������ ���� ����
 */
abstract class Info6{
    public abstract int getLevel();
}
class EmployeeInfo6 extends Info6{
    public int rank;
    EmployeeInfo6(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person6<T extends Info6>{ // ������ Ÿ�� T �� Info6�� �ڽĵ�θ� ���� �ϵ��� ����
    public T info;
    Person6(T info){
    	this.info = info; 
    	info.getLevel(); // Info6�� ��ӹ޾ұ� ������ ����?
    	}
}
public class GenericDemo6 {
    public static void main(String[] args) {
        Person6<EmployeeInfo6> p1 = new Person6<EmployeeInfo6>(new EmployeeInfo6(1)); //<EmployeeInfo6> �� Info6�� �ڽ��̱� ������ ����
        //Person6<String> p2 = new Person6<String>("����"); // <String> �� Info6�� �ڽ��� �ƴϱ� ������ error
    }
}