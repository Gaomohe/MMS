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
</head>
<body>
<div class="title" style="margin-top: 50px">买药审批</div>
<!-- 初始，渲染带装饰的html，供用户输入文本、上传图片、生成电子签名 -->
<div id="container">
    <!-- logo -->
    <div class="row">
        <div class="drop-div">
            <div id="dropzone" class="dropzone dropzone-div">
                <div class="dz-message needsclick" style="height: 100%">
                    <div
                            id="preview"
                            style="display: none"
                            class="preview-wrap"
                    ></div>
                    <div id="hide_preview" class="drop-no-img">
                        <div style="font-size: 16px; color: #d8152a">Logo</div>
                        <div class="button-upload" onclick="uploadImage()">Upload</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Date -->
    <div class="row" style="margin-top: 50px">
        <div class="row-input">
            <span>Date:</span>
            <input id="date_input" type="text" placeholder="XX March, 2023" />
        </div>
    </div>
    <!-- some text -->
    <div class="row" style="margin-bottom: 50px">
        <p>
            对于一下药品:
            <input
                    id="some_input"
                    type="text"
                    placeholder="Type anything you need here."
            />

        </p>
        <div class="layuimini-main">
            <script type="text/html" id="detailsDemo1">
                <c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>
            </script>
            <table id="detailsList1" lay-filter="detailsList1"></table>
        </div>
        <p>
            请仔细查看上述申请购买药品单号，完成后请在下面签名。
        </p>
    </div>
    <!-- signature -->
    <div class="row">
        <p>请签名:</p>
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
            对于一下药品:
        </p>
        <div class="layuimini-main">
            <script type="text/html" id="detailsDemo2">
                <c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>
            </script>
            <table id="detailsList2" lay-filter="detailsList2"></table>
        </div>
        <p>
            请仔细查看上述申请购买药品单号，完成后请在下面签名。
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
    // 上传图片
    Dropzone.autoDiscover = false;
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

