package br.com.nilson.AppPessoasContatos.Modelos;

//Enum que define os tipos de contato disponíveis (Telefone e Celular).
public enum TipoContato {
	// Definindo os tipos de contato com seus respectivos valores
	TELEFONE(0),
    CELULAR(1);

	// Atributo que armazena o valor associado ao tipo de contato
    private final int valor;

    // Construtor que define o valor para cada tipo de contato
    TipoContato(int valor) {
        this.valor = valor;
    }
    
    // Método getter para obter o valor associado ao tipo de contato
    public int getValor() {
        return valor;
    }
    
    // Método estático que retorna o tipo de contato com base no valor fornecido
    public static TipoContato fromValor(int valor) {
    	// Itera sobre todos os tipos de contato e retorna o correspondente ao valor fornecido
    	for (TipoContato tipo : TipoContato.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
    	// Lança uma exceção se o valor não corresponder a nenhum tipo de contato
        throw new IllegalArgumentException("Valor inválido para TipoContato: " + valor);
    }
}