<?php
$array1 = array(
    "id" => "1",
    "name" => "Dr.Sarah",
    "type" => "Dokter Umum",
    "experience" => 7,
    "like" => 204,
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg",
    "jadwal" => "Senin      10:30 - 17:00\nSelasa      10:30 - 17:00\nRabu      10:30 - 17:00\nKamis      10:30 - 17:00\nJumat      10:30 - 15:00"
);

$array2 = array(
    "id" => "2",
    "name" => "Dr.Sam",
    "type" => "Sp. Mata",
    "experience" => 5,
    "like" => 300,
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg",
    "jadwal" => "Senin      15:30 - 17:00\nSelasa      15:30 - 17:00\nRabu      15:30 - 17:00\nKamis      15:30 - 17:00\nJumat      15:30 - 17:00"
);

$array3 = array(
    "id" => "3",
    "name" => "Dr.Macy",
    "type" => "Dokter Gigi",
    "experience" => 3,
    "like" => 103,
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg",
    "jadwal" => "Senin      10:30 - 17:00\nSelasa      10:30 - 17:00\nRabu      10:30 - 17:00\nKamis      10:30 - 17:00\nJumat      10:30 - 15:00"
);

$array4 = array(
    "id" => "4",
    "name" => "Dr.Dawson",
    "type" => "Sp. THT",
    "experience" => 4,
    "like" => 400,
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg",
    "jadwal" => "Senin      15:30 - 17:00\nSelasa      15:30 - 17:00\nRabu      15:30 - 17:00\nKamis      15:30 - 17:00\nJumat      15:30 - 17:00"
);

$array5 = array(
    "id" => "5",
    "name" => "Dr.Michael",
    "type" => "Sp. THT",
    "experience" => 5,
    "like" => 200,
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg",
    "jadwal" => "Senin      10:30 - 17:00\nSelasa      10:30 - 17:00\nRabu      10:30 - 17:00\nKamis      10:30 - 17:00\nJumat      10:30 - 15:00"
);

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    if ($id == "1") {
        echo json_encode($array1);
    } else if ($id == "2") {
        echo json_encode($array2);
    } else if ($id == "3") {
        echo json_encode($array3);
    } else if ($id == "4") {
        echo json_encode($array4);
    } else if ($id == "5") {
        echo json_encode($array5);
    }
}
?>