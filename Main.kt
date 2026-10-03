fun main() {
    println("=== QUESTÃO 1: Sistema de Cupons Avançado ===")
    println("Resultado Cupom PROMO10: R$ ${calcularDesconto(100.0, "PROMO10")}")
    println("Resultado Cupom PROMO20: R$ ${calcularDesconto(100.0, "PROMO20")}")
    println("Resultado Cupom Inválido: R$ ${calcularDesconto(100.0, "PROMO50")}")
    println("Resultado Cupom Nulo: R$ ${calcularDesconto(100.0, null)}")
    println()

    println("=== QUESTÃO 2: Auditoria de Entregas ===")
    val enderecos = listOf("Rua das Flores, 123", null, "Av. Central, 456", null, "Rua B, 789")
    auditarEntregas(enderecos)
    println()

    println("=== QUESTÃO 3: Validação de Perfil de Streaming ===")
    validarBioInfantil("Gosto de desenhos e jogos!")
    validarBioInfantil("Esta é uma biografia absurdamente longa criada propositalmente para ultrapassar o limite de cinquenta caracteres definidos pela regra.")
    validarBioInfantil(null)
    println()

    println("=== QUESTÃO 4: Processamento de Transações Pix ===")
    val transacoes = listOf(50.0, null, 120.5, null, 10.0)
    processarTransacoesPix(transacoes)
    println()

    println("=== QUESTÃO 5: Classificação de Feedback de Motoristas ===")
    avaliarMotorista(5)
    avaliarMotorista(4)
    avaliarMotorista(2)
    avaliarMotorista(0)
    avaliarMotorista(null)
    println()

    println("=== QUESTÃO 6: Função Lambda para Cálculo de Gorjeta ===")
    println("Gorjeta de R$ 15.0: R$ ${calcularGorjeta(15.0)}")
    println("Gorjeta de R$ -5.0: R$ ${calcularGorjeta(-5.0)}")
    println("Gorjeta Nula: R$ ${calcularGorjeta(null)}")
    println()

    println("=== QUESTÃO 7: Limpeza de Banco de Dados de Usuários ===")
    val emails = listOf("usuario1@email.com", null, "", "  ", "usuario2@email.com")
    limparBancoDeDadosEmails(emails)
}

// -----------------------------------------------------------------------------
// Questão 1: Sistema de Cupons Avançado (when e Null Safety)
// -----------------------------------------------------------------------------
fun calcularDesconto(valorProduto: Double, codigoCupom: String?): Double {
    return when (codigoCupom) {
        "PROMO10" -> valorProduto - 10.0
        "PROMO20" -> valorProduto - 20.0
        else -> valorProduto
    }
}

// -----------------------------------------------------------------------------
// Questão 2: Auditoria de Entregas (Laço de Repetição e Elvis Operator)
// -----------------------------------------------------------------------------
fun auditarEntregas(listaEnderecos: List<String?>) {
    for (item in listaEnderecos) {
        val enderecoFinal = item ?: "Endereço Desconhecido"

        if (enderecoFinal == "Endereço Desconhecido") {
            println("Entrega Pendente: Falta de dados")
        } else {
            println("Rota traçada para: $enderecoFinal")
        }
    }
}

// -----------------------------------------------------------------------------
// Questão 3: Validação de Perfil de Streaming (if/else e Safe Call)
// -----------------------------------------------------------------------------
fun validarBioInfantil(biografia: String?) {
    val tamanho = biografia?.length ?: 0

    if (tamanho <= 50) {
        println("Bio aceita")
    } else {
        println("Bio muito longa")
    }
}

// -----------------------------------------------------------------------------
// Questão 4: Processamento de Transações Pix (Laço e if/else)
// -----------------------------------------------------------------------------
fun processarTransacoesPix(transacoes: List<Double?>) {
    var total = 0.0

    for (valor in transacoes) {
        if (valor != null) {
            total += valor
        } else {
            println("Transação ignorada")
        }
    }

    println("Valor total processado: R$ $total")
}

// -----------------------------------------------------------------------------
// Questão 5: Classificação de Feedback de Motoristas (when e Null Safety)
// -----------------------------------------------------------------------------
fun avaliarMotorista(notaInput: Int?) {
    val nota = notaInput ?: 0

    when (nota) {
        5 -> println("Excelente corrida!")
        4 -> println("Boa corrida.")
        1, 2, 3 -> println("Precisamos melhorar.")
        0 -> println("Nenhuma avaliação fornecida.")
        else -> println("Nota inválida.")
    }
}

// -----------------------------------------------------------------------------
// Questão 6: Função Lambda para Cálculo de Gorjeta (Lambda, Null Safety e if)
// -----------------------------------------------------------------------------
val calcularGorjeta: (Double?) -> Double = {
    if (it == null || it < 0.0) {
        0.0
    } else {
        it
    }
}

// -----------------------------------------------------------------------------
// Questão 7: Limpeza de Banco de Dados de Usuários (Laços e Múltiplas Condições)
// -----------------------------------------------------------------------------
fun limparBancoDeDadosEmails(listaEmails: List<String?>) {
    var contasInvalidas = 0

    for (email in listaEmails) {
        // Safe Call + Elvis para garantir que nulo ou em branco (inclusive apenas espaços) seja tratado
        val tamanho = email?.trim()?.length ?: 0

        if (email == null || tamanho == 0) {
            contasInvalidas++
            println("Aviso: Conta inválida e marcada para deleção ($email)")
        } else {
            println("Conta válida: $email")
        }
    }

    println("Total de contas que precisam ser apagadas: $contasInvalidas")
}