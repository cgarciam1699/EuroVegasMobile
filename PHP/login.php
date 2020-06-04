<?php 
		$con=mysqli_connect("192.168.1.241","cgarciam99","1305701606","eurovegasmobile");
	
		$correo = $_POST["correo"];
		$contrasena = $_POST["contrasena"];

		$sql = "SELECT * FROM usuarios WHERE  correo = '$correo' AND contrasena = '$contrasena'";
		$result = mysqli_query($con,$sql);
		
		if($result->num_rows > 0){
			echo "Iniciando sesion";
		}else{
  			 echo "Usuario no encontrado";
}
?>