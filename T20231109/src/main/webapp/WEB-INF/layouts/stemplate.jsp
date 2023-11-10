<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="resources/boot-shop/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
        <!-- Product section-->
       	<tiles:insertAttribute name="body"></tiles:insertAttribute>
        <!-- Footer-->
       <tiles:insertAttribute name="footer"></tiles:insertAttribute>
    </body>
</html>
