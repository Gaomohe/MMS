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
        LayuiTable<User> allUser = userService.getAllUser(7, 5);
        System.out.println(allUser.getData().size());
    }
}