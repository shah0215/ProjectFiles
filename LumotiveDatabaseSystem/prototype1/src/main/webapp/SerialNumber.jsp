<html> 


























<head><title>Serial Number</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<script>

   
}
    
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
  <h1>SERIAL NUMBER</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a class="active" href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
<br>
<input id="showFormBtn" onClick="showContent()" type=button value="HIDE" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="${action }" method="post" onsubmit="return  validateForm()">
                   <table id="design" >
                     
                    
                      <tr>  <td>  <label>PART NUMBER:</label></td>
                       <td><select  id="select" name="partNumber" >
                       <option value="${obj.getPartNumber() }">${obj.getPartNumber() } </option>
                    ${dropDownPartNumber }

  </select> </td> </tr>
                   
                       <tr> <td>  <label>REV ID:</label></td>
                        <td><select  id="select" name="revId" >
                        <option value="${obj.getRevId() }">${obj.getRevId() } </option>
                    ${dropDownRevId }

  </select> </td> </tr>
                    
                      
                   
                      <tr><td>  <label>DATE RECEIVED:</label></td>
                        <td><input type="date" name="dateReceived"  value="${obj.getDateReceived()} "/>  </td> </tr>
                   
                       <tr> <td>  <label>SUPPLIER LOT NUMBER:</label></td>
                       <td><select  id="select" name="supplierLotNumber" >
                       <option value="${obj.getSupplierLotNumber() }">${obj.getSupplierLotNumber() } </option>
                    ${dropDownSupplierLotNumber }

  </select> </td> </tr>

                   
                       <tr> <td>  <label>SUPPLIER SERIAL NUMBER:</label></td>
                       <td><input type="text" name="supplierSerialNumber"  value="${obj.getSupplierSerialNumber()} "/> </td> </tr>
                    
                    <tr> <td>  <label>STATUS:</label></td>
                       <td><select  id="select" name="status" >
                       <option value="${obj.getStatus() }">${obj.getStatus() } </option>
                    <option value="STOCK">STOCK</option>
                    <option value="SHIPPED">SHIPPED</option>

                    <option value="REJECT">REJECT</option>
                    <option value="REWORK">REWORK</option>
                    <option value="RETURN">RETURN</option>
                    <option value="SCRAP">SCRAP</option>






  </select> </td> </tr>
                    
                    <tr> <td>  <label>LOCATION:</label></td>
                       <td><input type="text" name="location"  value="${obj.getLocation()} "/> </td> </tr>
                    
                    <tr> <td>  <label>CUSTOMER:</label></td>
                       <td><input type="text" name="customer"  value="${obj.getCustomer()} "/> </td> </tr>
                    
                    <tr> <td>  <label>TEST DATA:</label></td>
                       <td><input type="text" name="testData"  value="${obj.getTestData()} "/> </td> </tr>
                    
                    
                    <tr> <td>  <label>COMMENTS:</label></td>
                       <td><textarea type="text" name="comments"   "/> ${obj.getComments()} </textarea></td> </tr>
                       
                <tr> <td colspan=2> <input type="submit" value="${button }" /></td> </tr></table></form> 
                </div>
<br>
 <div class="dropdown">
<button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestSn">NEWEST</a>
    <a href="oldestSn">OLDEST</a>
   
  </div>
</div><br><br>

<table id="design" class="data"><tr><th>PART NUMBER</th><th>REV ID</th><th>SERIAL NUMBER</th><th>DATE RECEIVED</th><th>SUPPLIER LOT NUMBER</th>
<th>SUPPLIER SERIAL NUMBER</th><th>STATUS</th><th>LOCATION</th><th>CUSTOMER</th><th>TEST DATA</th><th>COMMENTS</th><th>ACTIONS</th></tr>

${tableData }

</table>
<br>
<br>
<br>
<br>
<br>
<br></body></html>