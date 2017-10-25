package cn.com.systec.service.serviceTwo;

import cn.com.systec.dao.UserDao;
import cn.com.systec.domain.User;
import cn.com.systec.service.HotelService;
import cn.com.systec.utility.ConditionList;
import cn.com.systec.utility.DbOperation;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wh on 10/23/2017.
 */
@Service
@ModelAnnotation(description = "user logger")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Page findAllUser(){
        Page page = userDao.doFindAllByPaging(0, 0);
        return page;
    }

    public void addOrUpdateOrDeleteList(List<User> list){

        List<User> oldList = userDao.doFindAll();
        //添加或修改用户
        for(int i = 0 ,j = list.size(); j>i; i++){
          int n = userDao.doCountObjectByConditions(new ConditionList().add(new Object[]{DbOperation.EQ, "id", list.get(i).getId()}).toList()) ;
          if(n>0){
              userDao.doUpdateObject(list.get(i));
          }else {
              userDao.doSaveObject(list.get(i));
          }
        }
        //删除用户
        for (User olduser:oldList ) {
            boolean isDelete = true;
            for (User user: list) {
                if(olduser.getId().equals(user.getId())){
                   isDelete = false;
                }
            }
            if(isDelete){
                userDao.doDeleteObject(olduser);
            }
        }
    }

    public void addOrUpdateOrDeleteByList(List<User> list){
        List<User> oldList = userDao.doFindAll();
        Collection c = list;
//        userDao.doSaveOrUpdateList(c);
        hibernateTemplate.merge(c);
        //删除用户
        for (User olduser:oldList ) {
            boolean isDelete = true;
            for (User user : list) {
                if (olduser.getId().equals(user.getId())) {
                    isDelete = false;
                }
            }
            if (isDelete) {
                userDao.doDeleteObject(olduser);
            }
        }
    }
}
