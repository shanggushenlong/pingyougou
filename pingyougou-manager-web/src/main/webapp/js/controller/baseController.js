//基本控制层，父类，子可以继承
app.controller('baseController',function($scope){
	//分页控件配置 
	$scope.paginationConf = {
		 currentPage: 1,
		 totalItems: 10,
		 itemsPerPage: 10,
		 perPageOptions: [10, 20, 30, 40, 50],
		 onChange: function(){
		      $scope.reloadList();//重新加载
		 }
	}; 
	//刷新页面
	$scope.reloadList = function () {
		//每一次加载，更新当前页码 currentPage 当前页的记录数 itemPerPage
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	};
	
	//数据准备：要删除的商品的ID,定义一个数组ID
	$scope.selectIds= [];
	$scope.updateSelection = function ($event,id) {
		//如果被选中，则为true
		if ($event.target.checked) {
			//如果被选中，将商品的ID添加到数组
			$scope.selectIds.push(id);
		}else {
			//查询id的商品在数组的中的位置
			var idx = $scope.selectIds.indexOf(id);
			//参数1：要移除的位置 参数2：移除的个数
			$scope.selectIds.splice(idx, 1); //删除
		}
	};
});