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
      <h1 class="page-title">Web Request Form</h1>
      <p>
        To request a service from Diji Domain for you home or company, simply
        complete the form below and submit it. An agent will get in touch with
        you soon.
      </p>
      <p class="block">
        <img src="./images/alert.png" style="width: 25px;"/>Only our web
        development service is currently available to clients.
      </p>
      <script src="./scripts/orderForm.js"></script>
      <div class="form-container">
        <form id='service-request-form' onsubmit="getServiceOrder()">
          <fieldset id="contact_info">
            <legend>Contact Information</legend>

            <div class="form-field">
              <label for="fname">First Name:</label>
              <input name="fname" id="fname" type="text"
                     placeholder="First name..." pattern="^[a-zA-Z-\s]+"
                     oninvalid="this.setCustomValidity('Please enter a valid name')"
                     required/>
              <label for="lname">Last Name:</label>
              <input name="lname" id="lname" type="text"
                     placeholder="Last name...." pattern="^[a-zA-Z-\s]+"
                     oninvalid="this.setCustomValidity('Please enter a valid name')"
                     required/>
            </div>

            <div class="form-field">
              <label for="phone">Phone:</label>
              <input type="tel" name="phone" id="phone"
                     placeholder="###-###-####"
                     pattern="^[+]?[\s-]?[\d]{0,3}[\s-]?[\d]{3}[\s-]?[\d]{3}[\s-]?[\d]{4}"/>
              <label for="email">Email:</label>
              <input name="email" type="email" id="email"
                     placeholder="example@example.com" required/>
            </div>

            <div class="form-field">
              <label for="com-name">Company Name:</label>
              <input name="com-name" type="text" id="com-name"
                     placeholder="Name of your business"
                     required/>
            </div>

            <div class="form-field">
              <label for="industry">Industry:</label>
              <select name="industry" id="industry">
                <option>&nbsp;</option>
                <option>Accommodation &amp; Food Services</option>
                <option>Agriculture</option>
                <option>Construction &amp; Real Estate</option>
                <option>Consultation &amp; Professional
                  Services
                </option>
                <option>Culture &amp; Leisure</option>
                <option>Education</option>
                <option>Energy</option>
                <option>Beauty and Health Care</option>
                <option>Information &amp; Communications Technology
                </option>
                <option>Manufacturing</option>
                <option>Natural Resources</option>
                <option>Retail &amp; Wholesale</option>
                <option>Science and Technology</option>
                <option>Storage &amp; Transportation</option>
                <option>Travel and Tourism</option>
              </select>
            </div>

            <div class="form-field">
              <label for="address">Street Address:</label>
              <input type="text" id="address" name="address"
                     placeholder="Street address..."/>
            </div>

            <div class="form-field">
              <label for="com-website">Current Website:</label>
              <input type="text" id="com-website" name="com-website"
                     placeholder="optional"/>
            </div>
            <div class="form-field">
              <input type="checkbox" name="taxstatus" id="taxstatus"/>
              <label for="taxstatus">I qualify for tax exemption (current rate =
                15%)</label>
            </div>
          </fieldset>

          <fieldset>
            <legend>Web Development Packages</legend>
            <div class="form-field">
              <div id="packs">
                <ul>
                  <li>
                    <input name="package" class="webmenu" value="simple"
                           type="radio"
                           id="simple"/>
                    <label for="simple">Standard 5-page site - $300.00</label>
                    <p>
                      A simple 5-page website comprising a Homepage, About Us,
                      Contact Us, Privacy Policy and one last page containing
                      any content of your choosing. We recommend this for
                      companies with less web-centered business and only looking
                      to create some web presence.
                    </p>
                  </li>
                  <li><input name="package" class="webmenu" value="ecom"
                             type="radio"
                             id="ecom"/>
                    <label for="ecom">E-Commerce Store - $800.00</label>
                    <p>
                      Are you looking to build an online store? This package
                      comes with all
                      standard web pages and including user registration and
                      login to help your
                      clients/customers get a personal shopping experience.
                    </p>
                  </li>
                  <li><input name="package" class="webmenu" value="brand"
                             type="radio"
                             id="brand"/>
                    <label for="brand">Brand Landing Page - $250.00</label>
                    <p>
                      Landing pages are a great way to advertise a product
                      you're about to release
                      onto the market. It's a great way to buidl anticipation
                      from your clients
                      and involve them in the development process from start to
                      finish. Capture
                      their attention and emails so you can stay in touch; keep
                      them ready to buy
                      till your ready to sell.
                    </p>
                  </li>
                  <li><input name="package" class="webmenu" value="corp"
                             type="radio"
                             id="corp"/>
                    <label for="corp">Corporate Website - $1500.00</label>
                    <p>
                      Every corporation needs to not only have a web presence
                      but keep it's
                      customers, employees, investors and all relevant stake
                      holders in the loop
                      on what they're about.
                    </p>
                  </li>
                </ul>
              </div>

              <div id="add-services">
                <h4>Additional Features</h4>
                <ul>
                  <li>
                    <input name="deploy" type="checkbox"
                           class="added-features"/>
                    <label for="deploy">Hosting &amp; deployment -
                      $50.00</label>
                  </li>
                  <li>
                    <input name="membership" type="checkbox"
                           class="added-features"/>
                    <label for="membership">User Registration/Forum -
                      $120.00</label>
                  </li>
                  <li>
                    <input name="mailing" type="checkbox"
                           class="added-features"/>
                    <label for="mailing">Custom email address(es) -
                      $29.99</label>
                  </li>
                  <li>
                    <input name="analytics" type="checkbox"
                           class="added-features"/>
                    <label for="analytic">Web Analytics Integration -
                      15.99</label>
                  </li>
                  <li>
                    <input name="seo" type="checkbox"
                           class="added-features"/>
                    <label for="seo">SEO and Publishing - $21.00</label>
                  </li>
                  <li>
                    <input name="payment" type="checkbox"
                           class="added-features"/>
                    <label for="payment">Payment Integration - $110.00</label>
                  </li>
                  <li>
                    <input name="blog" type="checkbox"
                           class="added-features"/>
                    <label for="blog">Blogging - $49.99</label>
                  </li>
                </ul>
              </div>
            </div>
            <br>
            <h4 style="text-align: center;"><label for="msg">Request other
                features</label></h4>
            <div>
              <textarea name="message" id="msg" rows="15" cols=100></textarea>
            </div>
          </fieldset>
          <div>
            <input type="submit" name="Submit Form" class="submit btn"/>
            <input type="reset" name="Reset Fields" class="reset btn"/>
          </div>
        </form>
      </div>
    </div>
    </div>
  </article>
</main>
<?php
include("../common/footer.php")
?>

</body>

</html>
