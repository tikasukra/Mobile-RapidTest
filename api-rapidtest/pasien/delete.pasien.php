<?php 

include("../config.php");

	$id = $_POST['id'];

	$sql = "DELETE FROM tb_pasien WHERE id = '$id' ";
	$query = mysqli_query($db, $sql);

	//apakah query update berhasil?
	if ($query) {
		
	} else {
		// kalau gagal tampilkan pesan
		die("Gagal menyimpan perubahan...");
	}
	
 ?>