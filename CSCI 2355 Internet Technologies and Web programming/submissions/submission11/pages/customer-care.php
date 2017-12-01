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
      <h1 class="page-title">Customer Care</h1>
      <div class="form-container">
        <form id="feedback-form" onsubmit="validateForm()" action="./scripts/email.php" method="post">
          <h3>Product/service Feeback</h3>
          <div class="form-field">
            <label>Salutation: </label>
            <select name="salute" id="salute">
              <option>&nbsp;</option>
              <option value="Mrs">Mrs.</option>
              <option value="Ms">Ms.</option>
              <option value="Mr">Mr.</option>
            </select>
          </div>
          <div class="form-field">
            <label for="fname">First Name:</label>
            <input name="fname" id="fname" type="text"
                   placeholder="First name..." pattern="^[a-zA-Z-\s]+"
                   oninvalid="this.setCustomValidity('Please enter a valid name')"
                   required/>
          </div>
          <div class="form-field">
            <label for="lname">Last Name:</label>
            <input name="lname" id="lname" type="text" placeholder="Last name..."
                   pattern="^[a-zA-Z-\s]+"
                   oninvalid="this.setCustomValidity('Please enter a valid name')"
                   required/>
          </div>
          <div class="form-field">
            <label for="userphone">Phone:</label>
            <input type="tel" name="phone" id="userphone"
                   placeholder="###-###-####"
                   pattern="^[+]?[\s-]?[\d]{0,3}[\s-]?[\d]{3}[\s-]?[\d]{3}[\s-]?[\d]{4}"/>
          </div>
          <div class="form-field">
            <label for="useremail">Email:</label>
            <input name="email" type="email" id="useremail"
                   placeholder="Email address..." required/>
          </div>
          <div class="form-field">
            <label for="subject">Subject:</label>
            <input name="subject" id="subject" placeholder="Feedback subject">
          </div>
          <div class="form-field">
            <label for="products">Products & Services:</label>
            <textarea name="products" id="products"
                      onclick="clearArea('products')">What product(s) are you commenting on?</textarea>
          </div>
          <h5>Message</h5>
          <textarea name="message" id="msg" rows="15" cols="50"></textarea>
          <div class="form-field">
            <label for="rating">Overall Rating</label>
            <input name="rating" type="radio" value="1"/>
            <input name="rating" type="radio" value="2"/>
            <input name="rating" type="radio" value="3"/>
            <input name="rating" type="radio" value="4"/>
            <input name="rating" type="radio" value="5"/>
          </div>
          <br>
          <div style="width: 100%;text-align: center;">
            <input type="checkbox" name="reply" id="reply"
                   style="width: auto;"/>
            <label for="reply" style="width: auto;">Please click here if you
              wish to receive a reply</label>
          </div>
          <div class="form-field">
            <input type="submit" name="Submit Form" class="submit btn"/>
            <input type="reset" name="Reset Fields" class="reset btn"/>
          </div>
        </form>
      </div>
    </div>
  </article>
</main>
<?php
include("../common/footer.php")
?>
<script src="./scripts/feedbackForm.js"></script>
</body>

</html>
