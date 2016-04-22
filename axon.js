(function(){

	//call the UI page "home"
	App.load('Home');

	setInterval(function(){
	
		$.getJSON( "http://localhost:8080/nervousnet-api/raw-sensor-data/GPS", function( data ) {
			
			$("#sensordata").html(JSON.stringify(data));
			
		});
		
		
	}, 1000);
	

})();

var data = {}; // no need for an array


/*for (var key in arr_jq_TabContents) {
    console.log(arr_jq_TabContents[key]);
}*/

function checkedBox(checkbox)
{
   
    	console.log("yay");
    	//data["Main"] = jq_TabContents_Mian;
        $("#counter").html(checkbox.name + " set to " +checkbox.value);
    
}

function changeSelect(sel)
{
	$("#counter").html(sel.name + " set to " + sel.value);
}
