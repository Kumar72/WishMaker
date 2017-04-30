angular.module('wishModule').component('showWish', {
	templateUrl: 'app/wish/showWish/showWish.component.html',
	controller: function(wishService){
		var vm = this;
		
		vm.editWish = null;
		vm.save = function(){
			vm.onUpdate({parent: vm.editWish}).then(function(res){
				vm.wish = res.data;
			})
		}
		
		vm.editMode = false;
		vm.setEditWish = function() {
			vm.editMode = true;
			vm.editWish = angular.copy(vm.details);
		}
	},
	controllerAs: 'vm',
	bindings: {
		details: '<',
		goBack: '&',
		onUpdate: '&'
	}

})