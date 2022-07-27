<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
  <form action="/auth/loginProc" method="post">
    <div class="form-group">
      <label for="playername">playername:</label>
      <input type="text" name="username" class="form-control" placeholder="Enter playername" id="playername">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
    </div>

    <button type="submit" class="btn btn-primary">로그인</button>
    <a href="https://kauth.kakao.com/oauth/authorize?client_id=${clientKey}&redirect_uri=http://58.77.93.16/auth/kakao/callback&response_type=code">
      카카오 로그인</a>
  </form>

</div>
<%@include file="../layout/footer.jsp"%>

