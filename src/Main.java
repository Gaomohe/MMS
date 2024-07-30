import com.dao.Impl.BillDaoImpl;
import com.dao.Impl.ShoppingDaoImpl;
import com.dao.Impl.init.InitDaoImpl;
import com.google.gson.Gson;
import com.pojo.*;
import com.pojo.echarts.Times;
import com.service.Impl.GSPReportProServiceImpl;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.SupplierServlceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.MedicineService;
import com.util.*;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.util.Vessel.*;

public class Main {
    public static void main(String[] args) {
        String key[]={"manufactor","rName"};
        String value[]= {"江西","药"};
        String table = "(SELECT\n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber,\n" +
                "    q.statue,\n" +
                "    q.storageStatus,\n" +
                "    q.id\n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q\n" +
                "ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0 ) AS a";
        String sql = SQLtoString.getSQL(key, value, table);
        String sql1 = "select * from ("+sql+") as b limit 0,10";
        System.out.println(sql1);

    }


}