<html> 

<head><title>Part Information</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> </head>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<body> 




<div class="header">
  <h1> PART INFORMATION</h1>
</div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a class="active" href="partTable">Part </a></li>
        <li><a href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
<br>
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
<input id="showFormBtn" onClick="showContent()" type=button value="Hide Form" ><br>
<div id="formContent">
  <form name="myForm" class="form-inline" action="${action}" method="post" >
                
                   
                       <table id="design" >
                     
                        <tr> <td><label for >PART TYPE ID :</label></td>
                      <td> <select  name="partTypeId">  ${dropDown }</select></td>
        <td>  <label>TEST PLAN :</label></td>
          <td><input type="text" name="assemblyTestPlan" value="${obj.getAssemblyTestPlan()} " /> </td></tr>
                      
        <tr> <td> <label>REV ID :</label></td>
          <td><input type="number" name="revId" value="00" /> </td>
                       <td>  <label>CUSTOM FIELD 1 :</label></td>
                        <td><input type="text" name="field1" value="${obj.getCustomField1()} "/> </td></tr>
  
          

        <tr><td>  <label>DESCRIPTION :</label></td>
          <td><input type="text" name="description" value="${obj.getPartDescription()} " /> </td>
                      <td>  <label>CUSTOM FIELD 2 :</label></td>
                       <td><input type="text" name="field2"  value="${obj.getCustomField2()} "/> </td> </tr>
     
         <tr><td> <label>PART CODE :</label></td>
          <td><input type="text" name="partCode" value="${obj.getPartCode()} " /></td>
                      <td>  <label>CUSTOM FIELD 3 :</label></td>
                        <td><input type="text" name="field3"  value="${obj.getCustomField3()} "/>  </td></tr>
     
         <tr><td> <label>FOLDER LINK :</label></td>
          <td><input type="text" name="folderLink" value="${obj.getPartFolderLink()} " /></td>
                      <td>  <label>CUSTOM FIELD 4 :</label></td>
                       <td><input type="text" name="field4" value="${obj.getCustomField4()} " /></td></tr>
      
         <tr><td> <label>INSPECTION DOCUMENT :</label></td>
          <td><input type="text" name="inspectionDocument" value="${obj.getInspectionDocument()} " /> </td>
                      <td> <label>CUSTOM FIELD 5 :</label></td>
                       <td><input type="text" name="field5" value="${obj.getCustomField5()} " /></td></tr>

                    
               <tr><td colspan=4> <input  type="submit" value="${button }"  /></td> </tr></table></form>
               </div>
                <div class="dropdown">
  <button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestPart">NEWEST</a>
    <a href="oldestPart">OLDEST</a>
   
  </div>
</div><br><br>
<table id="design">
        <tr><th>Part ID</th>
        <th>PART TYPE ID</th>
        <th>REV ID </th>
        <th>DESCRIPTION</th>
        <th>PART CODE</th>
        <th>FOLDER LINK</th>
        <th>INSPECTION DOCUMENT </th>
        <th>TEST PLAN </th>
        <th>CUSTOM FIELD 1</th>
        <th>CUSTOM FIELD 2</th>
        <th>CUSTOM FIELD 3</th>
        <th>CUSTOM FIELD 4</th>
        <th>CUSTOM FIELD 5</th>
        <th>ACTIONS</th>
    </tr>${tableData}</table>

</body></html>