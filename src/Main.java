import com.dao.Impl.BillDaoImpl;
import com.dao.Impl.ShoppingDaoImpl;
import com.dao.Impl.init.InitDaoImpl;
import com.google.gson.Gson;
import com.pojo.Supplier;
import com.pojo.User;
import com.pojo.echarts.Times;
import com.service.Impl.GSPReportProServiceImpl;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.SupplierServlceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.MedicineService;
import com.util.JDBC;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,4,4,4,5,5,6};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]==arr[j]){
                    System.out.print(arr[j]);
                }else {
                    i = j-1;
                    System.out.println("");
                    break;
                }
            }
        }


    }

}