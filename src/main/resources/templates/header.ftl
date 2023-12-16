<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/headerStyle.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/f606cb79ef.css" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f606cb79ef.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="topnav" id="myTopnav">
        <a class="active"><span id="br">br</span>Transport</a>
        <a href="/"><i class="fa fa-home" aria-hidden="true"></i><br/> Accueil</a>
        <a href=""><i class="fa-solid fa-circle-info"></i><br/> About</a>
        <a href="/reserver_transport"><i class="fa-solid fa-cart-shopping"></i><br/> Réserver transport</a>
        <a href="/contact"><i class="fa-solid fa-phone"></i><br/> Contact</a>
        <#if userNom??&&userPrenom??>
            <div class="dropdown">
             <button class="dropbtn"><i class="fa-regular fa-user"></i>  ${userPrenom}_${userNom}  <i class="fa fa-caret-down" aria-hidden="true"></i></button>
            <div class="dropdown-content">
            <a href="/operation"><i class="fa-solid fa-truck-fast"></i> Mes opérations</a>
            <a href="/setting"><i class="fa-solid fa-gear"></i> Paramètre</a>
            <a href="/deconnexion" style="color:red;"><i class="fa-solid fa-arrow-right-from-bracket"></i> Déconnexion</a>
          </div>
          </div>
        <#else>
        <a href="/connexion" id="cnx">Connexion</a>
        </#if>

      </div>
      
      
      <script>
      function myFunction() {
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