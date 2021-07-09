package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //controller annotation 필수
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // templates/hello.html 화면 실행 시켜라 ( Thymeleaf 템플릿 엔진 처리)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // 해당 모델은 view에서 렌더링 할때 쓰임
        model.addAttribute("name", name); // key : value
        return "hello-template"; // hello-template으로 이동 됨.
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body에 데이터를 직접 넣어준다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 넘겨줌
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
