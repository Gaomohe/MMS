layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form'], function() {
	var $ = layui.jquery;
	var layer = layui.layer;
	var element = layui.element;
	var util = layui.util;
	var table = layui.table;
	var tableX = layui.tableX;
	var layer = layui.layer;
	var form = layui.from;


	var select1;
	var select2;
	var select3;
	var select4;
	// var arr;
	// 前端分页
	var tableIns=tableX.render({
		elem: '#xTable1',
		url: '/medicine?action=getAllMedicine',
		toolbar: '#toolbarDemo',
		page: true,
		height: 'full-145',
		limit: 10,
		limits: [5,10,15,20,25],
		cols: [
			[{fixed: "left",
				type: "checkbox",
				width: 50
			},
				{
					field: 'tableCoding',
					title: '数据编号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'mId',
					title: '药品编号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'mName',
					title: '药品名称',
					minWidth: 400,
					align: "center",
				},
				{
					field: 'specification',
					title: '规格',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'manufactor',
					title: '生产企业',
					minWidth: 400,
					align: 'center',
				},
				{
					field: 'unit',
					title: '单位',
					minWidth: 100,
					align: "center",
				},
				{
					field: 'department',
					title: '部门',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'position',
					title: '货位',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'number',
					title: '数量',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'batchNumber',
					title: '批号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'usefulLife',
					title: '有效期',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'purchasePrice',
					title: '采购价',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'salePrice',
					title: '销售价',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'productDate',
					title: '生产日期',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'profits',
					title: '利润金额',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'code',
					title: '自编码',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'goodsType',
					title: '商品分类',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'mType',
					title: '药品分类',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'defined',
					title: '自定义类',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'supplier',
					title: '供货单位',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'warehousingDate',
					title: '入库日期',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'locationDescription',
					title: '货位说明',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'sign',
					title: '标志',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'warehousingRemarks',
					title: '入库备注',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'drugFrom',
					title: '剂型',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'handlingInformation',
					title: '处理情况',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'approvalNumber',
					title: '批准文号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'LastCuringDate',
					title: '上次养护日期',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'timesStorage',
					title: '入库次数',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'documentNumber',
					title: '单据号码',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'placeOrigin',
					title: '产地',
					minWidth: 200,
					align: 'center',
				},
				{
					field: 'batchsNumber',
					title: '批次号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					field: 'recordNumber',
					title: '记录号',
					minWidth: 200,
					align: 'center',
					sort: true
				},
				{
					title: '操作',
					width: 200,
					templet: '#barDemo',
				}
			]
		],
		height: 390
	});
	table.on('toolbar(xTable1)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		var roleid = '';
		for(i=0;i<data.length;i++){
			roleid = data[i].id;
		}
		switch(obj.event){
			case 'delRole':	//删除角色
				if(data.length != 1){
					layer.msg("请选择一行数据进行操作")
					return false;
				}
				layer.confirm('删除角色后用户对应的权限也会删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
					delRole(roleid);
					layer.close(index);
				});
				break;

			case 'upRole':	//修改角色
				if(data.length != 1){
					layer.msg("请选择一行数据进行操作")
					return false;
				}else{
					upRole(roleid);
				}
				break;

			case 'addRole':	//新增角色
				addRole();
				break;

			case 'hairMenu':	//修改角色权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hairMenu(roleid);
				}
				break;
		};
	});
	//点击搜索查询
	$("#searchByQuerys").click(function () {
		select1 = $("#select1").val();
		select2 = $("#select2").val();
		select3 = $("#select3").val();
		select4 = $("#select4").val();
		$.ajax({
			url: '/medicine?action=getMedicineByQuery', // 后端处理数据的URL
			type: "POST", // 或 'GET'，取决于后端接口的要求
			data: {
				select1,
				select2,
				select3,
				select4
			},
			dataType:"JSON",
			success: function(response) {
				// 在成功回调中处理后端返回的数据
				// 假设后端返回的数据是一个数组，可以根据数据格式进行处理
				var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
				renderTable(tableData); // 渲染表格数据
			},
			error: function(error) {
				console.error('Error:', error);
			}
		});
	});
	//查询方法
	function renderTable(data) {
		layui.use('table', function(){
			var table = layui.table;

			table.render({
				elem: '#xTable1',
				data: data, // 使用从后端获取的数据渲染表格
				cols: [ [
					{fixed: "left",
						type: "checkbox",
						width: 50
					},
					{
						field: 'tableCoding',
						title: '数据编号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'mId',
						title: '药品编号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'mName',
						title: '药品名称',
						minWidth: 400,
						align: "center",
					},
					{
						field: 'specification',
						title: '规格',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'manufactor',
						title: '生产企业',
						minWidth: 400,
						align: 'center',
					},
					{
						field: 'unit',
						title: '单位',
						minWidth: 100,
						align: "center",
					},
					{
						field: 'department',
						title: '部门',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'position',
						title: '货位',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'number',
						title: '数量',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'batchNumber',
						title: '批号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'usefulLife',
						title: '有效期',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'purchasePrice',
						title: '采购价',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'salePrice',
						title: '销售价',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'productDate',
						title: '生产日期',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'profits',
						title: '利润金额',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'code',
						title: '自编码',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'goodsType',
						title: '商品分类',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'mType',
						title: '药品分类',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'defined',
						title: '自定义类',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'supplier',
						title: '供货单位',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'warehousingDate',
						title: '入库日期',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'locationDescription',
						title: '货位说明',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'sign',
						title: '标志',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'warehousingRemarks',
						title: '入库备注',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'drugFrom',
						title: '剂型',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'handlingInformation',
						title: '处理情况',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'approvalNumber',
						title: '批准文号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'LastCuringDate',
						title: '上次养护日期',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'timesStorage',
						title: '入库次数',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'documentNumber',
						title: '单据号码',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'placeOrigin',
						title: '产地',
						minWidth: 200,
						align: 'center',
					},
					{
						field: 'batchsNumber',
						title: '批次号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						field: 'recordNumber',
						title: '记录号',
						minWidth: 200,
						align: 'center',
						sort: true
					},
					{
						title: '操作',
						width: 200,
						templet: '#barDemo',
					}
				]
				],
				page: true // 开启分页
			});
		});
	}
	//加载时间
	setTimeout(function () {
		table.resize('xTable1');
	}, 200);
});
