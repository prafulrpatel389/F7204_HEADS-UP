<?php
  require "connect.php";
  $user_name = $_POST["user_name"];
  $user_pass = $_POST["user_pass"];
  $mysql_qry = "select * from user_profiles where username like '$user_name' and password like '$user_pass'";

  $result = mysqli_query($con, $mysql_qry);

  if(mysqli_num_rows($result) > 0) {
    echo "Login Successful";
  } else {
    echo "Invalid username or password!";
  }

?>
