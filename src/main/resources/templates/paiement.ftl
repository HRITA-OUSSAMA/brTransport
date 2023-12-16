<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/paiement.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
        <div id="total">
         <h1>Total:</h1>
         <h1 id="prix">754.8 DH</h1>
        </div>
        <div id="line"></div>
        <form 
        <#if i==1>
        action="/payer1"
        <#elseif i==2>
        action="/payer2"
        </#if>
        method="post"
        >
         <div id="name">
            <input type="text" placeholder="First name" style="margin-right: 12px;">
            <input type="text" placeholder="Last name">
        </div>
         <div id="card">
            <input type="text" placeholder="Card number" style="display: block; width: 354px;"/>
            <input type="text" placeholder="CVV" style="display: block; width: 70px;"/>
         </div>
         <div id="date">
            <input type="text" placeholder="MM/YY" style="display: block; width: 70px;"/>
         </div>
            <button type="submit" style="background-color: rgb(53,148,57); margin-top: 10px;">Payer</button>
        </form>
     </div>
</body>
</html>