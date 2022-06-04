<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>POST Test</title>
    </head>

    <body>

    </body>
    <script>
        let respone;
        function ajax_test(){
            fetch("/blog/dummy/join", {
                method: "POST",
                cache: 'no-cache',
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body :  'username=test&password=1234&email=test@test.com'
            }).then((response) => respone=response)
        }
    </script>
</html>