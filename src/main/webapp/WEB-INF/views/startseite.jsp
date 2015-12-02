<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="ressources/bootstrap/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="ressources/css/extra.css">
</head>
<body  style="background-color:#eee">
<jsp:useBean id="user" class="com.effortmanagement.model.User" scope="session"/>	

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="startseite.html">effortManagement</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="semester.html">Semester</a></li>
        <li><a href="#">Vorlesungen</a></li>
        <li><a href="#">Auswertungen</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container">
	
  <h3>Startseite</h3>
  	
  	
  	    <div class="container">
        <section style="padding-bottom: 50px; padding-top: 50px;">
        		<!-- Ausgabe Benutzer aktualiesiert -->
        		<c:if test="${requestScope.profilAkt}">
				  <div class="alert alert-success">
				    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				    <strong>Success!</strong> Die Profil-Daten wurden aktualisiert.
				  </div>
				</c:if>
            <div class="row">
                <div class="col-md-4">
                    <img src="ressources/bilder/250x250.png" class="img-rounded img-responsive" />
                    <br />
                    <br />
                    
		            <ul class="list-group">
		            <li class="list-group-item text-muted listeErste"><strong>Benutzerdaten</strong></li>
		            <li class="list-group-item text-right"><span class="pull-left"><strong>Username</strong></span><c:out value="${user.userName}"/></li>
		            <li class="list-group-item text-right"><span class="pull-left"><strong>E-Mail Addresse</strong></span><c:out value="${user.email}"/></li>
		            <li class="list-group-item text-right"><span class="pull-left"><strong>Hochschule</strong></span><c:out value="${user.hochschule}"/></li>
		            
		          </ul> 
                    <br>
                    
                    <div class="col-md-6 padtop15">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalProfil" id="buttonProfilAnpassen">Profil anpassen</button> 
					</div>
                    <div class="col-md-6 padtop15">
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModalChangePass" id="buttonPasswortAendern">Passwort ändern</button>
                 	</div>
                 	
                    <br /><br/>
                </div>
                <div class="col-md-8">
                    <div class="alert alert-info">
                        <h2>User Bio : </h2>
                        <h4>Bootstrap user profile template </h4>
                        <p>
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                             3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. 
                        </p>
                    </div>


                </div>
            </div>
            <!-- ROW END -->


        </section>
        <!-- SECTION END -->
    </div>
    <!-- CONATINER END -->
  	
</div>




	
	<!-- Modal Passwort Aendern -->
	<div id="myModalChangePass" class="modal fade" role="dialog">
	  <div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
		<div class="modal-header " style="background-color:orange">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:white;"><span ></span> Passwort ändern</h4>
        </div>
        <div class="modal-body" id="modal-bodyLinks">
        
        <!-- Fehler Ausgabe und Aufrufen des Models -->
	        <c:if test="${requestScope.altesPasswortFalsch || requestScope.passwortUngleich }">
				 <script type="text/javascript">
				    $(window).load(function(){
				        $('#myModalChangePass').modal('show');
				    });
				</script>
				<c:if test="${requestScope.altesPasswortFalsch}">
	        	<div class="alert alert-danger">
	  				<strong>Fehler!</strong> Das angegebene Passwort ist falsch.
				</div> 
				</c:if>
				<c:if test="${requestScope.passwortUngleich }">
	        	<div class="alert alert-danger">
	  				<strong>Fehler!</strong> Die neuen Passwörter sind nicht gleich!
				</div> 
				</c:if>
			</c:if>
		<!-- Fehler ENDE Passwort Aendern -->
          <form  action="passwortAendern.html" method="Post"autocomplete="off">
            <div class="form-group form-groupNeu">
              <label for="altesPasswort">Altes Passwort eingeben:</label>
              <input type="password" name="altesPasswort" class="form-control" id="altesPasswort" required="required" placeholder="altes Passwort">
            </div>
            <div class="form-group form-groupNeu">
              <label for="neuesPassword">Neues Passwort eingeben:</label>
              <input type="password" name="neuesPassword"  class="form-control" id="neuesPassword" required="required" placeholder="Passwort eingeben">
            </div>
			 <div class="form-group form-groupNeu">
              <label for="passwordRepeat">Neues Passwort wiederholen:</label>
              <input type="password" name="passwordRepeat"  class="form-control" id="passwordRepeat" required="required" placeholder="Passwort wiederholen">
            </div>
		  
            <div class="form-group" style="text-align: right;">
            <button type="submit" value="aendernPass" class="btn btn-default btn-warning" id="buttonPasswortAendernM"><span class="glyphicon glyphicon-ok"></span> Passwort ändern</button>
      		</div>
       </form>
       
        </div>

		 <div class="modal-footer footerERG" >
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         
       
        </div>
		</div>

	  </div>
	</div>
	</div>
	
	<!-- Modal ENDE Passwort Aendern -->
	
		<!-- Modal Profil anpassen -->
	<div id="myModalProfil" class="modal fade" role="dialog">
	  <div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
		<div class="modal-header " style="background-color:green">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:white;"><span ></span>Profil anpassen</h4>
        </div>
        <div class="modal-body" id="modal-bodyLinks">
        
        <!-- Fehler User vorhanden -->
        <c:if test="${requestScope.userVorhanden}">
				 <script type="text/javascript">
				    $(window).load(function(){
				        $('#myModalProfil').modal('show');
				    });
				</script>
				<div class="alert alert-danger">
	  				<strong>Fehler!</strong> Dieser Benutzername ist bereits vergeben.
				</div> 

			</c:if>	 
		<!-- ENDE: Fehler User vorhanden -->    
		   
		<form  action="profilAnpassen.html" method="Post"autocomplete="off">
            <div class="form-group form-groupNeu">
              <label for="benutzername">Benutzername:</label>
              <input type="text" name="benutzername" class="form-control" id="benutzername" required="required" placeholder="Benutzername eingeben" value="<c:out value="${user.userName}"/>">
            </div>
            <div class="form-group form-groupNeu">
              <label for="email">E-Mail:</label>
              <input type="email" name="email"  class="form-control" id="email" required="required" placeholder="E-mail Adresse eingeben" value="<c:out value="${user.email}"/>">
            </div>
			 <div class="form-group form-groupNeu">
              <label for="hochschule">Hochschule:</label>
              <input type="text" name="hochschule"  class="form-control" id="hochschule" required="required" placeholder="Name der Hochschule eingeben" value="<c:out value="${user.hochschule}"/>">
            </div>
		  
            <div class="form-group" style="text-align: right;">
            <button type="submit" value="aendernPass" class="btn btn-default btn-warning" id="buttonProfilAnpassenM" ><span class="glyphicon glyphicon-ok"></span> Bestätigen</button>
      		</div>
       </form>
       
        </div>

		 <div class="modal-footer footerERG" >
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         
       
        </div>
		</div>

	  </div>
	</div>
	</div>
	<!-- Modal ENDE Profil anpassen -->
	
</body>
</html>
