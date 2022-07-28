<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Produto, DAO.ProdutosDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!doctype html>
<html lang="pt">
<head>
    <style>
       #container{
            display: grid;
            grid-template-columns: 1fr 5fr 1fr;

        }
        .posicaoTitulo{    
            text-align: center;
            padding-bottom: 5px;
            background-color: blue;
            color: white;   
        }

        #sub-container{overflow: hidden;}
        .carrocel{
            width: 800px;
            height: 460px;      
        }
        .nav{
            justify-content: center;   
            justify-items: center;
            align-items: center;
            text-align: center;
        }
        .nav ul li a{
            text-decoration: underline;
        }

        .carrocel li img{
            display:flex;   
            width: 820px;
            height:480px;      
            margin: 5px 20px;
        }

        .carrocel ul{   
            display: flex;    
            list-style: none;    
            width: 1100px;
            height: 460px;  

        }
        .carrocel li{    
            position: relative;
            margin-right: 15px;
            animation: slide 25s infinite ease-out;
        }
        @keyframes slide{
            0%{left:0px}
            19%{left: 0px}
            27%{left:-860px}
            47%{left: -860px;}
            57%{left: -1700px;}
            77%{left: -1700px;}
            87%{left:-2530px;}
            100%{left:-2530px}
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./css/style.css">
    <title>blueSupermarket</title>
</head>
<body>
hello word!!

</body>
</html>