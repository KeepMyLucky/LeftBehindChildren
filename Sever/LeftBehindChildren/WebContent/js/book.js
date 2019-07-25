$(function(){
    $.ajax({
            url:'Book/getAll.do',
            type:'post',
            dataType:'json',
            data: {

			},
			async: true,
			timeout: 1000,
            success:function(data){
            	if(data.code==1){
                	$.each(data.books,function(index,item){
                        var tr;
                        tr = 
 							'<td>' + item.isbn + '</td>' + 
 							'<td>' + item.bookname + '</td>' +
 							'<td>' + item.author + '</td>' +
 							'<td>' + item.bookface + '</td>' +
 							'<td>' + item.overview + '</td>' +
 							'<td>' +
 							'<button type="button" class="btn btn-warning" title="修改"><i class="fa fa-clipboard"></i></button>' +
 							'&nbsp;' +
 							'<button type="button" class="btn btn-danger" title="删除"><i class="fa fa-trash"></i></button>' +
 							'</td>' ;
 							$("#usertable").append('<tr>' + tr + '</tr>')
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