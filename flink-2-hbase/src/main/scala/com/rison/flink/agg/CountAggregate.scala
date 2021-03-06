package com.rison.flink.agg

import com.rison.flink.domain.LogEntity
import org.apache.flink.api.common.functions.AggregateFunction

/**
 * @author : Rison 2021/6/15 上午9:02
 *
 */
case class CountAggregate() extends AggregateFunction[LogEntity, Long, Long]{
  override def createAccumulator(): Long = 0

  override def add(in: LogEntity, acc: Long): Long = {
    acc + 1
  }

  override def getResult(acc: Long): Long = acc

  override def merge(acc: Long, acc1: Long): Long = acc + acc1
}
