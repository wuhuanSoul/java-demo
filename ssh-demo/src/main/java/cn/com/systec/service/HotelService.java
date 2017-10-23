package cn.com.systec.service;

import cn.com.systec.dao.HotelDao;
import cn.com.systec.domain.Hotel;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wh on 10/23/2017.
 */

@Service
@ModelAnnotation(description = "hotel logger")
public class HotelService {

    @Autowired
    private HotelDao hotelDao;

    public void addHotel(Hotel hotel){
        hotelDao.doSaveObject(hotel);
    }

    public Page findAllHotel(){
        Page page = hotelDao.doFindAllByPaging(0, 0);
        return page;
    }
}
