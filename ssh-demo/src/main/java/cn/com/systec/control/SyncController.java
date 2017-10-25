package cn.com.systec.control;

import cn.com.systec.core.Response;
import cn.com.systec.sync.SyncSunway;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wh on 10/25/2017.
 */
@RequestMapping("")
@Controller
@ModelAnnotation(description = "sync sunway user data")
public class SyncController {

    @Autowired
   private SyncSunway syncSunway;

    @RequestMapping(value = "/syncUser", method = RequestMethod.GET)
    public @ResponseBody Response syncUserByList(){
        syncSunway.syncUserByList();
        return new Response().success("同步成功");
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    public @ResponseBody Response syncUser(){
        syncSunway.syncUser();
        return new Response().success("同步成功");
    }
}
