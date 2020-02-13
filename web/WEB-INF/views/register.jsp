<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleLoginIn.css" rel="stylesheet" type="text/css"/>
        <title>Enregistrer</title>
    </head>
    <body>
        <form action="servletLogin" method="POST" accept-charset="UTF-8">
         <div class="wrapper">    
            <div id="leftform">
                <h1>Enregistrer</h1>
                <p><input type="text" placeholder="Nom" name="nom" id="nom"required/></p>
                <p><input type="text" placeholder="Prenom" name="prenom" id="prenom"required/></p>
                <p><input type="email" placeholder="Email" name="email2" id="email"required/></p>
                <p><input type="text" placeholder="Username" name="username2" id="user2"required/></p>
                <p><input type="password" placeholder="Password" name="password2" id="pass2"required/></p>
                <p><input type="number" placeholder="Adresse Livr(no)" name="adresseL" required/></p>
                <p><input type="number" placeholder="Adresse Fact (no)" name="adresseF" required/></p>
                <p><input type="hidden" name="statut" value="1" /></p>
                <p><input type="submit" value="Valider" name="reg"/></p>
            </div>
            </div>  
        </form>
    </body>
</html>

              
  