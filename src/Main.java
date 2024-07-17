import com.dao.Impl.BillDaoImpl;
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
//        ResultSet one = initDao.getOne(1, "mId", "dictionary");
        BillDaoImpl billDao = new BillDaoImpl();
        ResultSet allIncome = billDao.getAllIncome();
        try {
            if (allIncome.next()){
                System.out.println("okyyy");
            }else {
                System.out.println("杀杀杀cc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /*public static void main(String[] args) {
        int totalRecords = 157674;
        int limit = 1000;

        for (int offset = 0; offset < totalRecords; offset += limit) {
            System.out.println("SELECT * FROM `dictionary` LIMIT " + limit + " OFFSET " + offset + ";");
        }
    }*/

}