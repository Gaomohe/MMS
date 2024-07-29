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
		height: 600,
		limit: 15,
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
					sort: true,
					hide:true,
				},
				{
					field: 'mId',
					title: '药品编号',
					minWidth: 200,
					align: 'center',
					sort: true,
					hide:true,
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
					sort: true,
					hide:true,
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
					field: 'lastCuringDate',
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
					sort: true,
					hide:true,
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
					sort: true,
					hide:true,
				},
				{
					field: 'recordNumber',
					title: '记录号',
					minWidth: 200,
					align: 'center',
					sort: true,
					hide:true,
				},
			]
		],
	});
	table.on('toolbar(xTable1)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		console.log(data)
		var tableCoding = '';
		for(i=0;i<data.length;i++){
			tableCoding = data[i].tableCoding;
		}
		switch(obj.event){
			case 'delFunc':	//删除药品
				if(data.length != 1){
					layer.msg("请选择一行数据进行操作")
					return false;
				}
				delFunc(tableCoding);
				break;
			case 'upFunc':	//修改药品
				if(data.length != 1){
					layer.msg("请选择一行数据进行操作")
					return false;
				}else{
					upFunc(tableCoding);
				}
				break;

			case 'addFunc':	//删除药品
				addfunc();
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
			var tableIns=table.render({
				elem: '#xTable1',
				data: data, // 使用从后端获取的数据渲染表格
				toolbar: '#toolbarDemo',
				page: true,
				height: 600,
				limit: 15,
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
							sort: true,
							hide:true,
						},
						{
							field: 'mId',
							title: '药品编号',
							minWidth: 200,
							align: 'center',
							sort: true,
							hide:true,
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
							sort: true,
							hide:true,
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
							field: 'lastCuringDate',
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
							sort: true,
							hide:true,
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
							sort: true,
							hide:true,
						},
						{
							field: 'recordNumber',
							title: '记录号',
							minWidth: 200,
							align: 'center',
							sort: true,
							hide:true,
						},
					]
				],

			});
			//重新绑定工具栏
			table.on('toolbar(xTable1)', function(obj){
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				console.log(data)
				var tableCoding = '';
				for(i=0;i<data.length;i++){
					tableCoding = data[i].tableCoding;
				}
				switch(obj.event){
					case 'delFunc':	//删除药品
						if(data.length != 1){
							layer.msg("请选择一行数据进行操作")
							return false;
						}
						delFunc(tableCoding);
						break;

					case 'upFunc':	//修改药品
						if(data.length != 1){
							layer.msg("请选择一行数据进行操作")
							return false;
						}else{
							upFunc(tableCoding);
						}
						break;

					case 'addFunc':	//删除药品
						addfunc();
						break;
				};
			});

			$('#btnExportTbAdv').click(function () {
				var checkRows = table.checkStatus('xTable1');
				if (checkRows.data.length == 0) {
					layer.msg('请选择要导出的数据', {icon: 2});
				} else {
					table.exportFile(tableIns.config.id, checkRows.data, 'xls');
				}
			});
			//重新绑定搜索回车
			$('#search').off('keypress').on('keypress', function(event) {
				if (event.which === 13) {
					var search = $('#search').val();
					$.ajax({
						url: '/medicine?action=getMedicineByName',
						type: "POST",
						data: {
							mName: search,
						},
						dataType: "JSON",
						success: function(response) {
							var tableData = response.data;
							renderTable(tableData);
						},
						error: function(error) {
							console.error('Error:', error);
						}
					});
				}
			});
			//重新绑定搜索按条件
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
		});

	}
	//加载时间
	setTimeout(function () {
		table.resize('xTable1');
	}, 200);

	function delFunc(tableCoding){
		$.ajax({
			url:"/medicine?action=delMedicine",
			type:"post",
			data:{"tableCoding":tableCoding},
			success:function(data){
				var info = JSON.parse(data);
				if(info.status == 200){
					console.log(info.status)
					layer.msg("删除成功");
					location.reload();
				}
			}
		})
	}
	function upFunc(tableCoding){
		layui.layer.open({
			title : "修改药品",
			type : 2,
			content : "/medicine?action=getMedicineOne&tableCoding="+tableCoding,
			area:['600px','600px'],
		});
	}
	function addfunc(){
		layui.layer.open({
			title : "新增药品",
			type : 2,
			content : "medicine/medicineManage/medDictionary/dictionaryAdd.jsp",
			area:['600px','600px'],
		});
	}

	$('#btnExportTbAdv').click(function () {
		var checkRows = table.checkStatus('xTable1');
		if (checkRows.data.length == 0) {
			layer.msg('请选择要导出的数据', {icon: 2});
		} else {
			table.exportFile(tableIns.config.id, checkRows.data, 'xls');
		}
	});


	//回车搜索
	$('#search').on('keypress', function(event) {
		if (event.which === 13) {
			var search = $('#search').val();
			$.ajax({
				url: '/medicine?action=getMedicineByName',
				type: "POST",
				data: {
					mName: search,
				},
				dataType: "JSON",
				success: function(response) {
					var tableData = response.data;
					renderTable(tableData);
				},
				error: function(error) {
					console.error('Error:', error);
				}
			});
		}
	});
});
