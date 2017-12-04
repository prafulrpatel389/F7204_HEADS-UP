<?php
  require "connect.php";
  $user_username = $_POST["user_username"];
  $user_name =$_POST["user_name"];
  $user_pass = $_POST["user_pass"];
  $user_email =$_POST["user_email"];
  $user_zip =$_POST["user_zip"];
  $user_score =$_POST["user_score"];

  $mysql_qry = "insert into user_profiles (username, name, password, email, zipcode, score) values ('$user_username','$user_name','$user_pass', '$user_email', '$user_zip', 'user_score')";
  $contUsername = "select * from user_profiles where username like '$user_username'";
  $contEmail = "select * from user_profiles where email like '$user_email'";



  $resultName = mysqli_query($con, $contUsername);
  $reseltEmail = mysqli_query($con, $contEmail);

  if(($con->query($mysql_qry)) === TRUE) {

    echo "Register Successful";

  } else if (mysqli_num_rows($resultName) > 0){

    echo "Username already exists";

  } else if (mysqli_num_rows($reseltEmail) > 0){

    echo "Email already exists";
  }
    else {
    echo "Register Failed"."</b>";
  }
  $con->close();

?>
