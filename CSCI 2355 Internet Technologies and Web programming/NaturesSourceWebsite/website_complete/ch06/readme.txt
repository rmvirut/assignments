ch06/readme.txt

Study Order for Files in This Directory
These are the files from Chapter 6.
---------------------------------------

========================= NOTE ============================
Even though all HTML files in this directory should validate
as HTML 5 and CSS 3, you should note that as of this writing
you will still get an "empty element" warning if an element
(such as the h3 element in buy3.html or buy4.html) contains 
only an empty script element with the path to an external
JavaScript file in its src attribute. And if you validate
TestFormControls.html, you will receive warnings about form
controls that may not be available in your browser.
========================= NOTE ============================

0. default.css
The CSS file used for all files in this directory.

1. estore.html
To provide an "ordinary" HTML file to compare and
contrast with the following three examples.

2. estoreEmbedded.html
To illustrate a script element "embedded" within
the body element of a web page and containing some
JavaScript code.

3. estoreExternal.html and estoreExternal.js
To illustrate a script element located within the
body element of a web page, but instead of containing
JavaScript code the element has a src attribute whose
value is an external file containing JavaScript code.

4. estorePopup.html and estorePopup.js
To illustrate another external JavaScript file containing
the code for a popup message window.

5. bmiForm.html, together with three external JavaScript files
   The bmiForm.html file contains a version of the BMI form
   set up for input validation and actual calculation of
   the BMI value.
   - scripts/bmiFormProcess.js
     External JavaScript file containing the "driver" code
     for dealing with the BMI form.
   - scripts/bmiFormValidate.js
     External JavaScript file containing code for validating
     BMI form elements.
   - scripts/bmiCalculate.js
     External JavaScript file containing code for performing
     the BMI calculation once all input has been validated.

6. feedbackForm.html and scripts/feedbackFormValidate.js
   To illustrate a simple feedback form, together with an
   external JavaScript file containing code for validating
   some of the form elements.

7. TestHTML5FormControls.html and modernizr_inputtypes.js,
   though this js file is "minimized" JavaScript and
   hence is basically unreadable, even though it's text.
   This example is designed to show you whether certain
   new form controls only available since HTML 5 are 
   available in your browser of choice and the version
   of that browser you happen to be using. When you open
   the file in your browser there will be a message telling
   you, for each form control shown, whether it works or
   not in your browser.
