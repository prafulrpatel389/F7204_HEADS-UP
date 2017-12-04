<?php
require "connect.php";

$user_name = "wchen";

$getScore = "SELECT score FROM user_profiles WHERE username = '$user_name'";

$resule = mysqli_query($con, $getScore)-> fetch_assoc();


echo '<p>', $resule , '</p>';
// if (mysqli_num_rows($resule) === 1 ) {
//     echo "111";
// } else {
//     echo "222";
// }

foreach ($resule as $row) {
    echo $row['score'];
}


  
?>