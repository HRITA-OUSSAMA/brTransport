<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="messageStyle.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="conImg">
        <img src="/Images/img1.jpg" alt="">
     </div>
    <div class="contact" id="message">
        <img src="/Images/checked.png" width="150px">
        <h1>
        <#if u??>
        <#if u==1>
        Votre compte a été créé avec succès!
        <#elseif u==2>
        Votre opération de fret a bien été enregistrée!
        <#elseif u==3>
        Le paiement effectué avec succès!
        <#elseif u==4>
        votre message a été envoyé avec succès!
        </#if>
        </#if>
        </h1>
    </div>
</body>
</html>