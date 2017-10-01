<?php
  // Connect with MYSQL
  require "connect.php";
  // Define Variables
  $username = $_POST["username"];
  $user_name =  $_POST["user_name"];
  $user_zip = $_POST["user_zip"];
  $user_email = $_POST["user_email"];
  $editprofile = 0;


  $sqlN = "UPDATE user_profiles SET name = '$user_name' WHERE username = '$username' ";
  $sqlE = "UPDATE user_profiles SET email = '$user_email' WHERE username = '$username' ";
  $sqlZ = "UPDATE user_profiles SET zipcode = '$user_zip' WHERE username = '$username' ";

  if (!empty($user_name)) {
    $con->query($sqlN);
    $editprofile = 1;
  }
  if (!empty($user_email)) {
    $con->query($sqlE);
    $editprofile = 1;
  }
  if (!empty($user_zip)) {
    $con->query($sqlZ);
    $editprofile = 1;
  }

  if ($editprofile == 1) {
    echo "Profile Editing Successful";
  }


  $con ->close();

?>
