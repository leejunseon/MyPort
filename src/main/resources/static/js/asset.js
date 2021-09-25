console.log("Asset js Module");

var assetService = (function() {

	function getAssets(param, callback, errorFunc) {
		console.log("assetService.getAssets");
		console.log("param(uno) : "+param);

		axios({
			method: 'get',
			url: `/asset/${param}`,
		})
			.then(response => {
				callback(response.data);
			})
			.catch(error => {
				errorFunc(error);
			})
	}

	return {
		getAssets: getAssets
	}

})();