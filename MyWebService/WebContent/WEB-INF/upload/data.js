/**
 * this javascript does validation and calls data rest service
 */


function myfunc() 
{
			
		/**
		*	generate form data
		*/
		var fileName = document.getElementById("element_1").value;
		var desc = document.getElementById("element_2").value;
		var file = document.getElementById("element_3").files[0];
		var dd = document.getElementById("element_4_1").value;
		var mm = document.getElementById("element_4_2").value;
		var yy = document.getElementById("element_4_3").value;
		//create date
		yy = yy.concat("/");
		yy = yy.concat(mm);
		yy = yy.concat("/");
		var date = yy.concat(dd);
		
		var type_csv = document.getElementById("element_5_1");
		var type = 0;
		if(type_csv.checked)
			type = 1;
		else
			type = 0;
		
		
		
		var isLabeled = document.getElementById("element_6_1");
		var label;
		
		if(isLabeled.checked)
			label = new Boolean(true);
		else
			label = new Boolean(false);
		
		
		//create formdata here
		var data = new FormData();
		data.append("file",file);
		data.append("name",fileName);
		data.append("type",type);
		data.append("isLabeled",label);
		data.append("desc",desc);
		data.append("uploaddate",date);
	
		/**
		*   calling REST request from javascript
		*
		*/
		var c = new XMLHttpRequest();
		
		c.open("POST","http://localhost:8080/MyWebService/rest/data/upload",false);
		c.send(data);

		if(c.status == 200)
			alert(c.responseText);
		else
			alert(c.status + ":" + c.statusText);
				
		// redirect to main page if successfully done
		
		alert(c.responseText);
		
}
	
	