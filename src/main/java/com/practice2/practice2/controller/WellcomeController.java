package com.practice2.practice2.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WellcomeController {

    // @RequestMapping("login") this handle both post and get request set for single request
   // @RequestParam String name, ModelMap modle
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(ModelMap modelMap){
        modelMap.put("name",getUserDetais());
 //   modle.put("name",name);
  //  logger.debug("the request params is: {}" ,name);
        //System.out.println("the rquestparams is {}", name);
        return  "welcome";
    }
    private String getUserDetais(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
