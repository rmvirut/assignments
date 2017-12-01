//feedbackFormValidate.js
//Now, since the actual validation has been shifted to the
//pattern attribute of the input elements in the HTML file,
//all this script has to do is report that all went well and,
//if required, mention that e-mail replies are not yet available.

function feedbackFormValidate()
{
    textToDisplay = "<p>All the information looks good.<br>Thank you!</p>"
    var feedbackDisplay = window.open("", "",
        "width=250, height=100, top=300, left=300");
    feedbackDisplay.document.write(textToDisplay);
}

function handleFeedbackEmailRequest()
{
    var contactFormObj = document.getElementById("contactForm");
    if (contactFormObj.reply.checked)
    {
        alert("Sorry, but the e-mail reply feature is currently not "
              + "supported.\nBut we do validate your email address "
              + "(syntax only) in any case.");
    }
    //User has clicked the checkbox if the above message has been
    //displayed, so uncheck the checkbox
    contactFormObj.reply.checked = false;
}
