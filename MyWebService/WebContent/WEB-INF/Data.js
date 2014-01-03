/**
 * this javascript does validation and calls data rest service
 */

function myfunc() {
			
		var form = document.getElementById('dataForm');
		
		//add validation
		var type = document.getElementsByName('type')[0].value;
		
		if(type != "0" && type != "1") {
			alert("possible values for type is 0 [arff] or 1 [csv]");
			return;
		} 
					
		var islabel = document.getElementsByName('isLabeled')[0].value;
			
		if(islabel.toUpperCase() != "FALSE" && islabel.toUpperCase() != "TRUE") {
			alert("possible values for islabel is FALSE or TRUE");
			return;
		}
		
		// bind the form data
		var formData = new FormData(form);		
		
		/**
		*   calling REST request from javascript
		*
		*/
		var c = new XMLHttpRequest();
		
		c.open("POST","http://localhost:8080/MyWebService/rest/data/upload",false);
		c.send(formData);
		
		alert(c.responseText);
				
		// redirect to main page if successfully done
		
		window.location.href = "Home.htm";
	}
	
	
