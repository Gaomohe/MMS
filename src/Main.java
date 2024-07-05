import com.dao.Impl.ShoppingDaoImpl;
import com.pojo.Supplier;
import com.pojo.User;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.SupplierServlceImpl;
import com.service.Impl.UserServiceImpl;
import com.service.MedicineService;
import com.util.JDBC;
import com.util.LayuiTable;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        ShoppingDaoImpl shoppingDao = new ShoppingDaoImpl();
        ResultSet str = shoppingDao.likeSelect("蓝");
        try {
            if (str.next()){
                System.out.println("ok");
            }else {
                System.out.println("no");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}