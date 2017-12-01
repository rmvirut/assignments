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
      <h1 class="page-title">Diji Domain Merchandise Store</h1>
      <p>
        Welcome to the online store where you can purchase from among a diverse
        selection of Diji Domain merchandise. Shoe off to your friends, families
        and competitors that you're working with the best.
      </p>
    </div>
    <div id="estore">
      <ol>
        <?php
        include("../../../htpasswd/database.inc");
        $categoryLink = './pages/category.php?category=';

        // Create connection
        $db = mysqli_connect($dbServer, $dbUsername, $dbPassword, $dbName);

        // Check connection
        if ($db->connect_error || $db == null) {
          die("Connection failed: " . $db->connect_error);
        } else {
          //get products and print the list
          $query = "SELECT * FROM `my_categories`";
          $result = mysqli_query($db, $query);

          while ($row = $result->fetch_assoc()) {
            $href = $categoryLink . $row['category_name'];
            print "<li><a href='" . $href . "'>" . $row['category_name'] . "</a></li>";
          }
          mysqli_free_result($result);
        }
        ?>
      </ol>
    </div>
  </article>
</main>
<?php
include("../common/footer.php")
?>
</body>

</html>
