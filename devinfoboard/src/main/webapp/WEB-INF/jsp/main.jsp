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
    <button id="btn1"> server 와 통신시작 </button>
    <p><span id="res"></span></p>

    <form id="frm">
        search name : <input type="text" name="name" id="name"><br>
    </form>
        <buttion id ="btn2">serialize</button>
        <div id="searchresult"></div>

    <%-- <script src="/devinfoboard/resource/static/js/" --%>
    <script src="/webjars/jquery/3.5.1/jquery.js"></script>
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript">

    //$.ajax 방법 사용
    $(document).ready(function(){
        $("#btn1").click(function(){
            $.ajax({
                url : "/users",
                type : "get",
                // data : {
                //     user_id : "user id",
                //     name : "name",
                //     email : "email"
                // },

                success : function(result){
                    alert("통신 성공");
                    $("#searchresult").text("결과 : " + JSON.stringify(result));
                },

                error : function(xhr, status, error){
                    alert("통신 에러")
                }
            });
        });

        //ajax 2번 search
        $('#btn2').click(function(){
        $.ajax({
            url: "/user",
            type: "get",
            data: $("#frm").serialize(),
            success: function(data){
                $('#result').text(data);
            },
            error: function(){
                alert("serialize err");
            }
        });
    });
    });

    </script>

</body>

</html>
