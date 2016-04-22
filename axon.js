(function(){

	//call the UI page "home"
	App.load('Home');
	var x = 5;
	var y = 0;
	setInterval(function(){
	
		$.getJSON( "http://localhost:8080/nervousnet-api/raw-sensor-data/GPS", function( data ) {
			
			$("#sensordata").html(JSON.stringify(data));
			
		});
		
		
	}, 1000);
	

})();
