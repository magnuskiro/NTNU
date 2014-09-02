<?php

$dbhost = 'mysql.stud.ntnu.no';
$dbuser = 'mikkela_mike';
$dbpass = 'pfhsl';
$dbname = 'mikkela_highscore';
$dbtbl = 'highscore';

mysql_connect($dbhost, $dbuser, $dbpass) or die ('Error connecting to mysql');

mysql_select_db($dbname) or die ("cannot selct database");

?>
