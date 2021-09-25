console.log("Asset js Module");

var assetService = (function() {

	function getAssets(param,callback, error) {
		console.log("assetService.getAssets");
		console.log(param);
		
		axios({
			method: 'get', //통신 방식
			url: '/ajax', //통신할 페이지
			data: {} //인자로 보낼 데이터
		})
			.then(response => {
				document.getElementById('boom').innerText = response.data.num;
				console.log(response);
			})
			.catch(error => {
				document.getElementById('boom').innerText = 'error';
				console.log(error);
			})
	}

	return {
		getAssets: getAssets
	}

})();