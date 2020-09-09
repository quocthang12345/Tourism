<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/common/taglib.jsp"%>
  <c:url var="APIurl" value="/api-hotel-list"/>
  <c:url var="ITEMurl" value="/khach-san"/>
<!DOCTYPE html>
<html>
<head>
<title>Khách sạn</title>
</head>
<body>
<div class="row">
	<div class="card" style="width:100%; height: auto;">
		<div class="card-body">
			<form id="hotelSubmit" name="hotelSubmit" action='<c:url value='/khach-san'/>' method="get" >
			
			<div class="form-group">
			<div class="card-title">
				<div class="row">
						<select class="form-control col-2"  id="sortBy" name="sortBy" onchange="this.form.submit()">
							<option value="">Lọc theo giá</option>
							<option value="DESC">Cao nhất</option>
							<option value="ASC">Thấp nhất</option>
						</select>
					
						<select class="form-control col-3" style="margin-left:2%;" id="BusinessID" name="BusinessID" onchange="this.form.submit()">
							<option value="">Lọc theo kiểu khách sạn</option>
							<c:forEach var="business" items="${BusinessAreas}">
                                  <option value="${business.getBusinessID()}">${business.getName()}</option>
                            </c:forEach>
						</select>
				</div>
			</div>
			</div>
			
			<div class="form-group">
			<div class="card-title">
						<div class="row">
							<input type="text" class="form-control col-7" value="" id="find" name="find" placeholder="Nhập tên nơi ở bạn muốn tìm" />
							<button type="button" class="form-control btn btn-success col-1" style="margin-left:2%;" id="btnfind" name="btnfind">Tìm kiếm</button>
						</div>
			</div>
			</div>
			<div class="form-group">
				<c:if test="${not empty message}">
					<div class="row">
						<div class="alert alert-${alert}" style="width:100%; text-align: center; color:red; font-size:20px;">${message}</div>
						<a href='<c:url value="/khach-san?action=khachsan&page=1&maxPage=5&BusinessID=&type=&sortName=TotalPrice&sortBy=DESC&find="/>' class="form-control btn btn-primary col-2" style="margin-left:2%;text-align:center;"  >Trở về trang danh sách</a>
					</div>
				</c:if>	
					<c:forEach var="i" items="${itemHotel.getResultList()}">
					<div class="card mb-3" style="width:60%;">
						<div class="row no-gutters">
							<div class="col-md-4">
							  <img src="<c:url value='${i.getThumbnail()}'/>" class="card-img" alt="hotel">
							</div>
							   <div class="col-md-8">
							     <div class="card-body">
							        <h5 class="card-title" >${i.getNameItem()}</h5>
							        <p class="card-text" ><small class="text-muted">Last updated ${i.getCreateDate()} minutes ago</small></p>
							        <p class="card-text">${i.getTotalPrice()}<a href='<c:url value="/thue-muon?action=rent&id=${i.getItemID()}"/>' class="btn btn-primary float-right" style="width:20%;" >Rent </a></p>
							     </div>
							  </div>
						</div>
					</div>
					</c:forEach>
				</div>
					 <ul class="pagination" id="pagination"></ul>
					  <input type="hidden" value="" name="page" id="page"/> 
					  <input type="hidden" value="" name="maxPage" id="maxPage"/> 
					  <input type="hidden" value="" name="sortName" id="sortName"/> 
					  <input type="hidden" value="" name="type" id="type"/> 
					  <input type="hidden" value="khachsan" name="action" id="action"/> 
			</form>		
		</div>
	</div>
</div>
<script type="text/javascript">
		var currentPage = ${itemHotel.getPage()};
		var TotalPages = ${itemHotel.getTotalPage()};
		var limit = 5;
		$('#sortBy').on('change', function () {
			var sortby = $("#sortBy option:selected").val();
					$('#maxPage').val(limit); 
					$('#page').val(currentPage); 
					$('#sortName').val("TotalPrice"); 
					$('#sortBy').val(sortby);  
					$('#action').val('khachsan');
					$('#type').val('');
					$('#hotelSubmit').submit(); 
		});
		$('#BusinessID').on('change', function () {
			var BusinessID = $("#BusinessID option:selected").val();
					$('#maxPage').val(limit); 
					$('#page').val(currentPage); 
					$('#sortName').val("TotalPrice"); 
					$('#BusinessID').val(BusinessID);  
					$('#action').val('khachsan');
					$('#type').val('');
					$('#hotelSubmit').submit(); 
		});
		
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: TotalPages,
				visiblePages:6,
				startPage:currentPage,
				onPageClick: function(event,page){
				 	 if(currentPage != page){
						$('#maxPage').val(limit); 
						$('#page').val(page); 
						$('#sortName').val("TotalPrice"); 
						$('#sortBy').val("DESC");  
						$('#action').val('khachsan');
						$('#type').val();
						$('#BusinessID').val(); 
						$('#find').val();
						$('#hotelSubmit').submit();
					}  
				}
			});
			$('#btnfind').click(function(e){
				e.preventDefault();
		        var data = {};
		        var NameItem = $('#find').val();
				data["NameItem"] = NameItem;
				Find(data);
		        function Find(data){
		        	 $.ajax({
		                 url : "${APIurl}",
		                 type : "POST",
		                 contentType: "application/json",
		                 data: JSON.stringify(data),
		                 dataType: "json",
		                 success: function (result){
		              	   window.location.href = "${ITEMurl}?action=khachsan&type=find&find="+$('#find').val()+"&page=1&maxPage=5&message=find_error&alert=danger";
		                 },
		                 error: function (error){
		                	 window.location.href = "${ITEMurl}?action=khachsan&page=1&maxPage=5&message=find_error&alert=danger";
		                 },
		              });
		        }
		 });   
</script>
		

</body>
</html>