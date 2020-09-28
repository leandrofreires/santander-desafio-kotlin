import com.sun.source.tree.TryTree
import java.util.*

class DigitalHouseManager(
        var alunos: MutableMap<Int, Aluno> = mutableMapOf(),
        var professores: MutableMap<Int, Professor> = mutableMapOf(),
        var cursos: MutableMap<Int, Curso> = mutableMapOf(),
        var matriculas: MutableMap<Int, Matricula> = mutableMapOf()
) {
    fun registrarCurso(
            nome: String,
            codigoCurso: Int,
            quantidadeMaximaDeAlunos: Int
    ) {
        try {
            val curso = Curso(
                    codigoCurso,
                    nome,
                    null,
                    null,
                    quantidadeMaximaDeAlunos);
            if(cursos.containsKey(codigoCurso)){
                throw Exception("ESTE CODIGO DE CURSO JA ESTÁ EM USO")
            }
            cursos[codigoCurso] = curso
            println("CURSO CADASTRADO COM SUCESSO!")

        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL CADASTRAR O CURSO: ${e.localizedMessage}");
        }
    }
    fun excluirCurso(codigoCurso: Int) {
        try {
            if(!cursos.containsKey(codigoCurso)){
                throw Exception("ESTE CODIGO DE CURSO É INVALIDO")
            }
            cursos.remove(codigoCurso)
            println("CURSO REMOVIDO")
        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL REMOVER O CURSO: ${e.localizedMessage}");
        }
    }
    fun registrarProfessorAdjunto(
            nome: String,
            sobrenome: String,
            codigoProfessor: Int,
            quantidadeDeHoras: Int
    ){
        try {
            val professor = ProfessorAdjunto(codigoProfessor, nome, sobrenome,0,quantidadeDeHoras)
            if(professores.containsKey(codigoProfessor)){
                throw Exception("O CODIGO DO PROFESSOR $codigoProfessor ESTA EM USO!")
            }
            professores.set(codigoProfessor,professor)
            println("PROFESSOR ADJUNTO CADASTRADO COM SUCESSO")
        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL CADASTRAR O PROFESSOR POIS: ${e.localizedMessage}")
        }
    }
    fun registrarProfessorTitular(
            nome: String,
            sobrenome: String ,
            codigoProfessor: Int,
            especialidade: String
    ){
        try {
            val professor = ProfessorTitular(codigoProfessor, nome, sobrenome,0, especialidade)
            if(professores.containsKey(codigoProfessor)){
                throw Exception("O CODIGO DO PROFESSOR $codigoProfessor ESTA EM USO!")
            }
            professores.set(codigoProfessor,professor)
            println("PROFESSOR TITULAR CADASTRADO COM SUCESSO")

        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL CADASTRAR O PROFESSOR POIS: ${e.localizedMessage}")
        }
    }

    fun excluirProfessor(codigoProfessor: Int) {
        try {
            if(!professores.containsKey(codigoProfessor)){
                throw Exception("O PROFESSOR $codigoProfessor NÃO ESTA CADASTRADO!")
            }
            val prof = professores.get(codigoProfessor)
            professores.remove(codigoProfessor)
            println("O PROFESSOR ${prof?.nome + ' ' + prof?.sobrenome} FOI REMOVIDO DO SISTEMA")
        }catch (e: Exception){
            println("NÃO FOI POSSIVEL REMOVER O PROFESSOR POIS: ${e.localizedMessage}")
        }
    }
    fun registrarAluno(nome: String , sobrenome: String , codigoAluno: Int) {
        try {
            if (alunos.containsKey(codigoAluno)){
                throw Exception("O CODIGO DO ALUNO $codigoAluno ESTA EM USO!")
            }
            val aluno = Aluno(codigoAluno,nome,sobrenome);
            alunos.set(codigoAluno,aluno)
            println("ALUNO CADASTRADO COM SUCESSO")

        } catch (e: Exception) {
            println("NÃO FOI POSSIVEL CADASTRAR O ALUNO POIS: ${e.localizedMessage}")
        }
    }
    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        try {
            if (!alunos.containsKey(codigoAluno)){
                throw Exception("NÃO EXISTE NENHUM ALUNO CADASTRADO COM ESSE CODIGO")
            }
            if (!cursos.containsKey(codigoCurso)){
                throw Exception("NÃO EXISTE NENHUM CURSO CADASTRADO COM ESSE CODIGO")
            }
            val aluno =  alunos.get(codigoAluno) as Aluno;
            val curso = cursos.get(codigoCurso) as Curso;

            curso.adicionarUmAluno(aluno);

            val matricula = Matricula(aluno,curso, Date())
            matriculas.set(matriculas.size + 1, matricula);
            println("MATRICULA REALIZADA COM SUCESSO")
        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL MATRICULAR O ALUNO POIS: ${e.localizedMessage}")
        }
    }
    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        try {
            if (!cursos.containsKey(codigoCurso)){
                throw Exception("NÃO EXISTE NENHUM CURSO CADASTRADO COM ESSE CODIGO")
            }
            if (!professores.containsKey(codigoProfessorAdjunto)){
                throw Exception("NÃO EXISTE NENHUM PROFESSOR CADASTRADO O CODIGO $codigoProfessorAdjunto")
            }
            if (!professores.containsKey(codigoProfessorTitular)){
                throw Exception("NÃO EXISTE NENHUM PROFESSOR CADASTRADO O CODIGO $codigoProfessorTitular")
            }
            val curso = cursos.get(codigoCurso) as Curso;

            try {
                val professorAdjunto = professores.get(codigoProfessorAdjunto) as ProfessorAdjunto;
                curso.professorAdjunto = professorAdjunto;
            }catch(e: Exception) {
                throw Exception("ESTE PROFESSOR NÃO É ADJUNTO")
            }
            try {
                val professorTitular = professores.get(codigoProfessorTitular) as ProfessorTitular;
                curso.professorTitular = professorTitular;
            }catch (e: Exception) {
                throw Exception("ESTE PROFESSOR NÃO É TITULAR")
            }
            println("PROFESSORES ALOCADOS COM SUCESSO!")
        }catch (e: Exception) {
            println("NÃO FOI POSSIVEL ALOCAR OS PROFESSOR: ${e.localizedMessage}")
        }
    }
}