package cn.com.systec.datasource;

/**
 * Created by wh on 10/23/2017.
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<String>  contextHolder = new ThreadLocal<String>();

    /**
     * @Description: 设置数据源类型
     * @param customerType  数据库类型
     * @return void
     * @throws
     */
    public static void setCustomerType(String customerType){
        contextHolder.set(customerType);
    }
    /**
     * @Description: 获取数据源类型
     * @param
     * @return String
     * @throws
     */
    public static String getCustomerType(){
        return contextHolder.get();
    }

    /**
     * @Description: 清除数据源类型
     * @param
     * @return void
     * @throws
     */
    public static void clearCustomerType(){
        contextHolder.remove();
    }
}
