<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url var="APIurl" value="/api-admin-item"/>
<c:url var="ITEMurl" value="/admin-item-list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Khách Sạn</title>
</head>
<body>
<div class="main-content">
<form action='<c:url value='/admin-item-list'/>' method="get" id="formSubmit">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
        	<div class="widget-box table-filter">
				<div class="table-btn-controls">
					<div class="pull-right tableTools-container">
						<div class="dt-buttons btn-overlap btn-group">
							<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
								title='Thêm bài viết' href='<c:url value="/admin-item-list?type=edit"/>'>
								<span>	<i class="fa fa-plus-circle bigger-110 purple"></i> </span>
							</a>
						<button id="btnDelete" type="button" 
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
							<span> <i class="fa fa-trash-o bigger-110 pink"></i> </span>
						</button>
						</div>
					</div>
				</div>
			</div>
            <div class="row" >
                <div class="col-xs-12">
					<div class="table-responsive">
 					 <table class="table">
    					<thead class="thead-dark">
					    <tr>
					      <th></th>
					      <th scope="col">NameItem</th>
					      <th scope="col">TotalPrice</th>
					      <th scope="col">CreateDate</th>
					      <th scope="col">CreateBy</th>
					      <th scope="col">Edit</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="i" items="${model.getResultList()}">
					    <tr>
					      <td><input type="checkbox" id="check_${i.getItemID()}" value="${i.getItemID()}"/></td>	
					      <td>${i.getNameItem()}</td>
					      <td>${i.getTotalPrice()}</td>
					      <td>${i.getCreateDate()}</td>
					      <td>${i.getCreateBy()}</td>
					      <td>
					      	<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" title="Update Items" 
					      	href='<c:url value="/admin-item-list?type=edit&id=${i.getItemID()}"/>'>
					      		<i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
					   
					      </td>
					    </tr>
					    </c:forEach>

					  </tbody>
  					</table>
					  <ul class="pagination" id="pagination"></ul>
					  <input type="hidden" value="" name="page" id="page"/> 
					  <input type="hidden" value="" name="maxPage" id="maxPage"/> 
					  <input type="hidden" value="" name="sortName" id="sortName"/> 
					  <input type="hidden" value="" name="sortBy" id="sortBy"/> 
					  <input type="hidden" value="" name="type" id="type"/> 
				</div>
                </div>
            </div>
        </div>
    </div>
    </form>
</div><!-- /.main-content -->

<script type="text/javascript">
	var currentPage = ${model.getPage()};
	var TotalPages = ${model.getTotalPage()};
	var limit = 3;
	$(function(){
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: TotalPages,
			visiblePages:10,
			startPage:currentPage,
			onPageClick: function(event,page){
			 	 if(currentPage != page){
					$('#maxPage').val(limit); 
					$('#page').val(page); 
					$('#sortName').val('NameItem');
					$('#sortBy').val('DESC');
					$('#type').val('list');
					$('#formSubmit').submit();
				}  
			}
		})
});
	 $('#btnDelete').click(function(e){
	        var data = {};
	        var ids = $('tbody input[type=checkbox]:checked').map(function(e){
				return $(this).val();
			}).get();
			data['ids'] = ids;
			ConfirmDelete();
			function ConfirmDelete()
   			{
      		var x = confirm("Are you sure you want to delete?");
     		 if (x){
				deleteItem(data);
			  }
     		 else {
				window.location.href = "${ITEMurl}?type=list&page=1&maxPage=3";
			  }
    		}
	        function deleteItem(data){
	            $.ajax({
	               url : "${APIurl}",
	               type : "DELETE",
	               contentType: "application/json",
	               data: JSON.stringify(data),
	               success: function (result){
	                    window.location.href = "${ITEMurl}?type=list&page=1&maxPage=3&message=delete_complete&alert=success";
	               },
	               error: function (error){
					window.location.href = "${ITEMurl}?type=list&page=1&maxPage=3&message=delete_error&alert=danger";
	               },
	            });
	        }
	 });   
</script> 

</body>
</html>