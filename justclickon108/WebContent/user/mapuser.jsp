<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" /> 
  <title>Google Maps Multiple Markers</title> 
  <script src="http://maps.google.com/maps/api/js?key=AIzaSyDGBTc2yRLHSq8TeEJl-80Zl3VPShIbfXU&sensor=false" 
          type="text/javascript"></script>
</head> 
<body>

<input type="hidden" name="flag" value="search"/>
                                    <table style= "display:none;">
                                        <thead>
                                        <tr>
                                            <th>Ambulance Number</th>
                                            <th>Model Number</th>
                                            <th>allocation</th>
                                            <th>passingyear</th>
                                            <th>statename</th>
                                            <th> cityname</th>
                                            <th> areaname</th>
                                            <th> latitude</th>
                                            <th> longitude</th>
                                            <th> action</th>
                                        </tr>
                                        </thead>
										<f:forEach items="${sessionScope.searchlist}" var="a">
										<tr>
										<td>${a.ambulanceNumber}</td>
										<td>${a.modelNumber}</td>
										<td>${a.allocation}</td>
										<td>${a.passingYear} </td>
											               <td>
                                                        	${a.statevo.stateName}
                                                        	</td>
                                                        	<td>
                                                       	    ${a.cityvo.cityName}
                                                        	</td>
                                                        	<td>
                                                        	${a.areavo.areaName}
                                                        	</td>
                                                        	<td>
                                                        	${a.latitude}
                                                        	<input type="hidden" value="${a.latitude}" name="hd_lat" />
                                                        	</td>
                                                        	<td>
                                                        	${a.longitude}
                                                        	<input type="hidden" value="${a.longitude}" name="hd_lng" />
                                                        	</td>
										<td><a href="<%=request.getContextPath()%>/AmbulanceController?flag=edit&ambulanceNumber=${a.ambulanceNumber}">edit</a> </td>
										<td><a href="<%=request.getContextPath()%>/AmbulanceController?flag=delete&ambulanceNumber=${a.ambulanceNumber}">/delete</a> </td>
										</tr>
										<tr>
										</tr>
										</f:forEach>
                                    </table>
  <div id="map" style="width: 700px; height: 500px;"></div>

  <script type="text/javascript">
    var locations = [
      ['Bondi Beach', -33.890542, 151.274856, 4],
      ['Coogee Beach', -33.923036, 151.259052, 5],
      ['Cronulla Beach', -34.028249, 151.157507, 3],
      ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
      ['Maroubra Beach', -33.950198, 151.259302, 1]
    ];

    var lat = document.getElementsByName("hd_lat");
    var lng = document.getElementsByName("hd_lng");
    
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(parseFloat(lat[0].value), parseFloat(lng[0].value)),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;
    for (i = 0; i < lat.length; i++) {  
alert(lng[i].value);
    	marker = new google.maps.Marker({
        position: new google.maps.LatLng(parseFloat(lat[i].value), parseFloat(lng[i].value)),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent("");
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>
</body>
</html>