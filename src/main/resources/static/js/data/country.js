console.log("Country js Module");

var countryService = (function() {

	function getCountries(param, callbackFunction, errorFunction) {
		console.log("countryService.getCountries");

		axios({
			method: 'get',
			url: `/country/${param}`,
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}
	
	function addCountry(param, callbackFunction, errorFunction){
		console.log("countryService.addCountry");
	
		axios({
			method: 'post',
			url: '/country/add',
			data:param
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}
	
	function modifyCountries(param, callbackFunction, errorFunction){
		console.log("countryService.modifyCountries");
		
		axios({
			method: 'post',
			url: '/country/modify',
			data:param
		})
			.then(response => {
				callbackFunction(response.data);
			})
			.catch(error => {
				errorFunction(error);
			})
	}
	
	function deleteCountries(param, callbackFunction, errorFunction) {
		console.log("countryService.deleteCountries");

		axios({
			method: 'post',
			url: '/country/delete',
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
		getCountries: getCountries,
		addCountry: addCountry,
		modifyCountries: modifyCountries,
		deleteCountries: deleteCountries
	}

})();