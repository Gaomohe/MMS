package com.service.Impl;

import com.dao.Impl.BillDaoImpl;
import com.pojo.Advance;
import com.pojo.Income;
import com.pojo.Spend;
import com.pojo.Transfer;
import com.service.BillService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillServiceImpl implements BillService {
    BillDaoImpl billDao = new BillDaoImpl();
    ResultData<Integer> integerResultData = new ResultData<>();
    LayuiTable<Income> listLayuiTable = new LayuiTable<>();
    LayuiTable<Spend> spendLayuiTable = new LayuiTable<>();
    LayuiTable<Advance> advanceLayuiTable = new LayuiTable<>();
    LayuiTable<Transfer> transferLayuiTable = new LayuiTable<>();
    @Override
    public LayuiTable<?> search(String[] key, String[] value) {
        ResultSet ledger = billDao.search(key, value, "ledger");

        return null;
    }

    @Override
    public ResultData<Integer> del(int[] ints) {
        try {
            for (int i : ints) {
                boolean b = billDao.delOne(i, "", "");
                if (!b){
                    integerResultData.setStatus(400);
                }else {
                    integerResultData.setStatus(200);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return integerResultData;
    }

    @Override
    public List<Income> getSupply1() {
        List<Income> list = new ArrayList<>();
        ResultSet supply1 = billDao.getSupply1();
        try {
            while (supply1.next()){
                Income income = new Income();
                income.setSupplier(supply1.getString(1));
                list.add(income);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Spend> getSupply2() {
        List<Spend> list = new ArrayList<>();
        ResultSet supply2 = billDao.getSupply2();
        try {
            while (supply2.next()){
                Spend spend = new Spend();
                spend.setSupplier(supply2.getString(1));
                list.add(spend);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Advance> getSupply3() {
        List<Advance> list = new ArrayList<>();
        ResultSet supply3 = billDao.getSupply3();
        try {
            while (supply3.next()){
                Advance advance = new Advance();
                advance.setSupplier(supply3.getString(1));
                list.add(advance);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<?> getOpera1() {
        List<?> list = new ArrayList<>();
        ResultSet kind = billDao.getKind("", "");
        try {
            // TODO: 2024-07-16

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<?> getFinance1() {
        List<?> list = new ArrayList<>();
        ResultSet kind = billDao.getKind("", "");
        try {
            // TODO: 2024-07-16

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Transfer> getFinance2() {
        List<Transfer> list = new ArrayList<>();
        ResultSet finance2 = billDao.getFinance2();
        try {
            while (finance2.next()){
                Transfer transfer = new Transfer();
                transfer.setcName(finance2.getString(1));
                list.add(transfer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<?> getAccount1() {
        List<?> list = new ArrayList<>();
        ResultSet kind = billDao.getKind("", "");
        try {
            // TODO: 2024-07-16

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Transfer> getAccount2() {
        List<Transfer> list = new ArrayList<>();
        ResultSet account2 = billDao.getAccount2();
        try {
            while (account2.next()){
                Transfer transfer = new Transfer();
                transfer.setSupName(account2.getString(1));
                list.add(transfer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public LayuiTable<Income> getAllIncome() {

        ResultSet allIncome = billDao.getAllIncome();
        List<Income> incomeList = new ArrayList<>();
        int count = 0;
        try {
            while (allIncome.next()){
                if (allIncome.getString("status")==null || !allIncome.getString("status").equals("已取药")){
                    continue;
                }
                Income income = new Income();
                income.setOrderId(allIncome.getInt(3));
                income.setMname(allIncome.getString("mName"));
                income.setKind("药品");
                income.setSpecification(allIncome.getString("specification"));
                income.setDrugFrom(allIncome.getString("goodsType"));
                income.setSupplier(allIncome.getString("supplier"));
                income.setUnit(allIncome.getString("unit"));
                income.setProductDate(allIncome.getString("productDate"));
                income.setSalePrice(allIncome.getDouble("salePrice"));
                income.setNumber(allIncome.getInt("m.number"));
                income.setOpera("张三");
                income.setFinence("无");
                income.setState("已审核");
                income.setTimes(allIncome.getString("diagnosticTime"));
                income.setAccount("无");
                count++;
                incomeList.add(income);

            }
            listLayuiTable.setData(incomeList);
            listLayuiTable.setCode(0);
            listLayuiTable.setCount(count);
            listLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return listLayuiTable;
    }

    @Override
    public LayuiTable<Advance> getAllAdvance(int page,int limit) {
        String table = "select * from quality left join dictionary on quality.tableCoding=dictionary.tableCoding where oId is not null";
        ResultSet allIncome = billDao.getAllCustomize(page,limit,table);
        ResultSet all = billDao.getAllCustomize(table);
        List<Advance> advanceList = new ArrayList<>();
        int count = 0;
        try {
            while (all.next()){
                count++;
            }

            while (allIncome.next()){
                Advance advance = new Advance();
                advance.setOrderId(allIncome.getInt("oId"));
                advance.setMname(allIncome.getString("mName"));
                advance.setKind("药品");
                advance.setSpecification(allIncome.getString("specification"));
                advance.setDrugFrom(allIncome.getString("goodsType"));
                advance.setSupplier(allIncome.getString("supplier"));
                advance.setUnit(allIncome.getString("unit"));
                advance.setProductDate(allIncome.getString("productDate"));
                advance.setBuyPrice(allIncome.getDouble("purchasePrice"));
                advance.setNumber(allIncome.getInt("totlNumber"));
                advance.setPercent("30%");
                advance.setOpera("张三");
                advance.setFinence("无");
                advance.setState("已审核");
                Date date = new Date();
                advance.setTimes(date.toString());
                advance.setAccount("无");
                advanceList.add(advance);

            }
            advanceLayuiTable.setData(advanceList);
            advanceLayuiTable.setCode(0);
            advanceLayuiTable.setCount(count);
            advanceLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return advanceLayuiTable;
    }

    @Override
    public LayuiTable<Income> search01(String[] keys,String[] values) {
        String table = "select  * from patient left join medicineorder on patient.mId = medicineorder.orderId left join dictionary on medicineorder.mId = dictionary.tableCoding where status='已取药' ";
        ResultSet allIncome = billDao.searchCustomize(keys, values, table, 1);
        List<Income> incomeList = new ArrayList<>();
        int count = 0;
        try {
            while (allIncome.next()){
                Income income = new Income();
                income.setOrderId(allIncome.getInt(3));
                income.setMname(allIncome.getString("mName"));
                income.setKind("药品");
                income.setSpecification(allIncome.getString("specification"));
                income.setDrugFrom(allIncome.getString("goodsType"));
                income.setSupplier(allIncome.getString("supplier"));
                income.setUnit(allIncome.getString("unit"));
                income.setProductDate(allIncome.getString("productDate"));
                income.setSalePrice(allIncome.getDouble("salePrice"));
                income.setNumber(allIncome.getInt("medicineorder.number"));
                income.setOpera("张三");
                income.setFinence("无");
                income.setState("已审核");
                income.setTimes(allIncome.getString("diagnosticTime"));
                income.setAccount("无");
                count++;
                incomeList.add(income);

            }
            listLayuiTable.setData(incomeList);
            listLayuiTable.setCode(0);
            listLayuiTable.setCount(count);
            listLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return listLayuiTable;
    }

    @Override
    public LayuiTable<Spend> search02(String[] keys, String[] values) {
        String sqlTable = "select * from app_order left join dictionary on app_order.aId=dictionary.mId";
        ResultSet allIncome = billDao.searchCustomize(keys,values,sqlTable,0);
//        ResultSet allCustomize = billDao.getAllCustomize(sqlTable);
        List<Spend> spendList = new ArrayList<>();
        int count = 0;
        try {
//            while (allCustomize.next()){
//                count++;
//            }
            while (allIncome.next()){
                Spend spend = new Spend();
                spend.setOrderId(allIncome.getInt(1));
                spend.setMname(allIncome.getString("mName"));
                spend.setKind("药品");
                spend.setSpecification(allIncome.getString("specification"));
                spend.setDrugFrom(allIncome.getString("goodsType"));
                spend.setSupplier(allIncome.getString("supplier"));
                spend.setUnit(allIncome.getString("unit"));
                spend.setProductDate(allIncome.getString("productDate"));
                spend.setBuyPrice(allIncome.getDouble("purchasePrice"));
                spend.setNumber(100);
                spend.setOpera("张三");
                spend.setFinence("无");
                spend.setState("已审核");
                Date date = new Date();
                spend.setTimes(date.toString());
                spend.setAccount("无");
                count++;
                spendList.add(spend);

            }
            spendLayuiTable.setData(spendList);
            spendLayuiTable.setCode(0);
            spendLayuiTable.setCount(count);
            spendLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return spendLayuiTable;
    }

    @Override
    public LayuiTable<Advance> search03(String[] keys, String[] values) {
        String table = "select * from quality left join dictionary on quality.tableCoding=dictionary.tableCoding where oId is not null";
        ResultSet allIncome = billDao.searchCustomize(keys,values,table,0);
        List<Advance> advanceList = new ArrayList<>();
        int count = 0;
        try {
            while (allIncome.next()){
                Advance advance = new Advance();
                advance.setOrderId(allIncome.getInt("oId"));
                advance.setMname(allIncome.getString("mName"));
                advance.setKind("药品");
                advance.setSpecification(allIncome.getString("specification"));
                advance.setDrugFrom(allIncome.getString("goodsType"));
                advance.setSupplier(allIncome.getString("supplier"));
                advance.setUnit(allIncome.getString("unit"));
                advance.setProductDate(allIncome.getString("productDate"));
                advance.setBuyPrice(allIncome.getDouble("purchasePrice"));
                advance.setNumber(allIncome.getInt("totlNumber"));
                advance.setPercent("30%");
                advance.setOpera("张三");
                advance.setFinence("无");
                advance.setState("已审核");
                Date date = new Date();
                advance.setTimes(date.toString());
                advance.setAccount("无");
                count++;
                advanceList.add(advance);

            }
            advanceLayuiTable.setData(advanceList);
            advanceLayuiTable.setCode(0);
            advanceLayuiTable.setCount(count);
            advanceLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return advanceLayuiTable;
    }

    @Override
    public LayuiTable<Transfer> search_transfer(String[] keys, String[] values) {
        String sql = "select * from apply where financeApprove ='已审阅通过' ";
        int count = billDao.getRow(sql, 1);
        ResultSet allTransfer = billDao.searchCustomize(keys, values, sql, 1);
        List<Transfer> transferList = new ArrayList<>();
        try {
            while (allTransfer.next()){
                Transfer transfer = new Transfer();
                transfer.setId(allTransfer.getInt(1));
                transfer.setcName(allTransfer.getString("finance"));
                transfer.setzName("医院");
                transfer.setName(allTransfer.getString("finance"));
                int applyNumber = allTransfer.getInt("applyNumber");
                double purchasePrice = allTransfer.getDouble("purchasePrice");

                transfer.setMoney(String.format("%.2f",applyNumber*purchasePrice)+"元");
                transfer.setRealMoney(String.format("%.2f",applyNumber*purchasePrice*0.3)+"元");
                transfer.setSupName(allTransfer.getString("supplier"));
                transfer.setTime(allTransfer.getString("financeTime"));
                transfer.setNote("预付款");
                transferList.add(transfer);
            }

            transferLayuiTable.setCount(count);
            transferLayuiTable.setData(transferList);
            transferLayuiTable.setMsg("");
            transferLayuiTable.setCode(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferLayuiTable;

    }

    @Override
    public LayuiTable<Spend> getAllSpend(int page,int limit) {
        String sqlTable = "select * from app_order left join dictionary on app_order.aId=dictionary.mId";
        ResultSet allIncome = billDao.getAllCustomize(page,limit,sqlTable);
        ResultSet allCustomize = billDao.getAllCustomize(sqlTable);
        List<Spend> spendList = new ArrayList<>();
        int count = 0;
        try {
            while (allCustomize.next()){
                count++;
            }
            while (allIncome.next()){
                Spend spend = new Spend();
                spend.setOrderId(allIncome.getInt(1));
                spend.setMname(allIncome.getString("mName"));
                spend.setKind("药品");
                spend.setSpecification(allIncome.getString("specification"));
                spend.setDrugFrom(allIncome.getString("goodsType"));
                spend.setSupplier(allIncome.getString("supplier"));
                spend.setUnit(allIncome.getString("unit"));
                spend.setProductDate(allIncome.getString("productDate"));
                spend.setBuyPrice(allIncome.getDouble("purchasePrice"));
                spend.setNumber(100);
                spend.setOpera("张三");
                spend.setFinence("无");
                spend.setState("已审核");
                Date date = new Date();
                spend.setTimes(date.toString());
                spend.setAccount("无");
                spendList.add(spend);

            }
            spendLayuiTable.setData(spendList);
            spendLayuiTable.setCode(0);
            spendLayuiTable.setCount(count);
            spendLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return spendLayuiTable;
    }

    @Override
    public LayuiTable<Transfer> getAllTransfer(int page,int limit) {
        String sql = "select * from apply where financeApprove ='已审阅通过' ";
        int count = billDao.getRow(sql, 1);
        List<Transfer> transferList = new ArrayList<>();
        ResultSet allTransfer = billDao.getAllTransfer(page,limit);
        try {
            while (allTransfer.next()){
                Transfer transfer = new Transfer();
                transfer.setId(allTransfer.getInt(1));
                transfer.setcName(allTransfer.getString("finance"));
                transfer.setzName("医院");
                transfer.setName(allTransfer.getString("finance"));
                int applyNumber = allTransfer.getInt("applyNumber");
                double purchasePrice = allTransfer.getDouble("purchasePrice");

                transfer.setMoney(String.format("%.2f",applyNumber*purchasePrice)+"元");
                transfer.setRealMoney(String.format("%.2f",applyNumber*purchasePrice*0.3)+"元");
                transfer.setSupName(allTransfer.getString("supplier"));
                transfer.setTime(allTransfer.getString("financeTime"));
                transfer.setNote("预付款");
                transferList.add(transfer);
            }

            transferLayuiTable.setCount(count);
            transferLayuiTable.setData(transferList);
            transferLayuiTable.setMsg("");
            transferLayuiTable.setCode(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferLayuiTable;
    }
}
