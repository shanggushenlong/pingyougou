//定义控制器   在controller层中必须引入service，否则无法使用
app.controller('brandController' ,function($scope,$controller,brandService){	
	$controller('baseController',{$scope:$scope});//继承	
		
		//$scope $http数据交互
		$scope.findAll = function() {
			brandService.findAll().success(
					function (response) {
						$scope.list = response;
					}
			);
		}
		
		
		
		
		//1,商品分页
		$scope.findPage = function (page,size) {
			brandService.findPage(page,size).success(
					function (response) {
						$scope.list = response.rows;  //显示当前页数
						 //更新总的记录数，由于页面加载默认初始化数为totalItems: 10
						$scope.paginationConf.totalItems = response.total; 
					}
			);
		};
		
		//2.商品保存（增加）
		$scope.save = function () {
			var object = null;
			if ($scope.entity.id != null) {
				object = brandService.update($scope.entity);
			}else{
				object = brandService.add($scope.entity);
			}
			object.success(
					function (response) {
						if (response.success) {
							//如果添加成功，只需重新查询页面记录
							$scope.reloadList(); //重新加载页面
						}else {
							//添加失败
							alert(response.message);
						}
					}
			);
		};
		
		//3.商品的查询，当页面点击修改的时候，文本框内获取相应的内容
		$scope.findOne = function (id) {
			brandService.findOne(id).success(
					function (response) {
						$scope.entity = response;
					}
			)
		};
		
		//4.商品删除
		
		//批量删除
		$scope.dele = function () {
			//获取选中的复选框
			brandService.dele($scope.selectIds).success(
					function(response) {
						if (response.success) {
							$scope.reloadList();//刷新列表
						}
					}
			);
		};
		
		//5.条件查询
		$scope.searchEntity={};//定义搜索对象 	
		$scope.search = function (page,size) {
			brandService.search(page,size,$scope.searchEntity).success(
				function (response) {
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;
				}		
			)
		}
			
});