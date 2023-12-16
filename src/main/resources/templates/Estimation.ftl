<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/EstimationStyle.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="/Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
         <h1>Votre estimation</h1>
         <h1 id="prix">${price} DH</h1>
         <ul>
            <li>Délais de livraison 24/48h</li>
            <li>Prise en charge GARANTIE !</li>
            <li>Livraison sur rendez vous inclus</li>
            <li>Livraison sur créneau horaire inclus</li>
         </ul>
         <#if u?? && u==1>
        <form action="/addOperation" method="post">
            <button type="button" style="background-color: rgb(53,148,57);"><a href="/EstimationPaiement">Payer</a></button>
            <button type="submit" style="background-color: blue;">Ajouter</button>
        </form>
        </#if>
     </div>
</body>
</html>