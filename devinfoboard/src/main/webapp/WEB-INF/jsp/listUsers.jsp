<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html dir="ltr" lang="ko">

<head>
    <title>jsp로 유저 정보 보기</title>
    <style>
    .cls1 {
        font-size : 40px;
        text-align : center;
    }
    .cls2 {
        font-size : 20px;
        text-align : center;
    }
</head>

<body>
    <p class="cls1">회원정보</p>
    <table align="center" border="1">
        <tr width="7%"><b>번호</b></td> 
        <tr width="7%"><b>이름</b></td> 
        <tr width="7%"><b>이메일</b></td> 
    </tr>
    
    <c:forEach items="${userList}"

</body>

</html>

