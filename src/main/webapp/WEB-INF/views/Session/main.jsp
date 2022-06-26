<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session Test</title>
</head>

<body>
<h3>세션 테스트 페이지</h3>
<button onclick="javascript:removeSession();">세션 초기화</button>
정보 키 : <input type="text" name="key" id="inkey"/>
정보 값 : <input type="text" name="value" id="invalue"/>
<button onclick="javascript:addData();">세션 정보 추가</button>
<button onclick="javascript:deleteData();">세션 정보 삭제</button>
<p> session : ${sessionId}</p>
<table>
    <tr>
        <th>정보 이름</th>
        <th>정보 값</th>
    </tr>
    <c:forEach var="resultMap" items="${resultList}">
        <tr>
            <td>${resultMap.sessionKey}</td>
            <td>${resultMap.data}</td>
        </tr>
    </c:forEach>
</table>
</body>
<script>

    function addData () {
        let key  = document.querySelector('#inkey').value;
        let value = document.querySelector('#invalue').value;
        fetch("/blog/Session/addData.do" , {
            method: "Post",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "key" : key,
                "value": value,
            })
        }).then((response) => console.log(response))
    }


    function deleteData () {
        let key  = document.querySelector('#inkey').value;

        fetch("/blog/Session/deleteData.do" , {
            method: "Post",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "key" : key,

            })
        }).then((response) => console.log(response))
    }


    function removeSession () {

        fetch("/blog/Session/removeSession.do" , {
            method: "Post",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({

            })
        }).then((response) => console.log(response))
    }


</script>
</html>