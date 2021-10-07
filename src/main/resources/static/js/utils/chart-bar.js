// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
	type: 'bar',
	data: {
		labels: ["KODEX 200TR", "KBSTAR 대형고배당10TR", "SPY", "DIA", "QQQ", "ARKK", "VT", "TIGER 중장기국채", "TLT", "IEF", "SCHP", "BNDW", "BCI", "KRK 금 현물", "달러RP"],
		datasets: [{
			axis: 'y',
			data: [819535, 728410, 1038478, 405836, 877052, 562892, 980799, 728980, 355705, 549185, 445132, 475280, 793113, 432893, 414527],
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
		barThickness: 30,
		maintainAspectRatio: false,
		layout: {
			padding: {
				left: 10,
				right: 10,
				top: 10,
				bottom: 0
			}
		},
		plugins: {
			legend: {
				display: false,
			},
			title: {
				display: true,
				text: '투자 현황'
			}
		},
	}
});
