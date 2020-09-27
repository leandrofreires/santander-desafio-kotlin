import java.util.*

class ProfessorAdjunto(
        cod: Int,
        nome: String,
        sobrenome: String,
        tempoDeCasa: Int,
        var horasDeMentoria: Int
): Professor(cod, nome, sobrenome, tempoDeCasa)