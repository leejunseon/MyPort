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
	
	function addAsset(param, callbackFunction, errorFunction){
		console.log("assetService.addAsset");
		console.log("param(asset) : "+param);

		axios({
			method: 'post',
			url: '/asset/add',
			data:param
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}
	
	function modifyAssets(param, callbackFunction, errorFunction){
		console.log("assetService.modifyAssets");
		console.log("param(asset info) : "+param);
		
		axios({
			method: 'post',
			url: '/asset/modify',
			data:param
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}

	return {
		getAssets: getAssets,
		addAsset: addAsset,
		modifyAssets: modifyAssets
	}

})();