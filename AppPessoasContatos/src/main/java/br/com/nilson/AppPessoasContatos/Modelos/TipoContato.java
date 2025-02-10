package br.com.nilson.AppPessoasContatos.Modelos;

public enum TipoContato {
    TELEFONE(0),
    CELULAR(1);

    private final int valor;

    TipoContato(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TipoContato fromValor(int valor) {
        for (TipoContato tipo : TipoContato.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TipoContato: " + valor);
    }
}