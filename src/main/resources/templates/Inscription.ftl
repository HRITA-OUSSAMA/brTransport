<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/InscriptionBodyStyle.css">
    <title>Document</title>
</head>
<body>
     <#include "header.ftl">
    
     <div class="conImg">
        <img src="Images/img1.jpg" alt="">
     </div>
    <div class="contact">
        <h1>Inscrivez-vous</h1>
        <form action="/saveUser" method="post">
            <select name="genre" id="gender">
                <option value="M">M</option>
                <option value="Mme">Mme</option>
                <option value="Mlle">Mlle</option>
            </select>
            <input type="text" placeholder="Nom" name="nom" id="lastName" required />
            <input type="text" placeholder="Prénom" name="prenom" id="firstName" required  />
            <input type="text" placeholder="Téléphone" name="telephone" id="phoneNumber" required />
            <input type="text" placeholder="Adresse" name="adresse" id="adress" required />
            <input type="email" placeholder="E-mail" name="mail" id="email" required />
            <input type="password" placeholder="Mot de passe" name="password" id="password" required />
             <button type="submit" id="submit">Enregistrer</button>
        </form>
    </div>
</body>
</html>