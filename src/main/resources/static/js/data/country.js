console.log("Country js Module");

var countryService = (function() {

	function getCountries(param, callbackFunction, errorFunction) {
		console.log("countryService.getCountries");
		console.log("param(uno) : "+param);

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
		console.log("param(country) : "+param);
	
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
		console.log("param(editCountries info) : "+param);
		
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
		console.log("param(deleteCountries info) : " + param);

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