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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        GSPReportProServiceImpl gspReportProService = new GSPReportProServiceImpl();
        LocalDate currentDate = LocalDate.now();

        // 定义日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 格式化日期
        String formattedDate = currentDate.format(formatter);

        // 输出当前日期
        System.out.println("当前日期是: " + formattedDate);

    }

}