package repository;

import domain.Aluno;
import storage.Node;
import storage.NodeStream;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class AlunoRepository {

    private Node<Aluno> head;
    private Node<Aluno> tail;

    public AlunoRepository() {
        this.head = new Node<Aluno>(null);
        this.tail = this.head;
    }

    public List<Aluno> findAll() {
        NodeStream stream = new NodeStream(head);
        List<Aluno> alunos = stream.toList();
        return alunos;
    }

    public Aluno findByRA(String registro) {
        if (registro == null){
            throw new IllegalArgumentException();
        }
        if (head == tail){
            return null;
        }
        List<Aluno> alunos = this.findAll();
        Optional<Aluno> aluno = Optional.ofNullable(alunos.stream()
                .filter((aux) -> aux.getRa().equals(registro))
                .findFirst()
                .orElse(null));

        if (aluno.isEmpty()){
            return null;
        }
        return aluno.get();
    }

    public List<Aluno> findByTurma(String turma) {
        if (turma == null){
            throw new IllegalArgumentException();
        }
        if (head == tail){
            return Collections.emptyList();
        }
        List<Aluno> alunos = this.findAll();
        List<Aluno> alunosTurma = alunos.stream()
                .filter((aux) -> aux.getTurma().equals(turma))
                .collect(Collectors.toList());

        if (alunosTurma.isEmpty()){
            return Collections.emptyList();
        }
        return alunosTurma;
    }

    public boolean exists(Aluno aluno) {
        if (aluno == null){
            throw new IllegalArgumentException();
        }
        NodeStream stream = new NodeStream(head);
        return stream.anyMatch((item) -> item.equals(aluno));
    }

    public boolean existsByRA(String registro) {
        if (registro == null){
            throw new IllegalArgumentException();
        }
        NodeStream stream = new NodeStream(head);
        return stream.anyMatch((item) -> ((Aluno) item).getRa().equals(registro));
    }

    public void saveAll(List<Aluno> alunos) {
        if (alunos == null){
            throw new IllegalArgumentException();
        }
        alunos.stream().forEach((aluno) -> {
            List<Aluno> alunosList = findAll();
            Optional<Aluno> alunoOpt = Optional.ofNullable(alunosList.stream()
                    .filter((aux) -> aux.equals(aluno))
                    .findFirst()
                    .orElse(null));
            if (alunoOpt.isEmpty()) {
                this.saveAluno(aluno);
            }
        });
    }

    public void save(Aluno aluno) {
        if (aluno == null){
            throw new IllegalArgumentException();
        }
        List<Aluno> alunos = findAll();
        Optional<Aluno> alunoOpt = Optional.ofNullable(alunos.stream()
                .filter((aux) -> aux.equals(aluno))
                .findFirst()
                .orElse(null));

        if (alunoOpt.isEmpty()){
            this.saveAluno(aluno);
        }else {
            throw new IllegalArgumentException();
        }
    }

    private void saveAluno(Aluno aluno) {
        Node newNode = new Node(aluno);
        this.tail.setNext(newNode);
        newNode.setPrevious(this.tail);
        this.tail = newNode;
    }


    public void delete(Aluno aluno) {
        if (head == tail) {
            throw new IllegalArgumentException();
        }
        if (aluno == null) {
            throw new IllegalArgumentException();
        }

        deleteNode(aluno);
    }

    private void deleteNode(Aluno aluno){
        int counter = 0;
        boolean found = false;
        Node current = head.getNext();
        while (counter < this.count()) {
            if (current.getValue().equals(aluno)){
                found = true;
                if (current.getNext() != null){
                    current.getNext().setPrevious(current.getPrevious());
                }
                current.getPrevious().setNext(current.getNext());
                counter++;
            }else {
                counter++;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteAll() {
        head = tail;
    }

    public int count() {
        List<Aluno> alunos = this.findAll();
        return alunos.size();
    }

}
