ch04/nature1_readme.txt

The nature1 subdirectory of this chapter contains
a version of our Nature's Source website that is
analogous (from the user's point of view) to the
simple version of our website in the nature1
subdirectory of the previous chapter. The page
contains the same four components (logo, address,
text, and image), but gone is the use of a table
for layout, and we are now using CSS to achieve
essentially the same "look and feel" we had before.

Two interface changes we have made in this version,
with the help of CSS, are these:
- First, we specify a width for our page.
- Second, we right-justify the text of the company address.
Behind the scenes in this example, in the markup, we also
introduce these new HTML 5 "semantic elements":
- header
- main
- article
Previously, to achieve the same effect, we would likely have
had three div elements with these names as values of their id
attributes.

This page should validate as HTML 5 and CSS 3.

Full list of nature1 subdirectory contents:
-- index.html (our home page)
-- images (subdirectory) files:
   -- naturelogo.gif (the Nature's Source logo)
   -- outdoor4.jpg (a business-related image for our home page)
-- css (subdirectory) files:
   -- default.css (our CSS style sheet for the first version of
      our website in this chapter)
