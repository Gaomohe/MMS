package com.util;

public class Result {
    //返回操作状态
    public static ResultData resultStatus(int num){
        ResultData resultData = new ResultData();
        try{
            if (num > 0){
                resultData.setMsg("操作成功");
                resultData.setStatus(200);
            }else {
                resultData.setMsg("操作失败");
                resultData.setStatus(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //返回Data数据
    public static ResultData resultData(int num,Object data){
        ResultData resultData = new ResultData();
        try{
            if (num > 0){
                resultData.setMsg("操作成功");
                resultData.setStatus(200);
                resultData.setData(data);
            }else {
                resultData.setMsg("操作失败");
                resultData.setStatus(500);
                resultData.setData(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //返回Data数据
    public static ResultData resultData(Object data){
        ResultData resultData = new ResultData();
        try{
            if (data != null){
                resultData.setMsg("操作成功");
                resultData.setStatus(200);
                resultData.setData(data);
            }else {
                resultData.setMsg("操作失败");
                resultData.setStatus(500);
                resultData.setData(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //重名验证
    //返回Data数据
    public static ResultData resultNameStatus(int num){
        ResultData resultData = new ResultData();
        try{
            if (num > 0){
                resultData.setMsg("操作成功");
                resultData.setStatus(500);
            }else {
                resultData.setMsg("操作失败");
                resultData.setStatus(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }
}
