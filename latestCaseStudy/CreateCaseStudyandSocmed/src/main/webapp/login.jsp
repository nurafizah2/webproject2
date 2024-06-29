<%-- 
    Document   : login
    Author     : Nurafizah
--%>
<%@page import="DAO.AdminDAO"%>
<%@page import="DAO.ClientDao"%>
<%@page import="Model.admin"%>
<%@page import="Model.client"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<style>
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

        .elon-image, .tony-image , .job-image {
            max-width: 40%; /* Smaller size for the image on medium screens */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 6px; /* Adjusted margin to separate from the text */
        }

        @media screen and (min-width: 601px) {
            .elon-image, .tony-image , .job-image {
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
    </style>

<!-- JavaScript for navigation and form submission -->

</head>

<body>


<div class="form-container">
    <form id="Login" action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" size="30" placeholder="Enter your username" required><br><br>
             
            <label for="pw">Password</label>
            <input type="password" id="pw" name="pw" size="30" placeholder="Enter your password" required><br><br>
             
            <label for="role">Role</label>
            <select name="role" id="role" required>
                <option value="admin">Admin</option>
                <option value="client">Client</option>
            </select><br><br>
            
            <button type="submit">Login</button>
        </fieldset>
    </form>
    
    <p>New user? <a href="register.jsp"> <button>Register</button></a></p>

 <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
            out.println("<p style='color:red;'>" + errorMessage + "</p>");
        }
    %>
</div>
    
   

<div class="footer">
    <p>&copy; 2024 Marketing Success Stories</p>
</div>
<script>
    function toggleNavigation() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }
    </script>
</body>
</html>
