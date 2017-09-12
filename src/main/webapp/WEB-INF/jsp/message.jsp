
<%@page import="org.lanqiao.util.PageConterller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <title>留言板</title>
    <meta charset="UTF-8">
    <style>
        div {
            margin: 0;
            padding: 0;
            font-size: 12px;
            margin: 0 auto;
        }

        h3 {
            text-align: center
        }

        #container {
            width: 500px;
        }

        .article {
            border: 1px solid #a6cbe7;
            margin-top: 5px;
        }

        .author {
            background-color: #0099FF;
            width: 100%;
            height: 24px;
            line-height: 24px;
        }

        .content {
            height: 40px;
            padding: 10px;
        }

        .author span {
            float: right;
            padding-right: 10px;
        }

        .time {
            border-top: solid 1px #a6cbe7;
        }

        .page {
            text-align: right;
            height: 30px;
            line-height: 30px;
            padding-right: 10px;
        }
    </style>
    <script src="js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript">
        
    </script>
</head>

<body>
<div id="container">
    <div><h3>留言板</h3></div>
    <form action="searchMsg" method="post">
            <div>
                标题    : <input type="text" name="title" value=""/>
            </div>
            <div>
                开始时间: <input type="date" name="starTime" value=""/>
            </div>
            <div>
            <div>
                结束时间: <input type="date" name="endTime" value=""/>
            </div>
            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="搜索"/></div>
        </form>
    <c:forEach items="${mList}" var="msg">
       <div>
        <div class="article">
            <div class="author">用户:${msg.userName}<span>${msg.msgId}#</span></div>
            <div class="content">${msg.userSay}</div>
            <div class="time page"><fmt:formatDate value="${msg.time}" pattern="yyyy-MM-dd"/></div>
        </div>
        </div>
    </c:forEach>
    


    <% out.print(PageConterller.getPageCode(Integer.parseInt(session.getAttribute("pageNum")==null?"":session.getAttribute("pageNum").toString()) ,Integer.parseInt(session.getAttribute("maxPage")==null?"":session.getAttribute("maxPage").toString()),"getMsg")); %>
    <div>
        <form action="sendMsg" method="post">
            <div>
                用户: <input type="text" name="userName" value=""/>
            </div><br>
            <div>
                留言: <textarea name="userSay" rows="5" cols="72"></textarea>
            </div>
            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
        </form>
    </div>
</div>
</body>
</html>
