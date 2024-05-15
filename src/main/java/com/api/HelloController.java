package com.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
 
  @RequestMapping("/java")
  public static void main(String[] args) {

      System.out.println("helloWorld!!!");
  }
 
  @RequestMapping("/web")
  public String reHello() {
    List<Map<String,Object>> t = new ArrayList<Map<String,Object>>();
      for (int i = 0; i < t.size(); i++) {

      }
      for(Map<String,Object> n : t){
        n.get("1");
      }
      return "helloword!!!!!!!!!!!!!!!!!!!!!";
  }
}