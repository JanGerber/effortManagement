angular.module('wettEditor').controller(
            'wettkampfCtrl',
            [ '$rootScope', '$scope','$location','$routeParams','$http', '$timeout' ,'$filter' ,'wettkampfDataService' ,
                    function($rootScope, $scope,$location,$routeParams, $http, $timeout ,$filter,  wettkampfDataService) {
            			$scope.uebung = {};
            	
						$scope.showModal = false;
						$scope.openModal = function(uebung){
							$scope.uebung = uebung;							
							$scope.showModal = !$scope.showModal;
						};
						$scope.openModal2 = function(uebung){
							$scope.uebung = uebung;			
							$scope.calcUebung = {
									anzTeilePen : 0,
									anzA : 0,
									anzB : 0,
									anzC : 0,
									anzD : 0,
									anzE : 0,
									anzF : 0,
									anzTeilePen : 0,
									linie: 0,
									abzuege1: 0,
									abzuege2: 0 ,
									verstoesse : 0,
									elementgruppen: 0,
									verbindungen: 0,
									maxA: 0,
									maxB:0,
									maxC:0,
									maxD: 0,
									maxE:0,
									maxF:0,
							};
							$scope.showModal2 = !$scope.showModal2;
						};
						
						wettkampfDataService.getInfoWettkampf($routeParams.wettkampfId)	
						.then(function(response) {
							//First function handles success
							$scope.wettkampfInfo = response.data;
						}, function(response) {
							//Second function handles error
							$scope.daten = "Something went wrong";
							$scope.statuscode = response.status;
						});
						
						wettkampfDataService.getWertungeWettkampf($routeParams.wettkampfId)	
						.then(function(response) {
							//First function handles success
							$scope.wettkampfWertung = response.data;
						}, function(response) {
							//Second function handles error
							$scope.daten = "Something went wrong";
							$scope.statuscode = response.status;
						});

						$scope.changeUebung = function(){
							console.log('after');
							switch ($scope.calcUebung.anzA + $scope.calcUebung.anzB + $scope.calcUebung.anzC + $scope.calcUebung.anzD + $scope.calcUebung.anzE + $scope.calcUebung.anzF) {
							case 10:
							case 9:
							case 8:
							case 7:
								$scope.calcUebung.anzTeilePen = 0;
								break;
							case 6:
								$scope.calcUebung.anzTeilePen = 4;
								break;
							case 5:
								$scope.calcUebung.anzTeilePen = 5;
								break;
							case 4:
							case 3:
							case 2:
							case 1:
								$scope.calcUebung.anzTeilePen = 8;
								break;
							case 0:
								$scope.calcUebung.anzTeilePen = 10;
								break;
							default:
								console.log("DEFAULT: This should never happend!")
								break;
							};
							$scope.dNote =  $scope.calcUebung.anzA * 0.1 + $scope.calcUebung.anzB * 0.2  + $scope.calcUebung.anzC  * 0.3 + $scope.calcUebung.anzD * 0.4  + $scope.calcUebung.anzE * 0.5  + $scope.calcUebung.anzF * 0.6 + $scope.calcUebung.elementgruppen + $scope.calcUebung.verbindungen ;
							
							$scope.e1Note = 10 - $scope.calcUebung.anzTeilePen - $scope.calcUebung.abzuege1 ;
							$scope.e2Note = 10 - $scope.calcUebung.anzTeilePen - $scope.calcUebung.abzuege2 ;
							
							if($scope.e1Note < 0){
								$scope.e1Note = 0;
							};
							if($scope.e2Note < 0){
								$scope.e2Note = 0;
							};
							$scope.uebung.penalty = $scope.calcUebung.anzTeilePen + $scope.calcUebung.linie + $scope.calcUebung.verstoesse;
							$scope.uebung.endNote = (parseFloat($scope.uebung.e1Note) + parseFloat($scope.uebung.e2Note)) / 2 + parseFloat($scope.uebung.dNote) - parseFloat($scope.calcUebung.linie) - parseFloat($scope.calcUebung.verstoesse);
							
							$scope.uebung.endNote =  $filter('number')($scope.uebung.endNote, 2);
							
							wettkampfDataService.editUebung($scope.uebung)	
							.then(function(response) {
								//First function handles success
								$scope.reloadWertungen();
								$scope.showModal2 = false;
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								console.log("Error:response: " + response);
							});
							
							$timeout($scope.updateErgebnisse, 500); // Probleme ohne timeout --> watch ergebnisse noch nicht angepasst
							
						}
						
						
						$scope.editUebung =function(){
							$scope.uebung.endNote = (parseFloat($scope.uebung.e1Note) + parseFloat($scope.uebung.e2Note)) / 2 + parseFloat($scope.uebung.dNote) - parseFloat($scope.uebung.penalty);
							
							$scope.uebung.endNote =  $filter('number')($scope.uebung.endNote, 2);
							wettkampfDataService.editUebung($scope.uebung)	
							.then(function(response) {
								//First function handles success
								$scope.reloadWertungen();
								$scope.showModal = false;
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								console.log("Error:response: " + response);
							});
							
							$timeout($scope.updateErgebnisse, 500); // Probleme ohne timeout --> watch ergebnisse noch nicht angepasst
													
						};
						
						$scope.updateErgebnisse = function(){
							ergebnissePost.heimGesamtPunkte =  $filter('number')($scope.ergebnis.heimGesamtPunkte, 2);
							ergebnissePost.gastGesamtPunkte	=  $filter('number')($scope.ergebnis.gastGesamtPunkte, 2);
							ergebnissePost.heimGesamtScorer = $scope.ergebnis.heimGesamtScorer;
							ergebnissePost.gastGesamtScorer = $scope.ergebnis.gastGesamtScorer;
							ergebnissePost.heimGesamtGeraete = $scope.ergebnis.heimGesamtGeraete;
							ergebnissePost.gastGesamtGeraete = $scope.ergebnis.gastGesamtGeraete;
							
							console.log(ergebnissePost);
							wettkampfDataService.updateErgebnisse($routeParams.wettkampfId, ergebnissePost )	
							.then(function(response) {
								//First function handles success
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								console.log("Error:response: " + response);
							});	
						};
						
						$scope.reloadWertungen = function(){
							wettkampfDataService.getWertungeWettkampf($routeParams.wettkampfId)	
							.then(function(response) {
								//First function handles success
								$scope.wettkampfWertung = response.data;
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								$scope.statuscode = response.status;
							});
						}
						
						$scope.auswertung = function(){
							ergebnissePost.heimGesamtPunkte =  $scope.ergebnis.heimGesamtPunkte;
							ergebnissePost.gastGesamtPunkte	= $scope.ergebnis.gastGesamtPunkte;
							ergebnissePost.heimGesamtScorer = $scope.ergebnis.heimGesamtScorer;
							ergebnissePost.gastGesamtScorer = $scope.ergebnis.gastGesamtScorer;
							ergebnissePost.heimGesamtGeraete = $scope.ergebnis.heimGesamtGeraete;
							ergebnissePost.gastGesamtGeraete = $scope.ergebnis.gastGesamtGeraete;
							
							wettkampfDataService.updateErgebnisse($routeParams.wettkampfId, ergebnissePost )	
							.then(function(response) {
								//First function handles success
								$location.path("/auswertung/" + $routeParams.wettkampfId );
							}, function(response) {
								//Second function handles error
								$scope.daten = "Something went wrong";
								console.log("Error:response: " + response);
							});	
						};
						
						//Watches  Endergebnis
						$scope.$watchGroup([ 'ergebnis.heim.boden.scorer' , 'ergebnis.heim.pferd.scorer' ,'ergebnis.heim.ringe.scorer' , 'ergebnis.heim.sprung.scorer', 'ergebnis.heim.barren.scorer','ergebnis.heim.reck.scorer' ], function() {
						        $scope.ergebnis.heimGesamtScorer = $scope.ergebnis.heim.boden.scorer + $scope.ergebnis.heim.pferd.scorer + $scope.ergebnis.heim.ringe.scorer + $scope.ergebnis.heim.sprung.scorer + $scope.ergebnis.heim.barren.scorer + $scope.ergebnis.heim.reck.scorer;
						    });
						$scope.$watchGroup(['ergebnis.gast.boden.scorer', 'ergebnis.gast.pferd.scorer','ergebnis.gast.ringe.scorer','ergebnis.gast.sprung.scorer', 'ergebnis.gast.barren.scorer','ergebnis.gast.reck.scorer'], function() {
					        $scope.ergebnis.gastGesamtScorer = $scope.ergebnis.gast.boden.scorer + $scope.ergebnis.gast.pferd.scorer + $scope.ergebnis.gast.ringe.scorer + $scope.ergebnis.gast.sprung.scorer + $scope.ergebnis.gast.barren.scorer + $scope.ergebnis.heim.reck.scorer;
					    });
						$scope.$watchGroup([ 'ergebnis.heim.boden.punkte' , 'ergebnis.heim.pferd.punkte' ,'ergebnis.heim.ringe.punkte' , 'ergebnis.heim.sprung.punkte', 'ergebnis.heim.barren.punkte','ergebnis.heim.reck.punkte' ], function() {
					        $scope.ergebnis.heimGesamtPunkte = parseFloat($scope.ergebnis.heim.boden.punkte) + parseFloat($scope.ergebnis.heim.pferd.punkte) + parseFloat($scope.ergebnis.heim.ringe.punkte) + parseFloat($scope.ergebnis.heim.sprung.punkte) + parseFloat($scope.ergebnis.heim.barren.punkte) + parseFloat($scope.ergebnis.heim.reck.punkte);
					    });
						$scope.$watchGroup(['ergebnis.gast.boden.punkte', 'ergebnis.gast.pferd.punkte','ergebnis.gast.ringe.punkte','ergebnis.gast.sprung.punkte', 'ergebnis.gast.barren.punkte','ergebnis.gast.reck.punkte'], function() {
					        $scope.ergebnis.gastGesamtPunkte = parseFloat($scope.ergebnis.gast.boden.punkte) + parseFloat($scope.ergebnis.gast.pferd.punkte) + parseFloat($scope.ergebnis.gast.ringe.punkte) + parseFloat($scope.ergebnis.gast.sprung.punkte) + parseFloat($scope.ergebnis.gast.barren.punkte) + parseFloat($scope.ergebnis.heim.reck.punkte);
					    });
						$scope.$watchGroup([ 'ergebnis.heim.boden.geraete' , 'ergebnis.heim.pferd.geraete' ,'ergebnis.heim.ringe.geraete' , 'ergebnis.heim.sprung.geraete', 'ergebnis.heim.barren.geraete','ergebnis.heim.reck.geraete' ], function() {
					        $scope.ergebnis.heimGesamtGeraete = $scope.ergebnis.heim.boden.geraete + $scope.ergebnis.heim.pferd.geraete + $scope.ergebnis.heim.ringe.geraete + $scope.ergebnis.heim.sprung.geraete + $scope.ergebnis.heim.barren.geraete + $scope.ergebnis.heim.reck.geraete;
					    });
						$scope.$watchGroup(['ergebnis.gast.boden.geraete', 'ergebnis.gast.pferd.geraete','ergebnis.gast.ringe.geraete','ergebnis.gast.sprung.geraete', 'ergebnis.gast.barren.geraete','ergebnis.gast.reck.geraete'], function() {
					        $scope.ergebnis.gastGesamtGeraete = $scope.ergebnis.gast.boden.geraete + $scope.ergebnis.gast.pferd.geraete + $scope.ergebnis.gast.ringe.geraete + $scope.ergebnis.gast.sprung.geraete + $scope.ergebnis.gast.barren.geraete + $scope.ergebnis.heim.reck.geraete;
					    });
						
						//Waches Modal 2
						$scope.$watchGroup(['calcUebung.anzA', 'calcUebung.anzB','calcUebung.anzC','calcUebung.anzD', 'calcUebung.anzE','calcUebung.anzF','calcUebung.verbindungen','calcUebung.elementgruppen'], function() {
					        $scope.uebung.dNote = $scope.calcUebung.anzA * 0.1 + $scope.calcUebung.anzB * 0.2 + $scope.calcUebung.anzC * 0.3 + $scope.calcUebung.anzD * 0.4 + $scope.calcUebung.anzE * 0.5 + $scope.calcUebung.anzF * 0.6 + $scope.calcUebung.elementgruppen + $scope.calcUebung.verbindungen;
					        anzTeile = $scope.calcUebung.anzA + $scope.calcUebung.anzB  + $scope.calcUebung.anzC  + $scope.calcUebung.anzD  + $scope.calcUebung.anzE + $scope.calcUebung.anzF;
					        $scope.calcUebung.maxA = $scope.calcUebung.anzA + (10-anzTeile);
					        $scope.calcUebung.maxB = $scope.calcUebung.anzB + (10-anzTeile);
					        $scope.calcUebung.maxC = $scope.calcUebung.anzC + (10-anzTeile);
					        $scope.calcUebung.maxD = $scope.calcUebung.anzD + (10-anzTeile);
					        $scope.calcUebung.maxE = $scope.calcUebung.anzE + (10-anzTeile);
					        $scope.calcUebung.maxF = $scope.calcUebung.anzF + (10-anzTeile);
						});
						$scope.$watchGroup(['uebung.anzA', 'uebung.anzB','uebung.anzC','uebung.anzD', 'uebung.anzE','uebung.anzF','uebung.anzA','uebung.anzA', 'calcUebung.anzTeilePen','calcUebung.abzuege1'], function() {
							console.log($scope.calcUebung);
							switch ($scope.calcUebung.anzA + $scope.calcUebung.anzB + $scope.calcUebung.anzC + $scope.calcUebung.anzD + $scope.calcUebung.anzE + $scope.calcUebung.anzF) {
							case 10:
							case 9:
							case 8:
							case 7:
								$scope.calcUebung.anzTeilePen = 0;
								break;
							case 6:
								$scope.calcUebung.anzTeilePen = 4;
								break;
							case 5:
								$scope.calcUebung.anzTeilePen = 5;
								break;
							case 4:
							case 3:
							case 2:
							case 1:
								$scope.calcUebung.anzTeilePen = 8;
								break;
							case 0:
								$scope.calcUebung.anzTeilePen = 10;
								break;
							default:
								console.log("DEFAULT: This should never happend!")
								break;
							};
							
							$scope.uebung.e1Note = 10 - $scope.calcUebung.anzTeilePen - $scope.calcUebung.abzuege1 ;
							if($scope.uebung.e1Note < 0){
								$scope.uebung.e1Note = 0;
							};
					    });
						$scope.$watchGroup(['calcUebung.anzA', 'calcUebung.anzB','calcUebung.anzC','calcUebung.anzD', 'calcUebung.anzE','calcUebung.anzF', 'calcUebung.anzTeilePen','calcUebung.abzuege2'], function() {
							switch ($scope.calcUebung.anzA + $scope.calcUebung.anzB + $scope.calcUebung.anzC + $scope.calcUebung.anzD + $scope.calcUebung.anzE + $scope.calcUebung.anzF) {
							case 10:
							case 9:
							case 8:
							case 7:
								$scope.calcUebung.anzTeilePen = 0;
								break;
							case 6:
								$scope.calcUebung.anzTeilePen = 4;
								break;
							case 5:
								$scope.calcUebung.anzTeilePen = 5;
								break;
							case 4:
							case 3:
							case 2:
							case 1:
								$scope.calcUebung.anzTeilePen = 8;
								break;
							case 0:
								$scope.calcUebung.anzTeilePen = 10;
								break;
							default:
								console.log("DEFAULT: This should never happend!")
								break;
							};
							$scope.uebung.e2Note = 10 - $scope.calcUebung.anzTeilePen - $scope.calcUebung.abzuege2 ;
							if($scope.uebung.e2Note < 0){
								$scope.uebung.e2Note = 0;
							};
					    });
						$scope.$watchGroup(['calcUebung.anzTeilePen', 'calcUebung.linie','calcUebung.verstoesse'], function() {
					        $scope.uebung.penalty = $scope.calcUebung.anzTeilePen + $scope.calcUebung.linie + $scope.calcUebung.verstoesse;
					    });
						$scope.$watchGroup(['uebung.e1Note', 'uebung.e2Note','uebung.dNote', 'calcUebung.linie', 'calcUebung.verstoesse'], function() {
							$scope.calcUebung.endNote = (parseFloat($scope.uebung.e1Note) + parseFloat($scope.uebung.e2Note)) / 2 + parseFloat($scope.uebung.dNote) - parseFloat($scope.calcUebung.linie) - parseFloat($scope.calcUebung.verstoesse);
							
							$scope.uebung.endNote =  $filter('number')($scope.uebung.endNote, 2);
					    });
						
						$scope.calcUebung = {};
						$scope.ergebnis ={
								heimGesamtPunkte: 0,
								gastGesamtPunkte: 0,
								heimGesamtScorer: 0,
								gastGesamtScorer: 0,
								heimGesamtGeraete: 0,
								gastGesamtGeraete: 0,
								heim:{
									boden:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									pferd:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									ringe:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									sprung:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									barren:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									reck:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									}
								},
								gast:{
									boden:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									pferd:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									ringe:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									sprung:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									barren:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									},
									reck:{
										scorer: 0,
										punkte: 0,
										geraete: 0
									}
								}
						};
						
						ergebnissePost = {
								heimGesamtPunkte: 0,
								gastGesamtPunkte: 0,
								heimGesamtScorer: 0,
								gastGesamtScorer: 0,
								heimGesamtGeraete: 0,
								gastGesamtGeraete: 0
						};
						
								
						
                    } ]);

