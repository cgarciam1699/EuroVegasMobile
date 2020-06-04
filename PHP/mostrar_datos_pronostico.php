<?php
$con = mysqli_connect("192.168.1.241","cgarciam99","1305701606","eurovegasmobile");
$correo = $_GET['correo'];

$sql = "SELECT ganador_premier,ganador_liga_santander,ganador_bundesliga,ganador_ligue_one,ganador_serieA
		FROM pronosticos WHERE correo like '$correo' ORDER BY id";  

$res = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($res)){
	array_push($result,array(
    	'ganador_premier'=>$row[0],
    	'ganador_liga_santander'=>$row[1],
    	'ganador_bundesliga'=>$row[2],
    	'ganador_ligue_one'=>$row[3],
    	'ganador_serieA'=>$row[4],
	));
}
 
echo json_encode(array("result"=>$result));
 
mysqli_close($con);

?>