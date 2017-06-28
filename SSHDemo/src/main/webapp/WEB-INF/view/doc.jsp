<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>文档内容</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="ouym" />
   <style type="text/css">

       body{
           background-color: #e6e6e6;
       }
       .doc{
           width:65%;
           min-height: 600px;
           margin: 50px auto ;
           background-color: #fff;
           font-family: "Helvetica";
           padding: 30px;
           font-size: 16px;
           text-align: left;
       }
   </style>

</head>
<body>
    <div class="doc">
        <h1>
            ${docName}
        </h1>
        <p>${content}</p>
    </div>
</body>
</html>