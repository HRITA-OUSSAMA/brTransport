<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/param.css">
    <script src="https://kit.fontawesome.com/f606cb79ef.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://kit.fontawesome.com/f606cb79ef.css" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
        <div id="total">
         <h1>Informations personnelles :</h1>
        </div>
        <div id="line"></div>
        <#if v?? && v==1>   
        <h4 style="margin-left: 22px; color: rgb(53,148,57);"> vos informations personnelles ont été modifiées avec succès!</h4>
        </#if>
        <form action="/updateUser" method="post">
         <div id="name">
            <div style="margin-right:10px; margin-top:5px;">Prénom :</div>
            <input type="text" placeholder="Prénom" value="${user.getPrenom()}" name="prenom" style="margin-right: 12px; width:113px;">
            <div style="margin-right:10px; margin-top:5px;">Nom :</div>
            <input type="text" placeholder="Nom" value="${user.getNom()}" style="width:113px;" name="nom">
        </div>
         <div id="card">
            <div>Adresse :</div>
            <input type="text" placeholder="Adresse" value="${user.getAdresse()}" name="adresse" style="display: block; width: 354px;"/>
            <div>Télèphone :</div>
            <input type="text" placeholder="Télèphone" value="${user.getTelephone()}" name="telephone" style="display: block; width: 354px;"/>
             <div>Email :</div>
            <input type="text" placeholder="Email" name="mail" value="${user.getMail()}" style="display: block; width: 354px;"/>
             <div>Mot de passe :</div>
            <input type="text" placeholder="Mot de passe" value="${user.getPassword()}" name="password" style="display: block; width: 354px;"/>
         </div>
            <button type="submit" style="background-color: rgb(53,148,57); margin-top: 10px;margin-left: 256px;"><i class="fa-solid fa-pen-to-square"></i> Modifier</button>
        </form>


        <div id="total">
            <h1>Suppression de compte :</h1>
           </div>
           <div id="line"></div>
           <form action="/deleteUser" method="post" style="margin-left: 5%; margin-top: 10px;">
               <button type="submit" style="background-color: red; margin-top: 10px;width: 150px;"><i class="fa-solid fa-trash-can"></i> Supprimer </button>
           </form>
           </div>
     </div>
</body>
</html>