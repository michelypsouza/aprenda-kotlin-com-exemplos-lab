// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val matricula: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário com matricula ${usuario.matricula} e nome ${usuario.nome} foi matriculado na formação $nome.")
    }
}

fun main() {

    val usuario1 = Usuario("Michely", 1)
    val usuario2 = Usuario("Paulo", 2)

    val conteudo1 = ConteudoEducacional("Linguagem Kotlin")
    val conteudo2 = ConteudoEducacional("Padrões de Projeto com Kotlin")
    val conteudo3 = ConteudoEducacional("Spring Boot com Kotlin")

    val formacaoKotlin = Formacao("Formação Backend com Kotlin", listOf(conteudo1, conteudo2, conteudo3))
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    println("A formação ${formacaoKotlin.nome} possui os seguintes usuários matriculados : ${formacaoKotlin.inscritos.map { it.nome }}")

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}

