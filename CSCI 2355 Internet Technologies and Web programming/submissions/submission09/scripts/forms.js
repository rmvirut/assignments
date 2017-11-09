var runningSum;

var comInfo = document.getElementById("comp-info");

function showCompanyBlock() {
	if (document.getElementById("company").checked == true) {
		comInfo.style.display = "block";
	} else {
		comInfo.style.display = "none";
		x = document.get
	}
}

function getEntity() {
	if (getElementById("company").checked == true) {
		return "company";
	} else if (getElementById("individual").checked == true) {
		return "individual";
	}
}

function getElementById(id) {
	return document.getElementById(id);
}

function getPackage() {
	var x = document.getElementsByName("package");

	for (var i = 0; i < x.length; i++) {
		if (x[i].checked) {
			return x[i].value;
		}
	}
}


function getFeatures() {
	var x = document.getElementsByClassName("feature-name");
	var y = document.getElementsByName('feature');
	var arr = [];

	for (var i = 0; i < y.length; i++) {
		if (y[i].checked) {
			arr.push(x[i].innerHTML);

		}
	}
	return arr;
}


function validateEmail(email) {
	var re = /^(?:[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/;
	return re.test(email);
}


function webService() {
	this.entity = getEntity();
	if (entity == 'company') {
		this.comName = getElementById("com-name").value;
		this.industry = getElementById("industry").value;
		this.comPhone = getElementById("com-phone").value;
		this.comEmail = getElementById("com-email").value;
		this.streetAddr = getElementById("com-address").value;
		this.website = getElementById("com-website").value;
	}

	//user information
	this.salute = getElementById("salute").value;
	this.usrName = getElementById("username").value;
	this.role = getElementById("role").value;
	this.usrPhone = getElementById("userphone").value;
	this.usrEmail = getElementById("useremail").value;

	//service package and features
	this.service = getPackage();

	//additional features
	this.features = getFeatures();
	this.addComment = getElementById('msg').value;
	this.reqMeeting = getElementById('appoint').checked;

}

function sendRequest() {
	alert("submitted");
	quote = new webService();
	if (service.entity == 'company') {
		if (validateEmail(quote.comName)) {
			alert("Company email is invalid");
		}
	}

	if (validateEmail(quote.usrEmail)) {
		alert("User email is invalid");
	}

	printQuote(quote);
}


function printQuote(quote) {
	alert(`Service Pack: ${quote.service}
				 Additional Feature: ${quote.features}`);
}
