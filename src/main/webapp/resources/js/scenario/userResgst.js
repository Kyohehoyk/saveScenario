function chkLoginId() {
	var form = "loginId";
	var input = document.getElementById(form).value;
	var err = required(input);
	dispaly(form,err);
	if (err == 0){
		var err = isEnglishNumber(input);
		dispaly(form,err);
	}
}

function chkNickname() {
	var form = "nickname";
	var input = document.getElementById(form).value;
	var err = required(input);
	dispaly(form,err);
}

function chkPassword() {
	var password = "password";
	var confirmPassword = "confirmPassword";
	var input1 = document.getElementById(password).value;
	var input2 = document.getElementById(confirmPassword).value;
	var err = required(input1);
	dispaly(password,err);
	if (err == 0 && input2.length > 0){
		err = samePassword(input1, input2);
		dispaly(password,err);
		dispaly(confirmPassword,err);
	}
}

function chkConfirmPassword() {
	var password = "password";
	var confirmPassword = "confirmPassword";
	var input1 = document.getElementById(password).value;
	var input2 = document.getElementById(confirmPassword).value;
	var err = required(input2);
	dispaly(confirmPassword,err);
	if (err == 0 && input1.length > 0){
		err = samePassword(input1, input2);
		dispaly(password,err);
		dispaly(confirmPassword,err);
	}
}


function isEnglishNumber(str){
  if(!str.match(/^[A-Za-z0-9]*$/)){
    return "半角英数字のみを入力してください。";
  }else{
    return "";
  }
}

function samePassword(str1, str2) {
	if(str1 != str2){
		return "パスワードと確認用パスワードが一致していません。";
	} else {
		return "";
	}
}
