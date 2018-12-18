// WebContent/ajax.js
var ajax={}// 객체
ajax.xhr={};// 객체
ajax.xhr.Request = function(url,params,callback,method){// 객체 생성. 생성자
	// this.멤버명
	this.url = url;
	this.params = params;
	this.callback = callback;
	this.method = method;
	this.send();//멤버 메서드
}
ajax.xhr.Request.prototype={ //멤버 구현
		getXmlHttpRequest:function(){//ajax 객체 생성을 위한 멤버 메소드
			if(window.ActiveXObject){
				try{
					return new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					try{
						return new ActiveXObject("Microsoft.XMLHTTP");
					}catch(e2){
						return null;
					}
				}
			}else if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return null;
			}
		},
		send : function(){
			// this.req : ajax.xhr.Request 객체의 멤버 객체
			//				  ajax 객체 저장
			this.req = this.getXmlHttpRequest();
			var httpMethod = this.method?this.method:"GET"; // this.method? : method 존재의 유무(존재하는가?)
			if(httpMethod != 'GET' && httpMethod != 'POST'){
				httpMethod = 'GET';
			}
			var httpParams = (this.params == null || this.params =='')? null:this.params;
			var httpUrl = this.url;
			if(httpMethod == 'GET' && httpParams != null){
				httpUrl = httpUrl + "?" + httpParams; //GET 방식인 경우 파라미터를 붙임.
			}
			this.req.open(httpMethod,httpUrl,true); // ajax 객체 준비 true:비동기(false:동기)
			this.req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var request = this;  //ajax.xhr.Request 객체.
			// callback 함수 등록.
			this.req.onreadystatechange = function(){
				request.onStateChange.call(request); //request : 나 
			}
			this.req.send(httpMethod='POST'?httpParams:null);
		},
		onStateChange : function(){
			this.callback(this.req); //this.callback(this.req); : 콜백 함수 호출시 ajax 객체 전달.
		}
}