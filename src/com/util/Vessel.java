package com.util;

import com.dao.*;
import com.dao.Impl.*;
import com.service.*;
import com.service.Impl.*;

import java.util.ArrayList;
import java.util.List;

public class Vessel {
    public static UserDao userDao = new UserDaoImpl();
    public static UserService userService = new UserServiceImpl();
    public static MenuDao menuDao = new MenuDaoImpl();
    public static MenuService menuService = new MenuServiceImpl();

    public static StockAllDao stockAllDao = new StockAllDaoImpl();
    public static StockAllService stockAllService = new StockAllServiceImpl();
    public static RoleDao roleDao = new RoleDaoImpl();
    public static RoleService roleService = new RoleServiceImpl();

    public static LogDao logDao = new LogDaoImpl();
    public static LogService logService = new LogServiceImpl();

    public static AppointService appointService = new AppointServiceImpl();
    public static AppointDao appointDao = new AppointDaoImpl();
    public static OrdersDao ordersDao = new OrdersDaoImpl();
    public static OrdersService ordersService = new OrdersServiceImpl();

    public static ShoppingService shoppingService = new ShoppingServiceImpl();

    public static StockInFormDao stockInFormDao = new StockInFormDaoImpl();
    public static StockInFormService stockInFormService = new StockInFormServiceImpl();
    public static StockOutFormDao stockOutFormDao = new StockOutFormDaoImpl();

    public static StockOutFormService stockOutFormService = new StockOutFormServiceImpl();

    public static PurchaseDao purchaseDao = new PurchaseDaoImpl();
    public static PurchaseService purchaseService = new PurchaseServiceImpl();

    public static FinancialDao financialDao = new FinancialDaoImpl();
    public static FinancialService financialService = new FinancialServiceImpl();

    public static OutpatientDao outpatientDao = new OutpatientDaoImpl();
    public static OutpatientService outpatientService = new OutpatientServiceImpl();

    public static TypeService typeService = new TypeServiceImpl();

    public static int medicineCount = 0;

    public static int patientId = 0;

    public static List<Integer> intList = new ArrayList<Integer>();

    public static MedicineDao medicineDao = new MedicineDaoImpl();
    public static MedicineService medicineService = new MedicineServiceImpl();

    public static PharmacyDao pharmacyDao = new PharmacyDaoImpl();
    public static PharmacyService pharmacyService = new PharmacyServiceImpl();

    public static List<Integer> applyIdsList;

    public static WarnDao warnDao = new WarnDaoImpl();
    public static WarnService warnService = new WarnServiceImpl();

    public static QualityService qualityService = new QualityServiceImpl();
    public static QualityDao qualityDao = new QualityDaoImpl();

    public static MessageService messageService = new MessageServiceImpl();
    public static MessageDao messageDao ;

    public static PatientDao patientDao;
    public static PatientService patientService = new PatientServiceImpl();

    public static SalReturnDao salReturnDao = new SalReturnDaoImpl();
    public static SalReturnService salReturnService = new SalReturnServiceImpl();

    public static ApplyFaileService applyFaileService = new ApplyFailedServiceImpl();
    public static ApplyFailedDao applyFailedDao = new ApplyFaileDaoImpl();

    public static FirstPageService firstPageService = new FirstPageServiceImpl();
}
