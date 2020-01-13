## Spark Starter

TODO DESCRIPTION:


### Prerequisites

1. Docker

    + [Windows](https://docs.docker.com/docker-for-windows/install/)
    + [Mac](https://download.docker.com/mac/stable/Docker.dmg)


3. [Apache Drill] (https://drill.apache.org/docs/running-drill-on-docker/) - incredibly useful for manipulating and querying data locally.

### Up & Running

If you are in position of developing spark jobs on a variety of different versions one of the best
ways to manage that is through docker containers. For example,

```
docker run -it --rm -v ~/.ivy2:/root/.ivy2 -v ~/.sbt:/root/.sbt -v $PWD/app:/app -w /app hseeberger/scala-sbt:8u222_1.3.3_2.13.1 sbt ~package
```

will perform continuous compile of the local project.

Visit https://hub.docker.com/r/hseeberger/scala-sbt/tags to identify the version of scala you need.


Docker Compose helps out with running jobs locally. Simply run `docker-compose up` to spin up a local Spark cluster. We run jobs aginst with running cluster with something like,

```
docker exec -it -w /spark starter-spark-job_master_1 bin/spark-submit --conf spark.driver.extraJavaOptions=-XX:+UseG1GC --conf spark.driver.memory=8g --conf spark.serializer=org.apache.spark.serializer.KryoSerializer --class example.StarterSparkJob /build/example.jar
```

