<html> 


























<head><title>Part Type</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> </head>

<script>

    

</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* Style the body */
body {
  font-family: Arial;
  margin: 0;
}

/* Header/Logo Title */
.header {
  padding: 0px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 30px;
}


</style>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>

<style> .form-inline {  
  display: flex;
  flex-flow: row wrap;
  align-items: center;
}

.form-inline label {
  margin: 5px 10px 5px 0;
}

.form-inline input {
  vertical-align: middle;
  margin: 5px 10px 5px 0;
  padding: 10px;
  background-color: #fff;
  border: 1px solid #ddd;
}

.form-inline button {
  padding: 10px 20px;
  background-color: dodgerblue;
  border: 1px solid #ddd;
  color: blue;
  cursor: pointer;
}

.form-inline button:hover {
  background-color: royalblue;
}

@media (max-width: 800px) {
  .form-inline input {
    margin: 10px 0;
  }
  
  .form-inline {
    flex-direction: column;
    align-items: stretch;
  }
} table, th, td {  border: 1px solid black; width:1500px; text-align:center;} #design {  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;   border-collapse: collapse; width: 100%; }#design td, #design th { border: 1px solid #ddd; padding: 8px;}#design tr:nth-child(even){background-color: #f2f2f2;}#design tr:hover {background-color: #ddd;}#customers th {padding-top: 12px; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;}</style>
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
        <li><a href="PoTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
</ul>
<br><form name="myForm" class="form-inline" action="update" method="post" onsubmit="return  validateForm()">
                
                   
                        <label>TYPE ID :</label>
                       <input type="text" name="id" value="${id} " />
                    
                        <label>DESCRIPTION :</label>
                       <input type="text" name="description" value="${description} " />
                   
                        <label>CUSTOM FIELD 1 :</label>
                        <input type="text" name="field1" value="${f1} "/>
                    
                        <label>CUSTOM FIELD 2 :</label>
                       <input type="text" name="field2"  value="${f2} "/>
                   
                        <label>CUSTOM FIELD 3 :</label>
                        <input type="text" name="field3"  value="${f3} "/>
                   
                        <label>CUSTOM FIELD 4 :</label>
                       <input type="text" name="field4" value="${f4} " />
                   
                        <label>CUSTOM FIELD 5 :</label>
                       <input type="text" name="field5" value="${f5} " />
                    
                <input type="submit" value="Update" /></form>
                <h3 align='center'>DASHBOARD </h3><table id="design"><tr><th>Part ID</th><th>DESCRIPTION</th><th>CUSTOM FIELD 1</th><th>CUSTOM FIELD 2</th><th>CUSTOM FIELD 3</th><th>CUSTOM FIELD 4</th><th>CUSTOM FIELD 5</th><th>ACTIONS</th></tr>${tableData }</table></body></html>