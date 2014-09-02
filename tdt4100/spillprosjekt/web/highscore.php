<?php
/*
 * Created on Mar 30, 2010
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */

echo "<div align='center'><h1>Highscore for WorkingTitle</h1>";

echo "<h3>Highscore, sorted by time.</h3>";

include("dbconnect.php");
for($level = 7; $level>0; $level --){

echo "Level: ".$level; 

$result = mysql_query("SELECT * FROM $dbtbl WHERE LEVEL='$level' ORDER BY tid ASC");
echo "<table border='1'>
<tr>
<th>Player</th>
<th>Time</th>
<th>Ghosts Used</th>
<th>Score</th>
</tr>";

while($row = mysql_fetch_array($result))
{
	echo "<tr>";
	echo "<td>" . $row['playername'] . "</td>";
	echo "<td>" . $row['tid'] . "</td>";
	echo "<td>" . $row['ghostsUsed'] . "</td>";
	echo "<td>" . $row['score'] . "</td>";
	echo "</tr>";
}
echo "</table>";
echo "<br>";
}
echo "</div>";
?>
