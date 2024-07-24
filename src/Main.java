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
        // 获取当前时间
        Date currentDate = new Date();

        // 创建一个日期格式化对象，设置格式为年月日时分秒
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        // 将当前时间格式化为字符串
        String formattedDate = dateFormat.format(currentDate);

        // 打印格式化后的日期字符串
        System.out.println("格式化的日期：" + formattedDate);

        // 如果需要将日期转换为整数，可以去掉格式化字符串中的分隔符
        SimpleDateFormat dateFormatToInt = new SimpleDateFormat("yyyyMMddHHmmss");
        long formattedDateToInt = Long.parseLong(dateFormatToInt.format(currentDate));

        // 打印转换为整数的日期
        System.out.println("转换为整数的日期：" + formattedDateToInt);

    }

}