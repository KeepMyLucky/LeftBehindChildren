$('#sure').click(function(){
	var username=$('#username').val();
	var password=$('#password').val();
    $.ajax({
            url:'Admin/login.do',
            type:'post',
            dataType:'json',
            data: {
            	username: username,
            	password: password
			},
			async: true,
			timeout: 1000,
            success:function(data){
            	if(data.code==1){
            		alert("登录成功");
            		window.location.href = "main.html";
            	}else{
            		alert("登录失败");
            	}
           },
			error:function () {      
	            alert("请求失败!");
	        }
  })
})