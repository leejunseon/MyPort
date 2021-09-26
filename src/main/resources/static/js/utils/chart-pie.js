console.log("chart-pie Module");

// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

var pieChartService = (function() {

	function setPieChart(elementId, assets, ratios, colors) {
		console.log("pieChartService.setPieChart");
		console.log(elementId);
		console.log(assets);
		console.log(ratios);
		console.log(colors);
		
		var ctx = document.getElementById(elementId);
		var myPieChart1 = new Chart(ctx, {
			type: 'pie',
			data: {
				labels: assets,
				datasets: [{
					data: ratios,
					backgroundColor: colors,
					hoverBackgroundColor: colors,
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
	}

	return {
		setPieChart: setPieChart
	}

})();