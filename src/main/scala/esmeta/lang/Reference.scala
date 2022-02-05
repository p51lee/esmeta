package esmeta.lang

import esmeta.lang.util.*

// metalanguage references
sealed trait Reference extends Syntax
object Reference extends Parser.From[Reference]

// variables
case class Variable(name: String) extends Reference

// the running execution context literals
case class RunningExecutionContext() extends Reference

// the current realm record
case class CurrentRealmRecord() extends Reference

// the active function object
case class ActiveFunctionObject() extends Reference

// references to property
case class PropertyReference(base: Reference, prop: Property) extends Reference

// -----------------------------------------------------------------------------
// metalanguage properties
// -----------------------------------------------------------------------------
sealed trait Property extends Syntax
object Property extends Parser.From[Property]

// field property
case class FieldProperty(field: Field) extends Property

// component property
case class ComponentProperty(name: String) extends Property

// index property
case class IndexProperty(index: Expression) extends Property

// -----------------------------------------------------------------------------
// metalanguage fields
// -----------------------------------------------------------------------------
sealed trait Field extends Syntax
object Field extends Parser.From[Field]
case class StringField(name: String) extends Field
case class IntrinsicField(intrinsic: Intrinsic) extends Field

// -----------------------------------------------------------------------------
// intrinsics
// -----------------------------------------------------------------------------
case class Intrinsic(base: String, props: List[String]) extends Syntax
object Intrinsic extends Parser.From[Intrinsic]