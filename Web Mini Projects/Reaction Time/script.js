
		function getRandomColors(){
			var letter=["0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F",];
			var color="#";
			for(var i=0;i<6;i++){
				color+=letter[Math.floor(Math.random()*16)];
			}
			return color;
		}
		
		
		
		var start=new Date().getTime();
			function makeItAppear(){
				var top= Math.random() * 400;
				var left= Math.random() * 400;
				var size= Math.random() * 200;
				if(Math.random()<0.5)
				{
					document.getElementById("shape").style.borderRadius="50%";
				}else{
					document.getElementById("shape").style.borderRadius="0px";
				}
				document.getElementById("shape").style.backgroundColor=getRandomColors();
				document.getElementById("shape").style.top= top +"px";
				document.getElementById("shape").style.left=left+"px";
				document.getElementById("shape").style.width=size+"px";
				document.getElementById("shape").style.height=size+"px";
				document.getElementById("shape").style.display="block";
				start=new Date().getTime();
			}
			
			
		
			
			document.getElementById("shape").onclick=function(){
				document.getElementById("shape").style.display="none";
				var end = new Date().getTime();
				var timeTaken=(end-start)/1000;
				document.getElementById("time").innerHTML =timeTaken + "s";
				setTimeout(makeItAppear,Math.random()*2000);
			}
			