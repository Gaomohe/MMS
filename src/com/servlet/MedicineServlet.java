package com.servlet;

import com.pojo.Medicine;
import com.pojo.Menu;
import com.service.Impl.MedicineServiceImpl;
import com.service.MedicineService;
import com.util.BaseServlet;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/medicine")
public class MedicineServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return MedicineServlet.class;
    }
    MedicineService medicineService = new MedicineServiceImpl();
    //获取所有药品、、
    public ResultData<Medicine> getAllMedicine(HttpServletRequest request, HttpServletResponse response){
        List<Medicine> allMedicine = medicineService.getAllMedicine();
        return Result.resultData(allMedicine);
    }
    //药品回显,,
    public String getMedicineOne(HttpServletRequest request, HttpServletResponse response){
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        Medicine medicine = medicineService.getMedicine(tableCoding);
        HttpSession session = request.getSession();
        session.setAttribute("medicine",medicine);
        return "回显页面";
    }
    //多条件查询药品（非多轮）
    public ResultData<Medicine> getMedicineByQuery(HttpServletRequest request, HttpServletResponse response){
        String[] queries = request.getParameterValues("query");
        List<Medicine> allMedicine = medicineService.getMedicineByQuery(queries);
        return Result.resultData(allMedicine);
    }
    //修改价格时多个药品回显
    public ResultData<Medicine> getMedicineByMId(HttpServletRequest request, HttpServletResponse response){
        int mid = Integer.parseInt(request.getParameter("mid"));
        List<Medicine> allMedicine = medicineService.getMedicineByMId(mid);
        return Result.resultData(allMedicine);
    }


    //新增药品,,
    public ResultData<Medicine> addMedicine(HttpServletRequest request, HttpServletResponse response){
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
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        int i = medicineService.delMedicine(tableCoding);
        return Result.resultStatus(i);
    }
    //根据药品编号删除药品
    public ResultData<Medicine> delMedicineByMId(HttpServletRequest request, HttpServletResponse response){
        int mid = Integer.parseInt(request.getParameter("mid"));
        int i = medicineService.delMedicineByMId(mid);
        return Result.resultStatus(i);
    }
    //修改药品价格
    public ResultData<Medicine> updateMedicinePrice(HttpServletRequest request, HttpServletResponse response){
        int mid = Integer.parseInt(request.getParameter("mid"));
        Double price = Double.parseDouble(request.getParameter("salePrice"));
        Medicine medicine = new Medicine();
        medicine.setmId(mid);
        medicine.setSalePrice(price);
        int i = medicineService.updateMedicinePrice(medicine);
        return Result.resultStatus(i);
    }
    //修改养护日期
    public ResultData<Medicine> updateMedicineLastCuringDate(HttpServletRequest request, HttpServletResponse response){
        int mid = Integer.parseInt(request.getParameter("mid"));
        int i = medicineService.updateMedicineLastCuringDate(mid);
        return Result.resultStatus(i);
    }
    //修改入库时间
    public ResultData<Medicine> updateMedicineWarehousingDate(HttpServletRequest request, HttpServletResponse response){
        int tableCoding = Integer.parseInt(request.getParameter("tableCoding"));
        String warehousingDate = request.getParameter("warehousingDate");
        Medicine medicine = new Medicine();
        medicine.setWarehousingDate(warehousingDate);
        medicine.setTableCoding(tableCoding);
        int i = medicineService.updateMedicineWarehousingDate(medicine);
        return Result.resultStatus(i);
    }
    //修改库存药品数量
    /*public ResultData<Medicine> updateMedicineNumber(HttpServletRequest request, HttpServletResponse response){

        return Result.resultStatus(i);
    }*/
    //药品基本信息修改
    public ResultData<Medicine> updateMedicineBasic(HttpServletRequest request, HttpServletResponse response){
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
        medicine.setTableCoding(Integer.parseInt(request.getParameter("tableCoding")));
        int i = medicineService.updateMedicineBasic(medicine);
        return Result.resultStatus(i);
    }
}
