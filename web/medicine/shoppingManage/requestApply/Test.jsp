<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-25
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* styles.css */
        .navbar {
            width: 100%;
            background-color: #333;
            color: white;
            font-family: Arial, sans-serif;
        }

        .nav-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }

        .nav-menu {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
        }

        .nav-menu li {
            padding: 10px;
        }

        .nav-menu li a {
            color: white;
            text-decoration: none;
        }

        .toggle-menu {
            background: none;
            border: none;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        #secondRow {
            display: none; /* 默认第二排不显示 */
        }
    </style>
</head>
<body>
<nav class="navbar">
    <div class="nav-row">
        <ul class="nav-menu" id="firstRow">
            <li><a href="#">首页</a></li>
            <li><a href="#">服务</a></li>
            <li><a href="#">产品</a></li>
            <li><a href="#">关于我们</a></li>
        </ul>
        <button class="toggle-menu" id="toggleSecondRow">更多 &#9662;</button>
    </div>
    <div class="nav-row" id="secondRow">
        <ul class="nav-menu">
            <li><a href="#">联系方式</a></li>
            <li><a href="#">常见问题</a></li>
            <li><a href="#">新闻</a></li>
            <li><a href="#">客户案例</a></li>
        </ul>
    </div>
</nav>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var toggleButton = document.getElementById('toggleSecondRow');
        var secondRow = document.getElementById('secondRow');

        toggleButton.addEventListener('click', function() {
            secondRow.style.display = secondRow.style.display === 'block' ? 'none' : 'block';
            this.textContent = secondRow.style.display === 'block' ? '收起 &#9652;' : '更多 &#9662;';
        });
    });
</script>

</body>
</html>
