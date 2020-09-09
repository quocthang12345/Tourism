<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Địa Điểm" /></title>

    <!-- css -->
    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/hotel.css' />" rel="stylesheet" type="text/css" media="all"/>
    <script src="<c:url value='http://maps.googleapis.com/maps/api/js?key=AIzaSyCAkSMZnLKE7x4KLHNO5rxihJmjJKU5ufc&sensor=falsecallback=initialize' />"></script>
    
</head>
<body>
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
    <div class="container-fluid">
    	<dec:body/>
    </div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->

	<script>
		// khai báo tọa độ của place
		
		var InfoObj = [];
		var features = [
			{
				placeName: "Vị trí hiện tại" ,
				position: new google.maps.LatLng(16.067340, 108.201660),
				title: "Vị trí hiện tại"
			},
		 	{
				placeName:  "Bà Nà là khu du lich toạ lạc 1 khu vực thuộc về dãy núi Trường Sơn nằm ở xã Hòa Ninh, huyện Hòa Vang, cách Đà Nẵng 25 km về phía Tây Nam." + 
				"Trung tâm du lịch của Bà Nà nằm trên đỉnh Núi Chúa có độ cao 1489 m so với mực nước biển." + 
				"<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/B%C3%A0_N%C3%A0'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(15.997993,107.988066),
				title: "Bà Nà Hills"
			}, {
				placeName: "Bán đảo Sơn Trà nằm cách trung tâm thành phố Ðà Nẵng chừng 10 km về hướng Ðông Bắc. Sơn Trà có diện tích 60 kilômét vuông (23 dặm vuông Anh), chiều dài 13 kilômét (8,1 dặm), chiều rộng 5 kilômét (3,1 dặm), nơi hẹp nhất 2 kilômét (1,2 dặm). Bán đảo Sơn Trà cùng với đèo Hải Vân bao bọc thành phố Đà Nẵng và vịnh Đà Nẵng." + 
				"<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/S%C6%A1n_Tr%C3%A0'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(16.118834, 108.271995),
				title: "Đỉnh Bàn Cờ"
			}, {
				placeName: "Phố cổ Hội An là một đô thị cổ nằm ở hạ lưu sông Thu Bồn, thuộc vùng đồng bằng ven biển tỉnh Quảng Nam, Việt Nam, cách thành phố Đà Nẵng khoảng 30 km về phía Nam. Nhờ những yếu tố địa lý và khí hậu thuận lợi, Hội An từng là một thương cảng quốc tế sầm uất, nơi gặp gỡ của những thuyền buôn Nhật Bản, Trung Quốc và phương Tây trong suốt thế kỷ XVII và XVIII." + 
				"<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/Ph%E1%BB%91_c%E1%BB%95_H%E1%BB%99i_An'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(15.880174, 108.335175),
				title: "Phố Cổ Hội An"
			}, {
				placeName: "Ngũ Hành Sơn (chữ Hán: 五行山) hay núi Non Nước là tên của một danh thắng gồm 5 ngọn núi đá vôi nhô lên trên một bãi cát ven biển, trên một diện tích khoảng 2 km². Ngũ Hành Sơn gồm các ngọn núi: Mộc Sơn, Thủy Sơn (lớn, cao và đẹp nhất), Thổ Sơn, Kim Sơn và Hỏa Sơn (có hai ngọn là Dương Hỏa Sơn và Âm Hỏa Sơn), nằm cách trung tâm thành phố Đà Nẵng khoảng 8 km về phía Đông Nam, ngay trên tuyến đường Đà Nẵng - Hội An; nay thuộc phường Hòa Hải, quận Ngũ Hành Sơn, thành phố Đà Nẵng."
				+ "<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/Ng%C5%A9_H%C3%A0nh_S%C6%A1n'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(16.003162, 108.264123),
				title: "Ngũ Hành Sơn"
			}, {
				placeName: "Đến thăm Đà Nẵng, Du khách còn được tìm hiểu các giá trị lịch sử của người Chăm tại Bảo tàng Chăm nổi tiếng, thăm danh thắng Ngũ Hành Sơn, chùa Non Nước, chùa Linh Ứng, thoát tục với Bà Nà hill, mơ màng với biển, rộn rã với Sơn Trà hay tham gia Open tới Cù Lao Chàm, Phố Cổ Hội An, thánh địa Mỹ Sơn....Bạn có thể tận hưởng một thời gian vui vẻ tại bãi biển Mỹ Khê. Biển mỹ khê là bãi biển lọt top 50 bãi biển đẹp nhất hành tinh"
				+ "<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/B%C3%A3i_bi%E1%BB%83n_M%E1%BB%B9_Kh%C3%AA'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(16.047278, 108.249989),
				title: "Biển Mỹ Khê"
			}, {
				placeName: "Đèo Hải Vân còn có tên là đèo Ải Vân (vì trên đỉnh đèo xưa kia có một cửa ải) hay đèo Mây (vì đỉnh đèo thường có mây che phủ), cao 500 m (so với mực nước biển), dài 20 km, cắt ngang dãy núi Bạch Mã (là một phần của dãy Trường Sơn chạy cắt ra sát biển) ở giữa ranh giới tỉnh Thừa Thiên-Huế (ở phía Bắc) và thành phố Đà Nẵng (ở phía Nam), Việt Nam "
				+ "<br>" + "<a target='_blank' href='<c:url value='https://vi.wikipedia.org/wiki/%C4%90%C3%A8o_H%E1%BA%A3i_V%C3%A2n'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(16.187935, 108.131052),
				title: "Hải Vân Quan"
			}, {
				placeName: "Biển Cửa Đại nằm cách trung tâm phố cổ Hội An khoảng 5km thuộc địa phận tỉnh Quảng Nam với đường bờ biển dài khoảng 7km. Đây là nơi các dòng sông Thu Bồn, Trường Giang đổ ra biển."
				+ "<br>" + "<a target='_blank' href='<c:url value='https://tudienwiki.com/bien-cua-dai/'/>'>"+ "Thông tin thêm" + "</a>",
				position: new google.maps.LatLng(15.898324, 108.366363),
				title: "Biển Cửa Đại"
			}];
			var input = document.getElementById("end").value;
			let myCenter = new google.maps.LatLng(16.067341,108.201660);	

		function initialize()
		{
			function getOption(input){
				if(input == "bana"){
						myCenter =  new google.maps.LatLng(15.997993,107.988066);
					}else if(input == "hoian"){
						myCenter =  new google.maps.LatLng(15.880174, 108.335175);
					}else if(input == "nguhanhson"){
						myCenter =  new google.maps.LatLng(16.003162, 108.264123);
					}else if(input == "mykhe"){
						myCenter =  new google.maps.LatLng(16.047278, 108.249989);
					}else if(input == "haivan"){
						myCenter =  new google.maps.LatLng(16.187935, 108.131052);
					}else if(input == "cuadai"){
						myCenter =  new google.maps.LatLng(15.898324, 108.366363);
					}else if(input == "dinhbanco"){
						myCenter =  new google.maps.LatLng(16.118834, 108.271995);
					}else if(input == ""){
						myCenter =  new google.maps.LatLng(16.067341,108.201660);
					}
			}
				$('#end').on('change', function () { 
					input1 = $("#end option:selected").val();
					getOption(input1);
					initialize(myCenter);
					console.log(myCenter);
				});
				
				console.log(myCenter);
				var mapProp = {
				  	center:myCenter,
				  	zoom:15,
				  	mapTypeId:google.maps.MapTypeId.ROADMAP
				 };

			var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

			for (var i = 0; i < features.length ; i++){
				var contentString = '<h6>' + features[i].placeName + '</h6>';
				const marker = new google.maps.Marker({
					position: features[i].position,
					title: features[i].title,
					draggable: true,
					animation:google.maps.Animation.BOUNCE,
					map:map
			 	});

				const infowindow = new google.maps.InfoWindow({
    				content: contentString
  				});
				marker.addListener('click', function() {
					CloseInfoWinDow();
					infowindow.open(map, marker);
					InfoObj[0] = infowindow;
  				}); 
				
				map.addListener('change',function(center){
					CloseMap();
					input1 = $("#end option:selected").val();
					getOption(input1);
				})
				  
			
				marker.setMap(map);
			};
		}
		function CloseInfoWinDow(){
				if(InfoObj.length > 0){
					InfoObj[0].set("market",null);
					InfoObj[0].close();
					InfoObj[0].length = 0;
				}
		}
		function CloseMap(){
				if(Map.length > 0){
					Map.close();
					InfoObj[0].length = 0;
				}
		}

		google.maps.event.addDomListener(window, 'load', initialize);
</script>

	<script type="text/javascript" src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	
</body>
</html> 