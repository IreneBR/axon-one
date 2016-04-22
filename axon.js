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
function checkCounter(checkbox)
{
    if (checkbox.checked)
    {
    	console.log("yay");
        $("#counter").html(checkbox.value " totally");
    }
}
