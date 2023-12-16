<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/bookTransportStyleS2.css">
    <title>Document</title>
</head>
<body>
    <#include "header.ftl">
    <div class="connImg">
        <img src="Images/img1.jpg" alt="image">
     </div>
     <div class="connexion">
        <h2>Réserver un transport</h2>
        <form action="/bookTransportS2Submit" method="post">
            <div class="v" id="vl">
                <img src="/Images/marchandise_generale.png" alt="">
                <div>
                 <input type="radio" name="type" value="MARCHANDISES GENERALES">
                 <label for="">MARCHANDISES GENERALES</label>
                </div>
           </div>
           <div class="v" >
            <img src="/Images/transpor_exceptionnel.png" alt="">
            <div>
             <input type="radio" name="type" value="TRANSPORT EXCEPTIONNEL">
             <label for="">TRANSPORT EXCEPTIONNEL</label>
            </div>
       </div>
       <div class="v">
        <img src="/Images/matieres_dangereuses.png" alt="">
        <div>
         <input type="radio" name="type" value="MATIERES DANGEREUSES">
         <label for="">MATIERES DANGEREUSES</label>
        </div>
   </div>
           
          <div class="btns">
            <button><a href="/bookTransportS1" style="color:white; text-decoration:none;">Précédent</a></button>
            <button type="submit
            ">Suivant</button>
         </div>
        </form>
           
    </div>
</body>
</html>