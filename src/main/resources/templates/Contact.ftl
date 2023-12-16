<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/ContactBodyStyle.css">
    <script src="https://kit.fontawesome.com/f606cb79ef.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://kit.fontawesome.com/f606cb79ef.css" crossorigin="anonymous">
    <title>Document</title>
</head>
<style>
</style>
<body>
     <#include "header.ftl">
     <div class="conImg">
        <img src="Images/img1.jpg" alt="">
     </div>
    <div class="contact">
        <h1>Contact</h1>
        <form action="/message" method="post">
            <input type="text" name="nom" id="" placeholder="Nom" required/>
            <input type="text" name="prenom" id="" placeholder="Prénom" required/>
            <input type="email" name="email" id="" placeholder="E-mail" required/>
            <input type="text" name="sujet" id="" placeholder="Sujet" required/>
            <textarea name="message" placeholder="Message..." required></textarea>
            <button type="submit">Envoyer <i class="fa-regular fa-paper-plane"></i></button>
        </form>
    </div>
</body>
</html>