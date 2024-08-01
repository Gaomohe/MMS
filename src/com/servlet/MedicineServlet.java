package com.servlet;

import com.pojo.Medicine;
import com.pojo.Menu;
import com.pojo.Type;
import com.pojo.User;
import com.service.Impl.MedicineServiceImpl;
import com.service.Impl.TypeServiceImpl;
import com.service.MedicineService;
import com.service.TypeService;
import com.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/medicine")
public class MedicineServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return MedicineServlet.class;
    }
    MedicineService medicineService = new MedicineServiceImpl();
    TypeService typeService  = new TypeServiceImpl();
    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","获取所有按钮");
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
        HttpSession session3 = request.getSession();
        HttpSession session4 = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        List<Type> allGoodsType = typeService.getAllGoodsType();
        List<Type> allMType = typeService.getAllMType();
        List<Type> allfreeType = typeService.getAllfreeType();
        List<Type> alldosage = typeService.getAlldosage();
        session.setAttribute("menuList",menuList);
        session1.setAttribute("type1",allGoodsType);
        session2.setAttribute("type2",allMType);
        session3.setAttribute("type3",allfreeType);
        session4.setAttribute("type4",alldosage);
        return "medicine/medicineManage/medDictionary/dictionary";
    }
    //获取所有药品、、
    public LayuiTable<Medicine> getAllMedicine(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","获取所有药品");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        int i = medicineService.getAllMedicine();
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        if (order==null){
            List<Medicine> allMedicine = medicineService.getAllMedicine(page,limit);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(allMedicine);
            layuiTable.setMsg("操作成功");
        }else {
            List<Medicine> allMedicine = medicineService.getAllMedicine(page,limit,order,sort);
            layuiTable.setCode(0);
            layuiTable.setCount(i);
            layuiTable.setData(allMedicine);
            layuiTable.setMsg("操作成功");
        }
        return layuiTable;
    }
    //药品回显,,
    public String getMedicineOne(HttpServletRequest request, HttpServletResponse response){
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        Medicine medicine = medicineService.getMedicine(tableCoding);
        HttpSession session = request.getSession();
        session.setAttribute("medicine",medicine);
        return "medicine/medicineManage/medDictionary/dictionaryInfo";
    }
    //通过名称获取药品信息
    public ResultData<Medicine> getMedicineByName(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","通过名称获取药品信息");
        String mName = request.getParameter("mName");
        List<Medicine> medicine = medicineService.getMedicine(mName);
        return Result.resultData(medicine);
    }
    //多条件查询药品（非多轮）
    public ResultData<Medicine> getMedicineByQuery(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","多条件查询药品（非多轮）");
        String select1 = request.getParameter("select1");
        String select2 = request.getParameter("select2");
        String select3 = request.getParameter("select3");
        String select4 = request.getParameter("select4");
        String[] queries = {select1,select2,select3,select4};
        List<Medicine> allMedicine = medicineService.getMedicineByQuery(queries);
        return Result.resultData(allMedicine);
    }
    //多条件查询药品（多轮查询）
    public ResultData<Medicine> getMedicineByQuerys(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","多条件查询药品（多轮查询）");
        String[] querie1s = request.getParameterValues("query1");
        String[] querie2s = request.getParameterValues("query2");
        String[] querie3s = request.getParameterValues("query3");
        String[] querie4s = request.getParameterValues("query4");
        List<Medicine> allMedicine = medicineService.getMedicineByQuerys(querie1s,querie2s,querie3s,querie4s);
        return Result.resultData(allMedicine);
    }
    //修改价格时多个药品回显,,
    public ResultData<Medicine> getMedicineByMId(HttpServletRequest request, HttpServletResponse response){
        int mid = Integer.parseInt(request.getParameter("mid"));
        List<Medicine> allMedicine = medicineService.getMedicineByMId(mid);
        return Result.resultData(allMedicine);
    }
    //新增药品,,
    public ResultData<Medicine> addMedicine(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","新增药品");
        Medicine medicine = new Medicine();
        medicine.setmId(Integer.parseInt(request.getParameter("mid")));
        medicine.setmName(request.getParameter("mName"));
        medicine.setSpecification(request.getParameter("specification"));
        medicine.setManufactor(request.getParameter("manufactor"));
        medicine.setUnit(request.getParameter("unit"));
        medicine.setDepartment(request.getParameter("department"));
        medicine.setPosition(request.getParameter("position"));
        medicine.setNumber(Integer.parseInt(request.getParameter("number")));
        medicine.setBatchNumber(request.getParameter("batchNumber"));
        medicine.setUsefulLife(request.getParameter("usefulLife"));
        medicine.setPurchasePrice(Integer.parseInt(request.getParameter("purchasePrice")));
        medicine.setSalePrice(Integer.parseInt(request.getParameter("salePrice")));
        medicine.setProductDate(request.getParameter("productDate"));
        medicine.setProfits(request.getParameter("profits"));
        medicine.setCode(request.getParameter("code"));
        medicine.setGoodsType(request.getParameter("goodsType"));
        medicine.setmType(request.getParameter("mType"));
        medicine.setDefined(request.getParameter("defined"));
        medicine.setSupplier(request.getParameter("supplier"));
        medicine.setWarehousingDate(request.getParameter("warehousingDate"));
        medicine.setLocationDescription(request.getParameter("locationDescription"));
        medicine.setSign(request.getParameter("sign"));
        medicine.setWarehousingRemarks(request.getParameter("warehousingRemarks"));
        medicine.setDrugFrom(request.getParameter("drugFrom"));
        medicine.setHandlingInformation(request.getParameter("handlingInformation"));
        medicine.setApprovalNumber(request.getParameter("approvalNumber"));
        medicine.setLastCuringDate(request.getParameter("LastCuringDate"));
        medicine.setTimesStorage(Integer.parseInt(request.getParameter("timesStorage")));
        medicine.setDocumentNumber(request.getParameter("documentNumber"));
        medicine.setPlaceOrigin(request.getParameter("placeOrigin"));
        medicine.setBatchsNumber(request.getParameter("batchsNumber"));
        medicine.setRecordNumber(Integer.parseInt(request.getParameter("recordNumber")));
        int i = medicineService.addMedicine(medicine);
        return Result.resultStatus(i);
    }
    //删除药品
    public ResultData<Medicine> delMedicine(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","删除药品");
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        int i = medicineService.delMedicine(tableCoding);
        return Result.resultStatus(i);
    }
    //根据药品编号删除药品
    public ResultData<Medicine> delMedicineByMId(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","根据药品编号删除药品");
        int mid = Integer.parseInt(request.getParameter("mid"));
        int i = medicineService.delMedicineByMId(mid);
        return Result.resultStatus(i);
    }
    //修改药品价格,,
    public ResultData<Medicine> updateMedicinePrice(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","修改药品价格");
        int mid = Integer.parseInt(request.getParameter("tableCoding"));
        Double price = Double.parseDouble(request.getParameter("price"));
        Medicine medicine = new Medicine();
        medicine.setTableCoding(mid);
        medicine.setSalePrice(price);
        int i = medicineService.updateMedicinePrice(medicine);
        return Result.resultStatus(i);
    }
    //修改养护日期,,
    public ResultData<Medicine> updateMedicineLastCuringDate(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","修改养护日期");
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        int i = medicineService.updateMedicineLastCuringDate(tableCoding);
        return Result.resultStatus(i);
    }
    //修改入库时间,,
    public ResultData<Medicine> updateMedicineWarehousingDate(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","修改入库时间");
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        String warehousingDate = request.getParameter("warehousingDate");
        Medicine medicine = new Medicine();
        medicine.setWarehousingDate(warehousingDate);
        medicine.setTableCoding(tableCoding);
        int i = medicineService.updateMedicineWarehousingDate(medicine);
        return Result.resultStatus(i);
    }
    //药品基本信息修改,,
    public ResultData<Medicine> updateMedicineBasic(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","药品基本信息修改");
        Medicine medicine = new Medicine();
        medicine.setmId(Integer.parseInt(request.getParameter("mid")));
        medicine.setmName(request.getParameter("mName"));
        medicine.setSpecification(request.getParameter("specification"));
        medicine.setManufactor(request.getParameter("manufactor"));
        medicine.setUnit(request.getParameter("unit"));
        medicine.setDepartment(request.getParameter("department"));
        medicine.setPosition(request.getParameter("position"));
        medicine.setNumber(Integer.parseInt(request.getParameter("number")));
        medicine.setBatchNumber(request.getParameter("batchNumber"));
        medicine.setUsefulLife(request.getParameter("usefulLife"));
        medicine.setPurchasePrice(Double.parseDouble(request.getParameter("purchasePrice")));
        medicine.setSalePrice(Double.parseDouble(request.getParameter("salePrice")));
        medicine.setProductDate(request.getParameter("productDate"));
        medicine.setProfits(request.getParameter("profits"));
        medicine.setCode(request.getParameter("code"));
        medicine.setGoodsType(request.getParameter("goodsType"));
        medicine.setmType(request.getParameter("mType"));
        medicine.setDefined(request.getParameter("defined"));
        medicine.setSupplier(request.getParameter("supplier"));
        medicine.setWarehousingDate(request.getParameter("warehousingDate"));
        medicine.setLocationDescription(request.getParameter("locationDescription"));
        medicine.setSign(request.getParameter("sign"));
        medicine.setWarehousingRemarks(request.getParameter("warehousingRemarks"));
        medicine.setDrugFrom(request.getParameter("drugFrom"));
        medicine.setHandlingInformation(request.getParameter("handlingInformation"));
        medicine.setApprovalNumber(request.getParameter("approvalNumber"));
        medicine.setLastCuringDate(request.getParameter("LastCuringDate"));
        medicine.setTimesStorage(Integer.parseInt(request.getParameter("timesStorage")));
        medicine.setDocumentNumber(request.getParameter("documentNumber"));
        medicine.setPlaceOrigin(request.getParameter("placeOrigin"));
        medicine.setBatchsNumber(request.getParameter("batchsNumber"));
        medicine.setRecordNumber(Integer.parseInt(request.getParameter("recordNumber")));
        medicine.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        int i = medicineService.updateMedicineBasic(medicine);
        return Result.resultStatus(i);
    }

    //库存锁定
    public ResultData<Medicine> updateMedicineNumber(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","库存锁定");
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        int num = Integer.parseInt(request.getParameter("num"));//开药的数量
        int patientId = Integer.parseInt(request.getParameter("patient"));//患者ID
        Medicine medicine = new Medicine();
        medicine.setTableCoding(tableCoding);
        int i = medicineService.updateMedicineNumber(medicine, num, patientId);
        return Result.resultStatus(i);
    }

    //库存回滚
    public ResultData<Medicine> rollBack(HttpServletRequest request,HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        int pId = Integer.parseInt(request.getParameter("pId"));
        logService.setLog(name9,"点击","药品管理","库存回滚");
        int i = medicineService.rollBack(pId);
        return Result.resultStatus(i);
    }
    //更新药品付款状态
    public ResultData<Medicine> updateDic_Num(HttpServletRequest request,HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","药品管理","更新药品付款状态");
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        int patientId = Integer.parseInt(request.getParameter("patientId"));//患者ID
        int i = medicineService.updateDic_Num(tableCoding,patientId);
        return Result.resultStatus(i);
    }

}
