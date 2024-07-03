import com.pojo.Supplier;
import com.pojo.User;
import com.service.Impl.SupplierServlceImpl;
import com.service.Impl.UserServiceImpl;
import com.util.JDBC;
import com.util.LayuiTable;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        JDBC jdbc = new JDBC();
        SupplierServlceImpl supplierServlce = new SupplierServlceImpl();
        LayuiTable<Supplier> supplierLayuiTable = supplierServlce.selectSupplier();
        System.out.println(supplierLayuiTable);
    }
}