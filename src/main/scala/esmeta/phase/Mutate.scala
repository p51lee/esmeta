package esmeta.phase

import esmeta.*
import esmeta.cfg.CFG
import esmeta.interp.*
import esmeta.util.*
import esmeta.util.SystemUtils.*
import esmeta.js.*

case object Mutate extends Phase[CFG, Unit] {
    val name = "mutate"
    val help = "mutates javascript programs to increase the semantics coverage"
    def apply(
        cfg: CFG,
        globalConfig: GlobalConfig,
        config: Config
    ): Unit = {}
    def defaultConfig: Config = Config()
    val options: List[PhaseOption[Config]] = List()
    case class Config()
}