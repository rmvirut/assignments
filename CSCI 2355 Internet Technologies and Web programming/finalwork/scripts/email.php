<?php
$toBusiness = "csc35502@mail.cs.smu.ca";

//message the client to confirm
$subjectToClient = "Diji Domain Feedback Received";
$messageToClient = "This is to inform you that you feedback message has been received by Diji Domain. Thank you.";
$toClient = $_POST['email'];
$headerToClient = "From: $toBusiness";

//message the feedback to the business

$subjectToBusiness = "Customer Feedback: " . $_POST['subject'];
$messageToBusiness = "Client name: " . $_POST['salute'] . " " . $_POST['fname'] . " " . $_POST['lname'];
$messageToBusiness .= "\nProducts: " . $_POST['products'] . "\nOverall Rating: " . $_POST['rating'] . "\nComment: " . $_POST['message'];
$headerToBusiness = "From: " . $_POST['email'];

if (mail($toBusiness, $subjectToBusiness, $messageToBusiness, $headerToBusiness)) {
//  email client if successful
  mail($toClient, $subjectToClient, $messageToClient, $headerToClient);
  echo "<p>Feedback succesfully submitted. A confirmation has been emailed to you"
    . "Below is a copy of your feedback message and details</p>";
} else {
  print "<p>Feedback failed to send. Click 'Back' in your browser to return to the form</p>";
}

//append to the log file
$filename = "data/feedback.txt";
$newEntry = "\n-------------------------------------------------------" .
  "\nDate received:" . date("F d, Y h:i:s A") .
  "\nFrom: " . $_POST['salute'] . " " . $_POST['fname'] . " " . $_POST['lname'] .
  "\nE-mail address: $toClient" .
  "\nPhone number: " . $_POST['phone'] .
  "\nSubject: " . $_POST['subject'] .
  "\nMessage: " . $_POST['message'];

$file = @fopen($filename, 'w+') or die("Couldn't open file");
@fwrite($file, $newEntry) or die("Couldn't write to file");
fclose($file);