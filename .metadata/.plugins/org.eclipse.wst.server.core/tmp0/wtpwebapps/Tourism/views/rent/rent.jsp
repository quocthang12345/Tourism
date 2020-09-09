<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/common/taglib.jsp"%>
      <c:url var="APIurl" value="/api-rent"/>
  	 <c:url var="ITEMurl" value="/thue-muon"/>
  	 <c:url var="APIvisitor" value="/api-visitor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent</title>
</head>
<body style="width:100%;">
	<div class="row">
		<div class="col-12">
			<div class="card" >
				<div class="row" >
				<div class="col-md-5">
					<img src="<c:url value='${itemRent.getThumbnail()}'/>" class="card-img" alt="hotel">
				</div>
					<div class="col-md-6" style="display:inline;">
					<form id="rentDetail">
						<div class="card-body">
							 <h3 class="card-title" >${itemRent.getNameItem()}</h3>
							  <p class="card-title" style="display:inline;">${itemRent.getItemDetail()}</p>							  
							  <p><label >Enter a date :</label>
  							  <input type="date" id="RentDetail" name="RentDetail" max="2020-6-30" value=""><br></p>
							  <p>Time to Booking: <input aria-label="quantity" style="width:20%" class="input-qty" max="max" min="1" name="" type="number" value="1"></p>
							  <p class="card-text" ><small class="text-muted">Last updated ${itemRent.getCreateDate()} minutes ago</small></p>
							  <p class="card-text"><h3>${itemRent.getTotalPrice()}/Night</h3>
							  <input type="hidden" id="Cost" name="Cost" value="${itemRent.getTotalPrice()}" />
							  <input type="hidden" id="ItemID" name="ItemID" value="${itemRent.getItemID()}"/>
							  <p><button type="button" data-toggle="modal" data-target="#infoRent" class="btn btn-primary" id="btnbooking">Booking Room</button></p>
						</div>
					</form>
					</div>
					</div>
				</div>
		</div>
	</div>
	
	<c:if test="${empty USER}">
	<div class="modal fade" id="infoRent" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		  <form id="rentDetailNonUser">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Info</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="card">
		        	<div class="card-body">
		        	<div class="row">
		       				<p style="margin-left:11%;"><label>Name:</label>
		       				<input type="text" id="Username" name="Username" value="" placeholder="Enter Your Name"></p>
		       				<p style="margin-left:6%;"><label>Address:</label>
		       				<input type="text" id="Address" name="Address" value="" placeholder="Enter Your Address"></p>
		       				<p><label>Telephone:</label>
		       				<input type="text" id="Telephone" name="Telephone" value="" placeholder="Enter Your Telephone"></p>
		       				<p style="margin-left:13%;"><label>Email:</label>
		       				<input type="text" id="Email" name="Email" value="" placeholder="Enter Your Email"></p>
		       				<input type="hidden" id="RentID" name="RentID" value="${rent.getRentID()}"/>
		        	</div>
		        	</div>
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" id="btnInfoNonUser"  data-toggle="modal" data-target="#rent">Send Info</button>
		      </div>
		    </div>
		    </form>
		  </div>
	</div>
	
	<div class="modal fade" id="rent" tabindex="-2" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Info Booking</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="card">
		        	<div class="card-body">
		        		<p class="card-title text-white bg-dark text-center" style="font-size:24px;">${itemRent.getTotalPrice()}</p>
		        		<p class="card-test font-weight-light text-center">If you are sure that you will book a room for this hotel, 
		        		please transfer 50% via the hotel account number below, we will complete the procedure for you: </p>
		        		<p class="text-white bg-dark text-center" style="font-size:24px;">XXXX-XXXX-XXXX</p>
		        	</div>
		        
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#alertRent">OK</button>
		      </div>
		    </div>
		  </div>
	</div>
	
	<div class="modal" id="alertRent" tabindex="-3" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div class="alert alert-success" style="margin:0px;" role="alert">
  					This is a success booking. Give it a click if you like.
				</div>
	      </div>
	      <div class="modal-footer">
	      <button type="button" class="btn btn-warning " data-dismiss="modal">Stay Here</button>
	        <a type="button" class="btn btn-primary" href='<c:url value="/trang-chu"/>'>Home</a>
	      </div>
	    </div>
	  </div>
	</div>
	
	</c:if>
	<c:if test="${not empty USER}">
	<div class="modal fade" id="infoRent" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Info Booking</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="card">        
		        	<div class="card-body">
		        		<p class="card-title text-white bg-dark text-center" style="font-size:24px;">${itemRent.getTotalPrice()}</p>
		        		<input class="form-control" type="hidden" id="Cost" name="Cost" value="${itemRent.getTotalPrice()}">
		        		<p class="card-test font-weight-light text-center">If you are sure that you will book a room for this hotel, 
		        		please transfer 50% via the hotel account number below, we will complete the procedure for you: </p>
		        		<p class="text-white bg-dark text-center" style="font-size:24px;">XXXX-XXXX-XXXX</p>
		        	</div>
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#rent">OK</button>
		      </div>
		    </div>
		  </div>
	</div>
	
	<div class="modal fade" id="rent" tabindex="-2" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div class="alert alert-success" style="margin:0px;" role="alert">
  					This is a success booking. Give it a click if you like.
				</div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-warning" data-dismiss="modal">Stay Here</button>
	        <a type="button" class="btn btn-primary" href='<c:url value="/trang-chu"/>'>Home</a>
	      </div>
	    </div>
	  </div>
	</div>
	</c:if>
	<script>
	$('#btnbooking').click(function(e){
	    e.preventDefault();
	    var data = {};
	    var formData = $('#rentDetail').serializeArray();
	    $.each(formData,function(i,v){
	        data[""+v.name+""] = v.value;
	    });
	   	 	addRent(data);
	    function addRent(data){
	        $.ajax({
	           url : "${APIurl}",
	           type : "POST",
	           contentType: "application/json",
	           data: JSON.stringify(data),
	           dataType: "json",
	           success: function (result){
	  				
	           },
	           error: function (error){
	        	   window.location.href = "${ITEMurl}?action=rent&id=${itemRent.getItemID()}";
	           },
	        });
	    	}
	    });
</script>
<script>
$('#btnInfoNonUser').click(function(e){
    e.preventDefault();
    var data = {};
    var formInfo = $('#rentDetailNonUser').serializeArray();
    $.each(formInfo,function(i,v){
        data[""+v.name+""] = v.value;
    });
    	addVisitor(data);
    function addVisitor(data){
        $.ajax({
           url : "${APIvisitor}",
           type : "POST",
           contentType: "application/json",
           data: JSON.stringify(data),
           dataType: "json",
           success: function (result){
        	   
           },
           error: function (error){
        	   window.location.href = "${ITEMurl}?action=rent&id=${itemRent.getItemID()}";
           },
        });
    	}
    });
</script>
</body>
</html>