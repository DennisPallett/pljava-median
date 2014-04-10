PL/Java Median
=============

This is a basic Median aggregate function for PostgreSQL written in PL/Java (and therefore requires PL/Java to be installed in your PostgreSQL installation and database).

This aggregate function uses a very simple algorithm to calculate the median for a set of tuples. All the tuples are collected, stored in memory and finally sorted using quicksort to determine the median. For large datasets this will not work or deliver very poor performance, especially when the dataset exceeds the available memory thereby causing disk swapping.
