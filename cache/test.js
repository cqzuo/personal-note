function makeList(){
	var oDiv = document.getElementById("div1");
	iterator = document.createNodeIterator(oDiv,
	NodeFilter.SHOW_ELEMENT,null,false);
	
	var oOutput = document.getElementById("text1");
	var oNode = iterator.nextNode();
	}