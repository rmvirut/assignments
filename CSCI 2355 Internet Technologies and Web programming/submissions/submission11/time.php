<?php
//format for "Its [day], [month] [dayOfMonth] Our time is [hour]:[minute] [meridian]"
$format = '\I\t\'\s l, F jS \n \O\u\r \t\i\m\e \i\s g:i a';

$x = date($format);

echo $x;//return the results
