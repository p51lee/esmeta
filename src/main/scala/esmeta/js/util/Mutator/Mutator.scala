package esmeta.js.util.mutator

import esmeta.js.*

/* A mutator for JS */
trait Mutator {
    val name: String
    def mutate: Ast
}
