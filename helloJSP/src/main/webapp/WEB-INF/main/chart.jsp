<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load("current", { packages: ["corechart"] });
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {
		fetch('drawChart.do')  //여기서 데이터 가져옴 
		.then(resolve => resolve.json())  //자바 객체타입으로 변경 
		.then(result => {
			console.log(result);  // 객체타입으로 나옴 
			let dataAry =[['Writer' , 'Cnt']];  //다시 배열타입으로 변경 
			result.forEach(item => {
				dataAry.push([item.replyer, item.cnt])  ///배열 타입으로 변경
			})
			console.log(dataAry);
			var data = google.visualization.arrayToDataTable(dataAry);  //넣어줬더니만 알아서 차트 그려줌 

			var options = {
				title: '작성자 건수별',
				is3D: true,
			};

			var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
				chart.draw(data, options);
		})//then
		.catch(err => console.log(err));
		
	
	}
</script>

<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
<jsp:include page="../layout/footer.jsp"></jsp:include>