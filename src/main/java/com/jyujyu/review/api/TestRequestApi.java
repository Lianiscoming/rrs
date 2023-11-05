package com.jyujyu.review.api;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    /* Request Parameter 방식*/

    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
            /* 메소드를 정상적으로 출력하려면 postman에 값을 입력해줘야 함*/
    ) {
        return "Hello, Request Param, I am " + name + ", " + age;
    }

    // Path Variable 방식
    @GetMapping("/test/path/{name}/{age}") // 경로에 맞게 호출을 해야함
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {
        return "Hello, Path Variable, I am " + name + ", " + age;
    }

    // Request Body 방식
    @PostMapping("/test/body") // RequestBody 방식을 사용할 때는 반드시 생성자를 만들어 줘야함
    public String requestBody( // 이 방식을 제대로 요청 받기 위해서는 postman에서 body에 raw 폼에 Jason으로 입력해야함
            @RequestBody TestRequestBody request
    ) {
        return "Hello, Request Body, I am " + request.name + ", " + request.age;
    }

    public static class TestRequestBody {
        String name;
        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
