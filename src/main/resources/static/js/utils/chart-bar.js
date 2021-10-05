function number_format(number, decimals, dec_point, thousands_sep) {
	// *     example: number_format(1234.56, 2, ',', ' ');
	// *     return: '1 234,56'
	number = (number + '').replace(',', '').replace(' ', '');
	var n = !isFinite(+number) ? 0 : +number,
		prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
		sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
		dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
		s = '',
		toFixedFix = function(n, prec) {
			var k = Math.pow(10, prec);
			return '' + Math.round(n * k) / k;
		};
	// Fix for IE parseFloat(0.55).toFixed(0) = 0;
	s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	if (s[0].length > 3) {
		s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	}
	if ((s[1] || '').length < prec) {
		s[1] = s[1] || '';
		s[1] += new Array(prec - s[1].length + 1).join('0');
	}
	return s.join(dec);
}

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
	type: 'bar',
	data: {
		labels: ["KODEX 200TR", "KBSTAR 대형고배당10TR", "SPY", "DIA", "QQQ", "ARKK", "VT", "TIGER 중장기국채", "TLT", "IEF", "SCHP", "BNDW", "BCI", "KRK 금 현물", "달러RP"],
		datasets: [{
			axis: 'y',
			label: 'My First Dataset',
			data: [65, 59, 80, 81, 56, 55, 40, 30, 50, 24, 13, 12, 24, 35, 15],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(255, 159, 64, 0.2)',
				'rgba(255, 205, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)', 
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)'
			],
			borderColor: [
				'rgba(255, 99, 132, 0.2)',
				'rgba(255, 159, 64, 0.2)',
				'rgba(255, 205, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)', 
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)',
				'rgba(201, 203, 207, 0.2)'
			],
			borderWidth: 1
		}]
	},
	options: {
		indexAxis: 'y',
		maintainAspectRatio: false,
		layout: {
			padding: {
				left: 10,
				right: 25,
				top: 25,
				bottom: 0
			}
		},
		scales: {
			xAxes: [{
				time: {
					unit: 'month'
				},
				gridLines: {
					display: false,
					drawBorder: false
				},
				maxBarThickness: 25,
			}],
			yAxes: [{
				ticks: {
					min: 0,
					max: 100,
					maxTicksLimit: 5,
					padding: 10,
					// Include a dollar sign in the ticks
					callback: function(value, index, values) {
						return number_format(value) + '원';
					}
				},
				gridLines: {
					color: "rgb(234, 236, 244)",
					zeroLineColor: "rgb(234, 236, 244)",
					drawBorder: false,
					borderDash: [2],
					zeroLineBorderDash: [2]
				}
			}],
		},
		plugins: {
			legend: {
				position: 'right',
			},
			title: {
				display: true,
				text: 'Chart.js Horizontal Bar Chart'
			}
		},
		tooltips: {
			titleMarginBottom: 10,
			titleFontColor: '#6e707e',
			titleFontSize: 14,
			backgroundColor: "rgb(255,255,255)",
			bodyFontColor: "#858796",
			borderColor: '#dddfeb',
			borderWidth: 1,
			xPadding: 15,
			yPadding: 15,
			displayColors: false,
			caretPadding: 10,
			callbacks: {
				label: function(tooltipItem, chart) {
					var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
					return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
				}
			}
		},
	}
});
