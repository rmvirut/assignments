ch04/nature4_readme.txt

The nature3 subdirectory of this chapter contains
a version of our Nature's Source website that is
almost an exact copy of nature3, except for one
major change: the replacement of the image on the
home page with a video to illustrate the new video
element in HTML 5.

================ RESPONSIVE DESIGN ================
The "responsive design" feature illustrated in the
nature3 example has been retained here. Reduce the
display to "tablet size" to see the same effect.
================ RESPONSIVE DESIGN ================

The files in this version are the same as in nature3,
except for the following changes:

-- index.html has been modified to reference the video
   rather than the image
-- images now contains only the logo image, since no
   still images are being used on the home page
-- videos is a new subdirectory containing the following
   two video files:
   -- outdoor.mp4
   -- outdoor.ogg
-- common/document_head.html has, of course, a new value
   for the base tag
-- css/desktop.css has two new styles at the end for the
   video in the desktop view
-- css/tablet.css also has two new styles at the end for
   video in tablet view
