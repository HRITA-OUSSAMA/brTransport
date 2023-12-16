<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/connexionBodyStyle.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
       <img src="Images/img1.jpg" alt="image">
    </div>
    <div class="connexion">
        <h1>Connexion</h1>
        <#if val??>
           <p style="color:red; text-align:center;">email et/ou mot de passe incorrect(s)</p>
       </#if>
        <form action="/login" method="post">
            <label for="mail">E-mail</label>
            <input type="email" id="mail" placeholder="Votre E-mail" name="mail">
            <label for="pass">Mot de passe</label>
            <input type="password" id="pass" placeholder="Votre mot de passe" name="password">
            <a href="" id="mpo">Mot de passe oublié?</a>
            <input type="submit" value="Connexion">
            <label for="ins" id="lins">Vous n'avez pas de compte?</label>
            <a href="/registration" id="ins">Inscrivez-vous</a>
        </form>
           
    </div>
</body>
</html>