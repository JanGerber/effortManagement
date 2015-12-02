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
 <script src="ressources/js/bootstrap-datepicker.js"></script>
 <script src="ressources/js/bootstrap-datepicker.de.js" charset="UTF-8"></script>
 <link rel="stylesheet" href="ressources/css/extra.css">
 <link rel="stylesheet" href="ressources/css/bootstrap-datepicker3.standalone.min.css">
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
        <li><a href="startseite.html">Home</a></li>
        <li class="active"><a href="semester.html">Semester</a></li>
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
        <section style="padding-bottom: 50px; padding-top: 50px;">
        		<h1>Semester</h1>
				<c:if test="${!empty sessionScope.listSemester}">
				
				<div class="table-responsive">
				    <table class="table table-hover">
				    <thead>
				    <tr>
				        <th width="120">Semester Name</th>
				        <th width="120">Start Datum</th>
				        <th width="120">End Datum</th>
				        <th width="60">Edit</th>
				        <th width="60">Delete</th>
				    </tr>
				    </thead>
				    <c:forEach items="${sessionScope.listSemester}" var="semester">
				        <tr>
				            <td>${semester.semesterName}</td>
				            <td>${semester.startDatum}</td>
				            <td>${semester.endDatum}</td>
				            <td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModalSemesterAender${semester.semesterId}">Edit</button></td>
				            
				            <td><a href="/webapplication/semesterDelete.html?semesterId=${semester.semesterId}" >Delete</a></td>
				        </tr>
				        
				       <!-- Modal Semester Aendern -->
					<div id="myModalSemesterAender${semester.semesterId}" class="modal fade" role="dialog">
					  <div class="modal-dialog">
				
						<!-- Modal content-->
						<div class="modal-content">
						<div class="modal-header " style="background-color:orange">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 style="color:white;"><span ></span> Semester Editieren</h4>
				        </div>
				        <div class="modal-body" id="modal-bodyLinks">
				        
				       <form  action="<c:url value='/semesterEdit${semester.semesterId}.html' />" method="Post"autocomplete="off">
				            <div class="form-group form-groupNeu">
				              <label for="semesterName">Semester Name</label>
				              <input type="text" name="semesterName" class="form-control" id="semesterName" required="required" placeholder="Semester Name" value="<c:out value="${semester.semesterName}"/>">
				            </div>
				            <div id="sandbox-container" class="form-group form-groupNeu">
				            <div class="input-daterange input-group" id="datepicker">
						            <div class="form-group form-groupNeu">
						              <label for="startDatum">Start Datum</label>
						              <input type="text" name="startDatum"  class="form-control" id="startDatum" required="required" placeholder="Start Datum wählen" value="<c:out value="${semester.startDatum}"/>">
						            </div>
									<div  class="form-group form-groupNeu">
						              <label for="endDatum">End Datum</label>
						              <input type="text" name="endDatum"  class="form-control" id="endDatum" required="required" placeholder="End Datum wählen" value="<c:out value="${semester.endDatum}"/>">
						            </div>
				            </div>
				            </div>
				            
						  	<input type="hidden" name="semesterId"  value="<c:out value="${semester.semesterId}"/>">
				            <input type="hidden" name="user_Id"  value="<c:out value="${semester.user_Id}"/>">
				            
				            <div class="form-group" style="text-align: right;">
				            <button type="submit" value="aendernSemester" class="btn btn-default btn-warning" ><span class="glyphicon glyphicon-ok"></span>Semester anpassen</button>
				      		</div>
				       </form>
				       
				        </div>
				
						 <div class="modal-footer footerERG" >
				          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				         
				       
				        </div>
						</div>
				
					  </div>
					</div><!-- Modal ENDE -->  
				
				    </c:forEach>
				    </table>
				    </div>
					
					 
				</c:if>
				<!-- Button zum aufruf des Modals Semester Neu -->
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalneuesSemester">Semester erstellen</button>
				
				<!-- Modal Semester Neu -->
					<div id="myModalneuesSemester" class="modal fade" role="dialog">
					  <div class="modal-dialog">
				
						<!-- Modal content-->
						<div class="modal-content">
						<div class="modal-header " style="background-color:orange">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 style="color:white;"><span ></span> Semester erstellen</h4>
				        </div>
				        <div class="modal-body" id="modal-bodyLinks">
				        
				       <form  action="semesterNew.html" method="Post" autocomplete="off">
				            
				            <div class="form-group form-groupNeu">
				              <label for="semesterName">Semester Name</label>
				              <input type="text" name="semesterName" class="form-control" id="semesterName" required="required" placeholder="Semester Name" >
				            </div>
				            
				            
				            
				            <div id="sandbox-container" class="form-group form-groupNeu">
				            <div class="input-daterange input-group" id="datepicker">
						            <div class="form-group form-groupNeu">
						              <label for="startDatum">Start Datum</label>
						              <input type="text" name="startDatum"  class="form-control" id="startDatum" required="required" placeholder="Start Datum wählen" >
						            </div>
									<div  class="form-group form-groupNeu">
						              <label for="endDatum">End Datum</label>
						              <input type="text" name="endDatum"  class="form-control" id="endDatum" required="required" placeholder="End Datum wählen">
						            </div>
				            </div>
				            </div>
				            
				            
				            <div class="form-group" style="text-align: right;">
				            <button type="submit" value="neuesSemester" class="btn btn-default btn-warning" ><span class="glyphicon glyphicon-ok"></span>Neues Semester</button>
				      		</div>
				       </form>
				       
				        </div>
				
						 <div class="modal-footer footerERG" >
				          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				         
				       
				        </div>
						</div>
				
					  </div>
					</div>
					
					
					<!-- Modal ENDE -->
				
				
				
				  
        </section>
        <!-- SECTION END -->
    
    <!-- CONATINER END -->
  	
</div>

	<!-- Script für Datepicker -->
		<script type="text/javascript">
		$('#sandbox-container .input-daterange').datepicker({
		    format: "yyyy-mm-dd",
		    weekStart: 1,
		    maxViewMode: 1,
		    todayHighlight: true,
		    language: "de",
		    daysOfWeekHighlighted: "0,6",
		    autoclose: true
		});
		</script>
	<!-- ENDE Script für Datepicker -->



</body>
</html>
