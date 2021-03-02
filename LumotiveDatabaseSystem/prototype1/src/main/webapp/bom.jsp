<html>


<head>
<title>BOM Table</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<style>
/* Style the body */

.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
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
    
    select {
vertical-align: middle;
  margin: 5px 10px 5px 0;
  padding: 10px;
  background-color: #fff;
  border: 1px solid #ddd;

}
    
    
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
    .form-inline {
        display: flex;
        margin-left: 4in;
        margin-right: 4in;
        flex-flow: COLUMN wrap;
        align-items: center;
        border: 1px solid #111111;
        border-radius: 10px;
        background-color: #B0E0E6;

    }
    .form-inline label {
        margin: 5px 10px 5px 0;
    }
    .form-inline input {
        vertical-align:center;
        display:inline-block;
        margin: 5px 10px 5px 0;
        padding: 10px;
        background-color: #fff;
        border: 1px solid #ddd;
    }
    .form-inline #submit {

        border: 1px solid #111111;
        background-color:#333333 ;
        padding: 10px 20px;
        color: #ffffff;
        width: auto;
        cursor: pointer;
    }
    .form-inline #submit:hover {
        background-color: #1abc9c;
    }



    table, th, td {  border: 1px solid black; width:1500px; text-align:center;}  
    #design {  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
     border-collapse: collapse; width: 100%; }
     #design td, #design th { border: 1px solid #ddd; padding: 8px;}
     #design tr:nth-child(even){background-color: #f2f2f2;}
     #design tr:hover {background-color: #ddd;}#
     customers th {padding-top: 12px; padding-bottom: 12px; text-align: left; background-color: #4CAF50; color: white;}

</style>
<body> 

    <div class="header">
        <h1>BOM Table</h1>
    </div>
    <ul>
        <li><a href="dashboard">Part Type </a></li>
        <li><a href="partTable">Part </a></li>
        <li><a class="active" href="bomTable">BOM </a></li>
        <li><a href="projectTable">Project </a></li>
        <li><a href="quoteTable">Quote </a></li>
        <li><a href="poTable">PO Table </a></li>
        <li><a href="snBulkAssignTable">SN Bulk Assign </a></li>
        <li><a href="serialNumberTable">Serial Number </a></li>
    </ul>
    
<input id="showFormBtn" onClick="showContent()" type=button value="Hide Form" ><br>
<div id="formContent">
    <form name="myForm" class="form-inline" action="addNewBom" method="post"
        onsubmit="return  validateForm()">

        <div>
        <label>Parent Part Number :</label> 
         <select  name="parentPartNumber">
                    ${dropDown }
  </select>
        </div>
        
        <div>   
        <label>Child Part Number and Quantity :</label> 
<select  name="childPart" multiple>
                    ${dropDown }
  </select>        </div>
        
        
        
        <div>
        <input type="submit" value="Submit" id = "submit"/>
        </div>
        
    </form>
    </div>
      <div class="dropdown">
  <button class="dropbtn">SORT</button>
  <div class="dropdown-content">
    <a href="newestBom">NEWEST</a>
    <a href="oldestBom">OLDEST</a>
   
  </div>
</div><br><br>
    <table id="design">
        <tr>
            <th>PARENT PART NUMBER</th>
            <th>CHILD PART NUMBER</th>
            <th>ACTIONS</th>
        </tr>
        ${tableData }
    </table>
</body>
</html>