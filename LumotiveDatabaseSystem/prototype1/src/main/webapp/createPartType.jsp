<html> 





























<head><title>Create Part Type</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<script>

    function validateForm() {
    	  var x = document.forms["myForm"]["id"].value;
    	  if (x == "" || x == null) {
    	    alert("Part Type ID must be filled out");
    	    return false;
  }
}
    
    function showContent() {

    	if(document.getElementById("formContent").style.display == "block") {
            document.getElementById("formContent").style.display="none"; 
            document.getElementById("showFormBtn").value="Add Part Type"; 
    		
    	} else {

            document.getElementById("formContent").style.display="block"; 
            document.getElementById("showFormBtn").value="Cancel"; 
    	}
    }
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body> 




<div class="header">
  <h1>CREATE PART TYPE INFORMATION</h1>
</div>
    <ul>
        <li><a class="active"  href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
<input id="showFormBtn" onClick="showContent()" type=button value="Cancel" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="submit" method="post" onsubmit="return  validateForm()">
                <p style="color:red;">${Error}</p>
                   <table id="design" >
                      <tr> <td> <label>Type ID:</label></td>
                       <td><input type="text" name="id" value="${id} " /> </td> </tr>
                    
                      <tr>  <td>  <label>Description:</label></td>
                       <td><input type="text" name="description" value="${description} " /> </td> </tr>
                   
                       <tr> <td>  <label>Custom Field 1:</label></td>
                        <td><input type="text" name="field1" value="${f1} "/> </td> </tr>
                    
                       <tr> <td>  <label>Custom Field 2:</label></td>
                       <td><input type="text" name="field2"  value="${f2} "/> </td> </tr>
                   
                      <tr><td>  <label>Custom Field 3:</label></td>
                        <td><input type="text" name="field3"  value="${f3} "/>  </td> </tr>
                   
                       <tr> <td>  <label>Custom Field 4:</label></td>
                       <td><input type="text" name="field4" value="${f4} " /></td> </tr>
                   
                        <tr> <td> <label>Custom Field 5:</label></td>
                       <td><input type="text" name="field5" value="${f5} " /></td> </tr>
                    
                <tr> <td colspan=2> <input type="submit" value="Submit" /></td> </tr></table></form> 
                </div>
                <div class="dropdown">
  <button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newest">NEWEST</a>
    <a href="oldest">OLDEST</a>
    <a href="partTypeIdDesc">DESCENDING BY PART TYPE ID</a>
    <a href="partTypeIdAsc">ASCENDING BY PART TYPE ID</a>
  </div>
</div><br><br>

<table id="design"><tr><th>PART TYPE ID</th><th>DESCRIPTION</th><th>CUSTOM FIELD 1</th><th>CUSTOM FIELD 2</th><th>CUSTOM FIELD 3</th><th>CUSTOM FIELD 4</th><th>CUSTOM FIELD 5</th><th>ACTIONS</th></tr>${tableData }</table>


<br>
<br>
<br>
<br>
<br>
<br>
<br></body></html>