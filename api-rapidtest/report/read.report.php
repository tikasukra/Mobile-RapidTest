<?php

include("../config.php");

$nama_pasien = $_POST['nama_pasien'];

$sql = "SELECT * FROM tb_report WHERE nama_pasien='$nama_pasien' ORDER BY id DESC";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('id' => $row['id'],
    'nama_pasien' => $row['nama_pasien'],
    'nama_rs' => $row['nama_rs'],
    'jadwaltest' => $row['jadwaltest'],
    'status' => $row['status'],
    'keterangan' => $row['keterangan']
));
}
echo json_encode(array("result" => $result));
?>



