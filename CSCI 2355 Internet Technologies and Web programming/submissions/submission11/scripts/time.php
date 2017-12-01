<?php

//set time zone
$changeZone = date_default_timezone_set('America/Halifax');

//format for "Its [day], [month] [dayOfMonth] Our time is [hour]:[minute] [meridian]"
$welcome = "Welcome!<br>";
$format = "\I\\t\'\s l, F jS\<\b\\r\>\O\u\\r \\t\i\m\\e \i\s g:i a\<\b\\r\>\I\\n e";

$x = date($format);

if ($changeZone) {
  echo $welcome . $x;//return the results
} else {
  echo "Error. Timezone seting failed";
}
