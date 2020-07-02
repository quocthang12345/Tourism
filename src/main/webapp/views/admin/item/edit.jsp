<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-item"/>
<c:url var="ITEMurl" value="/admin-item-list"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form id="formSubmit">
                        <div class="form-group">
                                <div class="col-sm-12">
                                    <input type="hidden" class="form-control" id="ItemID" name="ItemID" value="${model.getItemID()}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">BusinessAreas</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="BusinessCode" name="BusinessCode">
                                        <c:if test="${empty model.getBusinessCode()}">
                                            <option value="">Choose in BusinessAreas</option>
                                            <c:forEach var="business" items="${BusinessAreas}">
                                                <option value="${business.getCode()}">${business.getName()}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.getBusinessCode()}">
                                            <option value="">Choose in BusinessAreas</option>
                                            <c:forEach var="business" items="${BusinessAreas}">
                                                <option value="${business.getCode()}" <c:if test="${business.getCode() == model.getBusinessCode()}">selected="selected"</c:if>>
                                                        ${business.getName()}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
           
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">NameItem</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="NameItem" name="NameItem" value="${model.getNameItem()}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="Thumbnail" name="Thumbnail" value="${model.getThumbnail()}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">TotalPrice</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="TotalPrice" name="TotalPrice" value="${model.getTotalPrice()}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">ItemDetail</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="ItemDetail" name="ItemDetail" style="width: 820px;height: 175px">${model.getItemDetail()}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.getItemID()}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Update Item" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.getItemID()}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Insert Item" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div> 
                            <input type="hidden" value="${model.getItemID()}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var editor = "";
    $(document).ready(function(e){
        editor = CKEDITOR.replace('ItemDetail')
    });
    $('#btnAddOrUpdateNew').click(function(e){
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData,function(i,v){
            data[""+v.name+""] = v.value;
        });
        data["ItemDetail"] = editor.getData();
        var id = $('#id').val();
        if(id == ""){
            addItem(data);
        }else{
            updateItem(data);
        }
        function addItem(data){
            $.ajax({
               url : "${APIurl}",
               type : "POST",
               contentType: "application/json",
               data: JSON.stringify(data),
               dataType: "json",
               success: function (result){
            	   window.location.href = "${ITEMurl}?type=edit&page=1&maxPage=3&message=insert_complete&alert=success";
               },
               error: function (error){
            	   window.location.href = "${ITEMurl}?type=edit&page=1&maxPage=3&message=insert_error&alert=danger";
               },
            });
        }
        function updateItem(data){
            $.ajax({
               url : "${APIurl}",
               type : "PUT",
               contentType: "application/json",
               data: JSON.stringify(data),
               dataType: "json",
               success: function (result){
            	   window.location.href = "${ITEMurl}?type=edit&page=1&maxPage=3&message=update_complete&alert=success";
               },
               error: function (error){
            	   window.location.href = "${ITEMurl}?type=edit&page=1&maxPage=3&message=update_error&alert=danger";
               },
            });
        }
    });
</script>

</body>
</html>