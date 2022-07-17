<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script>

    function addData() {
        let key = document.querySelector('#inkey').value;
        let value = document.querySelector('#invalue').value;
        $.ajax({
            type: 'POST',
            url: '/Session/addData.do',
            data: JSON.stringify({
                'key': key,
                'value': value,
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json'
        }).done(function (response) {
            console.log('doen');
            console.log(response);
        }).fail(function (error) {
            console.log('fail');
            console.log(JSON.stringify(error));
        });

    }

    /*
    ajax 는 jquery 라이브러리가 필요하지만 성공 실패 값 출력
    fetch는 라이브러리가 필요 없지만 에러시 json변환이 안되어 Network response 별도 확인필요
     */

    function deleteData() {
        let key = document.querySelector('#inkey').value;
        fetch("/Session/deleteData.do", {
            method: "POST",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
            body: JSON.stringify({
                "key": key,

            })
        }).then((response) => response.json())
            .then((data) => {
                console.log('then');
                console.log(data);
            })
            .catch((error) => {
                console.log(error);
            });




    };


    function removeSession() {

        fetch("/Session/removeSession.do", {
            method: "Post",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
            body: JSON.stringify({})
        }).then((response) => response.json())
            .then((data)=>{
                console.log('then');
                console.log(data);
            }).catch((error)=> console.log(error));
    }


</script>
</html>