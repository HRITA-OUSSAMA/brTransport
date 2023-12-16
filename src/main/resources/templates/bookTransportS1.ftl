<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/bookTransportStyleS1.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
        <h2>Réserver un transport</h2>
        <form action="/bookTransportS1Submit" method="post">
            <div class="v" id="vl">
                   <label for="">Ville d'expédition</label>
                   <select name="lieu1">
                   <#list lieux as lieu>
                       <option value="${lieu.getLieu1()}">${lieu.getLieu1()}</option>
                   </#list>
                   </select>
           </div>
           <div class="v">
                   <label for="">Ville de livraison</label>
                   <select name="lieu2">
                       <#list lieux as lieu>
                          <option value="${lieu.getLieu2()}">${lieu.getLieu2()}</option>
                       </#list>
                   </select>
            </div>
          <div>
            <button type="submit" id="su">Suivant</button>
        </div>
        </form>
           
    </div>

</body>
</html>