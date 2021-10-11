console.log("Asset js Module");

var assetService = (function() {

	function getAssets(param, callbackFunction, errorFunction) {
		console.log("assetService.getAssets");

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
	
	function deleteAssets(param, callbackFunction, errorFunction) {
		console.log("assetService.deleteAssets");

		axios({
			method: 'post',
			url: '/asset/delete',
			data: param
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
		modifyAssets: modifyAssets,
		deleteAssets: deleteAssets
	}

})();