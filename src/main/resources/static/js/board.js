let index = {
    init: function () {
        $('#btn-save').on('click', () => { // this 바인딩 하기 위해
            this.save();
        });
        $('#btn-delete').on('click', () => { // this 바인딩 하기 위해
            this.deleteById();
        });


    },

    save: function () {
        //   alert('player save함수 호출됨');
        let data = {
            title: $('#title').val(), content: $('#content').val()
        };
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //body 데이터 타입
            dataType: "json" // 응답 데이터 타입
        }).done(function (response) {
            console.log(response);
            alert('글쓰기 완료');
            location.href = '/';
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });

        /*        fetch("/auth/joinProc", {
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
                        console.log( error);
                    });*/

    },
    deleteById: function () {
        let id = document.querySelector('#id').innerText;
        $.ajax({
            type: "DELETE",
            url: "/api/board/"+id,
            dataType: "json" // 응답 데이터 타입
        }).done(function (response) {
            console.log(response);
            alert('글삭제 완료');
            location.href = '/';
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });

        /*        fetch("/auth/joinProc", {
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
                        console.log( error);
                    });*/

    }
}

index.init();