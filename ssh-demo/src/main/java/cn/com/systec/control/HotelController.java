package cn.com.systec.control;

import cn.com.systec.core.Response;
import cn.com.systec.domain.Hotel;
import cn.com.systec.service.HotelService;
import cn.com.systec.utility.ModelAnnotation;
import cn.com.systec.utility.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wh on 10/23/2017.
 */
@RequestMapping("/hotel")
@Controller
@ModelAnnotation(description = "hotel message")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addHotel(@RequestBody Hotel hotel){
        hotelService.addHotel(hotel);
        return "添加成功";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody Response findAllHotel(){
        Page page= hotelService.findAllHotel();
        return new Response().success(page);
    }
}
