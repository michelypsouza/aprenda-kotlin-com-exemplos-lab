enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val matricula: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Usuario) return false
        return this.matricula == other.matricula
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        if (inscritos.contains(usuario)) {
           println("Usuario com matricula: ${usuario.matricula} e nome: ${usuario.nome} ja foi matriculado anteriormente na formação $nome.")
        } else {
           inscritos.add(usuario)
           println("Usuário com matricula: ${usuario.matricula} e nome: ${usuario.nome} foi matriculado na formação $nome.")
        }
    }
}

fun main() {

    val usuario1 = Usuario("Michely", 1)
    val usuario2 = Usuario("Paulo", 2)

    val conteudo1 = ConteudoEducacional("Lógica de Programação", 360)
    val conteudo2 = ConteudoEducacional("Padrões de Projeto com Kotlin", nivel=Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional(nome = "Spring Boot com Kotlin", duracao = 300, nivel=Nivel.DIFICIL)

    val formacaoKotlin = Formacao("Formação Backend com Kotlin", listOf(conteudo1, conteudo2, conteudo3))
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    println()
    formacaoKotlin.matricular(usuario1)

    println("A formação ${formacaoKotlin.nome} possui os seguintes usuários matriculados : ${formacaoKotlin.inscritos.map { it.nome }}\n")       

    val formacaoLogicaProg = Formacao("Formação Básica de Lógica de Programação", listOf(conteudo1))
    formacaoLogicaProg.matricular(usuario1)
    println("A formação ${formacaoLogicaProg.nome} possui os seguintes usuários matriculados : ${formacaoLogicaProg.inscritos.map { it.nome }}")  

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
