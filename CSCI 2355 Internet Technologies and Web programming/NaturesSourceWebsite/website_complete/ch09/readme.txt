ch09/readme.txt

This directory contains three files relevant to Chapter 9 of the text:
1. webbook2e_backup20150504.sql (for recreating the book's database)
2. customers1000.csv (data for 1000 customers in csv form)
3. products870.csv (data for 870 products in csv form)

The first file is probably the most useful, in the following sense:
If you are logged in to the command-line interface of your MySQL
installation, and the current directory is the directory where that
file is located, and your currently active database is the one you
want to use for the Nature's Source database, then the following
single command will set up the database to "parallel" the database
as used in the textbook discussion:
> source webbook2e_backup20150504.sql;

