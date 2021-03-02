<html> 




























<head><title>SN Bulk Assign</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<script>

    function validateForm() {
          var x = document.forms["myForm"]["quantityReceived"].value;
          if (x == "" || x == null) {
            alert("Quantity Received must be filled out");
            return false;
  }
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
  <h1>SN BULK ASSIGN</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a class="active" href="snBulkAssignTable">SN Bulk Assign </a></li>
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
                       
                       <option value="${obj.getPartNumber() }">${obj.getPartNumber() } </option>
                    ${dropDownPartNumber }
  </select> </td> </tr>
                    
                      <tr>  <td>  <label>REV ID:</label></td>
                       <td><select  id="select" name="revId" >
 <option value="${obj.getRevId() }">${obj.getRevId() } </option>
                       
                    ${dropDownRevId }
  </select> </td> </tr>
                   
                       <tr> <td>  <label>DATE RECEIVED:</label></td>
                        <td><input type="date" name="dateReceived" value="${dateReceived} "/> </td> </tr>
                    
                       <tr> <td>  <label>QUANTITY RECEIVED:</label></td>
                       <td><input type="text" name="quantityReceived"  value="${obj.getQuantityReceived()} "/> </td> </tr>
                   
                      <tr><td>  <label>SUPPLIER:</label></td>
                        <td><select  id="select" name="supplier" >
                        <option value="${obj.getSupplier() }">${obj.getSupplier() } </option>
                    ${dropDownSupplier }
  </select> </td> </tr>
                   
                       <tr> <td>  <label>SUPPLIER PN:</label></td>
                       <td> 
         <select  id="select" name="supplierPn" >
         <option value="${obj.getSupplierPn() }">${obj.getSupplierPn() } </option>
                    ${dropDownSupplierPn }
  </select></td> </tr>
                   
                       <tr>  <td>  <label>SUPPLIER LOT NUMBER:</label></td>
                       <td><input type="text" name="supplierLotNumber" value="${obj.getSupplierLotNumber()} " /> </td> </tr>
                   
                    <tr>  <td>  <label>COMMENTS:</label></td>
                       <td><textarea type="text" name="comments"  /> ${obj.getComments()}</textarea></td> </tr>
                   
                <tr> <td colspan=2> <input type="submit" value="${button }" /></td> </tr></table></form> 
                </div>
<br>
 <div class="dropdown">
<button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestBulk">NEWEST</a>
    <a href="oldestBulk">OLDEST</a>
    
  </div>
</div><br><br>

<table id="design" class="data"><tr><th>PART NUMBER</th><th>REV ID</th><th>DATE RECEIVED</th><th>QUANTITY RECEIVED</th><th>SUPPLIER</th><th>SUPPLIER PN</th><th>SUPPLIER LOT NUMBER</th><th>COMMENTS</th><th>ACTIONS</th></tr>

${tableData }

</table>
<br>
<br>
<br>
<br>
<br>
<br></body></html>