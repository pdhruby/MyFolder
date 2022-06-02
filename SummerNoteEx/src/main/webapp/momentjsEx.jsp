<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.3/moment.min.js" integrity="sha512-x/vqovXY/Q4b+rNjgiheBsA/vbWA3IVvsS8lkQSX1gQ4ggSJx38oI2vREZXpTzhAv6tNUaX81E7QBBzkpDQayA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.3/moment-with-locales.min.js" integrity="sha512-vFABRuf5oGUaztndx4KoAEUVQnOvAIFs59y4tO0DILGWhQiFnFHiR+ZJfxLDyJlXgeut9Z07Svuvm+1Jv89w5g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	moment.locale("ko-KR");
	document.write(moment() + "<br>");

	document.write(moment.locale()+ "<br>");         // ko
	document.write(moment().format('LT')+ "<br>");   // 오후 3:39
	document.write(moment().format('LTS')+ "<br>");  // 오후 3:39:51
	document.write(moment().format('L')+ "<br>");    // 2022.06.02.
	document.write(moment().format('l')+ "<br>");    // 2022.06.02.
	document.write(moment().format('LL')+ "<br>");   // 2022년 6월 2일
	document.write(moment().format('ll')+ "<br>");   // 2022년 6월 2일
	document.write(moment().format('LLL')+ "<br>");  // 2022년 6월 2일 오후 3:39
	document.write(moment().format('lll')+ "<br>");  // 2022년 6월 2일 오후 3:39
	document.write(moment().format('LLLL')+ "<br>"); // 2022년 6월 2일 목요일 오후 3:39
	document.write(moment().format('llll')+ "<br>");
</script>
</head>
<body>

</body>
</html>