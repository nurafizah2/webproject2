<%-- 
    Document   : AddSocmed
    Created on : 29 Jun 2024, 21:36:34
    Author     : 1
--%>


<%@page import="Model.Socmed"%>
<%@page import="DAO.SocmedDAO"%>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Social Media Marketing</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            position: relative;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        h2 {
            color: #4CAF50;
        }
        .section {
            margin-bottom: 20px;
        }
        .section p {
            margin: 10px 0;
        }
        .quote {
            font-style: italic;
            color: #555;
            border-left: 4px solid #4CAF50;
            padding-left: 10px;
            margin: 10px 0;
        }
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #777;
        }
        .topnav {
            overflow: hidden;
            background-color: #333;
        }
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
        .topnav .icon {
            display: none;
        }
        /* Slideshow button styles */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
            background-color: rgba(0, 0, 0, 0.5);
            text-decoration: none;
            display: inline-block;
        }
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }
        /* On hover, add a grey background color */
        .prev:hover, .next:hover {
            background-color: #f1f1f1;
            color: black;
        }
        .elon-image, .tony-image, .job-image {
            max-width: 40%; /* Smaller size for the image on medium screens */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 6px; /* Adjusted margin to separate from the text */
        }
        @media screen and (min-width: 601px) {
            .elon-image, .tony-image, .job-image {
                float: right; /* Float the image to the right on larger screens */
                margin-left: 15px; /* Margin between image and text */
            }
        }
        /* Hide buttons on small screens */
        @media screen and (max-width: 600px) {
            .topnav a:not(:first-child) { display: none; }
            .topnav a.icon {
                float: right;
                display: block;
            }
            .topnav.responsive { position: relative; }
            .topnav.responsive .icon {
                position: absolute;
                right: 0;
                top: 0;
            }
            .topnav.responsive a {
                float: none;
                display: block;
                text-align: left;
            }
        }
    
        /* Form styles */
        form {
            margin-top: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="date"], input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
        }
        input[type="submit"], input[type="button"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
            <div id="myTopnav" class="topnav">
        <a href="login.jsp">Home</a>
        <a href="Marketing.jsp" >Marketing Inventory</a>
        <a href="CaseStudy.jsp">Case Study Inventory</a>
        <a href="Socmed.jsp" class="active">Social Media Inventory</a>
 
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
            </div>
    <div class="container">
        <h1>Add Social Media Item</h1>
        <form action="SocmedServlet" method="post">
            <table>
                <tr>
                    <td><label for="date">Date:</label></td>
                    <td><input type="date" id="date" name="date" required></td>
                </tr>
                <tr>
                    <td><label for="description">Description:</label></td>
                    <td><input type="text" id="description" name="description" required></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Item">
                        <input type="button" value="Back" onclick="window.location.href='Socmed.jsp'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="footer">
        <p>&copy; 2024 Social Media</p>
    </div>
</body>
</html>
