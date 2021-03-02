<html> 



























<head><title>Quote</title>
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
  <h1>QUOTE INFORMATION</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a class="active" href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
<br>

<input id="showFormBtn" onClick="showContent()" type=button value="HIDE" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="${action }" method="post" onsubmit="return  validateForm()">
                   <table id="design" >
                     
                    
                      <tr>  <td>  <label>PART NUMBER:</label></td>
                       <td> <select  id="select" name="partNumber" >
                       <option value="${obj.getPartNumber() }"> ${obj.getPartNumber() } </option>
                    ${dropDownPartNumber }
  </select> </td> </tr>
                   
                       <tr> <td>  <label>SUPPLIER NAME:</label></td>
                        <td><input type="text" name="supplierName" value="${obj.getSupplierName()} "/> </td> </tr>
                    
                       <tr> <td>  <label>QUOTE ID:</label></td>
                       <td><input type="text" name="quoteId"  value="${obj.getQuoteId()} "/> </td> </tr>
                   
                      <tr><td>  <label>QUOTE LINK:</label></td>
                        <td><input type="text" name="quoteLink"  value="${obj.getQuoteLink()} "/>  </td> </tr>
                   
                       <tr> <td>  <label>SUPPLIER LINK:</label></td>
                       <td> <input type="text" name="supplierLink"  value="${obj.getSupplierLink()} "/></td> </tr>
                   
                       <tr> <td>  <label>QUOTE DATE:</label></td>
                       <td> <input type="date" name="quoteDate"  value="${obj.getQuoteDate()} "/></td> </tr>
                    
                    <tr> <td>  <label>SUPPLIER PN:</label></td>
                       <td> <input type="text" name="supplierPn"  value="${obj.getSupplierPn()} "/></td> </tr>
                    
                    <tr> <td>  <label>MANUFACTURER PN:</label></td>
                       <td> <input type="text" name="manufacturerPn"  value="${obj.getManufacturerPn()} "/></td> </tr>
                       
                       <tr> <td>  <label>CURRENCY:</label></td>
                       <td><select  id="select" name="currency">
                       <option value="${obj.getCurrency() }">${obj.getCurrency() }</option>
                    
                    <option value="USD">USD</option>
                    <option value="CAD">CAD</option>
                    
  </select></td> </tr>
  
  <tr><td> <label>1.  QUANTITY:</label><input type="text" name="quantity1"  value="${json.getQuantity().get(0)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre1"  value="${json.getNre().get(0)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price1"  value="${json.getPrice().get(0)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime1"  value="${json.getLeadTime().get(0)} "/></td></tr>
  
  
        <tr><td> <label>2.  QUANTITY:</label><input type="text" name="quantity2"  value="${json.getQuantity().get(1)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre2"  value="${json.getNre().get(1)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price2"  value="${json.getPrice().get(1)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime2"  value="${json.getLeadTime().get(1)} "/></td></tr>


<tr><td> <label>3.  QUANTITY:</label><input type="text" name="quantity3"  value="${json.getQuantity().get(2)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre3"  value="${json.getNre().get(2)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price3"  value="${json.getPrice().get(2)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime3"  value="${json.getLeadTime().get(2)} "/></td></tr>


<tr><td> <label>4.  QUANTITY:</label><input type="text" name="quantity4"  value="${json.getQuantity().get(3)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre4"  value="${json.getNre().get(3)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price4"  value="${json.getPrice().get(3)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime4"  value="${json.getLeadTime().get(3)} "/></td></tr>


<tr><td> <label>5.  QUANTITY:</label><input type="text" name="quantity5"  value="${json.getQuantity().get(4)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre5"  value="${json.getNre().get(4)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price5"  value="${json.getPrice().get(4)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime5"  value="${json.getLeadTime().get(4)} "/></td></tr>


<tr><td> <label>6.  QUANTITY:</label><input type="text" name="quantity6"  value="${json.getQuantity().get(5)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre6"  value="${json.getNre().get(5)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price6"  value="${json.getPrice().get(5)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime6"  value="${json.getLeadTime().get(5)} "/></td></tr>


<tr><td> <label>7.  QUANTITY:</label><input type="text" name="quantity7"  value="${json.getQuantity().get(6)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre7"  value="${json.getNre().get(6)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price7"  value="${json.getPrice().get(6)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime7"  value="${json.getLeadTime().get(6) }"/></td></tr>


<tr><td> <label>8.  QUANTITY:</label><input type="text" name="quantity8"  value="${json.getQuantity().get(7)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre8"  value="${json.getNre().get(7)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price8"  value="${json.getPrice().get(7)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime8"  value="${json.getLeadTime().get(7)} "/></td></tr>


<tr><td> <label>9.  QUANTITY:</label><input type="text" name="quantity9"  value="${json.getQuantity().get(8)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre9"  value="${json.getNre().get(8)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price9"  value="${json.getPrice().get(8)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime9"  value="${json.getLeadTime().get(8)} "/></td></tr>


<tr><td> <label>10.  QUANTITY:</label><input type="text" name="quantity10"  value="${json.getQuantity().get(9)} "/></td>
  <td> <label>NRE:</label><input type="text" name="nre10"  value="${json.getNre().get(9)} "/></td>
              <td> <label>PRICE:</label><input type="text" name="price10"  value="${json.getPrice().get(9)} "/></td>
  <td> <label>LEAD TIME:</label><input type="text" name="leadTime10"  value="${json.getLeadTime().get(9)} "/></td></tr>  
                    
                    
                <tr> <td colspan=2> <input type="submit" value="${button }" /></td> </tr></table></form> 
                </div>
<br>
 <div class="dropdown">
<button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestQuote">NEWEST</a>
    <a href="oldestQuote">OLDEST</a>
   
  </div>
</div><br><br>

<table id="design" class="data"><tr><th>PART NUMBER</th><th>SUPPLIER NAME</th><th>QUOTE ID</th><th>QUOTE LINK</th><th>SUPPLIER LINK</th><th>QUOTE DATE</th><th>SUPPLIER PN</th><th>MANUFACTURER PN</th><th>CURRENCY</th><th>QUANTITY, NRE, PRICE, LEAD TIME</th><th>ACTIONS</th></tr>

${tableData }

</table>
<br>


<br>
<br>
<br>
<br>
<br></body></html>