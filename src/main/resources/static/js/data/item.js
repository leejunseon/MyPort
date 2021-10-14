console.log("Item js Module");

var itemService = (function() {
	
	function addItem(param, callbackFunction, errorFunction){
		console.log("ItemService.addCountry");
	
		axios({
			method: 'post',
			url: '/item/add',
			data:param,
			headers:{ 'Content-Type': 'application/json' }
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