package com.jpql.biblioteca.repository;

import com.jpql.biblioteca.dto.EstatisticasEditoraDTO;
import com.jpql.biblioteca.model.Livro;
import com.jpql.biblioteca.projection.LivroMinimoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitulo(String titulo);

    List<Livro> findByCategoriaAndPrecoLessThan(String categoria, BigDecimal preco);

    List<Livro> findByPrecoBetween(BigDecimal min, BigDecimal max);

    List<Livro> findByCategoriaIn(List<String> categorias);

    List<Livro> findByIsbnIsNull();

    List<Livro> findByEditoraIdOrderByTituloAsc(Long editoraId);

    long countByAutoresNacionalidade(String nacionalidade);

    @Query("SELECT l.titulo FROM Livro l WHERE l.categoria = :categoria")
    List<String> findTitulosByCategoria(@Param("categoria") String categoria);

    @Query("SELECT l FROM Livro l JOIN l.autores a WHERE a.nome = :nomeAutor")
    List<Livro> findLivrosPorNomeAutor(@Param("nomeAutor") String nomeAutor);

    @Query("SELECT l FROM Livro l JOIN FETCH l.autores")
    List<Livro> findAllEmagerAutores();

    @Query("SELECT AVG(l.preco) FROM Livro l WHERE l.editora.id = :editoraId")
    BigDecimal findPrecoMedioPorEditora(@Param("editoraId") Long editoraId);

    @Query("SELECT l FROM Livro l WHERE l.preco > (SELECT AVG(l2.preco) FROM Livro l2)")
    List<Livro> findLivrosAcimaDaMediaDePreco();

    @Query(value = "SELECT * FROM livro WHERE YEAR(data_publicacao) = 2023", nativeQuery = true)
    List<Livro> findLivrosPublicadosEm2023Nativo();

    @Query(value = "SELECT l.* FROM livro l " +
            "JOIN livro_autores la ON l.id = la.livro_id " +
            "JOIN autor a ON a.id = la.autor_id " +
            "WHERE a.nacionalidade = 'Brasileira'", nativeQuery = true)
    List<Livro> findLivrosAutoresBrasileirosNativo();

    @Query(value = "SELECT * FROM livro WHERE LOWER(categoria) = LOWER(:categoria)", nativeQuery = true)
    List<Livro> findByCategoriaIgnoreCaseNativo(@Param("categoria") String categoria);

    @Query("SELECT l.titulo as titulo, l.preco as preco FROM Livro l")
    List<LivroMinimoProjection> findLivrosMinimos();

    @Query("SELECT new com.jpql.biblioteca.dto.EstatisticasEditoraDTO(e.nome, COUNT(l)) " +
            "FROM Livro l JOIN l.editora e GROUP BY e.nome")
    List<EstatisticasEditoraDTO> findEstatisticasEditoras();

    @Query(value = "SELECT titulo as titulo, preco as preco FROM livro WHERE preco < :precoMax", nativeQuery = true)
    List<LivroMinimoProjection> findLivrosBaratosNativo(@Param("precoMax") BigDecimal precoMax);

    <T> List<T> findByCategoria(String categoria, Class<T> type);
}