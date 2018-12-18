//ajaxStudy/WebContent/httpRequest.js : 자바 스크립트 파일
var httpRequest = null;
//getXmlHttpRequest() : Ajax 객체 생성 기능 함수.
function getXmlHttpRequest(){
		if(window.ActiveXObject){ //현재 브라우저가 익스플로러????  ActiveXObject 객체가 Ajax 객체임.
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		}else if(window.XMLHttpRequest){ // 그 외 브라우저?? XMLHttpRequest객체가 Ajax 객체임. 표준.
			return new XMLHttpRequest();
		}else{
			return null;
		}
	
}
//	sendRequest("hello.jsp",params,helloFromServer,"POST");
function sendRequest(url,params,callback,method){
	// httpRequest : Ajax 객체를 저장하는 변수.
	httpRequest = getXmlHttpRequest();
	// method? : method가 null이 아님
	var httpMethod = method?method:'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod='GET'; //서버에 GET 방식 또는 POST 방식으로 전송 하도록 설정.
	}
	// httpParams : 서버에 전송할 파라미터값을 저장.
	var httpParams = (params == null || params == '')? null : params;
	// 서버에 요청할 페이지
	var httpUrl = url;
	// GET 방식으로 요청시 파라미터가 존재함.
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;
	}
	//AJAX 객체 설정
	// Ajax 준비
	// true : 비동기 방식 전송
	httpRequest.open(httpMethod,httpUrl,true);
	//POST 방식의 파라미터전송방식 설정.
	httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	//callback함수 설정 : 상태 변경시 자동호출되는 함수.
	httpRequest.onreadystatechange = callback;
	//Ajax 객체로 서버에 전송
	httpRequest.send(httpMethod='POST'?httpParams:null);
}












