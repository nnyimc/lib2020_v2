<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   
    <head>
        <title>logIn</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleLoginIn.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
           
        <form action="servletLogin" method="POST" accept-charset="UTF-8">
            <input type="hidden" name="section" value="login" />
            <div class="wrapper">  

                <div id="leftform">
                    <h1>Log in</h1> 
                    <p><input type="text" placeholder="Username" name="username" id="user" required/></p>
                    <p><input type="password" placeholder="Password" name="password" id="pass" required/></p>
                    <p><input type="submit" value="Login" name="button" /></p>
                </div>
                <div id="formFooter">
                    <p><span> Première visite ? <a href="servletLogin?section=register"> Enregistrer </a></span></p>
                </div>
                <div id="formMsg">
                    <p><h2>${msg}</h2></p>
                </div>
            </div>   

        </form>
    </body>
</html>





