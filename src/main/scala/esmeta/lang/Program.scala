package esmeta.lang

/** programs for abstract algorithms */
case class Program(block: Block) extends LangElem

// -----------------------------------------------------------------------------
// algorithm blocks
// -----------------------------------------------------------------------------
sealed trait Block extends LangElem
object Block extends Parser[Block]

case class Order(steps: List[Step]) extends Block
case class Unorder(steps: List[Step]) extends Block
case class Figure(lines: List[String]) extends Block

// -----------------------------------------------------------------------------
// TODO algorithm steps
// -----------------------------------------------------------------------------
sealed trait Step extends LangElem
object Step extends Parser[Step]

case class LetStep(variable: Variable, expr: Expression) extends Step
case class YetStep(str: String, block: Option[Block]) extends Step

// -----------------------------------------------------------------------------
// algorithm expressions
// -----------------------------------------------------------------------------
sealed trait Expression extends LangElem
object Expression extends Parser[Expression]

case class LengthExpression(expr: Expression) extends Expression
case class IdentifierExpression(id: Identifier) extends Expression

// -----------------------------------------------------------------------------
// algorithm identifiers
// -----------------------------------------------------------------------------
sealed trait Identifier extends LangElem
object Identifier extends Parser[Identifier]

case class Variable(name: String) extends Identifier