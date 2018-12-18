<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Title</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
</script>
<style type="text/css">
.starR{
  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
  background-size: auto 100%;
  width: 30px;
  height: 30px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starR.on{background-position:0 0;}
</style>
</head>
<body>
<div class="starRev">
  <span class="starR on">��1</span>
  <span class="starR">��2</span>
  <span class="starR">��3</span>
  <span class="starR">��4</span>
  <span class="starR">��5</span>
  <span class="starR">��6</span>
  <span class="starR">��7</span>
  <span class="starR">��8</span>
  <span class="starR">��9</span>
  <span class="starR">��10</span>
</div>
</body>
</html>
    