layui.use('table', function() {
	var table = layui.table;
	
	var $ = layui.$ // 由于layer弹层依赖jQuery，所以可以直接得到
	, layer = layui.layer;
	
	var tableIns = table.render({
		elem: '#deptTable',
		url: '../dept/queryDept',
		method: 'post',
		toolbar: 'default',
		defaultToolbar: [],
		cols: [[
			{type: 'checkbox', fixed: 'left'},
			{field: 'deptNo', title: '编号', minWidth: 80, hide: true},
			{field: 'name', title: '名称', minWidth: 120},
			{field: 'address', title: '地址', minWidth: 120},
			{fixed: 'right', width: 165, align:'center', toolbar: '#deptTableBar'}
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
			var ret = {
					"code": d.status,
					"msg": d.msg
			}
			if(d.data != null){
				ret.count = d.data.count;
				ret.data = d.data.list;
			}
			return ret;
		}
	});
	
});