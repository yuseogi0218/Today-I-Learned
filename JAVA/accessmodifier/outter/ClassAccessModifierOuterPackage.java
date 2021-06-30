package org.opentutorials.javatutorials.accessmodifier.outter;
import org.opentutorials.javatutorials.accessmodifier.inner.*;

public class ClassAccessModifierOuterPackage {
// public class 이름 -> 파일의 이름 과 동일 하여야 한다.
	publicClass publicClass = new publicClass();
	
    //DefaultClass defaultClass = new DefaultClass(); -> 다른 패키지에 있는 default 클래스 -> error
}