<?php

  include "connect.php";

  $username = $_POST["username"];
  $oldPass = $_POST["oldPass"];
  $newPass =  $_POST["newPass"];

  $checkPass = "select * from user_profiles where username like '$username' and password like '$oldPass'";

  $result = mysqli_query($con, $checkPass);

  $sql = "UPDATE user_profiles SET password = '$newPass' WHERE username = '$username' ";

  if(mysqli_num_rows($result) > 0) {
    $con->query($sql);
    echo "Password change successful";
  } else {
    echo "Current password is not matched";
  }
  $con ->close();

?>
