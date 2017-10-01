<?php
  // Connect with MYSQL
  require "connect.php";
  // Define Variables
  $username = $_POST["username"];
  $name =  $_POST["user_name"];
  $zip = $_POST["user_zip"];
  $email = $_POST["user_email"];


  $sqlN = "UPDATE user_profiles SET name = '$name' WHERE username = '$username' ";
  $sqlE = "UPDATE user_profiles SET email = '$email' WHERE username = '$username' ";
  $sqlZ = "UPDATE user_profiles SET zipcode = '$zip' WHERE username = '$username' ";

  if (!empty($name)) {
    $con->query($sqlN);
    echo "name";
  }
  if (!empty($email)) {
    $con->query($sqlE);
    echo "email";
  }
  if (!empty($zip)) {
    $con->query($sqlZ);
    echo "zip";
  }


  $con ->close();

?>
