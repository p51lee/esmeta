package esmeta.js.util

import esmeta.util.BasicWalker
import esmeta.js.*

/** a walker for JS */
trait Walker extends BasicWalker {
  def walk(elem: JSElem): JSElem = elem match
    case elem: Ast => walk(elem)

  // ASTs
  def walk(ast: Ast): Ast = ast match
    case ast: Syntactic => walk(ast)
    case ast: Lexical => walk(ast)

  // ASTs contructed by syntactic productions
  def walk(ast: Syntactic): Syntactic =
    val Syntactic(name, args, rhsIdx, children) = ast
    Syntactic(name, args, rhsIdx, walkList(children, walkOpt(_, walk)))

  // ASTs contructed by lexical productions
  def walk(ast: Lexical): Lexical = ast
}

