package storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NodeStream<T> {

    private Node<T> head;
    private Node<T> tail;

    public NodeStream(Node<T> head) {
        /*
            Cria a referência inicial (head).
        */
        this.head = new Node<T>(null);
        /*
            Cria a referência final (tail).
            Como não existem elementos (ainda), a referência da cauda será a mesma da cabeça.
        */
        this.tail = this.head;

        /*
            A técnica utiliza para fazer cópia dos elementos do PARÂMETRO head será a Shallow Copy ou cópia superficial,
            ou seja será criado apenas um Novo Node, mantedo a referência do valor.

            A maneira de adicionar esses novos elementos na lista encadeada interna seguirá o padrão de fila, ou seja,
            sempre serão adicionados no tail (cauda).
        */

        Node<T> aux = head.getNext();
        while (aux != null) {
            Node<T> copy = new Node<T>(aux.getValue());
            this.tail.setNext(copy);
            copy.setPrevious(this.tail);
            // Como o node foi adicionado a lista, é possível definir esse elemento como o último
            this.tail = copy;
            aux = aux.getNext();
        }
    }

    @FunctionalInterface
    public interface FilterListaStream<T> {
        boolean aplicar(T item);
    }

    public NodeStream<T> filter(FilterListaStream<T> funcao) {
        Node<T> head = new Node<T>(null);
        Node<T> tail = head;
        Node<T> aux = this.head.getNext();

        while (aux != null) {
            if (funcao.aplicar(aux.getValue())) {
                Node<T> copy = new Node<T>(aux.getValue());
                tail.setNext(copy);
                copy.setPrevious(tail);
                tail = copy;
            }
            aux = aux.getNext();
        }

        return new NodeStream<T>(head);
    }

    @FunctionalInterface
    public interface MapListaStream<T, O> {
        O aplicar(T item);
    }

    public <O> NodeStream<O> map(MapListaStream<T, O> funcao) {
        Node<O> head = new Node<O>(null);
        Node<O> tail = head;
        Node<T> aux = this.head.getNext();

        while (aux != null) {
            Node<O> copy = new Node<O>(funcao.aplicar(aux.getValue()));
            tail.setNext(copy);
            copy.setPrevious(tail);
            tail = copy;
            aux = aux.getNext();
        }

        return new NodeStream<O>(head);
    }

    @FunctionalInterface
    public interface ReduceListaStream<T> {
        T aplicar(T acumulador, T item);
    }

    public Optional<T> reduce(ReduceListaStream<T> funcao) {
        Node<T> aux = this.head.getNext();
        T acumulador = null;

        while (aux != null) {
            if (acumulador == null) {
                acumulador = aux.getValue();
            }
            else {
                acumulador = funcao.aplicar(acumulador, aux.getValue());
            }
            aux = aux.getNext();
        }

        return Optional.ofNullable(acumulador);
    }

    @FunctionalInterface
    public interface AnyMatchNodeStream<T> {
        boolean aplicar(T item);
    }

    /*
        Verifica se qualquer elemento da lista retorna true baseado na expressão passada como argumento. Na primeira
        ocorrência, o loop será finalizado e será retornado true, caso contrário, será retornado false
    */
    public boolean anyMatch(AnyMatchNodeStream<T> funcao) {
        Node<T> aux = this.head.getNext();
        boolean resultado = false;
        while (aux != null && !resultado) {
            resultado = funcao.aplicar(aux.getValue());
            aux = aux.getNext();
        }
        return resultado;
    }

    @FunctionalInterface
    public interface ForEachNodeStream<T> {
        void aplicar(T item);
    }

    /*
        Para cada elemento da lista, aplica a "funcao" passada como parâmetro.

        A função recebe como argumento um elemento T e não retorna nada.
    */
    public void forEach(ForEachNodeStream<T> funcao) {
        Node<T> aux = this.head.getNext();
        while (aux != null) {
            funcao.aplicar(aux.getValue());
            aux = aux.getNext();
        }
    }

    /*
        Converte NodeStream para uma List
    */
    public List<T> toList() {
        List<T> lista = new ArrayList<T>();
        this.forEach(lista::add);
        return lista;
    }

    /*
        Obtém a propriedade head do NodeStream (ou seja, o inicio da lista)
    */
    public Node<T> toNodeHead() {
        return this.head;
    }

    /*
        Obtém a propriedade tail do NodeStream (ou seja, o final da lista)
    */
    public Node<T> toNodeTail() {
        return this.tail;
    }

}
