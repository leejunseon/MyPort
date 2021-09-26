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

	return {
		getCountries: getCountries
	}

})();