/*
 * This file contains globally accessible functions, constants and variables
 */

//globals
var emailReg = /^[\w.-]+@[\w.-]+\.[\w]+$/g;
var phoneReg = /^[+]?[\s-]?[\d]{0,3}[\s-]?[\d]{3}[\s-]?[\d]{3}[\s-]?[\d]{4}$/g;
WEB_SERVICE_PACKAGES = {
  package: {
    simple: {
      name: "Standard 5-page site",
      price: 300.00
    },
    ecom: {
      name: "E-Commerce Store",
      price: 800.00
    },
    brand: {
      name: "Brand Landing Page",
      price: 250.00
    },
    corp: {
      name: "Corporate Website",
      price: 1500.00
    }
  },
  features: {
    deploy: {
      name: "Hosting &amp; deployment",
      price: 50.00
    },
    membership: {
      name: "User Registration/Forum",
      price: 120.00
    },
    mailing: {
      name: "Custom email address(es)",
      price: 29.99
    },
    analytics: {
      name: "Web Analytics Integration",
      price: 15.99
    },
    seo: {
      name: "SEO and Publishing",
      price: 21.00
    },
    payment: {
      name: "Payment Integration",
      price: 110.00
    },
    blog: {
      name: "Blogging",
      price: 49.99
    }
  }
}

/**
 * Returns the reference to a DOM object according to th eid passed to it
 * @param id
 * @returns {Element}
 */
function getElementById(id) {
  return document.getElementById(id);
}

/**
 * Validate email against the pre-defined expression emailReg
 * @param emailAddress
 * @returns {boolean}
 */
function validateEmail(emailAddress) {
  return emailReg.test(emailAddress);
}

/**
 * Validates phone number string against the given expression phoneReg
 * @param telephone Given phone number string
 */
function validatePhoneNumber(telephone) {
  return phoneReg.test(telephone);
}

/**
 * Takes an array of radio buttons and finds and retuns the value of the checked button
 * @param radArray the array of a group of radio buttons
 */
function radioGroup(radArray) {
  for (var i = 0; i < radArray.length; i++) {
    if (radArray[i].checked)
      return radArray[i].value;
  }
}

/**
 * Remove innerHTML content to clear
 * @param x
 */
function clearArea(x) {
  document.getElementById(x).value = "";
  console.log(`Has been cleared.`);
}

/**
 * Hides the HTML element with the give id
 * @param itemID unique id attribute of the html element
 */
function hide(itemID) {
  sm = document.getElementById(itemID);
  sm.style.display = "none";
}