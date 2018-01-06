var xmlHttpRequest;
function sendWithPostMethod() {
	
	var url = "load";
	
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("POST", url, true);
	xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpRequest.send("load=" + "1");
}

function receive() {
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		console.log("receive")
		var response = JSON.parse(xmlHttpRequest.responseText);
		var namelist = response.namelist;
		var names = namelist.split(',');
		names.shift();
		console.log(names);
		document.open();
		document.write('<link rel="stylesheet" type="text/css" href="download.css"/>');	
		document.write('<input type ="button"　 id="start_draw" value="戻る" onclick="location.href=\'http://localhost:8080/isp2/project/oekaki/title.html\'"><br>')
			for(var i = names.length;i--;){
			var name = names[i].split('.');
			
		//	document.write('<input type ="button"　 id="start_draw" value="'+name[0]+'" onclick="location.href=\'http://localhost:8080/isp2/project/oekaki/save/'+name[0]+'.png\'"\'><br>');
			document.write('<a href ="http://localhost:8080/isp2/project/oekaki/save/'+name[0]+'.png" download="'+name[0]+'.png">'+name[0]+'</a><br>');
	}
		document.close();
	}
}
window.addEventListener("load",function() { 
    var postButtonElement = document.getElementById("get_data");
    postButtonElement.addEventListener("click", sendWithPostMethod, false);
},false);

sendWithPostMethod();