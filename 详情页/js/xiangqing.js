window.onload = function() {
	// 轮播
	var box = document.querySelector(".pro-lt");
	var bannerlist = document.querySelector(".banner-list");
	var listli = document.querySelectorAll(".banner-list li"); //所有滑块
	var len = document.querySelectorAll(".banner-list li").length; //滑块的个数
	var liWidth = document.querySelector(".banner-list li").offsetWidth; //获取li的宽度
	var page = document.querySelector(".page"); //找到分页容器
	var pageli = document.querySelectorAll(".page a") //找到所有分页下标

	var next = document.querySelector(".next");
	var prev = document.querySelector(".prev");

	console.log(len);

	// 当前所处的下标
	var curIndex = 0;

	//左按钮点击事件
	prev.onclick = function() {
		curIndex--;
		if (curIndex <= -1) {
			curIndex = len - 1;
		}
		change(curIndex);
	}

	//右按钮点击事件
	next.onclick = function() {
		curIndex++;
		if (curIndex >= len) {
			curIndex = 0;
		}
		change(curIndex);
	}

	// 分页下标点击切换事件
	for (var i = 0; i < pageli.length; i++) {
		pageli[i].setAttribute("data-index", i); //给每个a加上属于自己的序号
		pageli[i].onclick = function() {
			// console.log(this.getAttribute("data-index"))
			curIndex = this.getAttribute("data-index");
			//调用切换效果函数
			change(curIndex);
		}
	}

	//自动播放事件
	var timer = setInterval(function() {
		next.onclick(); //右边的按钮点击一次
	}, 3000);

	//鼠标移入到轮播区域时定时器停止,移开时定时器启动
	box.onmouseenter = function() {
		clearInterval(timer); //鼠标移入清楚定时器
	}
	box.onmouseleave = function() {
		timer = setInterval(function() {
			next.onclick(); //右边的按钮点击一次
		}, 3000);
	}

	//封装一个切换效果函数
	function change(index) {

		//当前下标相同的显示，即添加on，其他去掉on
		for (var i = 0; i < listli.length; i++) {
			listli[i].classList.remove("on");
		}
		listli[curIndex].classList.add("on");
		// 处理对应下标
		for (var i = 0; i < pageli.length; i++) {
			pageli[i].classList.remove("on")
		}
		pageli[index].classList.add("on"); //和当前下标对应的
	}



	//评论
	var ipt = document.getElementById("ipt");
	var txt = document.getElementById('txt');
	var textarea = document.getElementById("text");
	ipt.onclick = function(){
		var textValue = textarea.value.LTrim();
		textarea.value="";
		if(textValue.length>0 ){
			var divs = document.createElement("div");
			var imgs = document.createElement("img");
			var ps = document.createElement("p");
			var inputs = document.createElement("input");
			divs.setAttribute("class","creatediv");
			imgs.setAttribute('class',"createimg");
			ps.setAttribute("class","createdivs");
			inputs.setAttribute("class","createinput");
			imgs.src="pic/1.jpg";
			inputs.type="button";
			inputs.value="删除";
			ps.innerHTML=textValue;
			divs.appendChild(imgs);
			divs.appendChild(ps);
			divs.appendChild(inputs);
			if(txt.children.length==0){
				txt.appendChild(divs);

			}else{
				txt.insertBefore(divs,get_firstChild(txt))
			}
			inputs.onclick = function(){
				this.parentNode.parentNode.removeChild(this.parentNode)
			}
		}



	}
	function get_previousSibling(n) {
		y=n.previousSibling;
		while (y.nodeType!=1) {
			y=y.previousSibling;
		}
		return y;
	}
	function get_nextSibling(n) {
		y=n.nextSibling;
		while (y.nodeType!=1) {
			y=y.nextSibling;
		}
		return y;
	}
	function get_lastChild(n) {
		y=n.lastChild;
		while (y.nodeType!=1) {
			y=y.previousSibling;
		}
		return y;
	}
	function get_firstChild(n) {
		y=n.firstChild;
		while (y.nodeType!=1) {
			y=y.nextSibling;
		}
		return y;
	}

// Trim() , Ltrim() , RTrim()
	String.prototype.Trim = function(){
		return this.replace(/(^\s*)|(\s*$)/g, "");
	}
	String.prototype.LTrim = function(){
		return this.replace(/(^\s*)/g, "");
	}
	String.prototype.RTrim = function() {
		return this.replace(/(\s*$)/g, "");
	}



}
