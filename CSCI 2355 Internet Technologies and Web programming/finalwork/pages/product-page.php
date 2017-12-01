<?php
include("../common/document_head.php")
?>

<body>
<?php
include("../common/header.php")
?>
<main>
  <article class="article-w-sidebar">
    <div id="text">
      <h1 class="page-title"
          style="text-transform: capitalize"><?php echo $_GET['product'] ?></h1>
    </div>
    <div id="product">

      <?php
      include("../../../htpasswd/database.inc");

      // Create connection
      $db = mysqli_connect($dbServer, $dbUsername, $dbPassword, $dbName);

      // Check connection
      if ($db->connect_error || $db == null) {
        die("Connection failed: " . $db->connect_error);
      } else {

        $product = $_GET['product'];
        $query = "SELECT * FROM my_products WHERE product_name ='" . $product . "'";
        $result = mysqli_query($db, $query);

        while ($row = $result->fetch_assoc()) {
          print
            "<h3>Item description</h3>" .
            "<p>" . $row['description'] . "</p>";
        }

      }

      mysqli_close($db);
      ?>
      <div id="buyOrNot">
        <a href="./pages/customer-care.php">
          Buy <?php echo $_GET['product'] ?>
        </a>
        <br>
        <?php
        echo "<a href='./pages/category.php?category=" . $_GET['category'] . "'>
          Return to Category</a>"
        ?>
      </div>
    </div>
  </article>
</main>
<?php
include("../common/footer.php")
?>
</body>

</html>
