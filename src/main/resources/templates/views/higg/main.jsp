<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-30
  Time: 오후 1:06
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>HIGG</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<h1>Hi.gg LOL전적 검색</h1>
<div class="container">
    <div>
        <form class="row g-3" method="post">
            <div class="col-auto">
                <input type="text" readonly class="form-control-plaintext" value="로그인 후 검색 해주세요">
            </div>
            <div class="col-auto">
                <input type="text" name="searchName" class="form-control"size=29 placeholder="검색할 소환사명을 입력해주세요.">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>
        <c:if test="${sessionScope.loginInfo eq null}">
            <!-- 로그인이 안되어 있으면 -->
            <div>
                <form id="loginFrm" name="loginFrm" method="post" action="/main/Login">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="uid" id="uid" placeholder="10글자" maxlength="10"></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pw" id="pw" maxlength="20"></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="button" id="login" value="로그인"/>
                            </td>
                            <td><a href="/member/register"><input type="button" id="regForm" value="회원가입"/></a></td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
        <c:if test="${sessionScope.loginInfo ne null}">
            <h3>${sessionScope.loginInfo.uid}님 환영합니다.</h3>
            <a href="/logout">로그아웃</a>
        </c:if>
</div>
</body>
<script>
    $(document).ready(function (e) {
        $('#login').click(function () {
            if ($.trim($('#uid').val()) == '') {
                alert("아이디를 입력해 주세요.");
                $('#uid').focus();
                return;
            } else if ($.trim($('#pw').val()) == '') {
                alert("비밀번호를 입력해 주세요.");
                $('#pw').focus();
                return;
            }
            $('#loginFrm').submit();
        });
    });

</script>


</html>
