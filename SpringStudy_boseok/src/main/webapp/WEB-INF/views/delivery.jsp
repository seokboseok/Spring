<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송정보</title>
</head>
<body>
<form action="delivery-request" method="post">
1. 배송 받을 사람 : <input type="text" name="customer_name"><br>
2. 배송지 주소 : <input type = "text" name="customer_address"><br>
3. 연락처 <input type ="tel" name ="customer_phone"><br>
4. 요청사항 <input type= "text" name="customer_etc"><br>
<input type="submit" value="주문하기">
</form>
</body>
</html>