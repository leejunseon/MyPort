console.log("Item js Module");

var ItemService = (function() {
	
	function addItem(param, callbackFunction, errorFunction){
		console.log("ItemService.addCountry");
	
		axios({
			method: 'post',
			url: '/item/add',
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
		addItem: addItem
	}

})();