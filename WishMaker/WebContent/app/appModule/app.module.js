angular.module('appModule',['wishModule','ngRoute'])
.config(function($routeProvider){
	$routeProvider
	.when('/', {
		template: '<wish-maker></wish-maker>'
	})
	.otherwise({
		template: '<not-found-component></not-found-component>'
	})
});