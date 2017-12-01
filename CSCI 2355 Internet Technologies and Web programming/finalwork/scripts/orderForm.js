function getServiceOrder() {
  var sum;
  var valid;

  // get full name, phone number and other personal information
  var fname = getElementById("fname").value;
  var lname = getElementById("lname").value;
  var phone = getElementById("phone").value;
  var email = getElementById("email").value;
  var company = getElementById("com-name").value;
  var industry = getElementById("industry").value;
  var address = getElementById("address").value;
  var website = getElementById("com-website").value;
  var tax = getElementById('taxstatus').checked;

  // validate email and phone numbers
  if (!validateEmail(email)) {
    alert(`The email address ${email} is invalid.\nPlease enter a valid address`);
    valid = false;
  }

  var userInfo = `Name: ${fname} ${lname}
  Phone: ${phone}
  Email Address: ${email}
  Company: ${company}
  Industry: ${industry}
  Address: ${address}
  Website: ${website}
  Tax exempt?: ${tax}`;


  //get the service requested and info
  var service = getWebServiceChoice();
  var features = getAddedFeatures();

  //list of added features
  var featureList = "";
  for (var i = 0; i < features.length; i++) {
    featureList = +`\n${WEB_SERVICE_PACKAGES['features'][features[i]]['name']}`;
  }

  var orderInfo = `Package: ${WEB_SERVICE_PACKAGES['package'][service]['name']} - $${WEB_SERVICE_PACKAGES['package'][service]['price']}`;


  //calucate cost of service
  alert(sum);
  sum += WEB_SERVICE_PACKAGES['package'][service]['price'];
  for (var i = 0; i < features.length; i++) {
    sum += WEB_SERVICE_PACKAGES['features'][features[i]]['price'];
    alert(WEB_SERVICE_PACKAGES['features'][features[i]]['price'])
  }
  alert('were suppose to have everything added');

  //on submit
  alert(`${userInfo}
  ${orderInfo}
  ${featureList}
  Total cost ${tax ? (sum * 1.15) : sum}`);
}

/**
 * The package the user has selected
 */
function getWebServiceChoice() {
  var x = document.getElementsByName("package");
  for (var i = 0; i < x.length; i++) {
    if (x[i].checked) {
      return x[i].value;
    }
  }
}

/**
 *
 * @returns {Array}
 */
function getAddedFeatures() {
  var x = document.getElementsByClassName("added-features");
  var arr = [];

  for (var i = 0; i < x.length; i++) {
    if (x[i].checked) {
      arr.push(x[i].name);
    }
  }
  return arr;
}