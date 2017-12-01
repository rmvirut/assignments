function validateForm() {
  var valid = true;

  // get form fields
  var salute = getElementById("salute").value;
  var fname = getElementById("fname").value;
  var lname = getElementById("lname").value;
  var phone = getElementById("userphone").value;
  var email = getElementById("useremail").value;
  var subject = getElementById("subject").value;
  var products = getElementById("products").value;
  var msg = getElementById("msg").value;
  var rating = radioGroup(document.getElementsByName('rating'));


  // validate email
  if (!validateEmail(email)) {
    alert(`The email address ${email} is invalid.\nPlease enter a valid address`);
    valid = false;
  }

  if (msg == "") {
    alert("You did not enter a message in to be sent. The form will be reset")
    valid = false;
  }

  if (valid) {
    if (getElementById("reply").checked) {
      notifyUser(true);
    } else {
      alert(`Thank you ${salute} ${lname} for contacting us`);
    }
  }
}

function notifyUser() {
  alert(`Thanks you for contacting us. A representative will reply to your message shortly`);
}
