package projeto09.classes;

import java.util.Objects;

public class Produto {
    private Integer pk_id;
    private String nome;
    private String descricao;
    private Double desconto;

    public Produto() {
    }

    public Produto(Integer pk_id, String nome, String descricao, Double desconto) {
        this.pk_id = pk_id;
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
    }

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return pk_id == produto.pk_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_id);
    }
}
