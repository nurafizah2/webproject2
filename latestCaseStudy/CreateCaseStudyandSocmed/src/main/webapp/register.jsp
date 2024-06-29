<%@page import="DAO.AdminDAO"%>
<%@page import="DAO.ClientDao"%>
<%@page import="Model.admin"%>
<%@page import="Model.client"%>
<%@ page import="java.sql.SQLException" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        
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
            position: relative; /* Position relative for absolute positioning of slides */
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
    
      <script>
        function validateForm(event) {
            var password = document.getElementById("pw").value;
            var passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+]).{5,}$/;
            
            if (!passwordPattern.test(password)) {
                alert("Password must be at least 5 characters long and include an uppercase letter, a number, and a special character.");
                event.preventDefault();
            }
        }
    </script>
    </head>
    <body>

        

        
        <form id="Register" action="register" method="post"  onsubmit="validateForm(event)" >
            <fieldset>
            <legend> Registration</legend>
            <label for="username">Username </label><!-- comment -->&ensp;&nbsp;&nbsp;
            <input type="text" id="username" name="username" size="15" placeholder="Enter your username"><br><br>
             
            <label for="pw">Password</label><!-- comment -->&nbsp;&emsp;
            <input type="password" id="pw" name="pw" size="15" placeholder="Enter your password"><br><br><!-- comment -->
            
             <label for="role">Role</label><!-- comment -->&emsp;&emsp;
             <select name="role" id="role">
               <option value="admin">Admin</option>
               <option value="client">Client</option>
            </select> 
           
            <p><input type="submit" id="btnSubmit" value="Submit"/>
               
            </p>
             </fieldset>
        </form>
        
         <% 
            String username = request.getParameter("username");
            String password = request.getParameter("pw");
            String role = request.getParameter("role");
            
            if (username != null && password != null && role != null) {
                if (role.equals("admin")) {
                    AdminDAO adminDao = new AdminDAO();
                    admin admin = new admin();
                    admin.setUsername(username);
                    admin.setPassword(password);
                    admin.setRole(role);
                    try {
                        adminDao.insertAdmin(admin);
                        out.println("Registration successful for Admin!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        out.println("Error: " + e.getMessage());
                    }
                } else if (role.equals("client")) {
                    ClientDao clientDao = new ClientDao();
                    client client = new client();
                    client.setUsername(username);
                    client.setPassword(password);
                    client.setRole(role);
                    try {
                        clientDao.insertClient(client);
                        out.println("Registration successful for Client!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        out.println("Error: " + e.getMessage());
                    }
                }
            } else {
                out.println("Please fill out all fields.");
            }
        %>
        <div class="footer">
        <p>&copy; 2024 Marketing Success Stories</p>
    </div>
</body>
</html>