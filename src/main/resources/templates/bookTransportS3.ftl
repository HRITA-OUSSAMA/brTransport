<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/bookTransportStyleS3.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="conImg">
        <img src="Images/img1.jpg" alt="">
     </div>
    <div class="contact">
        <h1>Mon transport</h1>
        <form action="/bookTransportS3Submit" method="post">
            <h3>Dimensions</h3>
            <input type="number" name="hauteur" placeholder="Hautuer(cm)" required>
            <input type="number" name="largeur" placeholder="Largeur(cm)" required>
            <input type="number" name="longueur" placeholder="Longueur(cm)" required>
            <h3>Poids:</h3>
            <input type="number" name="poids" placeholder="Poids(Kg)" required>
            <button type="submit">Valider</button>
        </form>
    </div>
</body>
</html>