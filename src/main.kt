//inicia o programa
val digitalHouseManager = DigitalHouseManager();
fun main() {
    menu();
//    //cadastra o primeiro curso
//    digitalHouseManager.registrarCurso("Curso de python",12,10)
//    //tenta cadastrar o segundo curso igual o primeiro
//    digitalHouseManager.registrarCurso("Curso de python",12,10)
//    //lista os cursos
//    println(digitalHouseManager.cursos)
//    //tenta excluir um curso que não existe
//    digitalHouseManager.excluirCurso(20);
//    //remove o curso cadastrado anteriormente
//    digitalHouseManager.excluirCurso(12);
//    //lista os cursos
//    println(digitalHouseManager.cursos)
//
//    //registra professsor adjunto
//    digitalHouseManager.registrarProfessorAdjunto("Leandro freire","da Silva",10,7)
//    //registra professsor titular com o mesmo cod
//    digitalHouseManager.registrarProfessorTitular("Leandro freire","da Silva",10,"azure")
//    //registra professsor titular
//    digitalHouseManager.registrarProfessorTitular("Leandro freire","da Silva",11,"azure")
//
//    println(digitalHouseManager.professores)
//
//    digitalHouseManager.excluirProfessor(9)
//
//    digitalHouseManager.excluirProfessor(10)
//
//    println("PROFESSORES: "+ digitalHouseManager.professores)
//
//    digitalHouseManager.registrarAluno("jow jow","now",10)
//    digitalHouseManager.registrarAluno("jow jow","now",11)
//    digitalHouseManager.registrarCurso("Curso de python",12,1)
//    digitalHouseManager.matricularAluno(10, 12);
//    digitalHouseManager.matricularAluno(11, 12);
//    println(digitalHouseManager.cursos)

}
fun menu() {
    println("""
 _____  _       _ _        _   _    _
|  __ \(_)     (_) |      | | | |  | |
| |  | |_  __ _ _| |_ __ _| | | |__| | ___  _   _ ___  ___
| |  | | |/ _` | | __/ _` | | |  __  |/ _ \| | | / __|/ _ \
| |__| | | (_| | | || (_| | | | |  | | (_) | |_| \__ \  __/
|_____/|_|\__, |_|\__\__,_|_| |_|  |_|\___/ \__,_|___/\___|
        __/ |
       |___/

OPÇÕES:
1 -> REGISTRAR CURSO
2 -> EXCLUIR CURSO
3 -> REGISTRAR PROFESSOR ADJUNTO
4 -> REGISTRAR PROFESSOR TITULAR
5 -> EXCLUIR PROFESSOR
6 -> REGISTRAR ALUNO
7 -> MATRICULAR ALUNO
8 -> LISTAR ALUNOS CADASTRADOS
9 -> LISTAR CURSOS
""");
    println("DIGITE UMA OPÇÃO:");
    var opcao = readLine()
    while(opcao == "") {
        println("DIGITE UMA OPÇÃO:");
        opcao = readLine()
    }
    when(opcao as String){
        "1" -> fluxoRegistrarCurso()
        "2" -> fluxoExcluirCurso()
        "3" -> fluxoRegistrarProfessorAdjunto()
        "4" -> fluxoRegistrarProfessorTitular()
        "5" -> fluxoExcluirProfessor()
        "6" -> fluxoRegistrarAluno()
        "7" -> fluxoMatricularAluno()
        "8" -> fluxoListarAlunos()
        "9" -> fluxoListarCursos()
        else -> {
            println("OPÇÃO INVALIDA");
            Thread.sleep(2000)
            menu()
        }
    }
}
fun fluxoRegistrarCurso() {
    try {
        println("DIGITE O NOME DO CURSO:")
        val nome = readLine().toString();
        println("DIGITE NUMERO QUE SERÁ O CODIGO DO CURSO:")
        val cod = readLine()?.toInt() as Int;
        println("DIGITE A QUANTIDADE MAXIMA DE ALUNOS DO CURSO:")
        val qtMax = readLine()?.toInt() as Int;

        digitalHouseManager.registrarCurso(nome,cod,qtMax)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoExcluirCurso() {
    try {
        println("DIGITE O COD DO CURSO QUE QUER EXCLUIR:")
        val cod = readLine()?.toInt() as Int;
        digitalHouseManager.excluirCurso(cod)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoRegistrarProfessorAdjunto() {
    try {
        println("DIGITE O NOME DO PROFESSOR:")
        val nome = readLine() as String;
        println("DIGITE O SOBRENOME DO PROFESSOR:")
        val sobrenome = readLine() as String;
        println("DIGITE O COD DO PROFESSOR:")
        val cod = readLine()?.toInt() as Int;
        println("DIGITE A QUANTIDADE DE HORAS DISPONIVEIS DO PROFESSOR:")
        val qtHoras = readLine()?.toInt() as Int;
        digitalHouseManager.registrarProfessorAdjunto(nome,sobrenome,cod,qtHoras)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoRegistrarProfessorTitular() {
    try {
        println("DIGITE O NOME DO PROFESSOR:")
        val nome = readLine() as String;
        println("DIGITE O SOBRENOME DO PROFESSOR:")
        val sobrenome = readLine() as String;
        println("DIGITE O COD DO PROFESSOR:")
        val cod = readLine()?.toInt() as Int;
        println("DIGITE A ESPECIALIDADE DO PROFESSOR:")
        val espcialidade = readLine() as String;
        digitalHouseManager.registrarProfessorTitular(nome,sobrenome,cod,espcialidade)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoExcluirProfessor(){
    try {
        println("DIGITE O COD DO PROFESSOR QUE QUER EXCLUIR:")
        val cod = readLine()?.toInt() as Int;
        digitalHouseManager.excluirProfessor(cod)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoRegistrarAluno() {
    try {
        println("DIGITE O NOME DO ALUNO:")
        val nome = readLine() as String;
        println("DIGITE O SOBRENOME DO ALUNO:")
        val sobrenome = readLine() as String;
        println("DIGITE O COD DO ALUNO:")
        val cod = readLine()?.toInt() as Int;
        digitalHouseManager.registrarAluno(nome,sobrenome,cod)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }

}
fun fluxoMatricularAluno(){
    try {
        listarAlunos()
        println("DIGITE O COD DO ALUNO:")
        val codAluno = readLine()?.toInt() as Int;
        listarCursos()
        println("DIGITE O COD DO CURSO:")
        val codCurso = readLine()?.toInt() as Int;
        digitalHouseManager.matricularAluno(codAluno, codCurso);
        Thread.sleep(2000)
        menu();
    }catch (e: Exception) {
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }
}
fun fluxoListarAlunos() {
    listarAlunos()
    Thread.sleep(2000)
    menu()
}
fun fluxoListarCursos(){
    listarCursos()
    Thread.sleep(2000)
    menu()
}
fun listarAlunos() {
    digitalHouseManager.alunos.forEach {
        println(it)
    }
}
fun listarCursos(){
    digitalHouseManager.cursos.forEach {
        println(it)
    }
}



