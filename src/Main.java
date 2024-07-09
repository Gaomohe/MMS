import com.dao.Impl.ShoppingDaoImpl;
import com.dao.Impl.init.InitDaoImpl;
import com.google.gson.Gson;
import com.pojo.Supplier;
import com.pojo.User;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.SupplierServlceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.MedicineService;
import com.util.JDBC;
import com.util.LayuiTable;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        InitDaoImpl initDao = new InitDaoImpl();

        String[] keys={"mName"};
        String[] value={"飞翔"};
        ResultSet apply = initDao.search(keys, value, "apply");
        try {
            if (apply.next()){
                System.out.println("okyyy");
            }else {
                System.out.println("杀杀杀cc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}