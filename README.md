## Spark Starter

TODO DESCRIPTION:


### Prerequisites

1. Docker

    + [Mac](https://download.docker.com/mac/stable/Docker.dmg)


3. [Apache Drill](https://drill.apache.org/docs/running-drill-on-docker/) - incredibly useful for manipulating and querying data locally.

### Up & Running

Docker Compose helps out with running jobs locally. Simply run `docker-compose up` to spin up a local Spark cluster. We run jobs aginst with running cluster with,

```
docker exec -it -w /spark starter-spark-job_master_1 bin/spark-submit --conf spark.driver.extraJavaOptions=-XX:+UseG1GC --conf spark.driver.memory=8g --conf spark.serializer=org.apache.spark.serializer.KryoSerializer --class example.StarterSparkJob /build/example.jar
```

You can start the job in debug mode with,

```
docker exec -it -e SPARK_SUBMIT_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=4000 -w /spark spark-job-starter_master_1 bin/spark-submit --conf spark.driver.extraJavaOptions=-XX:+UseG1GC --conf spark.driver.memory=8g --conf spark.serializer=org.apache.spark.serializer.KryoSerializer --class example.StarterSparkJob /build/example.jar
```

Lastly, it can also be helpful to have access to a spark shell. I currently do this in the local directory by running.

```
docker run -it --rm -e ENABLE_INIT_DAEMON=false -w /spark -v "$PWD":/data bde2020/spark-master:2.4.4-hadoop2.7 bin/spark-shell
```

Adding an alias like `alias spark-shelld='....'` makes it easy to remember
