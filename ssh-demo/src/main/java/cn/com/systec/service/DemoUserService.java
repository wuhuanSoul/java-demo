package cn.com.systec.service;

import cn.com.systec.dao.DemoUserDao;
import cn.com.systec.domain.User;
import cn.com.systec.utility.ModelAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wh on 10/25/2017.
 */
@Service
@ModelAnnotation(description = "database is demo_test by tb_user")
public class DemoUserService {

    @Autowired
    private DemoUserDao DemoUserDao;

    public List<User> findAll(){
       List<User> userList =  DemoUserDao.doFindAll();
       return userList;
    }
}
