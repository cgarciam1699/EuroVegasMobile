<?php 

	#con=mysqli_connect("ip_servidor","nombre_usuario","contraseña","base_datos")	

	$con=mysqli_connect("192.168.1.241","cgarciam99","1305701606","eurovegasmobile");
	
	$respuesta1 = $_POST["respuesta1"];
	$respuesta2 = $_POST["respuesta2"];
	$respuesta3 = $_POST["respuesta3"];
	$respuesta4 = $_POST["respuesta4"];
	$correo =$_POST["correo"];

	$sql = "INSERT INTO encuestas(respuesta1,respuesta2,respuesta3,respuesta4,correo) VALUES ('$respuesta1','$respuesta2','$respuesta3','$respuesta4','$correo')";

	$result = mysqli_query( $con,$sql );
	
	if($result) {
		echo "Encuesta registrada";
	}
	else {
		echo "Error al registrar la encuesta";
	}

?>