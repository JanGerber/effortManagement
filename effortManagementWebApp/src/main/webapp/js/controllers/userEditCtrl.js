angular.module('wettEditor').controller(
            'createWettkampfCtrl',
            [ '$rootScope', '$scope','$http', '$filter','$location', 'wettkampfDataService' ,
                    function($rootScope, $scope, $http, $filter, $location , wettkampfDataService) {
						$scope.wettkampf = {
								heimmannschaft : '',
								gastmannschaft : '',
								ort : '',
								date: '',
								turnerHeim : [],
								turnerGast : [],
								wettkampftag: '',
								verantwortlicher: '',
								heimkariD1: '',
								gastkariD2: '',
								heimkariE1: '',
								gastkariE2: '',
								mannschaftsfuehrerHeim: '',
								mannschaftsfuehrerGast: '',
								oberkampfrichter: '',
								neutralerKampfrichter1: '',
								neutralerKampfrichter2: '',
								startPaarungHeim: '',
								zuschauer: '',
								liga: ''
						};
						$scope.dateWett = new Date();
						anzahlTurnerHeim = 0;
						anzahlTurnerGast = 0;
						$scope.maxTurner = {};
						$scope.maxTurner.heim = false;
						$scope.maxTurner.gast = false;
						$scope.turnerListHeim = [];
						$scope.turnerListGast = [];
						
						//Datepicker
						$scope.popup = {
								opended: false
						};
						$scope.popup.opened = false;
						$scope.openDatePicker = function() {
							    $scope.popup.opened = true;
							  };
						//Alerts
						$scope.alerts = [];
						$scope.closeAlert = function(index) {
							 $scope.alerts.splice(index, 1);
						};
							         	  
						
						wettkampfDataService.getAllMannschaften()	
						.then(function(response) {
							//First function handles success
							$scope.mannschaften = response.data; 
						}, function(response) {
							//Second function handles error
							$scope.daten = "Something went wrong";
							$scope.statuscode = response.status;
						});
						
						$scope.selectHeim = function(){
							wettkampfDataService.getTurnerByMannschaft($scope.wettkampf.heimmannschaft)	
							.then(function(response) {
								//First function handles success
								$scope.heimMannschaft = response.data; 
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								$scope.statuscode = response.status;
							});
						};
						$scope.selectGast = function(){
							wettkampfDataService.getTurnerByMannschaft($scope.wettkampf.gastmannschaft)	
							.then(function(response) {
								//First function handles success
								$scope.gastMannschaft = response.data; 
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								$scope.statuscode = response.status;
							});
						};
						
						
						$scope.createWettkampf = function() {
							$scope.wettkampf.date = $filter('date')($scope.dateWett, 'yyyy-MM-dd');
							
							wettkampfDataService.newWettkampf($scope.wettkampf)	
							.then(function(response) {
								//First function handles success
								console.log('new wett-response: ' + response.data);
								$location.path("/wettkampf/" + response.data);  //TODO wettkampfID
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								$scope.statuscode = response.status;
							});
							
						};	
						
						$scope.changeHeimTurner = function(aktive,turnerId,index){
							if(aktive === true){
								if(anzahlTurnerHeim < 10){
								$scope.wettkampf.turnerHeim.push({'turnerId' : turnerId});
								anzahlTurnerHeim++;
								}else{
									console.log("maxturnerHeim");
									$scope.maxTurner.heim = true;
									$scope.turnerListHeim[index].active = false;
								};
							}else{
								$scope.maxTurner.heim = false;
								var found = false;
								var index = 0
								for (i = 0; i < $scope.wettkampf.turnerHeim.length && !found && i <= anzahlTurnerHeim; i++) {
								  if ($scope.wettkampf.turnerHeim[i].turnerId === turnerId) {
								    found = true;
								    index = i;
								  };
								};
								$scope.wettkampf.turnerHeim.splice(index, 1);
								anzahlTurnerHeim--;
							};
						};
						$scope.changeGastTurner = function(aktive,turnerId,index){					
							if(aktive === true){
								if(anzahlTurnerGast < 10){
								$scope.wettkampf.turnerGast.push({'turnerId' : turnerId});
								anzahlTurnerGast++;
								}else{
									$scope.maxTurner.gast = true;
									$scope.turnerListGast[index].active = false;
								};
							}else{
								$scope.maxTurner.gast = false;
								var found = false;
								var index = 0
								for (i = 0; i < $scope.wettkampf.turnerGast.length && !found && i <= anzahlTurnerGast; i++) {
								  if ($scope.wettkampf.turnerGast[i].turnerId === turnerId) {
								    found = true;
								    index = i;
								  };
								};
								$scope.wettkampf.turnerGast.splice(index, 1);
								anzahlTurnerGast--;
							};
						};
						
						
						
                    } ]);

