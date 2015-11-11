<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html class=" js csstransitions" lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>effortManagement</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="ressources/bootstrap/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link href="ressources/css/scrolling-nav.css" rel="stylesheet">
  <link rel="stylesheet" href="ressources/css/extra.css">
  
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="0" >



<div class="jumbotron text-center">
<div class="container" id="container">
  <img src="ressources/bilder/Logo.png" alt="effortManagement" style="height: 40%;">
  <h1>effort Management</h1> 
  <p>Plane dein Semester</p>
<div class="row">  
  <div class="col-md-2">
	</div>
  <div class="col-md-4">
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">LOGIN</button>

	<!-- Modal LOGIN -->
	<div id="myModal" class="modal fade"  role="dialog">
	  <div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
		<div class="modal-header" style="background-color:red;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:white;"><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" id="modal-bodyLinks">
          <form action="login.html" method="Post">
            <div class="form-group form-groupNeu">
              <label for="usrname"><span class="glyphicon glyphicon-user" required="required"></span> Username</label>
              <input type="text" name="usrname"  class="form-control" id="usrname" placeholder="Username eingeben" required="required">
            </div>
            <div class="form-group form-groupNeu">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" name="psw" class="form-control" id="psw" placeholder="Passwort eingeben" required="required">
            </div>
            <button type="submit" value="login" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>

		 <div class="modal-footer footerERG">
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p class="footerERG">Forgot <a href="#">Password?</a></p>
        </div>
		</div>

	  </div>
	</div>
	</div>
	<div class="col-md-4">
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModalReg" data-keyboard="true">Registrieren</button>

	<!-- Modal LOGIN -->
	<div id="myModalReg" class="modal fade" role="dialog">
	  <div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
		<div class="modal-header" style="background-color:green;color:white;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:white;"><span ></span> Registrieren</h4>
        </div>
        <div class="modal-body" id="modal-bodyLinks">
          <form  action="registrieren.html" method="Post"autocomplete="off">
            <div class="form-group form-groupNeu">
              <label for="username"><span class="glyphicon glyphicon-user" required="required"></span> Username</label>
              <input type="text" name="username" class="form-control" id="username" placeholder="Username eingeben">
            </div>
            <div class="form-group form-groupNeu">
              <label for="password"><span class="glyphicon glyphicon-eye-open" required="required"></span> Password</label>
              <input type="password" name="password"  class="form-control" id="password" placeholder="Passwort eingeben">
            </div>
			 <div class="form-group form-groupNeu">
              <label for="passwordRepeat"><span class="glyphicon glyphicon-eye-open" required="required"></span> Password</label>
              <input type="password" name="passwordRepeat"  class="form-control" id="passwordWieder" placeholder="Passwort wiederholen">
            </div>
		   <div class="form-group form-groupNeu">
              <label for="email"><span class="glyphicon glyphicon-envelope" required="required"></span> E-Mail</label>
              <input type="email" name="email"  class="form-control" id="email" placeholder="E-Mail eingeben">
            </div>
			<div class="form-group form-groupNeu">
              <label for="university"><span class="glyphicon glyphicon-home" required="required"></span> Hochschule</label>
              <input type="text" name="university" class="form-control" id="university" placeholder="Name der Hochschule">
            </div>
            <div class="form-group" style="text-align: right;">
            <button type="submit" value="register" class="btn btn-default btn-success" ><span class="glyphicon glyphicon-ok"></span> Registrieren</button>
      		</div>
       </form>
       
        </div>

		 <div class="modal-footer footerERG">
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         
       
        </div>
		</div>

	  </div>
	</div>
	</div>
	<!-- Modal ENDE -->
   </div>
  	<div class="col-md-2">
	</div>
<div class="row">

	<div class="col-md-12 colmitte">
	
	<a href="#about" role="button" class="page-scroll"><button type="button" class="btn-lg btn-round"><span class="glyphicon glyphicon-chevron-down"></span></button></a>
	
  	</div>
	
  </div>
  </div>
</div>



<!-- Container (About Section) -->
<div id="about" class="container-fluid ">
  <div class="row">
    <div class="col-sm-8">
      <h2>About effortManagement</h2><br>
      <h4>effortManagement ist eine Webanwendung, welche Terminplanung und Aufwand f&uuml;r einzelne Vorlesungen/F&auml;cher koordiniert. Die Anwendung unterst&uuml;tzt den Studenten von Beginn des Semesters bei der Planung und gibt detaillierte Aufschl&uuml;sse bei der Reflexion des Lernaufwands.</h4><br>
      <p>Wenn ein dualer Student die Summe aus den fixen Vorlesungstunden und den eingetragenen Heimarbeitsstunden bildet ergibt sich f&uuml;r ihn, je nach Semester, ein Aufwand zwischen f&uuml;nfzig und siebzig Stunden pro Woche. Der duale Student ist darauf angewiesen die ihm zur Verf&uuml;gung stehende Zeit m&ouml;glichst effektiv zu nutzen. Wir m&ouml;chten eine Anwendung entwickeln die es jedem Student erm&ouml;glicht einen individuellen Lernplan zu erstellen und dauerhaft anzupassen. Dazu tr&auml;gt der er zu Beginn jedes Semesters seine Vorlesungen ein. An dieser Stelle muss der Benutzer entscheiden wie viel Zeit er tats&auml;chlich f&uuml;r jedes Fach einplant und welche Note er anstrebt. In einem Zeitplan kann nun die angestrebte Lernzeit auf konkrete Tage eingeteilt werden. </p>
      <p>Features:</p>
	  <ul>
	  <li>Aufgabenplanung</li>
	  <li>Vorlesungsplan</li>
	  <li>Langzeitauswertung / Reflexion</li>
	  <li>Semester&uuml;bersicht / Lerneffizienz</li>
	  </ul>
	  <br><a href="#contact" role="button" class="page-scroll"><button class="btn btn-default btn-lg" >Get in Touch</button></a>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-signal logo"></span>
    </div>
  </div>
</div>

<div class="container-fluid bg-grey">
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-globe logo"></span>
    </div>
    <div class="col-sm-8">
      <h2>Our Values</h2><br>
      <h4><strong>MISSION:</strong> Our mission lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</h4><br>
      <p><strong>VISION:</strong> Our vision Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
  </div>
</div>

<!-- Container (Services Section) -->
<div id="services" class="container-fluid text-center">
  <h2>SERVICES</h2>
  <h4>What we offer</h4>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-off logo-small"></span>
      <h4>POWER</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-heart logo-small"></span>
      <h4>LOVE</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-lock logo-small"></span>
      <h4>JOB DONE</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
  </div>
  <br><br>
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-leaf logo-small"></span>
      <h4>GREEN</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-certificate logo-small"></span>
      <h4>CERTIFIED</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-wrench logo-small"></span>
      <h4 style="color:#303030;">HARD WORK</h4>
      <p>Lorem ipsum dolor sit amet..</p>
    </div>
  </div>
</div>

<!-- Container (Portfolio Section) -->
<div id="portfolio" class="container-fluid text-center bg-grey">
  <h2>Portfolio</h2><br>
  <h4>What we have created</h4>
  <div class="row text-center">
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="paris.jpg" alt="Paris" width="400" height="300">
        <p><strong>Paris</strong></p>
        <p>Yes, we built Paris</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="newyork.jpg" alt="New York" width="400" height="300">
        <p><strong>New York</strong></p>
        <p>We built New York</p>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
        <p><strong>San Francisco</strong></p>
        <p>Yes, San Fran is ours</p>
      </div>
    </div>
  </div>

  <h2>What our customers say</h2>
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"This company is the best. I am so happy with the result!"<br><span style="font-style:normal;">Michael Roe, Vice President, Comment Box</span></h4>
      </div>
      <div class="item">
        <h4>"One word... WOW!!"<br><span style="font-style:normal;">John Doe, Salesman, Rep Inc</span></h4>
      </div>
      <div class="item">
        <h4>"Could I... BE any more happy with this company?"<br><span style="font-style:normal;">Chandler Bing, Actor, FriendsAlot</span></h4>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<!-- Container (Pricing Section) -->
<div id="pricing" class="container-fluid">
  <div class="text-center">
    <h2>Spende</h2>
    <h4>unterst&uuml;tze uns mit einer Spende</h4>
  </div>
  <div class="row">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Basic</h1>
        </div>
        <div class="panel-body">
          <p><strong>20</strong> Lorem</p>
          <p><strong>15</strong> Ipsum</p>
          <p><strong>5</strong> Dolor</p>
          <p><strong>2</strong> Sit</p>
          <p><strong>Endless</strong> Amet</p>
        </div>
        <div class="panel-footer plan">
          <h3>19 &euro;</h3>
          <h4>pro Monat</h4>
          <button class="btn btn-lg" data-toggle="modal" data-target="#myModal">Sign Up</button>
        </div>
      </div>      
    </div>     
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Pro</h1>
        </div>
        <div class="panel-body">
          <p><strong>50</strong> Lorem</p>
          <p><strong>25</strong> Ipsum</p>
          <p><strong>10</strong> Dolor</p>
          <p><strong>5</strong> Sit</p>
          <p><strong>Endless</strong> Amet</p>
        </div>
        <div class="panel-footer plan">
          <h3>29 &euro;</h3>
          <h4>per month</h4>
          <button class="btn btn-lg" data-toggle="modal" data-target="#myModal">Sign Up</button>
        </div>
      </div>      
    </div>       
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h1>Premium</h1>
        </div>
        <div class="panel-body">
          <p><strong>100</strong> Lorem</p>
          <p><strong>50</strong> Ipsum</p>
          <p><strong>25</strong> Dolor</p>
          <p><strong>10</strong> Sit</p>
          <p><strong>Endless</strong> Amet</p>
        </div>
        <div class="panel-footer plan">
          <h3>49 &euro;</h3>
          <h4>per month</h4>
          <button class="btn btn-lg"data-toggle="modal" data-target="#myModal">Sign Up</button>
        </div>
      </div>      
    </div>    
  </div>
</div>

<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">Kontakt</h2>
  <div class="row">
    <div class="col-sm-5">
      <p>Kontaktiere Sie uns und wir melden uns zur&uuml;ck.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> Karlsruhe, Deutschland</p>
      <p><span class="glyphicon glyphicon-phone"></span> +00 1515151515</p>
      <p><span class="glyphicon glyphicon-envelope"></span> mail@effortManagement.com</p>	   
    </div>
    <div class="col-sm-7">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <button class="btn btn-default pull-right" type="submit">Send</button>
        </div>
      </div>	
    </div>
  </div>
</div>

<div id="googleMap" style="height:400px;width:100%;"></div>

<!-- Add Google Maps -->
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
var myCenter = new google.maps.LatLng(49.026373 , 8.385505);

function initialize() {
var mapProp = {
  center:myCenter,
  zoom:12,
  scrollwheel:false,
  draggable:false,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var marker = new google.maps.Marker({
  position:myCenter,
  });

marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>Bootstrap Theme Made By <a href="http://www.w3schools.com" target="_blank" title="Visit w3schools">www.w3schools.com</a></p>		
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Prevent default anchor click behavior
    event.preventDefault();

    // Store hash
    var hash = this.hash;

    // Using jQuery's animate() method to add smooth page scroll
    // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
    $('html, body').animate({
      scrollTop: $(hash).offset().top
    }, 900, function(){
   
      // Add hash (#) to URL when done scrolling (default click behavior)
      window.location.hash = hash;
    });
  });
})
</script>

    <!-- jQuery -->
    <script src="ressources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="ressources/js/bootstrap.min.js"></script>

    <!-- Scrolling Nav JavaScript -->
    <script src="ressources/js/jquery.easing.min.js"></script>
    <script src="ressources/js/scrolling-nav.js"></script>
</body>
</html>