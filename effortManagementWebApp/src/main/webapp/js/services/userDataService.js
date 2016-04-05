angular.module('wettEditor').service('wettkampfDataService',[ '$http', '$location' ,
															function($http , $location) {
    var srv = {};

    srv._baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/jaxtest';

    //alle Mannschaften
    srv.getAllMannschaften = function() {
		return $http.get( srv._baseUrl + "/mannschaft/"); 
    };
    //eine Mannschaft
    srv.getMannschaft = function(mannschaftId) {
		return $http.get( srv._baseUrl + "/mannschaft/" +  mannschaftId); 
    };
    //alle Turner
    srv.getAllTurner = function() {
		return $http.get( srv._baseUrl + "/turner/"); 
    };
    //ein Turner
    srv.getTurner = function(turnerId) {
		return $http.get( srv._baseUrl + "/turner/" +  turnerId); 
    };
    //alle Turner einer Mannschaft
    srv.getTurnerByMannschaft = function(mannschaftId) {
		return $http.get( srv._baseUrl + "/turner/mannschaft/" +  mannschaftId); 
    };
    //Übung eintragen
    srv.editUebung = function(uebung) {
        return $http.put(
            srv._baseUrl + '/uebung/', uebung
        );
    };  
    //Übung auf anfangswert zurücksetzen
    srv.resetUebung = function(wettkmapfId, geraet, heimMannschaft, nummer) {
		return $http.delete( srv._baseUrl + "/uebung/" + wettkampfId +"/" + geraet +"/" + heimMannschaft + "/" + nummer + "/"); 
    };
    //alle Wettkaempfe
    srv.getAllWettkaempfe = function() {
		return $http.get( srv._baseUrl + "/wettkampf/"); 
    };
    //eine Wettkampf Info
    srv.getInfoWettkampf = function(wettkampfId) {
		return $http.get( srv._baseUrl + "/wettkampf/"+ wettkampfId+"/info/"); 
    };
    //eine Wettkampf Info Extended
    srv.getInfoExtWettkampf = function(wettkampfId) {
		return $http.get( srv._baseUrl + "/wettkampf/"+ wettkampfId+"/infoextended/"); 
    };
    //Wertungen eines Wettkmapfes
    srv.getWertungeWettkampf = function(wettkampfId) {
		return $http.get( srv._baseUrl + "/wettkampf/"+ wettkampfId+"/wertungen/"); 
    };
    //Neuer Wettkampf anlegen
    srv.newWettkampf = function(wettkampf) {
        return $http.post(
            srv._baseUrl + '/wettkampf/', wettkampf
        );
    };  
    //Auswertung eines Wettkampfes
    srv.getAuswertungWettkampf = function(wettkampfId) {
		return $http.get( srv._baseUrl + "/wettkampf/"+ wettkampfId+"/auswertung/"); 
    };
    //neue Turner anlegen
    srv.newTurner = function(turner) {
        return $http.post(
            srv._baseUrl + '/athletendatei/turner/', turner
        );
    };
    //neue Mannschaften anlegen
    srv.newMannschaft = function(mannschafte) {
        return $http.post(
            srv._baseUrl + '/athletendatei/mannschaften/', mannschafte
        );
    };
    //alle Turner und Mannschaften löschen
    srv.deleteAllTurnerMannschafte = function(wettkampfId, geraet, heimMannschaft, nummer) {
		return $http.delete( srv._baseUrl + "/athletendatei/"); 
    };
    //Ergebnisse in Wettkampf anpassen
    srv.updateErgebnisse = function(wettkampfId, ergebnisse) {
    	return $http.post(
                srv._baseUrl +'/wettkampf/'+ wettkampfId +'/updatergebnisse/', ergebnisse)
    };
    

    // Public API
    return {
    	getAllMannschaften: function() {
            return srv.getAllMannschaften();
        },
        getMannschaft: function(mannschaftId) {
            return srv.getMannschaft(mannschaftId);
        },
        getAllTurner: function() {
            return srv.getAllTurner();
        },
        getTurner: function(turnerId) {
            return srv.getTurner(turnerId);
        },
        getTurnerByMannschaft: function(mannschaftId) {
            return srv.getTurnerByMannschaft(mannschaftId);
        },
        editUebung: function(uebung) {
            return srv.editUebung(uebung);
        },
        resetUebung: function(wettkampfId, geraet, heimMannschaft, nummer) {
            return srv.resetUebung(wettkampfId, geraet, heimMannschaft, nummer);
        },
        getAllWettkaempfe: function() {
            return srv.getAllWettkaempfe();
        },
        getInfoWettkampf: function(wettkampfId) {
            return srv.getInfoWettkampf(wettkampfId);
        },
        getInfoExtWettkampf: function(wettkampfId) {
            return srv.getInfoExtWettkampf(wettkampfId);
        },
        getWertungeWettkampf: function(wettkampfId) {
            return srv.getWertungeWettkampf(wettkampfId);
        },
        newWettkampf: function(wettkampf) {
            return srv.newWettkampf(wettkampf);
        },
        getAuswertungWettkampf: function(wettkampfId) {
            return srv.getAuswertungWettkampf(wettkampfId);
        },
        newTurner: function(turner) {
            return srv.newTurner(turner);
        },
        newMannschaft: function(mannschafte) {
            return srv.newMannschaft(mannschafte);
        },
        deleteAllTurnerMannschafte: function() {
            return srv.deleteAllTurnerMannschafte();
        },
        updateErgebnisse: function(wettkampfId, ergebnisse) {
            return srv.updateErgebnisse(wettkampfId, ergebnisse);
        }
    };
}]);