// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx1 = document.getElementById("myPieChart_1");
var myPieChart1 = new Chart(ctx1, {
	type: 'pie',
	data: {
		labels: ["주식", "채권", "원자재", "금", "달러"],
		datasets: [{
			data: [50, 30, 10, 5, 5],
			backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
			hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
			hoverBorderColor: "rgba(234, 236, 244, 1)",
		}],
	},
	options: {
		responsive: true,
		maintainAspectRatio: false,
		tooltips: {
			backgroundColor: "rgb(255,255,255)",
			bodyFontColor: "#858796",
			borderColor: '#dddfeb',
			borderWidth: 1,
			xPadding: 15,
			yPadding: 15,
			displayColors: false,
			caretPadding: 10,
		},
		legend: {
			position: 'right',
		}
	}
});

var ctx2 = document.getElementById("myPieChart_2");
var myPieChart2 = new Chart(ctx2, {
	type: 'pie',
	data: {
		labels: ["미국", "한국", "국가분산"],
		datasets: [{
			data: [55, 30, 15],
			backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
			hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
			hoverBorderColor: "rgba(234, 236, 244, 1)",
		}],
	},
	options: {
		maintainAspectRatio: false,
		tooltips: {
			backgroundColor: "rgb(255,255,255)",
			bodyFontColor: "#858796",
			borderColor: '#dddfeb',
			borderWidth: 1,
			xPadding: 15,
			yPadding: 15,
			displayColors: false,
			caretPadding: 10,
		},
		legend: {
			position: 'right',
		}
	},
});
