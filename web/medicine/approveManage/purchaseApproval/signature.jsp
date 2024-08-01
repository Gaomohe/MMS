<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<%= path %>/iframe/css/style.css" />
    <!-- 引入JQuery -->
    <script src="<%= path %>/iframe/js/jquery.min.js"></script>
    <!-- 引入插件 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/dropzone/5.9.3/dropzone.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jSignature/2.1.3/jSignature.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<style>
    body {
        background-color: #fff; /* 白色背景 */
        color: #333; /* 页面默认文本颜色 */
        font-family: Arial, sans-serif;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 轻微的阴影效果 */
    }
    th, td {
        border: 1px solid #ddd;
        padding: 15px;
        text-align: left;
        color: #000; /* 字体颜色设置为黑色 */
    }
    th {
        background-color: #f2f2f2; /* 表头背景颜色 */
    }
    tr:nth-child(even) {
        background-color: #f9f9f9; /* 偶数行背景颜色 */
    }
    tr:hover {
        background-color: #f1f1f1; /* 鼠标悬浮行背景颜色 */
    }
</style>
</head>
<body style="background-color: white">
<div class="title" style="margin-top: 50px">买药审批</div>
<!-- 初始，渲染带装饰的html，供用户输入文本、上传图片、生成电子签名 -->
<div id="container">
    在HTML中，要将文字居中显示，可以使用CSS样式。对于标题标签<h1>，你可以添加text-align: center;样式来实现文字居中。以下是修改后的代码：

    html
    <h1 style="color: black; text-align: center;">药品采购药师审核</h1>
    <!-- Date -->
    <div class="row" style="margin-top: 50px">
        <div class="row-input">
            <span style="color: black;width: 75px">审批人:</span>
            <input style="color: black" id="" type="text" value="${user.userName}"  readonly />
            <br>
            <span style="color: black;width: 75px">时间:</span>
            <input style="color: black" id="datetime_input" type="text" placeholder="XX March, 2023" readonly />
            <br>



        </div>
    </div>

    <!-- some text -->
    <div class="row" style="margin-bottom: 50px">
        <p style="color: black">
            药品如下:
<%--            <input--%>
<%--                    id="some_input"--%>
<%--                    type="text"--%>
<%--                    placeholder="Type anything you need here."--%>
<%--            />--%>

        </p>
        <table id="tableOne">
            <thead>
            <tr>
                <th>药品编号</th>
                <th>药品名称</th>
                <th>药品类型</th>
                <th>是否处方</th>
                <th>申请数量</th>
            </tr>
            </thead>
            <tbody>

            <!-- Add more rows as needed -->
            </tbody>
        </table>
    </div>
    <!-- signature -->
    <div class="row">
        <p style="color: black">
            请仔细查看上述申请购买药品，完成后请在下面签名。
        </p>
        <p style="color: black">请签名:</p>
        <div id="signature"></div>
        <div
                style="
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: flex-end;
          "
        >
            <div
                    class="button-upload signature-feature"
                    onclick="generateSignature()"
            >
                确认
            </div>
            <div
                    class="button-upload signature-feature"
                    onclick="clearSignature()"
            >
                清除
            </div>
        </div>
        <p>确认签名:</p>
        <div id="signature_preview"></div>
    </div>
</div>
<button class="button-upload button-convert" onclick="isOK()">
    提交
</button>
<button class="button-upload button-convert" onclick="convertHtml()">
    生成相应文档
</button>

<!--
  预览，根据html生成图片或canvas
  【html2canvas插件必须在原html存在的情况下生成，如果预览和生成同时进行会渲染出空白横线】
-->
<div id="preview_title" class="title" style="display: none">Preview</div>
<!-- 根据输入的信息生成没有装饰、带文本图片的html片段，以此直接生成canvas -->
<div id="container_preview">
    <!-- logo -->
    <%--<div class="row">
        <img id="logo" src="" alt="logo" />
    </div>--%>
    <!-- Date -->
    <%--<div class="row" style="margin-top: 50px">
        <span>Date:</span>
        <span id="date"></span>
    </div>--%>
    <!-- some text -->
    <div class="row" style="margin-bottom: 50px">
        <p>
            药品:
        </p>
        <div class="layuimini-main">
            <table id="tableTwo">
                <thead>
                <tr>
                    <th>药品编号</th>
                    <th>药品名称</th>
                    <th>药品类型</th>
                    <th>是否处方</th>
                    <th>申请数量</th>
                </tr>
                </thead>
                <tbody>

                <!-- Add more rows as needed -->
                </tbody>
            </table>
        </div>
        <p>
            审批人签字:
        </p>
    </div>
    <!-- signature -->
    <div class="row">
        <img id="signature_img" src="" alt="signature" />
    </div>
</div>
<button
        id="convert_canvas_btn"
        class="button-upload button-convert"
        style="display: none"
        onclick="convertCanvas()"
>
    将签名文件保存为PDF
</button>

<!-- PDF预览图 -->
<div id="result_preview" style="display: none">
    <div class="title">PNG</div>
    <img id="canvas_preview" style="margin: 30px 0" />
</div>
</body>

<script src="<%= path %>/iframe/js/testDataUrl.js"></script>
<script>


    // 设置 input 元素的值为格式化的日期时间字符串
    document.getElementById("datetime_input").value = getNowTime();
    // 上传图片
    Dropzone.autoDiscover = false;



    window.addEventListener('message', function(event) {
        var messageData = event.data;
        let info = JSON.parse(messageData);
        insertOne(info.data)
        insertTwo(info.data)
    }, false);

    function getOID(){
        var queryString = window.location.search;
        var urlParams = new URLSearchParams(queryString);

        // 从查询字符串中获取 oId 参数
        // 现在可以使用 oId 变量，例如打印到控制台或使用在其他逻辑中
        return urlParams.get('dataString');
    }

    //插入第一个表格数据
    function insertTwo(data){
        var tbody = document.getElementById('tableTwo').getElementsByTagName('tbody')[0];
        data.forEach(function(medicine) {
            // 创建行 <tr> 元素
            var tr = document.createElement('tr');

            // 为行添加单元格 <td> 元素，并设置文本内容
            tr.innerHTML = '<td>' + medicine.mId + '</td>' +
                '<td>' + medicine.mName + '</td>' +
                '<td>' + medicine.unit + '</td>' +
                '<td>' + medicine.defined + '</td>' +
                '<td>' + medicine.applyBuyNumber + '</td>';

            // 将创建的行添加到 tbody 中
            tbody.appendChild(tr);
        });
    }
    function insertOne(data){
        var tbody = document.getElementById('tableOne').getElementsByTagName('tbody')[0];
        data.forEach(function(medicine) {
            // 创建行 <tr> 元素
            var tr = document.createElement('tr');

            // 为行添加单元格 <td> 元素，并设置文本内容
            tr.innerHTML = '<td>' + medicine.mId + '</td>' +
                '<td>' + medicine.mName + '</td>' +
                '<td>' + medicine.unit + '</td>' +
                '<td>' + medicine.defined + '</td>' +
                '<td>' + medicine.applyBuyNumber + '</td>';

            // 将创建的行添加到 tbody 中
            tbody.appendChild(tr);
        });
    }
    function getNowTime(){
        //格式:2024-24-24 24:24:24
        // 获取当前日期和时间
        var now = new Date();

        // 格式化日期和时间
        var year = now.getFullYear();
        var month = (now.getMonth() + 1).toString().padStart(2, '0'); // 月份从0开始，需要+1并确保两位数字
        var day = now.getDate().toString().padStart(2, '0');
        var hours = now.getHours().toString().padStart(2, '0');
        var minutes = now.getMinutes().toString().padStart(2, '0');
        var seconds = now.getSeconds().toString().padStart(2, '0');
        // 拼接成所需格式
        return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds;
    }
    /*function uploadImage() {
        let upload_dropzone = new Dropzone("#dropzone", {
            url: "/",
            uploadMultiple: false,
            acceptedFiles: ".png,.jpg,.tiff,.jpeg",
            addedfile: function (file) {
                $("#hide_preview").hide();
                $("#preview").html('<div class="loader preview-img"></div>');
                $("#preview").show();
            },
            success: function (file, response, e) {
                if (response.code == 200) {
                    $("#hide_preview").hide();
                    $("#preview").html(
                        `<img src="${response.data.url}" class="preview-img">`
                    );
                    $("#preview").show();
                    // 生成预览需要转换为base64的dataUrl
                    $("#logo").prop("src", file.dataURL);
                } else {
                    alert(response.msg);
                }
            },
            error: function (e, t) {
                // alert(t);

                // 上传失败，使用本地默认图片【仅供演示用】
                $("#hide_preview").hide();
                $("#preview").html(
                    `<img src="assets/testImage.jpg" class="preview-img">`
                );
                $("#preview").show();
                // 生成预览需要转换为base64的dataUrl
                $("#logo").prop("src", testDataUrl);
            },
        });
    }*/

    /**
     * 电子签名
     */
    let signatureSrc = "";
    // 初始化
    $("#signature").jSignature({
        lineWidth: 5, // 画笔粗细
        width: "100%", // 画布宽度
        height: 196, // 画布高度：div高度减去上下2px的边框
        "background-color": "#dddddd", // 画布背景
        color: "#333333", // 画笔颜色
        UndoButton: false, // 撤销上一步按钮
        willReadFrequently: true,
    });
    // 生成签名
    function generateSignature() {
        let res = $("#signature").jSignature("getData", "svgbase64");
        console.log("jSignature Data:", res); // 打印完整的 res 数组

        // 验证数据是否存在
        if (res && res[1]) {
            signatureSrc = `data:image/svg+xml;base64,` + res[1];
            console.log("Signature Source:", signatureSrc); // 打印 signatureSrc

            let img = new Image();
            img.src = signatureSrc;

            $("#signature_preview").html(img);
            $("#signature_img").prop("src", signatureSrc);
        } else {
            console.error("Signature data is missing or invalid.");
        }
    }



    // 清空签名
    function clearSignature() {
        $("#signature").jSignature("reset");
        $("#signature_preview").html("");
        signatureSrc = "";
        $("#signature_img").prop("src", "");
    }

    function isOK(){
        shengPi(getOID())
        parent.location.reload();
        parent.layer.close(parent.layer.getFrameIndex(window.name));

    }
    function shengPi(dataString){
        $.ajax({
            url:"/purchase?action=isOk",//根据id查询的方法
            type:"post",
            data:{dataString},
            success:function(data){
                let parse = JSON.parse(data);
                if (parse.status===200){
                    layer.msg('审阅完成', {icon: 1});
                    location.reload()
                }
            }
        });

    }
    // 转换成html片段
    function convertHtml() {
        // 隐藏预览区域
        const delay = 100;
        $("#preview_title").slideUp(delay);
        $("#container_preview").slideUp(delay);
        $("#convert_canvas_btn").slideUp(delay);

        // $("#logo")图片的赋值在Dropzone插件中完成
        $("#date").html($("#date_input").val());
        $("#some").html($("#some_input").val());
        // $("#signature_img")图片的赋值在jSignature插件中完成

        // 显示预览区域
        $("#preview_title").slideDown(delay);
        $("#container_preview").slideDown(delay);
        $("#convert_canvas_btn").slideDown(delay);
        // 滚动到预览区域
        $("html, body").animate(
            {
                scrollTop: $("#preview_title").offset().top,
            },
            200
        );
    }

    // 生成PDF
    function convertCanvas() {
        html2canvas(document.querySelector("#container_preview")).then(
            (canvas) => {
                let imgUrl = canvas.toDataURL("image/png"); // 将canvas转换成img的src流
                // 预览图
                $("#canvas_preview").prop("src", imgUrl);
                $("#result_preview").slideDown(100);
                $("html, body").animate(
                    {
                        scrollTop: $("#preview_title").offset().top,
                    },
                    200
                );
                // PDF 参考链接：https://cloud.tencent.com/developer/ask/142386/answer/101908574
                // 创建文件
                let doc = new jsPDF();
                // 图片在文件中的边距（0.1 => 10%）：左右共0.1、上下共0.1
                const margin = 0.1;
                // 获取图片宽高
                const imgWidth = canvas.width;
                const imgHeight = canvas.height;
                // 计算文件除去边距后剩余的可填充区域宽高
                const docWidth = doc.internal.pageSize.width * (1 - margin);
                const docHeight = doc.internal.pageSize.height * (1 - margin);
                // 计算可填充区域左上角坐标
                const x = doc.internal.pageSize.width * (margin / 2);
                const y = doc.internal.pageSize.height * (margin / 2);
                // 计算可填充区域和待填充图片的宽高比：找出图片的较短边
                const widthRatio = docWidth / imgWidth;
                const heightRatio = docHeight / imgHeight;
                // 按较短边比例缩放图片
                const ratio = Math.min(widthRatio, heightRatio);
                const w = imgWidth * ratio;
                const h = imgHeight * ratio;
                // 调用插件函数填充图片
                doc.addImage(imgUrl, "JPEG", x, y, w, h);
                // 触发下载保存
                doc.save("Your File.pdf");
            }
        );
    }
</script>
<script type="text/javascript" src="<%=basePath%>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>medicinejs/approveManage/purchaseApproval/signature.js" charset="UTF-8"></script>
</html>
