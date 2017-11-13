<?php
  require "connect.php";


  $username = $_POST["username"];
  $email = $_POST["email"];
  $name = $_POST["name"];
  $newPass = $_POST["newPass"];
  $mysql_qry = "select * from user_profiles where username like '$username' and email like '$email' and name like '$name'";

  $result = mysqli_query($con, $mysql_qry);


  $sql = "UPDATE user_profiles SET password = '$newPass' WHERE username = '$username' ";


  if(mysqli_num_rows($result) > 0) {
    $con->query($sql);
    echo "Password Reset Successful";
  } else {
    echo "Invalid Information ";
  }

?>
