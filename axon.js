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


function checkedBox(checkbox)
{
   
    	//console.log("yay");
    	//data["Main"] = jq_TabContents_Mian;
    	
    	if (checkbox.checked){
        	data[checkbox.name] = checkbox.value;
    	} else {
    		delete data[checkbox.name];
    	}
	var res = "";
        for (var key in data) {
    		res = res + key + ": " + data[key] + "\r";
	}
	$("#counter").html(res);
    
}

function changeSelect(sel)
{
	if (sel.value != "empty"){
        	data[sel.name] = sel.value;
	} else {
		alert("erasing it");
		delete data[sel.name];
	}
	var res = makeResultString();
	$("#counter").html(res);
}

function sendData()
{
	var res = makeResultString();
	alert("Sending " + res);
} 

function makeResultString(){
	var res = "";
	for (var key in data) {
    		res = res + key + ": " + data[key] + "\r";
	}
	return res;
}
