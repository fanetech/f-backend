package fanetech.tech.fbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping(path = "string")
    public String getString(){
        return "string transmitted";
    }

    @GetMapping()
        public List<String> getList(){
        return List.of("string", "transmetted by fanetech");
    }
}
