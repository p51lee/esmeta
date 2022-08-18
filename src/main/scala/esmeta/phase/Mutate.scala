package esmeta.phase

import esmeta.*
import esmeta.cfg.CFG
import esmeta.interp.*
import esmeta.util.*
import esmeta.util.SystemUtils.*
import esmeta.js.*
import esmeta.js.util.{Parser => JSParser}
import esmeta.js.util.mutator.*

/** `mutate` phase */
case object Mutate extends Phase[CFG, String] {
    val name = "mutate"
    val help = "mutates a JavaScript program."
    def apply(
        cfg: CFG,
        globalConfig: GlobalConfig,
        config: Config
    ): String =
        val filename = getFirstFilename(globalConfig, this.name)
        val ast = JSParser(cfg.spec.grammar)("Script").fromFile(filename)
        val mutator: Mutator = RandomMutation(ast)
        // mutator.mutate.toString
        mutator.mutate.toString(grammar = Some(cfg.grammar))

    def defaultConfig: Config = Config()
    val options: List[PhaseOption[Config]] = List()
    case class Config()
}