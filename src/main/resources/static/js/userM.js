let index = {
    init: function () {
        $('#btn-save').on('click', () => { // this 바인딩 하기 위해
            this.save();
        });
    },

    save: function () {
        //   alert('user의 save함수 호출됨');
        let data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val()
        };
        // console.log(data);
        // ajax 호출시 default 비동기 호출
        /*
        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json" // 응답 데이터 타입
        }).done(function (response) {
            console.log(response);
            alert('회원가입 완료');
            location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });*/

        fetch("/api/user", {
            method: "Post",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
            body: JSON.stringify(data)
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                alert('회원가입 완료');
                location.href = '/';
            })
            .catch((error) => {
                console.log('실패:', error);
            });
    }
}

index.init();