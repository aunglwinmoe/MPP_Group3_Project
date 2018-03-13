<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Makes</title>
<jsp:include page="menu.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="page-title">Model make of Vehicle</h3>
		<a href="addMake.html" class="btn"><i class="fas fa-plus-circle"></i> New</a>
		
		<c:if test="${!empty makes}">
			<table class="table table-hover" id="makeListTable">
				<thead>
					<tr>
						<!-- <th>Make ID</th> -->
						<th>Make</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${makes}" var="make">
						<tr>
							<%-- <td><c:out value="${make.id}"/></td> --%>
							<td><c:out value="${make.makeName}"/></td>
							<td align="center">
								<a href="editMake.html?id=${make.id}" class="icon"><i class="fas fa-pencil-alt"></i></a> 
								<a href="deleteMake.html?id=${make.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	<!--<div class="modal" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	 <script>
		var url = 'addMake.html';
		$( "#submit").click( function() {
		  $.ajax({
		      url: url,
		      data: {
	                ref: ref,
	                date: date
	            }
	            success: function(data) {
	            	$('#myModal').modal();
	            },
	            error: function(data) {

	            }
		  });
		});
	</script> -->
</body>
</html>