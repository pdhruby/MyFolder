/**
 * 
 */
   // 자바스크립트를 이용한 POST전송하기
   // (이동할 페이지, 전달할 내용(JSON형식), 전송방식)
   function sendPost(path, params, method) {
      // 세번째 인수가 넘어오지 않으면 기본값으로 전송방식을 post로 만든다.
        method = method || "post";
      // 폼태그 작성
        var form = document.createElement("form");
      // 폼태그에 속성 지정
        form.setAttribute("method", method); // 전송방식 
        form.setAttribute("action", path);   // 이동할 페이지 지정 
        // <form action="이동할 페이지" method="post"></form>

        // 전송할 데이터를 숨김필드로 만들어 form태그 안에 넣어준다.
        for (var key in params) {
            var hiddenField = document.createElement("input"); // input태그 작성
            hiddenField.setAttribute("type", "hidden"); // 타입을 hidden으로
            hiddenField.setAttribute("name", key); // name속성을 key로
            hiddenField.setAttribute("value", params[key]); // value 속성을 값으로 지정
            form.appendChild(hiddenField); // 폼태그에 추가
        }
        document.body.appendChild(form); // body에 폼태그 추가
        form.submit(); // 전송
    }
   // 호출
   // sendPost('list.jsp',{"p":4, "s":10, "b":10,"idx":5},"post");
   function clickBtn(){
      alert("익스터널방식");
   }