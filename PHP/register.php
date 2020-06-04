<?php 

	#con=mysqli_connect("ip_servidor","nombre_usuario","contraseña","base_datos")	

	$con=mysqli_connect("192.168.1.241","cgarciam99","1305701606","eurovegasmobile");
	
	$nombre = $_POST["nombre"];
	$correo = $_POST["correo"];
	$contrasena =$_POST["contrasena"];
	$edad =$_POST["edad"];
	$telefono =$_POST["telefono"];

	$sql = "INSERT INTO usuarios(nombre,correo,contrasena,edad,telefono) VALUES ('$nombre','$correo','$contrasena','$edad','$telefono')";

	$result = mysqli_query( $con,$sql );

	if($result) {
		echo "Registro completado";
	}
	else {
		echo "Error, cuenta existente";
	}

?>