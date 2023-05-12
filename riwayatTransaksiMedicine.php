<?php
$array1 = array(
    "id" => "1",
    "name" => "Rhino Junior Sirup 60 ml",
    "quantity" => "Per Botol",
    "price" => "Rp50.000",
    "description" => "Lorem ipsum dolor sit amet consectetur adipisicing elit. 
    Odit ducimus at corrupti iste fugit consequatur nesciunt in. Nesciunt, assumenda nobis!",
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg"
);


$array2 = array(
    "id" => "3",
    "name" => "Actifed Plus Cough Supressant",
    "quantity" => "Per Botol",
    "price" => "Rp60.000",
    "description" => "Lorem ipsum dolor, sit amet consectetur adipisicing elit. At illum animi, non nostrum commodi nihil nemo error vel veniam eius consequuntur optio quo inventore, porro mollitia deleniti qui quia. Dolorem!",
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg"
);

$array3 = array(
    "id" => "5",
    "name" => "Sanmol Sirup 60 ml",
    "quantity" => "Per Botol",
    "price" => "Rp.15.000",
    "description" => "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium quaerat delectus, iste quibusdam eaque voluptatibus vel odit dolor dolorum provident?",
    "photoUrl" => "https://randomuser.me/api/portraits/women/2.jpg"
);

echo json_encode(array($array1, $array2, $array3));
?>