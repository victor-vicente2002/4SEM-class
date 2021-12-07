import domain.Aluno;
import org.junit.jupiter.api.Test;
import repository.AlunoRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoRepositoryTest {

    @Test
    public void testQuandoFindAllListaVaziaRetornaListEmpty() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertEquals(Collections.emptyList(), alunoRepository.findAll());
    }

    @Test
    public void testQuandoFindAllListaElementosRetornaList() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));

        assertEquals(
                List.of(
                        new Aluno("001001", "José Silva", "2CCO"),
                        new Aluno("001002", "Antônio Carlos", "2CCO"),
                        new Aluno("002001", "Carlos Gomes", "3ADS")
                ),
                alunoRepository.findAll()
        );
    }

    @Test
    public void testQuandoFindByRALancaIllegalArgumentExceptionQuandoRegistroNull() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertThrows(IllegalArgumentException.class, () -> alunoRepository.findByRA(null));
    }

    @Test
    public void testQuandoFindByRAEListaVaziaRetornaNull() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertNull(alunoRepository.findByRA("001001"));
    }

    @Test
    public void testQuandoFindByRARetornaNullSeRegistroNaoEncontrado() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertNull(alunoRepository.findByRA("001010"));
    }

    @Test
    public void testQuandoFindByRARetornaAlunoSeRegistroEncontrado() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(
                new Aluno("001001", "José Silva", "2CCO"),
                alunoRepository.findByRA("001001")
        );
    }

    @Test
    public void testQuandoFindByTurmaLancaIllegalArgumentExceptionQuandoRegistroNull() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertThrows(IllegalArgumentException.class, () -> alunoRepository.findByTurma(null));
    }

    @Test
    public void testQuandoFindByTurmaEListaVaziaRetornaListaEmpty() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertEquals(Collections.emptyList(), alunoRepository.findByTurma("3CCO"));
    }

    @Test
    public void testQuandoFindByTurmaRetornaListEmptySeTurmaNaoEncontrada() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(Collections.emptyList(), alunoRepository.findByTurma("3CCO"));
    }

    @Test
    public void testQuandoFindByTurmaRetornaListaAlunoSeRegistroEncontrado() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(
                List.of(
                        new Aluno("001001", "José Silva", "2CCO"),
                        new Aluno("001002", "Antônio Carlos", "2CCO"),
                        new Aluno("001003", "John Doe", "2CCO"),
                        new Aluno("001004", "Reinaldo Gomes", "2CCO")
                ),
                alunoRepository.findByTurma("2CCO")
        );
    }

    @Test
    public void testQuandoSaveLancaIllegalArgumentExceptionQuandoAlunoNull() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertThrows(IllegalArgumentException.class, () -> alunoRepository.save(null));
    }

    @Test
    public void testQuandoSaveLancaIllegalArgumentExceptionQuandoAlunoDuplicado() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));

        assertThrows(
                IllegalArgumentException.class,
                () -> alunoRepository.save(
                        new Aluno("001002", "Antônio Carlos", "2CCO")
                )
        );
    }

    @Test
    public void testQuandoSaveCountIgualTres() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));

        assertEquals(3, alunoRepository.count());
    }

    @Test
    public void testQuandoSaveCountIgualUm() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));

        assertEquals(1, alunoRepository.count());
    }

    @Test
    public void testQuandoSaveCountIgualSeis() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(6, alunoRepository.count());
    }

    @Test
    public void testQuandoListaVaziaCountZero() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertEquals(0, alunoRepository.count());
    }

    @Test
    public void testQuandoExistsByRaLancaIllegalArgumentExceptionQuandoRegistroNull() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertThrows(IllegalArgumentException.class, () -> alunoRepository.existsByRA(null));
    }

    @Test
    public void testQuandoExistsByRaRetornaFalseQuandoRegistroNaoExiste() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        assertFalse(alunoRepository.existsByRA("001003"));
    }

    @Test
    public void testQuandoExistsByRaRetornaTrueQuandoRegistroExiste() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        assertTrue(alunoRepository.existsByRA("001001"));
    }

    @Test
    public void testQuandoExistsByRaRetornaFalseQuandoListaVazia() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertFalse(alunoRepository.existsByRA("001001"));
    }

    @Test
    public void testQuandoExistsLancaIllegalArgumentExceptionQuandoRegistroNull() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertThrows(IllegalArgumentException.class, () -> alunoRepository.exists(null));
    }

    @Test
    public void testQuandoExistsRetornaFalseQuandoRegistroNaoExiste() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        assertFalse(alunoRepository.exists(new Aluno("001003", "José Carlos", "2CCO")));
    }

    @Test
    public void testQuandoExistsRetornaTrueQuandoRegistroExiste() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        assertTrue(alunoRepository.exists(new Aluno("001001", "José Silva", "2CCO")));
    }

    @Test
    public void testQuandoExistsRetornaFalseQuandoListaVazia() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertFalse(alunoRepository.exists(new Aluno("001001", "José Silva", "2CCO")));
    }

    @Test
    public void testQuandoDeleteLancaIllegalArgumentExceptionQuandoAlunoNull() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertThrows(IllegalArgumentException.class, () -> alunoRepository.delete(null));
    }

    @Test
    public void testQuandoDeleteLancaIllegalArgumentExceptionQuandoAlunoNaoExiste() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));

        assertThrows(
                IllegalArgumentException.class,
                () -> alunoRepository.delete(
                        new Aluno("002001", "Carlos Gomes", "3ADS")
                )
        );
    }

    @Test
    public void testQuandoDeleteCountIgualDois() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));

        assertEquals(3, alunoRepository.count());

        alunoRepository.delete(new Aluno("001002", "Antônio Carlos", "2CCO"));

        assertEquals(2, alunoRepository.count());
        assertFalse(alunoRepository.exists(new Aluno("001002", "Antônio Carlos", "2CCO")));
    }

    @Test
    public void testQuandoDeleteCountIgualZero() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));

        assertEquals(1, alunoRepository.count());

        alunoRepository.delete(new Aluno("001001", "José Silva", "2CCO"));

        assertEquals(0, alunoRepository.count());
        assertFalse(alunoRepository.exists(new Aluno("001001", "José Silva", "2CCO")));
    }

    @Test
    public void testQuandoDeleteCountIgualCinco() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(6, alunoRepository.count());

        alunoRepository.delete(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(5, alunoRepository.count());
        assertFalse(alunoRepository.exists(new Aluno("002002", "Reginaldo Nunes", "3ADS")));
    }

    @Test
    public void testQuandoDeleteQuandoListaVaziaLancaIllegalArgumentException() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertEquals(0, alunoRepository.count());

        assertThrows(
                IllegalArgumentException.class,
                () -> alunoRepository.delete(new Aluno("002002", "Reginaldo Nunes", "3ADS"))
        );

        assertEquals(0, alunoRepository.count());
    }

    @Test
    public void testQuandoDeleteAllListaVaziaCountIgualZero() {
        AlunoRepository alunoRepository = new AlunoRepository();

        assertEquals(0, alunoRepository.count());

        alunoRepository.deleteAll();

        assertEquals(0, alunoRepository.count());
    }

    @Test
    public void testQuandoDeleteAllListaNaoVaziaCountIgualZero() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));
        alunoRepository.save(new Aluno("001003", "John Doe", "2CCO"));
        alunoRepository.save(new Aluno("001004", "Reinaldo Gomes", "2CCO"));
        alunoRepository.save(new Aluno("002002", "Reginaldo Nunes", "3ADS"));

        assertEquals(6, alunoRepository.count());

        alunoRepository.deleteAll();

        assertEquals(0, alunoRepository.count());
    }


    @Test
    public void testQuandoSaveAllLancaIllegalArgumentExceptionQuandoAlunosNull() {
        AlunoRepository alunoRepository = new AlunoRepository();
        assertThrows(IllegalArgumentException.class, () -> alunoRepository.saveAll(null));
        assertEquals(0, alunoRepository.count());
    }

    @Test
    public void testQuandoSaveAllCountNaoIncrementaQuandoAlunosEmpty() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.saveAll(Collections.emptyList());
        assertEquals(0, alunoRepository.count());
    }

    @Test
    public void testQuandoSaveAllCountIncrementa() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));

        assertEquals(2, alunoRepository.count());

        alunoRepository.saveAll(
                List.of(
                        new Aluno("002001", "Carlos Gomes", "3ADS"),
                        new Aluno("001003", "John Doe", "2CCO"),
                        new Aluno("001004", "Reinaldo Gomes", "2CCO"),
                        new Aluno("002002", "Reginaldo Nunes", "3ADS")
                )
        );

        assertEquals(6, alunoRepository.count());
    }

    @Test
    public void testQuandoSaveAllCountIncrementaQuandoRADuplicadoIgnora() {
        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.save(new Aluno("001001", "José Silva", "2CCO"));
        alunoRepository.save(new Aluno("001002", "Antônio Carlos", "2CCO"));
        alunoRepository.save(new Aluno("002001", "Carlos Gomes", "3ADS"));

        assertEquals(3, alunoRepository.count());

        alunoRepository.saveAll(
                List.of(
                        new Aluno("002001", "Carlos Gomes", "3ADS"),
                        new Aluno("001003", "John Doe", "2CCO"),
                        new Aluno("001004", "Reinaldo Gomes", "2CCO"),
                        new Aluno("002002", "Reginaldo Nunes", "3ADS")
                )
        );

        assertEquals(6, alunoRepository.count());
    }


}


/*
public class ListaStreamTest {

    @Test
    public void quandoFilterDeveRetornarListaComPares() {
        NodeStream<Integer> stream = new NodeStream<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<Integer> listaFiltrada = stream
                .filter((elemento) -> elemento % 2 == 0)
                .toList();
        Assertions.assertEquals(List.of(2, 4, 6), listaFiltrada);
    }

    @Test
    public void quandoMapDeveRetornarItemMaisUm() {
        NodeStream<Integer> stream = new NodeStream<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<Integer> listaMap = stream
                .map((elemento) -> elemento + 1)
                .toList();
        Assertions.assertEquals(List.of(2, 3, 4, 5, 6, 7, 8), listaMap);
    }

    @Test
    public void quandoReduceDeveRetornarSomaTodosElementos() {
        NodeStream<Integer> stream = new NodeStream<>(List.of(1, 2, 3, 4, 5, 6, 7));
        Integer somaReduce = stream
                .reduce((acumulador, item) -> acumulador + item)
                .get();
        Assertions.assertEquals(28, somaReduce);
    }

    @Test
    public void quandoFilterParesMapItemMaisUmReduceSoma() {
        NodeStream<Integer> stream = new NodeStream<>(List.of(1, 2, 3, 4, 5, 6, 7));
        Integer somaReduce = stream
                .filter((item) -> item % 2 == 0)
                .map((item) -> item + 1)
                .reduce((acumulador, item) -> item + acumulador)
                .get();
        Assertions.assertEquals(15, somaReduce);
    }

    public static String referenciaMetodo(Integer valor) {
        return String.format("O valor é %d", valor);
    }

    @Test
    public void quandoMapReferenciaMetodoConverterParaStringRetornaListaString() {
        NodeStream<Integer> stream = new NodeStream<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<String> converterMap = stream
                .map(ListaStreamTest::referenciaMetodo)
                .toList();
        Assertions.assertEquals(List.of(
                "O valor é 1",
                "O valor é 2",
                "O valor é 3",
                "O valor é 4",
                "O valor é 5",
                "O valor é 6",
                "O valor é 7"
        ), converterMap);
    }
}
*/