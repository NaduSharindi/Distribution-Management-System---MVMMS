<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="styles.css" />
    <title>MVMMS DASHBOARD</title>
    <style>
    @import url("https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap");

/*  styling scrollbars  */
::-webkit-scrollbar {
  width: 5px;
  height: 6px;
}

::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px #a5aaad;
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background: #8B0000;
  border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
  background: #a5aaad;
}

* {
  margin: 0;
  padding: 0;
}

body {
  
  box-sizing: border-box;
  font-family: "Lato", sans-serif;
}

.text-primary-p {
  color: #a5aaad;
  font-size: 14px;
  font-weight: 700;
}

.font-bold {
  font-weight: 700;
}

.text-title {
  color: #2e4a66;
}

.text-lightblue {
  color: #469cac;
}

.text-red {
  color: #cc3d38;
}

.text-yellow {
  color: #a98921;
}

.text-green {
  color: #3b9668;
}

.container {
  display: grid;
  height: 100vh;
  grid-template-columns: 0.8fr 1fr 1fr 1fr;
  grid-template-rows: 0.2fr 3fr;
  grid-template-areas:
    "sidebar nav nav nav"
    "sidebar main main main";
  /* grid-gap: 0.2rem; */
}

.navbar {
  background: #ffffff;
  grid-area: nav;
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 30px 0 30px;
  border-bottom: 1px solid lightgray;
}

.nav_icon {
  display: none;
}

.nav_icon > i {
  font-size: 26px;
  color: #a5aaad;
}

.navbar__left > a {
  margin-right: 30px;
  text-decoration: none;
  color: #a5aaad;
  font-size: 15px;
  font-weight: 700;
}

.navbar__left .active_link {
  color: #265acc;
  border-bottom: 3px solid #265acc;
  padding-bottom: 12px;
}

.navbar__right {
  display: flex;
  justify-content: center;
  align-items: center;
}

.navbar__right > a {
  margin-left: 20px;
  text-decoration: none;
}

.navbar__right > a > i {
  color: #a5aaad;
  font-size: 16px;
  border-radius: 50px;
  background: #ffffff;
  box-shadow: 2px 2px 5px #d9d9d9, -2px -2px 5px #ffffff;
  padding: 7px;
}

main {
  background: #f3f4f6;
  grid-area: main;
  overflow-y: auto;
}

.main__container {
  background-image: url(../../img/elec.jpg) repeat scroll 0 0 #fff;
  background-size: cover;
  padding: 20px 35px;
}

.main__title {
  display: flex;
  align-items: center;
}

.main__title > img {
  max-height: 100px;
  object-fit: contain;
  margin-right: 20px;
}

.main__greeting > h1 {
  font-size: 24px;
  color: #ffffff;
  margin-bottom: 5px;
}

.main__greeting > p {
  font-size: 14px;
  font-weight: 700;
  color: #a5aaad;
}

.main__cards {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
  gap: 10px;
  margin: 20px 0;
}

.card {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 70px;
  padding: 25px;
  border-radius: 5px;
  background: rgba(0,0,0,0.7);
  
}

.card_inner {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.card_inner > span {
  font-size: 25px;
}

.charts {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 30px;
  margin-top: 50px;
  
}

.charts__left {
  padding: 25px;
  border-radius: 5px;
  background: #ffffff;
  position: relative;
  
}

.charts__left__title {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.charts__left__title > div > h1 {
  font-size: 24px;
  color: #2e4a66;
  margin-bottom: 5px;
}

.charts__left__title > div > p {
  font-size: 14px;
  font-weight: 700;
  color: #a5aaad;
}

.charts__left__title > i {
  color: #ffffff;
  font-size: 20px;
  background: #ffc100;
  border-radius: 200px 0px 200px 200px;
  -moz-border-radius: 200px 0px 200px 200px;
  -webkit-border-radius: 200px 0px 200px 200px;
  border: 0px solid #000000;
  padding: 15px;
}

.charts__right {
  padding: 25px;
  border-radius: 5px;
  background: #ffffff;
  
}

.charts__right__title {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.charts__right__title > div > h1 {
  font-size: 24px;
  color: #2e4a66;
  margin-bottom: 5px;
}

.charts__right__title > div > p {
  font-size: 14px;
  font-weight: 700;
  color: #a5aaad;
}

.charts__right__title > i {
  color: #ffffff;
  font-size: 20px;
  background: #39447a;
  border-radius: 200px 0px 200px 200px;
  -moz-border-radius: 200px 0px 200px 200px;
  -webkit-border-radius: 200px 0px 200px 200px;
  border: 0px solid #000000;
  padding: 15px;
}

.charts__right__cards {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
  margin-top: 30px;
}

.card1 {
  background: #d1ecf1;
  color: #35a4ba;
  text-align: center;
  padding: 25px;
  border-radius: 5px;
  font-size: 14px;
}

.card2 {
  background: #d2f9ee;
  color: #38e1b0;
  text-align: center;
  padding: 25px;
  border-radius: 5px;
  font-size: 14px;
}

.card3 {
  background: #d6d8d9;
  color: #3a3e41;
  text-align: center;
  padding: 25px;
  border-radius: 5px;
  font-size: 14px;
}

.card4 {
  background: #fddcdf;
  color: #f65a6f;
  text-align: center;
  padding: 25px;
  border-radius: 5px;
  font-size: 14px;
}

/*  SIDEBAR STARTS HERE  */

#sidebar {
  background: #020509;
  grid-area: sidebar;
  overflow-y: auto;
  padding: 20px;
  -webkit-transition: all 0.5s;
  transition: all 0.5s;
}

.sidebar__title {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #f3f4f6;
  margin-bottom: 30px;
  /* color: #E85B6B; */
}

.sidebar__img {
  display: flex;
  align-items: center;
}

.sidebar__title > div > img {
  width: 75px;
  object-fit: contain;
}

.sidebar__title > div > h1 {
  font-size: 18px;
  display: inline;
}

.sidebar__title > i {
  font-size: 18px;
  display: none;
}

.sidebar__menu > h2 {
  color: #B22222;
  font-size: 16px;
  margin-top: 15px;
  margin-bottom: 5px;
  padding: 0 10px;
  font-weight: 700;
}

.sidebar__link {
  color: #f3f4f6;
  padding: 10px;
  border-radius: 3px;
  margin-bottom: 5px;
}
.sidebar__link:hover {
  background-color: #ffdf00;
  color: #B22222;
}

.sidebar__link a:hover {
  color: #B22222;
}

.active_menu_link {
  background: rgba(178, 34, 34, 0.3);
  color: #B22222;
}

.active_menu_link a {
  color: #B22222 !important;
}

.sidebar__link > a {
  text-decoration: none;
  color: #a5aaad;
  font-weight: 700;
}

.sidebar__link > i {
  margin-right: 10px;
  font-size: 18px;
}

.sidebar__logout {
  margin-top: 20px;
  padding: 10px;
  color: #e65061;
}

.sidebar__logout > a {
  text-decoration: none;
  color: #e65061;
  font-weight: 700;
  text-transform: uppercase;
}

.sidebar__logout > i {
  margin-right: 10px;
  font-size: 18px;
}

.sidebar_responsive {
  display: inline !important;
  z-index: 9999 !important;
  left: 0 !important;
  position: absolute;
}

@media only screen and (max-width: 978px) {
  .container {
    grid-template-columns: 1fr;
    /* grid-template-rows: 0.2fr 2.2fr; */
    grid-template-rows: 0.2fr 3fr;
    grid-template-areas:
      "nav"
      "main";
  }

  #sidebar {
    display: none;
  }

  .sidebar__title > i {
    display: inline;
  }

  .nav_icon {
    display: inline;
  }
}

@media only screen and (max-width: 855px) {
  .main__cards {
    grid-template-columns: 1fr;
    gap: 10px;
    margin-bottom: 0;
  }

  .charts {
    grid-template-columns: 1fr;
    margin-top: 30px;
  }
}

@media only screen and (max-width: 480px) {
  .navbar__left {
    display: none;
  }
}

.gmap_canvas {
    overflow:hidden;
    background:none!important;
    height:500px;
    width:1150px;
}
.mapouter{
    position:relative;
    text-align:right;
    height:500px;
    width:1150px;
}


.selection select{
    width:225px;
    height:40px;
    margin-left: 5px;
    border: 1px solid var(--select-border);
    border-radius: 0.25em;
    cursor: pointer;
    line-height: 1.1;
    background-color: #fff;
    background-image: linear-gradient(to top, #f9f9f9, #fff 33%);
}
.buttonselect{
  margin-left: 5px;
  background-color: #B22222; /* Green */
  border: none;
  color: #ffdf00;
  margin-left: 50px;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
    </style>
    
  </head>
  <body id="body">
  <script src="/resources/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <div class="container">
      <nav class="navbar">
        <div class="nav_icon" onclick="toggleSidebar()">
          <i class="fa fa-bars" aria-hidden="true"></i>
        </div>
        <div class="navbar__left">
          
        </div>
        <div class="navbar__right">
          <a href="#">
            <i class="fa fa-search" aria-hidden="true"></i>
          </a>
          <a href="#">
            <i class="fa fa-clock-o" aria-hidden="true"></i>
          </a>
          <a href="#">
            <img width="30" src="assets/avatar.png" alt="" />
            <!-- <i class="fa fa-user-circle-o" aria-hidden="true"></i> -->
          </a>
        </div>
      </nav>

      <main>
        <div class="main__container">
          <!-- MAIN TITLE STARTS HERE -->

          <div class="main__title">
            <div class="main__greeting">
              <h1>Home</h1>
              <p>Dashboard</p>
            </div>
          </div>

          <!-- MAIN TITLE ENDS HERE -->

          <!-- MAIN CARDS STARTS HERE -->
          <div class="main__cards">
            <div class="card">
              <i
                class="fa fa-ban fa-2x text-lightblue"
                aria-hidden="true"
              ></i>
              <div class="card_inner">
                  <p class="text-primary-p">Interruption Requests</p>
                <span class="font-bold text-title">11</span>
              </div>
            </div>

            <div class="card">
              <i class="fa fa-search fa-2x text-red" aria-hidden="true"></i>
              <div class="card_inner">
                <p class="text-primary-p">Inspection Requests</p>
                <span class="font-bold text-title">27</span>
              </div>
            </div>

            <div class="card">
              <i
                class="fa fa-wrench fa-2x text-yellow"
                aria-hidden="true"
              ></i>
              <div class="card_inner">
                <p class="text-primary-p">Maintanance Requests</p>
                <span class="font-bold text-title">34</span>
              </div>
            </div>

            <div class="card">
              <i
                class="fa fa-bolt fa-2x text-green"
                aria-hidden="true"
              ></i>
              <div class="card_inner">
                <p class="text-primary-p">Tower Line Validations</p>
                <span class="font-bold text-title">45</span>
              </div>
            </div>
              
              <div class="card">
              <i
                class="fa fa-handshake-o fa-2x text-#ff00ff"
                aria-hidden="true"
              ></i>
              <div class="card_inner">
                <p class="text-primary-p">Supports Validations</p>
                <span class="font-bold text-title">05</span>
              </div>
            </div>
              <div class="card">
              <i
                class="fa fa-gears fa-2x text-lightblue"
                aria-hidden="true"
              ></i>
              <div class="card_inner">
                <p class="text-primary-p">Maintanance Data validations</p>
                <span class="font-bold text-title">05</span>
              </div>
            </div>
          </div>
          <!-- MAIN CARDS ENDS HERE -->
            <div class="selection">
            <select id="cars" name="cars">
    <option value="cp">CENTRAL PROVINCE
</option>
    <option value="saab"></option>
    <option value="fiat"></option>
    <option value="audi"></option>
                </select>
                <select id="areaelec" name="cars">
    <option value="volvo">AREA ELECTRICAL ENGINEER KAGALLE</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
                </select>
                <select id="cars" name="cars">
    <option value="volvo">All LINES</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
                </select>
                <select id="cars" name="cars">
    <option value="volvo">MAP VIEW</option>
    <option value="saab">Saab</option>
    <option value="fiat">Fiat</option>
    <option value="audi">Audi</option>
                </select>
                <button class="buttonselect">View</button>
            </div>
            <br>
            <br>
             <!-- MAP STARTS HERE -->
            <div class="mapouter"><div class="gmap_canvas"><iframe width="1150" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=CEB&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.whatismyip-address.com"></a><br><a href="https://www.embedgooglemap.net">website maps free</a></div></div>
             <!-- MAP ENDS HERE -->
             
          <!-- CHARTS STARTS HERE -->

          <div class="charts">
            <div class="charts__left">
              <div class="charts__left__title">
                <div>
                  <h1>CEB</h1>
                  <p>Number of Equipments in Powelines</p>
                </div>
               
              </div>
              <div id="apex1"></div>
            </div>

            <div class="charts__right">
                <div class="charts__right__title">
                <div>
                  <h1>CEB</h1>
                  <p>Substation Report</p>
                
              <div id="piechart">
                    </div></div></div>
            </div>
          </div>
          <!-- CHARTS ENDS HERE -->
        </div>
      </main>

      <div id="sidebar">
        <div class="sidebar__title">
          <div class="sidebar__img">
           <!--   <img src="<c:url value="/resources/img/CEBImages/CEB_Logo.png"/>" alt="">-->
            <h1>MVMMS Dashboard
            </h1>
          </div>
          <i
            onclick="closeSidebar()"
            class="fa fa-times"
            id="sidebarIcon"
            aria-hidden="true"
          ></i>
        </div>

        <div class="sidebar__menu">
          <div class="sidebar__link active_menu_link">
            <i class="fa fa-home"></i>
            <a href="#">Dashboard</a>
          </div>
          <br>
          <div class="sidebar-bb">
          <div class="sidebar__link">
            <i class="fa fa-balance-scale"></i>
            <a href="#">Asset Information</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-building-o"></i>
            <a href="#">Data</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-wrench"></i>
            <a href="#">Maintenance Planning</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-calendar-check-o"></i>
            <a href="#">Schedules & Reports</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-question"></i>
            <a href="#">Activity Request</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          <div class="sidebar__link">
            <i class="fa fa-arrow-circle-down" aria-hidden="true"></i>
            <a href="#">Download & Upload</a>
          </div>
          
        
          <div class="sidebar__logout">
            <i class="fa fa-power-off"></i>
            <a href="#">Log out</a>
          </div>
          </div>
        </div>
      </div>
    </div>
      
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    <script src="script.js"></script>
    <script type="text/javascript">
    var options = {
    		  series: [
    		    {
    		      name: "Tower",
    		      data: [44, 55, 57, 56],
    		    },
    		    {
    		      name: "Pole",
    		      data: [76, 85, 101, 98],
    		    },
    		  ],
    		  chart: {
    		    type: "bar",
    		    height: 250, // make this 250
    		    sparkline: {
    		      enabled: true, // make this true
    		    },
    		  },
    		  plotOptions: {
    		    bar: {
    		      horizontal: false,
    		      columnWidth: "55%",
    		      endingShape: "rounded",
    		    },
    		  },
    		  dataLabels: {
    		    enabled: false,
    		  },
    		  stroke: {
    		    show: true,
    		    width: 2,
    		    colors: ["transparent"],
    		  },
    		  xaxis: {
    		    categories: ["Western Province", "Eastern Province", "Central Province", "Sabaragamu Province"],
    		  },
    		  yaxis: {
    		    title: {
    		      text: "Equipments",
    		    },
    		  },
    		  fill: {
    		    opacity: 1,
    		  },
    		  tooltip: {
    		    y: {
    		      formatter: function (val) {
    		        return "" + val + "Eqiupments";
    		      },
    		    },
    		  },
    		};

    		var chart = new ApexCharts(document.querySelector("#apex1"), options);
    		chart.render();

    		// Sidebar Toggle Codes;

    		var sidebarOpen = false;
    		var sidebar = document.getElementById("sidebar");
    		var sidebarCloseIcon = document.getElementById("sidebarIcon");

    		function toggleSidebar() {
    		  if (!sidebarOpen) {
    		    sidebar.classList.add("sidebar_responsive");
    		    sidebarOpen = true;
    		  }
    		}

    		function closeSidebar() {
    		  if (sidebarOpen) {
    		    sidebar.classList.remove("sidebar_responsive");
    		    sidebarOpen = false;
    		  }
    		}
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Hours per Day'],
  ['Wpn', 8],
  ['Ep', 2],
  ['Cp', 8]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Substation Summary', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}
</script>
  </body>
</html>