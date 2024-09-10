Exemplos de código que atendem as convenções do checkstyle

```java
package com.exemplo.hexagonal;

import java.util.List;

/**
 * Classe de exemplo que demonstra a adesão às regras de estilo de código.
 */
public class ExemploServico {

    private final RepositorioExemplo repositorio;

    /**
     * Construtor da classe ExemploServico.
     *
     * @param repositorio o repositório de exemplo
     */
    public ExemploServico(RepositorioExemplo repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Método que retorna uma lista de itens.
     *
     * @return lista de itens
     */
    public List<Item> obterItens() {
        return repositorio.buscarTodos();
    }

    /**
     * Método que adiciona um novo item.
     *
     * @param item o item a ser adicionado
     */
    public void adicionarItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }
        repositorio.salvar(item);
    }

    /**
     * Método que remove um item pelo seu ID.
     *
     * @param id o ID do item a ser removido
     */
    public void removerItem(int id) {
        repositorio.remover(id);
    }
}
```

```java
package com.exemplo.hexagonal;

import java.util.List;

/**
 * Interface de repositório para operações com itens.
 */
public interface RepositorioExemplo {

    /**
     * Busca todos os itens.
     *
     * @return lista de itens
     */
    List<Item> buscarTodos();

    /**
     * Salva um item.
     *
     * @param item o item a ser salvo
     */
    void salvar(Item item);

    /**
     * Remove um item pelo seu ID.
     *
     * @param id o ID do item a ser removido
     */
    void remover(int id);
}
```

```java
package com.exemplo.hexagonal;

/**
 * Classe que representa um item.
 */
public class Item {

    private int id;
    private String nome;

    /**
     * Construtor da classe Item.
     *
     * @param id o ID do item
     * @param nome o nome do item
     */
    public Item(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```

```java
package com.exemplo.hexagonal;

/**
 * Classe que representa um item.
 */
public class Item {

    private int id;
    private String nome;

    /**
     * Construtor da classe Item.
     *
     * @param id o ID do item
     * @param nome o nome do item
     */
    public Item(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```