class Aluno(
        override var cod: Int,
        override var nome: String,
        override var sobrenome: String
): Usuario {
    override fun toString(): String {
        return "$nome $sobrenome";
    }
}