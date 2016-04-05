angular.module('wettEditor').controller(
            'auswertungCtrl',
            [ '$rootScope', '$scope', '$location', '$routeParams' ,'$filter','$http', '$window', 'wettkampfDataService' ,
                    function($rootScope, $scope, $location, $routeParams, $filter, $http, $window , wettkampfDataService) {
            		$scope.file = {
            				xml : {}
            		};
            		$scope.punkteTurner = [];
            		
            	
					wettkampfDataService.getInfoWettkampf($routeParams.wettkampfId)	
					.then(function(response) {
						//First function handles success
						$scope.wettkampfInfo = response.data;
						wertungen();
						$scope.file.xml.name = 'OBL' + '_' + $filter('date')($scope.wettkampfInfo.date, 'yy-MM-dd') + '_' + $scope.wettkampfInfo.heimmannschaftName + '-' + $scope.wettkampfInfo.gastmannschaftName + '.xml'  ;
						
					}, function(response) {
						//Second function handles error
						$scope.daten = "Something went wrong";
						$scope.statuscode = response.status;
					});
					
					wettkampfDataService.getInfoExtWettkampf($routeParams.wettkampfId)	
					.then(function(response) {
						//First function handles success
						$scope.wettkampfInfoExt = response.data;						
					}, function(response) {
						//Second function handles error
						$scope.daten = "Something went wrong";
						$scope.statuscode = response.status;
					});
					
					
					
					wertungen = function (){
					wettkampfDataService.getWertungeWettkampf($routeParams.wettkampfId)	
					.then(function(response) {
						//First function handles success
						$scope.wettkampfWertung = response.data;
						berechnePunkteT();
					}, function(response) {
						//Second function handles error
						$scope.daten = "Something went wrong";
						$scope.statuscode = response.status;
					});
					}
						
					$scope.file.xml.downloadUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/jaxtest/wettkampf/' + $routeParams.wettkampfId + '/auswertung';
					
					
					$scope.printDiv = function(divName) {
						  var printContents = document.getElementById(divName).innerHTML;
						  var popupWin = $window.open('', '_blank', 'width=2100,height=300');
						  popupWin.document.open()
						  var css ='';
						  var css ='@page{size:auto;margin:2 mm}#rahmen{border:0.5pt solid #000;width:200mm;height:40 mm}.aussenLinksTable{color:#F00;font-size:18pt;font-family:Arial,sans-serif;text-align:right}.mitteDpTable{color:#000;font-size:18pt;font-family:Arial,sans-serif;text-align:center}.aussenRechtsTable{color:#00F;font-size:18pt;font-family:Arial,sans-serif;text-align:left}.beschreibung{color:#000;font-size:12pt;font-weight:700;font-family:Arial,sans-serif;vertical-align:middle}.geraeteName{color:#000;font-size:18pt;font-family:Arial,sans-serif}.borderHeim{color:#F00;font-size:10pt;font-family:Arial,sans-serif;text-align:center;border:0.5pt solid #000}.borderGast{color:#00F;font-size:10pt;font-family:Arial,sans-serif;text-align:center;border:0.5pt solid #000}#grossFeld{height:4mm;width:10mm;transform:rotate(270deg)}#mittelFeld{height:4mm;width:4mm;transform:rotate(270deg)}#nameverkettet{height:4mm;width:40mm}#smallFeld{height:4mm;width:3mm}table{border-collapse:collapse}.center-block{display:block;margin-right:auto;margin-left:auto}';
						  popupWin.document.write('<!DOCTYPE html><html><head><style type="text/css">' + css + '</style> </head><body onload="window.print()">' + printContents + '</html>');
						  //popupWin.document.write('<!DOCTYPE html><html><head><style type="text/css" media="print">' + css + '</style> </head><body onload="window.print()">' + printContents + '</html>');
						  popupWin.document.close();
						} 
					
					
					berechnePunkteT =function (){
						for(x in $scope.wettkampfInfo.turnerHeim){
							turner = {
									id : '',
									verkettet : '',
									mannschaft : '',
									punkte : 0,
									scorer: 0
							};
							turner.mannschaft = $scope.wettkampfInfo.heimmannschaftName;
							turner.id = $scope.wettkampfInfo.turnerHeim[x].turnerId;
							turner.verkettet = $scope.wettkampfInfo.turnerHeim[x].verkettetName
							console.log(turner);
							for(y in $scope.wettkampfWertung.heimBoden){
								if($scope.wettkampfWertung.heimBoden[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimBoden[y].endNote;
									if($scope.wettkampfWertung.heimBoden[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimBoden[y].scorer;
									};
									break;
								};
							};
							for(y in $scope.wettkampfWertung.heimPferd){
								if($scope.wettkampfWertung.heimPferd[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimPferd[y].endNote;
									if($scope.wettkampfWertung.heimPferd[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimPferd[y].scorer;
									};									
									break;
								};
							};
							for(y in $scope.wettkampfWertung.heimRinge){
								if($scope.wettkampfWertung.heimRinge[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimRinge[y].endNote;
									if($scope.wettkampfWertung.heimRinge[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimRinge[y].scorer;
									};
									break;
								};
							};
							for(y in $scope.wettkampfWertung.heimSprung){
								if($scope.wettkampfWertung.heimSprung[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimSprung[y].endNote;
									if($scope.wettkampfWertung.heimSprung[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimSprung[y].scorer;
									};
									break;
									
								};
							};
							for(y in $scope.wettkampfWertung.heimBarren){
								if($scope.wettkampfWertung.heimBarren[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimBarren[y].endNote;
									if($scope.wettkampfWertung.heimBarren[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimBarren[y].scorer;
									};
									break;
									
								};
							};
							for(y in $scope.wettkampfWertung.heimReck){
								if($scope.wettkampfWertung.heimReck[y].turnerId == $scope.wettkampfInfo.turnerHeim[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.heimReck[y].endNote;
									if($scope.wettkampfWertung.heimReck[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.heimReck[y].scorer;
									};
									break;
									
								};
							};
							
							$scope.punkteTurner.push(turner);
						};
						
						for(x in $scope.wettkampfInfo.turnerGast){
							turner = {
									id : 0,
									verkettet : '',
									mannschaft : '',
									punkte : 0,
									scorer: 0
							};
							turner.mannschaft = $scope.wettkampfInfo.gastmannschaftName;
							turner.id = $scope.wettkampfInfo.turnerGast[x].turnerId;
							turner.verkettet = $scope.wettkampfInfo.turnerGast[x].verkettetName;
							
							for(y in $scope.wettkampfWertung.gastBoden){
								if($scope.wettkampfWertung.gastBoden[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastBoden[y].endNote;
									if($scope.wettkampfWertung.gastBoden[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastBoden[y].scorer;
									};
									break;
								};
							};
							for(y in $scope.wettkampfWertung.gastPferd){
								if($scope.wettkampfWertung.gastPferd[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastPferd[y].endNote;
									if($scope.wettkampfWertung.gastPferd[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastPferd[y].scorer;
									};									
									break;
								};
							};
							for(y in $scope.wettkampfWertung.gastRinge){
								if($scope.wettkampfWertung.gastRinge[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastRinge[y].endNote;
									if($scope.wettkampfWertung.gastRinge[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastRinge[y].scorer;
									};
									break;
								};
							};
							for(y in $scope.wettkampfWertung.gastSprung){
								if($scope.wettkampfWertung.gastSprung[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastSprung[y].endNote;
									if($scope.wettkampfWertung.gastSprung[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastSprung[y].scorer;
									};
									break;
									
								};
							};
							for(y in $scope.wettkampfWertung.gastBarren){
								if($scope.wettkampfWertung.gastBarren[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastBarren[y].endNote;
									if($scope.wettkampfWertung.gastBarren[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastBarren[y].scorer;
									};
									break;
									
								};
							};
							for(y in $scope.wettkampfWertung.gastReck){
								if($scope.wettkampfWertung.gastReck[y].turnerId == $scope.wettkampfInfo.turnerGast[x].turnerId){
									turner.punkte += $scope.wettkampfWertung.gastReck[y].endNote;
									if($scope.wettkampfWertung.gastReck[y].scorer == 10){
										turner.scorer += 5;
									}else{
									turner.scorer += $scope.wettkampfWertung.gastReck[y].scorer;
									};
									break;
									
								};
							};
							$scope.punkteTurner.push(turner);
						};
						
					};

					

					
								
						
                    } ]);



