var emailReg = /^[\w.-]+@[\w.-]+\.[\w]+$/g;
var phoneReg = /^[+]?[\s-]?[\d]{0,3}[\s-]?[\d]{3}[\s-]?[\d]{3}[\s-]?[\d]{4}$/g;

function validateForm() {
  var valid = true;

  // get form fields
  var salute = getElementById("salute").value;
  var fname = getElementById("fname").value;
  var lname = getElementById("lname").value;
  var phone = getElementById("userphone").value;
  var email = getElementById("useremail").value;
  var subject = getElementById("subject").value;
  var msg = getElementById("msg").value;

  // validate email and phone numbers
  if (!validatePhoneNumber(phone)) {
    alert(`The number ${phone} you entered is invalid`);
    valid = false;
  }

  if (!validateEmail(email)) {
    alert(
      `The email address ${email} is invalid.\nPlease enter a valid address`
    );
    valid = false;
  }
  
  if(msg == ""){
    alert("You did not enter a message in to be sent. The form will be reset")
    valid = false;
  }

  alert(`${salute} ${fname} ${lname} ${phone} ${email}`);

  if (valid) {
    if (getElementById("reply").checked) {
      notifyUser(true);
    } else {
      alert(`Thank you ${salute} ${lname} for contacting us`);
    }
  }
}

function getElementById(id) {
  return document.getElementById(id);
}

function notifyUser() {
  alert(
    `Thanks you for contacting us. A representative will reply to your message shortly`
  );
}

function validateEmail(emailAddress) {
  return emailReg.test(emailAddress);
}

function validatePhoneNumber(telephone) {
  return phoneReg.test(telephone);
}