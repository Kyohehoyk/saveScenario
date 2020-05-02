function required(str) {
	if (str.length<=0){
		return "入力が必要です。";
	}
	return "";
}

function isInteger(num) {
	if(num.length==0) return "";
	// チェック条件パターン
	var pattern = /^([1-9]\d*|0)$/;
	if (pattern.test(num)) {
		return "";
	} else {
		return "整数を入力してください。";
	}
}

function isFloat(num) {
	if(num.length==0) return "";
	// チェック条件パターン
	var pattern = /^([1-9]\d*|0)(\.\d+)?$/;
	if (pattern.test(num)) {
		return "";
	} else {
		return " 整数または少数を入力してください。";
	}
}

function compare(small, big) {
	if(small.length!=0 && big.length!=0 && small > big){
		return "大小関係を見直してください。";
	} else {
		return "";
	}
}

function dispaly(str, err){
	var ok = str+"OK";
	var ng = str+"NG";
	var msg = str+"Msg";
	if(err.length>0){
		// noneで非表示
		document.getElementById(ok).style.display = "none";
		document.getElementById(ng).style.display = "block";
		document.getElementById(msg).innerHTML  = err;
	}else{
		// blockで表示
		document.getElementById(ok).style.display = "block";
		document.getElementById(ng).style.display = "none";
		document.getElementById(msg).innerHTML = err;
	}
}