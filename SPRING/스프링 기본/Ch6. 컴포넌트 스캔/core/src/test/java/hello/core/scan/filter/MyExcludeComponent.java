package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // class 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
