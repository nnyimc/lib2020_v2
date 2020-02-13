
function bookSuggestion()
{  
    var xhr;
    var typeRecherche = document.getElementById("typeRecherche").value;
    var recherche = document.getElementById("contenuRecherche").value;
    if (typeof XMLHttpRequest !== "undefined") { // Mozilla, Safari, ...
        xhr = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // IE 8 and older
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }
    var data = "rechercheAuto=" + encodeURIComponent(recherche) + "&typeRechercheAuto=" + encodeURIComponent(typeRecherche);
    xhr.open("POST", "suggestion", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {	   
              
            } else {
                alert('There was a problem with the request.');
            }
        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(data);
}
