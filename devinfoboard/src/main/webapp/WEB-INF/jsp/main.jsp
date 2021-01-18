<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html dir="ltr" lang="ko">

<head>
    <title>JSON return</title>

    <style type="text/css">
    table{
        border : #ABF200 solid;
    }
    </style>

</head>

<body>
	AJAX TEST
    <br>
    <br>
    <button id="btn1"> 테이블로 보기 </button>
    <div><table id ="userList" border = "1"></table></div>

    <%-- <p><span id="getresult"></span></p> --%>
    <br>
    <form id="frm">
        name : <input type="text" name="name" id="name"><br>
    </form>

    <br>

    <button id="btn2"> 검색하기 </button>
    <p><span id="searchresult"></span></p>

 <%-- jstl 테이블로 보기  --%>
    <br><br>
    <button id="btn3"> jstl테이블로 보기 </button>
    <div><table id ="userList2" border = "1"></table></div>

    <c:set var="List" value="${requestScope['json'].List}"/>

    




    <script src="/webjars/jquery/3.5.1/jquery.js"></script>
	<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript">



// ajax 사용해서 테이블 만들기
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
                    $("#getresult").text("결과 : " + JSON.stringify(result));


                    var tblresult = result;
                    var str = "";
                    $.each(tblresult, function(i){
                        str += "<TR>"
                        str += '<TD>' + tblresult[i].user_id + '</TD><TD>' + tblresult[i].name + '</TD><TD>' + tblresult[i].email + '</TD>'
                        str += '</TR>'
                    });
                    $("#userList").append(str);
                },

                error : function(xhr, status, error){
                    alert("통신 에러");
                }
            });

        });


        //--버튼 2 search 검색하기 

        $("#btn2").click(function(){
            var name = $("#name").val()

            $.ajax({
                url: "/user?name=" + name,
                type : "get",
                //data : form,
                success : function(name){
                    $("#searchresult").text(JSON.stringify(name));
                },

                error : function(xhr, status, error){
                    alert("검색 실패");
                }

            });
        });

    });

    </script>

</body>

</html>

