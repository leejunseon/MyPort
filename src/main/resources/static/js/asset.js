console.log("Asset js Module");

var assetService = (function() {

	function getAssets(param,callback, error) {
		console.log("assetService.getAssets");
		console.log(param);
		
		axios({
			method: 'get', //통신 방식
			url: '/asset/1', //통신할 페이지
			//data: 1 //인자로 보낼 데이터
		})
			.then(response => {
				console.log(response.data);
			})
			.catch(error => {
				console.log(error);
			})
	}

	return {
		getAssets: getAssets
	}

})();