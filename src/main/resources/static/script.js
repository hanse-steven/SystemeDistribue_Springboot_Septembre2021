$(document).ready(function(){
	$.ajax({
	url: "http://localhost:10000/api/articles",
	crossDomain: true,
	type: "GET",
	dataType: "json",
	})
	.done(function(response){
        /*let data = JSON.stringify(response);
        $("div#res").append(data);*/
		console.log(response);
    })
	.fail(function(error){
        alert("La requête s'est terminée en échec. Infos : " + JSON.stringify(error));
    });
});