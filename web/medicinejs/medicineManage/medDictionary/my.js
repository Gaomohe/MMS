layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel'], function() {
	var $ = layui.jquery;
	var layer = layui.layer;
	var element = layui.element;
	var util = layui.util;
	var table = layui.table;
	var tableX = layui.tableX;
	var layer = layui.layer;

	// 前端分页
	tableX.render({
		elem: '#xTable1',
		url: '/medicine?action=getAllMedicine',
		minHeight:10,
		toolbar: '#toolbarDemo',
		page: true,
		height: 'full-145',
		limit: 10,
		limits: [5,10,15,20,25],
		cols: [
			[{
					fixed: "left",
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
		]
	});
});