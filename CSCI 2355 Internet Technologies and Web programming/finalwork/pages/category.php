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
          style="text-transform: capitalize">
        Category: <?php echo $_GET['category'] ?></h1>
    </div>
    <div id="category">
      <table>
        <tbody>
        <tr>
          <th>Image</th>
          <th>Product Name</th>
          <th>Price</th>
          <th># Stock</th>
          <th>Purchase?</th>
        </tr>
        <?php
        include("../../../htpasswd/database.inc");

        // Create connection
        $db = mysqli_connect($dbServer, $dbUsername, $dbPassword, $dbName);
        // Check connection
        if ($db->connect_error || $db == null) {
          die("Connection failed: " . $db->connect_error);
        } else {

          $category = $_GET['category'];
          $query = "SELECT * FROM `my_products` WHERE category = '" . $category . "'";
          $result = mysqli_query($db, $query);

          $productPage = "./pages/product-page.php?category=" . $category . "&product=";

          while ($row = $result->fetch_assoc()) {
            $href = $productPage . $row['product_name'];

            print "<tr>" .
              "<td><img src='" . $row['image'] . "' alt='" . $row['product_name'] . "'/></td>" .
              "<td>" . $row['product_name'] . "</td>" .
              "<td>\$" . $row['price'] . "</td>" .
              "<td>" . $row['stock'] . "</td>" .
              "<td><a class='buy-button' href='" . $href . "'>Buy Item" . "</a><br>
              <a class='buy-button' href='./pages/merch-store.php'>Return to list" . "</a></td>" .
              "</tr>";
          }

        }

        mysqli_close($db);
        ?>
        </tbody>
      </table>
    </div>
  </article>
  <style>

    table {
      width: 100%;
      margin: auto 0px;
    }

    table, td, th, tr {
      border: solid #1e1e1e 1px;
    }

    td, th {
      padding: 0.5em;
      text-align: center;
    }

    img {
      width: 150px;
      height: 150px;
    }

    .buy-button {
      display: block;
      text-decoration: none;
      background-color: #3498db;
      width: 100%;
      font-weight: 300;
      padding: 10px 0px;
      text-align: center;
      color: #fff;
    }
  </style>
</main>
<?php
include("../common/footer.php")
?>
</body>

</html>
