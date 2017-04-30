angular.module('wishModule').factory('wishService', function($http) {
	var service ={};
	var Base_Url = 'http://localhost:8080/WishMaker/rest/users/4/wishes'
	
	//DONE
	service.index = function() {
		return $http({
			method:'GET',
			url: Base_Url
		})
	};
		
	//
	service.create = function(todo) {
		return $http({
	      method : 'POST',
	      url : Base_Url,
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : todo
	    })
	};
	

	service.update = function(id, todo) {
	    return $http({
	      method : 'PUT',
	      url : `${Base_Url}/${id}`,
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : todo
	    })
	  };
	  
	  //
	  service.destroy = function(id) {
		    return $http({
		      method : 'DELETE',
		      url : `${Base_Url}/${id}`
		    })
		  };
	  
	
	return service;
});
