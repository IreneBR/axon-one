(function(){

	//call the UI page "home"
	App.load('Home');

	setInterval(function(){
	
		$.getJSON( "http://localhost:8080/nervousnet-api/raw-sensor-data/GPS", function( data ) {
			
			$("#sensordata").html(JSON.stringify(data));
			gps = JSON.stringify(data);
		});
		
		
	}, 1000);
	

})();

var data = {}; 
var gps = "";


function checkedBox(checkbox)
{
   
    	//console.log("yay");
    	
    	if (checkbox.checked){
        	data[checkbox.name] = checkbox.value;
    	} else {
    		delete data[checkbox.name];
    	}
	//var res = makeResultString();
	//$("#counter").html(res);
    
}

function changeSelect(sel)
{
	if (sel.value != "empty"){
        	data[sel.name] = sel.value;
	} else {
		delete data[sel.name];
	}
	//var res = makeResultString();
	//$("#counter").html(res);
}

function getDateTime() {
    var now     = new Date(); 
    var year    = now.getFullYear();
    var month   = now.getMonth()+1; 
    var day     = now.getDate();
    var hour    = now.getHours();
    var minute  = now.getMinutes();
    var second  = now.getSeconds(); 
    if(month.toString().length == 1) {
        var month = '0'+month;
    }
    if(day.toString().length == 1) {
        var day = '0'+day;
    }   
    if(hour.toString().length == 1) {
        var hour = '0'+hour;
    }
    if(minute.toString().length == 1) {
        var minute = '0'+minute;
    }
    if(second.toString().length == 1) {
        var second = '0'+second;
    }   
    var dateTime = year+'/'+month+'/'+day+' '+hour+':'+minute+':'+second;   
     return dateTime;
}

function sendData()
{
	var obj = JSON.parse(gps);
	for (var key in data) {
    		var valu = "::name_" + data[key] + "::" + obj.lat + "::" + obj.long + "::" + getDateTime();
		storeNameValue(key,valu);
	}
	alert("Information Sent");
	data = {};
	App.load('Home');
} 

function storeNameValue(nam, val){
	//alert("scheiss " + gps);
	
	
	$.ajax({ type: 'POST',
	processData: false,
	contentType: 'application/json',
	//data: '{ "names" : "Guillaumeee" }', 
	data: '{"' + nam + '": "' +  val + '"}', 
	//data: '{"vars": "vala"}',
	url: '129.132.255.27:8445/',
	success: function(json) { 
		console.log('/sayHello POST was successful.');
		console.log(json); 
	} });
	
	//alert("Name: " + nam + " val: " + val);
}

function makeResultString(){
	var res = "";
	for (var key in data) {
    		res = res + key + ": " + data[key] + "\r";
	}
	return res;
}
