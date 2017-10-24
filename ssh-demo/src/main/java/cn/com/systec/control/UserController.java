package cn.com.systec.control;

import cn.com.systec.core.Response;
import cn.com.systec.domain.Hotel;
import cn.com.systec.service.serviceTwo.UserService;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wh on 10/23/2017.
 */
@RequestMapping("/user")
@Controller
@ModelAnnotation(description = "user message")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Response findAllHotel(){
        Page page= userService.findAllUser();
        return new Response().success(page);
    }
}