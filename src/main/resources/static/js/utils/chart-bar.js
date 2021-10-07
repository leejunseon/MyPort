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
