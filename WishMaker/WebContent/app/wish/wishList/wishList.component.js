angular.module('wishModule').component('wishList', {
	templateUrl: 'app/wish/wishList/wishList.component.html',
	controller: function(wishService){
		var vm = this;
		vm.wishes = []
		
		vm.reload = function() {
			wishService.index().then(function(res){
				vm.wishes = res.data;
			})
		}
		
		vm.reload();
		
		vm.selected = null;
		vm.showTable = true;
		vm.display = function(info) {
			vm.selected = info;
			vm.showTable = false;
		}
		vm.displayTable = function() {
			vm.showTable = true;
			vm.selected = null;
		}
		
		vm.hide = function() {
			//
		}
		
		
		vm.addTodo = function(wish) {
			wish.description = '';
			wishService.create(wish).then(function(res){
				vm.reload();
			})
		}
		
		vm.deleteWish = function(id) {
			wishService.destroy(id).then(function(res){
				vm.reload();
			})
		}
		
		vm.update = function(wish) {
			return wishService(wish).then(function(res){
				vm.reload();
			})
		}
	},
	controllerAs: 'vm'

})