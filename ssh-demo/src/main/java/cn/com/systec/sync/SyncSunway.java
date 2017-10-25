package cn.com.systec.sync;

import cn.com.systec.domain.User;
import cn.com.systec.service.DemoUserService;
import cn.com.systec.service.serviceTwo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wh on 10/25/2017.
 */
@Component
public class SyncSunway {

    @Autowired
    private UserService userService;

    @Autowired
    private DemoUserService demoUserService;

    public void syncUser(){
        List<User> newList = demoUserService.findAll();
        userService.addOrUpdateOrDeleteList(newList);
    }

    public void syncUserByList(){
        List<User> newList = demoUserService.findAll();
        userService.addOrUpdateOrDeleteByList(newList);
    }
}
