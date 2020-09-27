fun main() {
//    println("""
// _____  _       _ _        _   _    _
//|  __ \(_)     (_) |      | | | |  | |
//| |  | |_  __ _ _| |_ __ _| | | |__| | ___  _   _ ___  ___
//| |  | | |/ _` | | __/ _` | | |  __  |/ _ \| | | / __|/ _ \
//| |__| | | (_| | | || (_| | | | |  | | (_) | |_| \__ \  __/
//|_____/|_|\__, |_|\__\__,_|_| |_|  |_|\___/ \__,_|___/\___|
//        __/ |
//       |___/
//
//OPÇÕES:
//1 -> REGISTRAR CURSO
//2 -> EXCLUIR CURSO
//3 -> REGISTRAR PROFESSOR ADJUNTO
//4 -> REGISTRAR PROFESSOR TITULAR
//5 -> EXCLUIR PROFESSOR
//6 -> REGISTRAR ALUNO
//7 -> MATRICULAR ALUNO
//""");
//    println("DIGITE UMA OPÇÃO:");
//    var opcao = readLine()
//    while(opcao == "") {
//        println("DIGITE UMA OPÇÃO:");
//        opcao = readLine()
//    }
//    when(opcao){
//
//    }
//    opcao.let {
//        val digitalHouseManager = DigitalHouseManager();
//        digitalHouseManager.registrarCurso("Curso de python",12,10)
//    }
    //inicia o programa
    val digitalHouseManager = DigitalHouseManager();
    //cadastra o primeiro curso
    digitalHouseManager.registrarCurso("Curso de python",12,10)
    //tenta cadastrar o segundo curso igual o primeiro
    digitalHouseManager.registrarCurso("Curso de python",12,10)
    //lista os cursos
    println(digitalHouseManager.cursos)
    //tenta excluir um curso que não existe
    digitalHouseManager.excluirCurso(20);
    //remove o curso cadastrado anteriormente
    digitalHouseManager.excluirCurso(12);
    //lista os cursos
    println(digitalHouseManager.cursos)

    //registra professsor adjunto
    digitalHouseManager.registrarProfessorAdjunto("Leandro freire","da Silva",10,7)
    //registra professsor titular com o mesmo cod
    digitalHouseManager.registrarProfessorTitular("Leandro freire","da Silva",10,"azure")
    //registra professsor titular
    digitalHouseManager.registrarProfessorTitular("Leandro freire","da Silva",11,"azure")
}