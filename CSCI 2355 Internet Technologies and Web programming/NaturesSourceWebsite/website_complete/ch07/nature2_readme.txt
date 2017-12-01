ch07/nature2_readme.txt

The nature2 subdirectory of this chapter extends the
version of our website from the nature1 subdirectory
of this same chapter by activating all of the links
on the home page, whether a main menu link or a
dropdown menu link.

Also, in this version we incorporate into our website
the BMI and feedback forms introduced in the previous
two chapters. Both forms make use of an alternate way
of notifying the user that e-mail is not yet active,
and the feedback form also makes use of HTML 5 data
input validation that does not require JavaScript.

Full list of nature2 subdirectory contents:
-- index.html is our home page, located at the root level of the
   subdirectory
-- files in the images subdirectory:
   -- naturelogo.gif (the Nature's Source logo)
   -- outdoor1.jpg to outdoor6.jpg (outdoor exercise scenes to be
      displayed in rotation on our home page on weekend days-
      Friday, Saturday and Sunday)
   -- indoor1.jpg to indoor6.jpg (indoor exercise scenes to be
      displayed in rotation on our home page on weekdays-Monday
      to Thursday)
-- files in the common subdirectory:
   -- document_head.html (DOCTYPE, opening html tag, and head element)
   -- footer_content.html (copyright notice, but no two-element menu)
   -- logo.html (logo image)
   -- menus.html (our new dropdown menus)
-- files in the css subdirectory:
   -- desktop.css (contains the CSS styles for the desktop view of our
      website pages)
   -- tablet.css (contains the CSS styles for the tablet view of our
      website pages)
-- static files in the pages subdirectory:
   -- about.html
   -- catalog.html
   -- employment.html
   -- estore.html
   -- expert.html
   -- featured.html
   -- links.html
   -- locations.html
   -- news.html
   -- services.html
   -- sitemap.html
   -- suppliers.html
   -- tools.html
   -- vision.html
-- dynamic files (containing forms to be filled out) in the pages
   subdirectory:
   -- bmiForm.html
   -- feedbackForm.html
-- files in the scripts subdirectory:
   -- menus.js to handle the dropdown menus on our home page
      (and all other pages when we have other pages in nature2)
   -- rotate.js to handle the image rotation on our home page
   -- bmiFormProcess.js to act as the "driver" for handling the BMI form
   -- bmiFormValidate.js to validate the data entries for the BMI form
   -- bmiCalculate.js to perform the BMI calculation
   -- feedbackFormValidate.js to validate data entry into the feedback form

