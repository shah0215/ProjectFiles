<html> 



























<head><title>PO Table</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<script>

    
    
    function showContent() {

        if(document.getElementById("formContent").style.display == "block") {
            document.getElementById("formContent").style.display="none"; 
            document.getElementById("showFormBtn").value="Show Form"; 
            
        } else {

            document.getElementById("formContent").style.display="block"; 
            document.getElementById("showFormBtn").value="Hide Form"; 
        }
    }
</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body> 




<div class="header">
  <h1>PO INFORMATION</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a class="active" href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
<br>
<input id="showFormBtn" onClick="showContent()" type=button value="HIDE" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="${action }" method="post" onsubmit="return  validateForm()">
                   <table id="design" >
                      <tr> <td> <label>PART NUMBER:</label></td>
                       <td><select  id="select" name="partNumber" >
                       <option value="${obj.getPartNumber() }"> ${obj.getPartNumber() } </option>
                    ${dropDownPartNumber }
  </select>  </td> </tr>
                    
                      <tr>  <td>  <label>SUPPLIER:</label></td>
                       <td><select  id="select" name="supplier" >
                       <option value="${obj.getSupplier() }"> ${obj.getSupplier() } </option>
                    ${dropDownSupplier }
  </select> </td> </tr>
                   
                       <tr> <td>  <label>QUOTE ID:</label></td>
                        <td><select  id="select" name="quoteId" >
                        <option value="${obj.getQuoteId() }"> ${obj.getQuoteId() } </option>
                    ${dropDownQuoteId }
  </select>  </td> </tr>
                    
                       <tr> <td>  <label>PO DATE:</label></td>
                       <td><input type="date" name="poDate"  value="${obj.getPodate()} "/> </td> </tr>
                   
                      <tr><td>  <label>ORDER QUANTITY:</label></td>
                        <td><select  id="select" name="orderQuantity" >
                                                <option value="${obj.getOrderQuantity() }"> ${obj.getOrderQuantity() } </option>
                        
                    ${dropDownOrderQuantity }
  </select> </td> </tr>
                      <tr><td>  <label>STATUS:</label></td>
                        <td><select  id="select" name="status" >
<option value="${obj.getStatus() }"> ${obj.getStatus() } </option>
                        
                    <option value="OPEN">OPEN</option>
                                        <option value="CLOSED">CLOSED</option>

                    <option value="CANCELLED">CANCELLED</option>

                   


  </select> </td> </tr>
                   
                       <tr> <td>  <label>COMMENTS:</label>
                       <td><textarea type="text" name="comments" /> ${obj.getComments()}</textarea></td> </tr>

         </td> </tr>
                   
                       
                    
                <tr> <td colspan=2> <input type="submit" value="${button }" /></td> </tr></table></form> 
                </div>
<br>
 <div class="dropdown">
<button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestPo">NEWEST</a>
    <a href="oldestPo">OLDEST</a>
    
  </div>
</div><br><br>

<table id="design" class="data"><tr><th>PART NUMBER</th><th>SUPPLIER</th><th>QUOTE ID</th><th>PO DATE</th><th>ORDER QUANTITY</th><th>STATUS</th><th>COMMENTS</th><th>ACTIONS</th></tr>

${tableData }

</table>
<br>
<br>
<br>
<br>
<br>
<br></body></html>