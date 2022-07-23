let index = {
    init: function () {
        $('#btn-save').on('click', () => { // this 바인딩 하기 위해
            this.save();
        });
        $('#btn-login').on('click', () => { // this 바인딩 하기 위해
            this.login();
        });

    },

    save: function () {
        //   alert('player save함수 호출됨');
        let data = {
            playername: $('#playername').val(), password: $('#password').val(), email: $('#email').val()
        };
        // console.log(data);
        // ajax 호출시 default 비동기 호출
        /*
        $.ajax({
            type: "POST",
            url: "/api/player",
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

        fetch("/api/player", {
            method: "Post", cache: "no-cache", headers: {
                "Content-Type": "application/json; charset=utf-8",
            }, body: JSON.stringify(data)  // http body data
        })
            .then((response) => response.json())
            .then((data) => {

                console.log(data);
                if (data.status == 'OK' || data.status == '200') {
                    alert('회원가입 완료');
                    location.href = '/';
                }
            })
            .catch((error) => {
                console.log('실패:', error);
            });
    },

    login: function () {
        let data = {
            playername: $('#playername').val(), password: $('#password').val()
        };
        fetch("/api/player/login", {
            method: "Post", cache: "no-cache", headers: {
                "Content-Type": "application/json; charset=utf-8",
            }, body: JSON.stringify(data)  // http body data
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                if (data.status == 'OK' || data.status == '200') {
                    if (data.data == '1') {
                        alert('로그인 완료');
                        location.href = '/';
                    } else if (data.data == '-1') {
                        alert('로그인 실패');
                    }
                }
            })
            .catch((error) => {
                console.log('실패:', error);
            });
    }
}

index.init();