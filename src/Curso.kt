class Curso(
        var cod: Int,
        var nome: String,
        var professorTitular: ProfessorTitular? = null,
        var professorAdjunto: ProfessorAdjunto? = null,
        var qtMaxAluno: Int,
        var alunos: MutableMap<Int, Aluno> = mutableMapOf<Int, Aluno>()
) {
    fun adicionarUmAluno(aluno: Aluno): Boolean {
        if (alunos.containsKey(aluno.cod)){
            if (aluno == alunos.get(aluno.cod) as Aluno) {
                throw Exception("ESTE ALUNO JA ESTÁ MATRICULADO")
            }
            throw Exception("JA EXISTE UM ALUNO MATRICULADO COM ESTE COD")
        }
        if (alunos.size >= qtMaxAluno) {
           throw Exception("O CURSO JA ATINGIU O LIMITE MAXIMO DE ALUNOS")
        }
        alunos.set(aluno.cod, aluno)
        return true;
    }
    fun excluirAluno(aluno: Aluno) {
        try {
            if (!alunos.containsKey(aluno.cod)){
                throw Exception("ESTE ALUNO NÃO ESTA CADASTRADO NO CURSO")
            }
            alunos.remove(aluno.cod)
            println("ALUNO REMOVIDO DO CURSO $nome")
        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL REMOVER O ALUNO DO CURSO $nome: ${e.localizedMessage}");
        }
    }

    override fun toString(): String {
        return "Curso(cod=$cod, nome='$nome', professorTitular=$professorTitular, professorAdjunto=$professorAdjunto, qtMaxAluno=$qtMaxAluno, alunos=$alunos)"
    }

}