import java.util.*

open class Professor(
        override var cod: Int,
        override var nome: String,
        override var sobrenome: String,
        var tempoDeCasa: Int = 0
):Usuario {
    override fun toString(): String {
        return "$nome $sobrenome"
    }
}