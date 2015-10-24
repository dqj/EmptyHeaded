package scala

import DunceCap.attr.Attr
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization._

case class QueryPlan(val query_type:String,
                val relations:List[QueryPlanRelationInfo],
                val output:QueryPlanOutputInfo,
                val ghd:List[QueryPlanBagInfo]) {
  override def toString(): String = {
    implicit val formats = DefaultFormats
    writePretty(this)
  }
}

case class QueryPlanRelationInfo(val name:String,
                            val ordering:List[Int],
                            val attributes:Option[List[List[Attr]]],
                            val annotation:String)
case class QueryPlanOutputInfo(val name:String,
                          val ordering:List[Int],
                          val annotation:String)

case class QueryPlanBagInfo(val name:String,
                       val attributes:List[Attr],
                       val annotation:String,
                       val relations:List[QueryPlanRelationInfo],
                       val nprr:List[QueryPlanNPRRInfo])

case class QueryPlanNPRRInfo(val name:String,
                        val accessors:List[QueryPlanAccessor],
                        val materialize:Boolean,
                        val selection:Boolean,
                        val annotation:Option[Attr],
                        val aggregation:Option[QueryPlanAggregation],
                        val prevMaterialized:Option[Attr],
                        val nextMaterialized:Option[Attr])

case class QueryPlanAggregation(val operation:String,
                           val init:String,
                           val expression:String,
                           val prev:Option[Attr],
                           val next:Option[Attr])

case class QueryPlanAccessor(val name:String,
                        val attrs:List[Attr],
                        val annotated:Boolean)