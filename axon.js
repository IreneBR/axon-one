(function(){

	//call the UI page "home"
	App.load('Home');

	setInterval(function(){
	
		$.getJSON( "http://localhost:8080/nervousnet-api/raw-sensor-data/GPS", function( data ) {
			
			$("#sensordata").html(JSON.stringify(data));
			
		});
		
		
	}, 1000);
	

})();

var x = 5;
function checkedBox(checkbox)
{
    if (checkbox.checked)
    {
    	console.log("yay");
        $("#counter").html(checkbox.name + " set to " +checkbox.value);
    }
}

function changeSelect(sel)
{
	$("#counter").html(sel.name + " set to " + sel.value);
}
