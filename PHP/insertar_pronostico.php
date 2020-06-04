<?php 

	#con=mysqli_connect("ip_servidor","nombre_usuario","contraseña","base_datos")	

	$con=mysqli_connect("192.168.1.241","cgarciam99","1305701606","eurovegasmobile");
	
	$ganador_premier = $_POST["ganador_premier"];
	$ganador_liga_santander = $_POST["ganador_liga_santander"];
	$ganador_bundesliga = $_POST["ganador_bundesliga"];
	$ganador_ligue_one = $_POST["ganador_ligue_one"];
	$ganador_serieA = $_POST["ganador_serieA"];
	$correo =$_POST["correo"];

	$sql = "INSERT INTO pronosticos(ganador_premier,ganador_liga_santander,ganador_bundesliga,ganador_ligue_one,ganador_serieA,correo) 
	VALUES ('$ganador_premier','$ganador_liga_santander','$ganador_bundesliga','$ganador_ligue_one','$ganador_serieA','$correo')";

	$result = mysqli_query( $con,$sql );
	
	if($result) {
		echo "Pronostrico registrado";
	}
	else {
		echo "Error al registrar el pronostico";
	}

?>