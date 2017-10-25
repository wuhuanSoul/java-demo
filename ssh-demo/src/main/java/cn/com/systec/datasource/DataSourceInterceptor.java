package cn.com.systec.datasource;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by wh on 10/23/2017.
 */
@Component
public class DataSourceInterceptor {
    public void setDataSourceOne(JoinPoint jp) {
        DatabaseContextHolder.setCustomerType("dataSourceTwo");
        System.out.println("==========================================setOne================================");
    }

    public void setDataSourceTwo(JoinPoint jp) {
        DatabaseContextHolder.setCustomerType("dataSourceOne");
        System.out.println("===========================setTwo===================================");
    }
}
