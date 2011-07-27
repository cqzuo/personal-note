  function makeList(){
	log.profile('generate test string ');
	  var inputEle = document.getElementsByTagName("input");
	for(var i = 0;i<inputEle.length;i++){
		log.debug('input element');
			var oEle = inputEle[i];
			if(oEle.type=="button"){
			}else{
				oEle.style.color = "blue";
				oEle.readOnly = true;
			}
		}
	var selEle = document.getElementsByTagName("select");
	for(var i = 0;i<selEle.length;i++){
			var oEle = selEle[i];
			oEle.disabled = true;
		}
		
	var texEle = document.getElementsByTagName("textarea");
	for(var i = 0;i<texEle.length;i++){
			var oEle = texEle[i];
			oEle.style.color = "blue";
			oEle.readOnly = true;
		}
	log.profile('generate test string ');
  }