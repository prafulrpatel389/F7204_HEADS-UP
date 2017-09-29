<?php
  // Connect with MYSQL
  require "connect.php";
  // Define Variables
  $user_name = $_Post["user_name"];
  $user_zip = $_POST["user_zip"];
  // Select Database
  mysqli_select_db($con, 'id2847948_heads_up');

  //Select query
  $sql = "SELECT zipcode *FROM user_profiles WHERE user_name = '$user_name'";

  $result = mysqli_query($con, $sql);
  $row = mysqli_fetch_row($result);

  $sql = "UPDATE user_profiles SET zipcode = '$user_zip' ";
  $result = mysqli_query($dbc, $sql);
  echo "Zipcode successfully changed!";
  $con ->close();

?>
