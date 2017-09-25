<?php
  require_once "connect.php";

  if (!$con) {
    echo "DB connection failed";
  } else {
    echo "DB connection successfully";
  }


 ?>
