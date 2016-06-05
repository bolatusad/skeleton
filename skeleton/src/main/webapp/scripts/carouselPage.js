$(document).ready(function(){
	getImgByAjax();
	

//	setDataOfCarousel(image_data);
//	initialCarousel();
//	initialIcheck();
//	getCurrentImg();
//	$('#single2').on('slid.bs.carousel',getCurrentImg);
})
function getImgByAjax()
{
	$.post("getData.do", {		
	}, function(data) {
		setDataOfCarousel(data);
		initialCarousel();
		initialIcheck();
		getCurrentImg();
//		return image_JSON;
	}, "json");
}


function setDataOfCarousel(image_JSON){
//	alert(image_JSON)
//	if(!image_JSON)
//	var image_JSON = {
//		"images":[
//		{"image_id":"N20040118G105922","image_url":"../aurora/N20040118G105922.bmp","name":"N20040118G105922","type":"1", "round":"5","accuracy_rate":"78","count_trained":"15"},
//		{"image_id":"N20040118G105932","image_url":"../aurora/N20040118G105932.bmp","name":"N20040118G105932","type":"2", "round":"7","accuracy_rate":"80","count_trained":"16"},
//		{"image_id":"N20040118G105942","image_url":"../aurora/N20040118G105942.bmp","name":"N20040118G105942","type":"4", "round":"3","accuracy_rate":"65","count_trained":"14"},
//		{"image_id":"N20040118G105922","image_url":"../aurora/N20040118G105922.bmp","name":"N20040118G105922","type":"5", "round":"8","accuracy_rate":"91","count_trained":"18"}
//		]
//	};
	var divContainer = $('<div id="single2" class="carousel slide"  data-shift="1" ></div>');
	var carouselInner = $('<div class="carousel-inner" id="carousel-inner"></div>');
	var carouseControl = $('<a style="display:none;" id="leftControl" class="carousel-control left" href="#single2" data-slide="prev">Previous</a><a id="rightControl"  style="display:none;" class="carousel-control right" href="#single2" data-slide="next">Next</a>');
	var image_length = image_JSON.images.length;
//	alert(image_length)
	if(image_length>2) 
	{
		for(var i=0;i<Math.ceil(image_length/3);i++)
		{
			var ulEle = $('<ul class="row item"></ul>');
			for(var j=0;j<3;j++)
			{
				if(i*3+j<=image_length-1)
				{
					var image_id = image_JSON.images[i*3+j].image_id;
					var image_url = image_JSON.images[i*3+j].image_url;
					var name = image_JSON.images[i*3+j].name;
					var type = image_JSON.images[i*3+j].type;
					var round = image_JSON.images[i*3+j].round;
					var accuracy_rate = image_JSON.images[i*3+j].accuracy_rate;
					var count_trained = image_JSON.images[i*3+j].count_trained;
					var liStr = '<li class="col-xs-4" style="text-align:center;">'
						+ '<img class="img-responsive" id='+image_id +' '
						+ 'src='+ image_url +' '
						+ 'name='+ name +' '
						+ 'type=' + type +' '
						+ 'round=' +round +' '
						+ 'accuracy_rate=' +accuracy_rate +' '
						+ 'count_trained='+count_trained +' '
						+'><label align="center" style="margin-right:20px;">'
						+ name +'</label></li>';
					//console.log(liStr);
					ulEle.append($(liStr));			
				}
			}
			carouselInner.append(ulEle);
		}
		divContainer.append(carouselInner);
		divContainer.append(carouseControl);
		$('#section').append(divContainer);
		getCurrentImg();
	}
	else
		alert("图片少于3张");
}

function getCurrentImg(){
	//console.log("getimggggg");
	var goalUls = $("[class='row item active']");
	if(goalUls.length == 1)
	{
		var goalUl = goalUls[0];
		var goalLi = $(goalUl).children().eq(1);
		var goalImg = $(goalLi).children().get(0);   
		//console.log(goalImg.getAttribute("round"));
		var round = $("#round");
		var accuracy_rate = $("#accuracy_rate");
		var count_trained = $("#count_trained");
		var currentImg = $("#currentImg");
		var radios = document.getElementsByName("resultType");

		var roundValue = goalImg.getAttribute("round");
		var accuracy_rateValue = goalImg.getAttribute("accuracy_rate");
		var count_trainedValue = goalImg.getAttribute("count_trained");
		var currentImgvalue = goalImg.getAttribute("name");
		var radioValue = goalImg.getAttribute("type");

		round.html(roundValue);
		accuracy_rate.html(accuracy_rateValue+"%");
		count_trained.html(count_trainedValue);
		//currentImg.val(currentImgvalue);
		//currentImg.attr("readonly","readonly")
		currentImg[0].innerHTML = currentImgvalue;

		//radios[parseInt(radioValue)-1].checked=true;
		$(radios[parseInt(radioValue)-1]).iCheck('check');
	}


}

function initialIcheck(){
	$('.icheckUl input').iCheck({
	  checkboxClass: 'icheckbox_square-blue',
	  radioClass: 'iradio_square-blue',
	  increaseArea: '20%'
	});
}

function initialCarousel(){
	var carousels = $('.carousel');
	carousels.each(function() {
	  var $obj = $(this);
	  var $inner = $obj.find('.carousel-inner');
	  var id = 'uuid' + new Date().getTime();
	  $obj.addClass(id);
	  if ($obj.data('shift') === 1) {
		var items = $obj.find('.item > [class*="col-"]'),
			visibleCnt = $obj.find('.item:first [class*="col-"]').length,
			wrapper = "";	
		// build styles
		var rule_base = '.carousel.' + id + ' .carousel-inner > .item',
			styles = $('<style></style>'),
			rules = [];
			rules[0] = rule_base + '.next {left: ' + (100 / visibleCnt) + '%; transform: none;}';
			rules[1] = rule_base + '.active {left: 0;}';
			rules[2] = rule_base + '.active.left {left: -' + (100 / visibleCnt) + '%; transform: none;}';
			rules[3] = rule_base + '.next.left {left: 0;}';
			rules[4] = rule_base + '.active.right {left: ' + (100 / visibleCnt) + '%; transform: none;}';
			rules[5] = rule_base + '.prev.right {left: 0;}';
			rules[6] = rule_base + '.prev {left: -' + (100 / visibleCnt) + '%; transform: none;}';
		for (var i = 0; i < rules.length; i++) {
		  styles.append(rules[i]);
		}
		$obj.prepend(styles);
		// rebuild items
		for (var i = 0; i < $(items).length; i++) {
		  var $item = $(items[i]);
		  var parent = $item.parent();
		  if (parent.hasClass('item')) {
			if (!wrapper.length) {
			  wrapper = parent.clone().removeClass('active').html('');
			}
			$item.unwrap();
		  }		  
		  var itemGroup = [$item];
		  for (var x = 1; x < visibleCnt; x++) {
			var a = i + x;
			var next = $(items[a]);
			if (!next.length) {
			  next = $(items[(a - $(items).length)]);
			}
			itemGroup[x] = next.clone();
		  }
		  var newSet = wrapper.clone().html(itemGroup);
		  if (i == 0) {
			newSet.addClass('active');
		  }
		  newSet.appendTo($inner);
		}
	  }
	});
	
	$('#single2').carousel({
	pause: true,
	interval: false
	});
	
	$('#arrowLeft').click(function(){
		$('#leftControl').click();
	});
	$('#arrowRight').click(function(){
		$('#rightControl').click();
	});


}