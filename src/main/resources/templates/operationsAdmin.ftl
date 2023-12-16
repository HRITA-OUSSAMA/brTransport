<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>brTransport Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="/css.css">
    <link rel="stylesheet" href="">
    <script src="https://kit.fontawesome.com/688846302d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://kit.fontawesome.com/688846302d.css" crossorigin="anonymous">
     

</head>
<body>
  <!--Navbar-->
    <nav class="navbar">
        <div>
            <div class="bars"><i class="fas fa-bars"></i></div>
           <h1 class="logo"><span syle="color:blue;" >br</span>Transport</h1>
            </div>

        </div>
        <div class="input-box">
            <input type="text"  placeholder="type Your Search">
          <div class="search-icon"><i class="fas fa-search"></i></div>
        </div>
        <div>
            
            <div class="notification"><i class="fas fa-bell"></i>
            <span class="number">${n}</span>
              <div class="dropdown-menu">
                <div class="dropmenu-content">
                  <#if contacts??>
                   <#list contacts as contact>
                  <li>
                    ${contact.getNom()}_${contact.getPrenom()}
                    <div class="text">${contact.getSujet()}</div>
                  </li>
                </#list>
                </#if>
                </div>
              </div>
            </div>
            <div class="avatar">
            <#if prenom?? && nom??>
              <i class="fa-solid fa-user"></i><span style="font-size:14px"> ${prenom}_${nom}</span>
             </#if>
                <div class="dropdown-menu setting">
                  <div class="item"> <span class="fas fa-user"></span>Profile</div>
                  <div class="item"> <span class="fas fa-sign-out-alt"></span>LogOut</div>

                </div>

 
            </div>
        </div>

  </nav>
  <div class="content">
    <div class="sidebar">
      <div class="sidebar-nav">
        <div class="icon"><i class="fa-solid fa-location-dot"></i></div>
        <span><a href="/Admin/ajouterLigne" style="text-decoration:none;">ajouter ligne</a></span>
      </div>
      <div class="sidebar-nav ">
        <div class="icon"><i class="fa-solid fa-chart-pie"></i></div>
        <span><a href="/Admin/analytics" style="text-decoration:none;">Annalitics</a></span>
      </div>
      <div class="sidebar-nav active">
        <div class="icon"><i class="fa-solid fa-cart-flatbed"></i></div>
        <span><a href="/Admin/operations" style="text-decoration:none;">Opération</a></span>
      </div>
     
      
      <div class="sidebar-nav">
        <div class="icon"><i class="fa-solid fa-envelope"></i></div>
        <span><a href="/Admin/Contact" style="text-decoration:none;">Contact</a></span>
      </div>
      
     
    </div>
  
        
      
      <div class="rox">
        <div class="table ">
          <div class="table-body">
            <div class="table-row">
              <div> id</div>
              <div class="avatar">Nom</div>
              <div>Prenom</div>
              <div class="status">Status</div>
              
              <div class="actions">Actions</div>
            </div>
           <#if operations??>
           <#list operations as operation>
           <#if operation.getStatus()=="Pas confirmé">
            <div class="table-row">
              <div>ID: ${operation.getOperation_id()}</div>
              <div class="avatar">${operation.getNom()}</div>
              <div>${operation.getPrenom()}</div>
              <div class="">
                <span class="">${operation.getStatus()}</span>
              </div>      
              <div class="actions">
               <form action="/Encours/${operation.getOperation_id()}" method="post">
                 <button>Payer</button>
                </form>
                <form action="/Effectuer/${operation.getOperation_id()}" method="post">
                <button style="background-color:blue;">Effectuer</button>
                </form>
              </div>
            </div>
            
            <#elseif operation.getStatus()=="En cours">
            <div class="table-row">
              <div>ID: ${operation.getOperation_id()}</div>
              <div class="avatar">${operation.getNom()}</div>
              <div>${operation.getPrenom()}</div>
              <div class="">
                <span class="">${operation.getStatus()}</span>
              </div>   
              <div class="actions">
              <form action="/Effectuer/${operation.getOperation_id()}" method="post">
                <button type="submit" style="background-color:blue;">Effectué</button>
              </div>
              </from>
            </div>
            
            <#elseif operation.getStatus()=="Effectué avec succès">
            <div class="table-row">
              <div>ID: ${operation.getOperation_id()}</div>
              <div class="avatar">${operation.getNom()}</div>
              <div>${operation.getPrenom()}</div>
              <div class="">
                <span class="">${operation.getStatus()}</span>
              </div>
            </div>
            </#if>
           </#list>
         </#if>
          </div>
        </div>
      </div>
      <div class="rox"></div>

    </div>
  </div>
    <script>
    
    let avatar = document.querySelector(".avatar"),
 notification =document.querySelector(".notification");
 
 dropMenu(avatar)
 dropMenu(notification)
 function dropMenu(selector)
 {
    selector.addEventListener("click",()=>{
let dropDownMenu = selector.querySelector(".dropdown-menu") ; 
dropDownMenu.classList.contains("active") ?dropDownMenu.classList.remove("active"): dropDownMenu.classList.add("active")
 
})
 }
let sidebar = document.querySelector(".sidebar"),
bars = document.querySelector(".bars");
bars.addEventListener("click",()=>{
    sidebar.classList.contains("active") ? sidebar.classList.remove("active"):
    sidebar.classList.add("active");
})
let Visitors=[800,320],
 
years =["non paye","paye"];
var options = {
    chart :{
        type: 'area'
    },
    series :[{
      type: 'column',
      name:"Visitors",
      data: Visitors
}
    ],
    xaxis : {
        categories : [...years]
    },
    colors:[ '#43a047','#e65245' ,'#e42a15']
}
 var chart = new ApexCharts(document.querySelector("#chart"),options);
 chart.render();
 const form = document.getElementById('form');
const username = document.getElementById('username');

const password = document.getElementById('password');


form.addEventListener('submit', e => {
    e.preventDefault();

    validateInputs();
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success')
}

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

const validateInputs = () => {
    const usernameValue = username.value.trim();

    const passwordValue = password.value.trim();

    if(usernameValue === '') {
        setError(username, 'Username is required');
    } else {
        setSuccess(username);
    }

   

    if(passwordValue === '') {
        setError(password, 'Password is required');
    } else if (passwordValue.length < 8 ) {
        setError(password, 'Password must be at least 8 character.')
    } else {
        setSuccess(password);
    }

  

};
    </script>
</body>
</html>