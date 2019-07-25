$(function(){
    $.ajax({
            url:'Comment/getAll.do',
            type:'post',
            dataType:'json',
            data: {

			},
			async: true,
			timeout: 1000,
            success:function(data){
            	if(data.code==1){
                	$.each(data.comments,function(index,item){
                		var div;
                		div =
                			'<div class="card-header bg-light">'+"请选择操作"+
						    '<div class="card-actions">'+
							'<a href="#" class="btn">'+
							'<i class="fa fa-pencil-alt" title="修改"></i>'+
							'</a>'+
							'<a href="#" class="btn">'+
							'<i class="fa fa-cog" title="删除"></i>'+
							'</a>'+
						    '</div>'+
					        '</div>'+
					        '<div class="card-body">'+item.details+
					        '</div>';
                		$("#message").append(div);
     })
            	}else{
            		alert("数据获取失败");
            	}

   },
			error:function () {      
	            alert("请求失败!");
	        }
  })
})