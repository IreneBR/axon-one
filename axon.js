(function(){

	//call the UI page "home"
	App.load('Home');

	setInterval(function(){
	
		$.getJSON( "http://localhost:8080/nervousnet-api/raw-sensor-data/GPS", function( data ) {
			
			$("#sensordata").html(JSON.stringify(data));
			
		});
		
		
	}, 1000);
	

})();

var data = {}; 
var res = "";

function checkedBox(checkbox)
{
   
    	//console.log("yay");
    	//data["Main"] = jq_TabContents_Mian;
        data[checkbox.name] = checkbox.value;

        for (var key in data) {
    		res = res + key + ": " + data[key] + "\r";
	}
	$("#counter").html(res);
    
}

function changeSelect(sel)
{

        data[sel.name] = sel.value;

        for (var key in data) {
    		res = res + key + ": " + data[key] + "\r";
	}
	$("#counter").html(res);
}
