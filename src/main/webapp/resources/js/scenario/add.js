function chkTitle() {
	var form = "title";
	var input = document.getElementById(form).value;
	var err = required(input);
	dispaly(form,err);
}

function chkCreater() {
	var form = "creater";
	var input = document.getElementById(form).value;
	var err = required(input);
	dispaly(form,err);
}

function chkParticipant(){
	var form = "participant";
	var Start = "participantStart";
	var End = "participantEnd";

	var inputStart = document.getElementById(Start).value;
	var inputEnd = document.getElementById(End).value;

	var err = isInteger(inputStart);
	dispaly(form,err);
	if (err.length==0) {
		err = isInteger(inputEnd);
		dispaly(form,err);
	}
	if (err.length==0) {
		err = compare(inputStart,inputEnd);
		dispaly(form,err);
	}
}

function chkEstimatedTime(){
	var form = "estimatedTime";
	var Start = "estimatedTimeStart";
	var End = "estimatedTimeEnd";

	var inputStart = document.getElementById(Start).value;
	var inputEnd = document.getElementById(End).value;

	var err = isFloat(inputStart);
	dispaly(form,err);
	if (err.length==0) {
		var err = isFloat(inputEnd);
		dispaly(form,err);
	}
	if (err.length==0) {
		err = compare(inputStart,inputEnd);
		dispaly(form,err);
	}
}