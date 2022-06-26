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

        function ajax_join(username, password, email){
            fetch("/blog/dummy/join", {
                method: "POST",
                cache: 'no-cache',
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body :  'username='+username+'&password='+password+'&email='+email
            }).then((response) => console.log(response))
        }

        function ajax_update (userId, password, email) {

            fetch("/blog/dummy/user/"+userId , {
                method: "PUT",
                cache: "no-cache",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    "userId" : userId,
                    "password": password,
                    "email": email,
                })
                }).then((response) => console.log(response))
            }



    </script>
</html>