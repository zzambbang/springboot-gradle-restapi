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
    <button id="start_ajax"> server 와 통신시작 </button>
    <p><span id="res"></span></p>

    <%-- <script src="/devinfoboard/resource/static/js/" --%>
    <script src="/webjars/jquery/3.5.1/jquery.js"></script>
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript">
       $(document).ready(function(){
           $.get('/users', function(result){
               $('body').html(result);
           });
       });

    // $(document).ready(function(){
    //     $("#start_ajax").click(function(){
    //         $.ajax({
    //             url : "/users",
    //             type : "get",
    //             data : {
    //                 user_id : "user id",
    //                 name : "name",
    //                 email : "email"
    //             },

    //             success : function(result){
    //                 alert("통신 성공");
    //                 $("#res").text("결과 : " + result);
    //             },

    //             error : function(xhr, status, error){
    //                 alert("통신 에러")
    //             }
    //         });
    //     });
    // });

    </script>

</body>

</html>
