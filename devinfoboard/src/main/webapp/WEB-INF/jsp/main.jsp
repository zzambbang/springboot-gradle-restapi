<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html dir="ltr" lang="ko">

<head>
    <title>JSON return</title>
</head>

<body>
	AJAX TEST
    <input type = "button" onclick = "javascript:ajax()" value = "ㅠㅠ" />
    <div><table id = "boardList" border ="1"></table></div>


    <script>
        
        $.ajax({
            type : 'GET',
            url : '/users'
            async : false,
            headers : {
                "Content-Type" : "application/json"
            },

            dataType : 'json',
            data : JSON.stringify({
                "user_id" : user_id,
                "name" : name,
                "email" : email
            }),

            succeess : function(result) {
                alert("데이터를 성공적으로 가져왔습니다");
                console.log(result)
            },
            error : function(){
                alert("에러가 났습니다.");
            }
        })

    </script>


</body>

</html>
