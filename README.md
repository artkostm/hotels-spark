First of all download train.csv: https://www.kaggle.com/c/expedia-hotel-recommendations/data

Then build a jar file with ```sbt assembly```

To submit the app to Spark use the following command:

```
spark-submit --class by.artsiom.bigdata101.hotels.Main --master local[*] hotels-spark.jar /path/to/train.csv
```

## Task 1

### Find top 3 most popular hotels between couples. (treat hotel as composite key of continent, country and market).

Result:

```shell
+---------------+-------------+------------+-------+
|hotel_continent|hotel_country|hotel_market|    cnt|
+---------------+-------------+------------+-------+
|              2|           50|         628|1190143|
|              2|           50|         675|1007502|
|              4|            8|         110| 588213|
+---------------+-------------+------------+-------+
```

## Task2

### Find the most popular country where hotels are booked and searched from the same country.

Result:

```shell
+-------------+-----+
|hotel_country|count|
+-------------+-----+
|           68| 1619|
+-------------+-----+
```

## Task3

### Find top 3 hotels where people with children are interested but not booked in the end.

Result:

```shell
+---------------+-------------+------------+------+
|hotel_continent|hotel_country|hotel_market|   cnt|
+---------------+-------------+------------+------+
|              2|           50|         682|398872|
|              2|           50|         675|294833|
|              2|           50|         628|218325|
+---------------+-------------+------------+------+
```

Spark Jobs:

![Spark Jobs](./img/hotels-spark.png "Spark Jobs")
