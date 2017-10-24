package cn.com.systec.service.serviceTwo;

import cn.com.systec.dao.UserDao;
import cn.com.systec.datasource.DatabaseContextHolder;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wh on 10/23/2017.
 */
@Service
@ModelAnnotation(description = "user logger")
public class UserService {

    @Autowired
    private UserDao userDao;

    public Page findAllUser(){
        Page page = userDao.doFindAllByPaging(0, 0);
        return page;
    }
}
