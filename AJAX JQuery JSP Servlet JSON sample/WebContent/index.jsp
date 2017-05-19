<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>JSON with JSP</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

  $(document).ready(function(){
	  $('#button1').click(function(){
		  $.ajax({
			  type:'GET',
		      url:'product?action=demo1',
		      headers:{
		    	  Accept: "application/json; charset=utf-8",
		    	    "Content-Type" : "application/json; charset=utf-8"
		      },
		      success: function(result){
				  var product= $.parseJSON(result);
				  document.getElementById('result1').innerHTML= 'Id: ' + product.id + '<br>Name: ' +product.name + '<br>Price: ' + product.price;
		  }
		  });		  
	  });   

//	  $('#button2').click(function(){
		  $.ajax({
			  type:'GET',
		      url:'product?action=demo2',
		      headers:{
		    	  Accept: "application/json; charset=utf-8",
		    	    "Content-Type" : "application/json; charset=utf-8"
		      },
		      success: function(result){
				  var listProducts= $.parseJSON(result);
				  var s= '';
				  for(var i=0; i<listProducts.length; i++){
					  s += 'Id: ' +  listProducts[i].id + '<br>Name: ' +listProducts[i].name + '<br>Price: ' + listProducts[i].price + '<br>==============================================<br>';
				  }
				  document.getElementById('result2').innerHTML= s;
		  }
		  });		  
	  });
//  });
  

</script>
</head>
<body>

<fieldset>
   <legend>Demo 1</legend>
   <input type="button" value = "Display Object" id="button1">
   <br>
   <div id="result1" ></div>
</fieldset>

<fieldset>
   <legend>Demo 2</legend>
   <input type="button" value = "Display Object" id="button2">
   <br>
   <div id="result2" ></div>
</fieldset>
</body>
</html>