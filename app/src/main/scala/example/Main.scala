package example

import org.apache.spark.sql.SparkSession;

object StarterSparkJob {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("Starter Spark Job")
      .getOrCreate()

  }
}
