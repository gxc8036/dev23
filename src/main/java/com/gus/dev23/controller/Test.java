package com.gus.dev23.controller;

import com.gus.dev23.init.JdbcStartupRunner;
import com.gus.dev23.service.TestService;
import com.gus.dev23.vo.Emp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
public class Test {

    private final TestService ts;
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @RequestMapping("/hello")
    public String hello(@RequestBody Map<String, Object> data) {
        return "Data received: " + data.toString();
    }

    @RequestMapping("/emp")
    public ResponseEntity<?> createEmp(@Valid @RequestBody Emp emp) {
        logger.info("emp is ready!");
        // 在此处继续您的业务逻辑，例如保存emp，下面只是一个示例响应
        return ResponseEntity.ok("Emp created with name: " + emp.toString());
    }

    @RequestMapping("/ts01")
    public List<Map<String, Object>> ts01() {
        return ts.TestService01();
    }

    @RequestMapping("/hikariCPStatus")
    public Map<String, Object> getHikariCPStatus() {
        return JdbcStartupRunner.hikariCPStatusMap;
    }
}
