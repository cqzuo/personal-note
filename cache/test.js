function a(){
      var i=0;
      function b(){
        document.write("<br>");
        document.write(++i);
      }
      return b;
    }
    var c = a();
	
	for(var j=0;j<100;j++){
			c();
		}