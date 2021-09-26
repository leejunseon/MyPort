console.log("Asset js Module");

var assetService = (function() {

	function getAssets(param, callbackFunction, errorFunction) {
		console.log("assetService.getAssets");
		console.log("param(uno) : "+param);

		axios({
			method: 'get',
			url: `/asset/${param}`,
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}

	return {
		getAssets: getAssets
	}

})();