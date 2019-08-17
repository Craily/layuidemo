layui.use(['table', 'form'], function() {
	var table = layui.table;
	var form = layui.form;
	
	var $ = layui.$ // 由于layer弹层依赖jQuery，所以可以直接得到
	, layer = layui.layer;
	
	var tableIns = table.render({
		elem: '#empTable',
		id: 'empTable',
		url: '../emp/queryEmp',
		method: 'post',
		toolbar: 'default',
		defaultToolbar: [],
		cols: [[
			{type: 'checkbox', fixed: 'left'},
			{field: 'empNo', title: '编号', minWidth: 80, hide: true},
			{field: 'name', title: '姓名', minWidth: 120, fixed: 'left'},
			{field: 'sex', title: '性别', align:'center', width: 80, templet: function(d){
				return d.sex == "1" ? "男" : d.sex == "0" ? "女" : "-";
			}},
			{field: 'mobilePhone', title: '电话', width: 120},
			{field: 'joinTime', title: '入职时间', align:'center', width: 120},
			{field: 'deptNo', title: '部门', minWidth: 150},
			{field: 'jobNo', title: '职位', align:'center', width: 90},
			{fixed: 'right', align:'center', width: 180, toolbar: '#empTableBar'}
		]],
		page: {
			limit: 10,
			limits: [10, 20, 30]
		},
		loading: true,
		response: {
			statusCode: 1
		},
		parseData: function(d) {
			return {
				"code": d.status,
				"msg": d.msg,
				"count": d.data.count,
				"data": d.data.list
			};
		}
	});
});