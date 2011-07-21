function makeList(){
	var oDiv = document.getElementById("div1");
	iterator = document.createNodeIterator(oDiv,
	NodeFilter.SHOW_ELEMENT,null,false);
	
	var oOutput = document.getElementById("text1");
	var oNode = iterator.nextNode();
	var sum = 0;
	while(oNode){
		oOutput.value +=oNode.innerHTML +"\n";
		oNode = iterator.nextNode();
		sum  +=1;
		}
	alert(sum);
	}