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
	여기에 리턴값을 보여줘야해 ㅠㅠ
    <input type = "button" onclick = "javascript:ajax()" value = "ㅠㅠ" />
    <div><table id = "boardList" border ="1"></table></div>
    

    <script>
        
        $.ajax({
            url:"/api/users",
            method: "GET"
            data : {"user_id" : user_id, "name" : name, "email" : email},
            success : function (res){
                if (condition) {
                    
                }
            }

        })

    </script>


</body>

</html>

$