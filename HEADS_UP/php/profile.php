<?php
  // Connect with MYSQL
  require "connect.php";
  // Define Variables
  $username = $_POST["username"];
  $user_name =  $_POST["user_name"];
  $user_zip = $_POST["user_zip"];
  $user_email = $_POST["user_email"];


  $sqlN = "UPDATE user_profiles SET name = '$user_name' WHERE username = '$username' ";
  $sqlE = "UPDATE user_profiles SET email = '$user_email' WHERE username = '$username' ";
  $sqlZ = "UPDATE user_profiles SET zipcode = '$user_zip' WHERE username = '$username' ";

  if (!empty($user_name)) {
    $con->query($sqlN);
    echo "Profile Editing Successful";
  }
  if (!empty($user_email)) {
    $con->query($sqlE);
    echo "Profile Editing Successful";
  }
  if (!empty($user_zip)) {
    $con->query($sqlZ);
    echo "Profile Editing Successful";
  }


  $con ->close();

?>
