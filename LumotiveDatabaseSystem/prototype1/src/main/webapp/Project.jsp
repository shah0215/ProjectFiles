<html> 



























<head><title>Project</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<script>

  
}
    
    function showContent() {

        if(document.getElementById("formContent").style.display == "block") {
            document.getElementById("formContent").style.display="none"; 
            document.getElementById("showFormBtn").value="ADD PROJECT"; 
            
        } else {

            document.getElementById("formContent").style.display="block"; 
            document.getElementById("showFormBtn").value="HIDE"; 
        }
    }
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body> 




<div class="header">
  <h1>PROJECT INFORMATION</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM Screen</a></li>
        <li><a class="active" href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
<input id="showFormBtn" onClick="showContent()" type=button value="HIDE" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="${action }" method="post" onsubmit="return  validateForm()">
                   <table id="design" >
                     
                    
                      <tr>  <td>  <label>PROJECT NAME:</label></td>
                       <td><input type="text" name="projectName" value="${obj.getProjectName()} " /> </td> </tr>
                   
                       <tr> <td>  <label>PROJECT DESCRIPTION:</label></td>
                        <td><input type="text" name="projectDescription" value="${obj.getProjectDescription()} "/> </td> </tr>
                    
                       <tr> <td>  <label>START DATE:</label></td>
                       <td><input type="date" name="startDate"  value="${obj.getStartDate()} "/> </td> </tr>
                   
                      <tr><td>  <label>END DATE:</label></td>
                        <td><input type="date" name="endDate"  value="${obj.getEndDate()} "/>  </td> </tr>
                   
                       <tr> <td>  <label>ASSOCIATED PARTS:</label></td>
                       <td> 
         <select  id="select" name="associatedParts" multiple=true>
                    ${associatedParts }
  </select></td> </tr>
                   
                       
                    
                <tr> <td colspan=2> <input type="submit" value="${button }" /></td> </tr></table></form> 
                </div>
<br>
 <div class="dropdown">
<button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestProject">NEWEST</a>
    <a href="oldestProject">OLDEST</a>
    
  </div>
</div><br><br>

<table id="design" class="data"><tr><th>PROJECT ID</th><th>PROJECT NAME</th><th>PROJECT DESCRIPTION</th><th>START DATE</th><th>END DATE</th><th>ASSOCIATED PARTS</th><th>ACTIONS</th></tr>

${tableData }

</table>

<br>
<br>
<br>
<br>
<br>
<br></body></html>