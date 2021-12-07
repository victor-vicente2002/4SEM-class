package domain;

import java.util.Objects;

public class Aluno {

    private String ra;
    private String nome;
    private String turma;

    public Aluno(String ra, String nome, String turma) {
        this.ra = ra;
        this.nome = nome;
        this.turma = turma;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(ra, aluno.ra) && Objects.equals(nome, aluno.nome) && Objects.equals(turma, aluno.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ra, nome, turma);
    }

}
