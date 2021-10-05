console.log("chart-pie Module");

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
				plugins: {
					legend: {
						display: true,
						position: 'right'
					}
				}
			}
		});
	}

	return {
		setPieChart: setPieChart
	}

})();