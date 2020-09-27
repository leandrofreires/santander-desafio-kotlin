import java.util.*

class ProfessorTitular(
        cod: Int,
        nome: String,
        sobrenome: String,
        tempoDeCasa: Int,
        var especialidade: String
): Professor(cod, nome, sobrenome, tempoDeCasa)