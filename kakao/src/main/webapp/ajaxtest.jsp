<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
    <input type="text"id="user_name"value="김준일">
    <script>
        const user_name=document.querySelector('#user_name');
        alert(user_name.value);
        const user_name2=$("#user_name");
        alert(user_name2.val()='2');
        var dataOrigin={
        		     user_name:"전보석",
					user_phone : "01063998524"
					}
					$.ajax({
						type : "get",
						async : "true",//동기화(false) 비동기화(true)
						url : "ajaxTest",
						data : {
							dataOrigin: Json.stringify(dataOrigin);
						},
						dataType : "text",
						success : function(data) {
							alert('비동기 전송성공');
							let dataParse = Json.parse(data);
							alert(data);
						},//응답성공시	
						error : function() {
							alert('비동기 전송 실패');
						},
						complete : function() {
							alert('걍실행됨');
						}

					});
				</script>

        
</body>
</html>