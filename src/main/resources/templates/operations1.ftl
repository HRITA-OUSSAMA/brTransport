<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/operations.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/f606cb79ef.css" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/f606cb79ef.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="/Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
         <h1>Mes opérations de fret</h1>
         <div id="line"></div>

        <div class="ops">
        <#if operationCards??>
           <#list operationCards as operationCard>
             <#if operationCard.getStatus()=='Pas confirmé'>
            <div class="op" style="display: flex;">
                <span id="opid">id: ${operationCard.getOperation_id()}</span>
                <span class="opSpan">De ${operationCard.getLieu1()} à ${operationCard.getLieu2()}</span>
                <span class="opSpan">${operationCard.getStatus()}</span>
            <span class="opi1" style="display: flex;">
                <span>
                <form action="">
                        <input type="text" value="1">
                        <button type="submit" class="detailBtns1">Détail</button>
                </form>
               </span>
               <span>
                <form action="/paiement/${operationCard.getOperation_id()}" method="post">
                    <button type="submit" class="payerBtns">Payer</button>
                </form>
               </span>
               <span>
                <form action="/deleteOperation/${operationCard.getOperation_id()}" method="post">
                    <button type="submit" class="deleteBtns"><i class="fa-solid fa-trash-can"></i></button>
                </form>
                </span>
              </span>
            </div>
            <#elseif operationCard.getStatus()=='Effectué avec succès' || operationCard.getStatus()=='En cours'>
            <div class="op" style="display: flex;">
                <span id="opid">id: ${operationCard.getOperation_id()}</span>
                <span class="opSpan">De ${operationCard.getLieu1()} à ${operationCard.getLieu2()}</span>
                <span class="opSpan">${operationCard.getStatus()}</span>
            <span class="opi2" style="display: flex;">
                <span>
                <form action="">
                        <button type="submit" class="detailBtns2">Détail</button>
                </form>
               </span>
               <span>
                <form action="/deleteOperation/${operationCard.getOperation_id()}" method="post">
                    <button type="submit" class="deleteBtns"><i class="fa-solid fa-trash-can"></i></button>
                </form>
                </span>
              </span>
            </div>
            </#if>
            </#list>
            </#if>
            
        </div>
     </div>
</body>
</html>