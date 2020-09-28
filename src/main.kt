//inicia o programa
val digitalHouseManager = DigitalHouseManager();
fun main() {
    menu();
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
1  -> REGISTRAR CURSO
2  -> EXCLUIR CURSO
3  -> REGISTRAR PROFESSOR ADJUNTO
4  -> REGISTRAR PROFESSOR TITULAR
5  -> EXCLUIR PROFESSOR
6  -> REGISTRAR ALUNO
7  -> MATRICULAR ALUNO
8  -> LISTAR ALUNOS CADASTRADOS
9  -> LISTAR CURSOS
10 -> ALOCAR PROFESSOR AO CURSO
11 -> LISTAR PROFESSORES
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
        "10"-> fluxoAlocarProfessor()
        "11"-> fluxoListarProfessores()
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
fun fluxoListarProfessores(){
    listarProfessores()
    Thread.sleep(2000)
    menu()
}
fun fluxoAlocarProfessor(){
    try {
        listarCursos();
        println("DIGITE O COD DO CURSO:")
        val codCurso = readLine()?.toInt() as Int;
        listarProfessores();
        println("DIGITE O COD DO PROFESSOR TITUTLAR:")
        val codProfessorTitular = readLine()?.toInt() as Int;
        println("DIGITE O COD DO PROFESSOR ADJUNTO:")
        val codProfessorAdjunto= readLine()?.toInt() as Int;
        digitalHouseManager.alocarProfessores(codCurso,codProfessorTitular,codProfessorAdjunto)
        Thread.sleep(2000)
        menu();
    }catch (e: Exception){
        println("VOCE ENTROU COM UM DADO INVALIDO: ${e.localizedMessage}")
        Thread.sleep(2000)
        menu();
    }

}
fun listarAlunos() {
    if (digitalHouseManager.alunos.size == 0){
        println("NÃO HÁ ALUNOS CADASTRADOS")
        return
    }
    digitalHouseManager.alunos.forEach {
        println("${it.key} -> ${it.value.nome}")
    }
}
fun listarCursos(){
    if (digitalHouseManager.cursos.size == 0){
        println("NÃO HÁ CURSOS CADASTRADOS")
        return
    }
    digitalHouseManager.cursos.forEach {
        println("${it.key} -> ${it.value.nome}" )
    }
}
fun listarProfessores(){
    if (digitalHouseManager.professores.size == 0){
        println("NÃO HÁ PROFESSORES CADASTRADOS")
        return
    }
    digitalHouseManager.professores.forEach {
        println("${it.key} -> ${it.value.nome} ${it.value.sobrenome} " )
    }
}



