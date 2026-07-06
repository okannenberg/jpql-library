package com.jpql.biblioteca.service;

import com.jpql.biblioteca.dto.*;
import com.jpql.biblioteca.mapper.LivroMapper;
import com.jpql.biblioteca.model.Livro;
import com.jpql.biblioteca.projection.LivroMinimoProjection;
import com.jpql.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    @Transactional
    public LivroResponseDTO salvar(LivroRequestDTO dto) {
        Livro livro = livroMapper.toEntity(dto);
        Livro livroSalvo = livroRepository.save(livro);
        return livroMapper.toResponse(livroSalvo);
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex1Find(String titulo) {
        return livroRepository.findByTitulo(titulo).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex2And(String categoria, BigDecimal preco) {
        return livroRepository.findByCategoriaAndPrecoLessThan(categoria, preco).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex3Between(BigDecimal min, BigDecimal max) {
        return livroRepository.findByPrecoBetween(min, max).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex5In(List<String> categorias) {
        return livroRepository.findByCategoriaIn(categorias).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex6IsNull() {
        return livroRepository.findByIsbnIsNull().stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex7OrderBy(Long editoraId) {
        return livroRepository.findByEditoraIdOrderByTituloAsc(editoraId).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public long ex8Count(String nacionalidade) {
        return livroRepository.countByAutoresNacionalidade(nacionalidade);
    }

    @Transactional(readOnly = true)
    public List<String> ex9SelectSimples(String categoria) {
        return livroRepository.findTitulosByCategoria(categoria);
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex10Join(String nomeAutor) {
        return livroRepository.findLivrosPorNomeAutor(nomeAutor).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex11JoinFetch() {
        return livroRepository.findAllEmagerAutores().stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public BigDecimal ex12Agregacao(Long editoraId) {
        return livroRepository.findPrecoMedioPorEditora(editoraId);
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex13Subquery() {
        return livroRepository.findLivrosAcimaDaMediaDePreco().stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex14SelectBasicoNativo() {
        return livroRepository.findLivrosPublicadosEm2023Nativo().stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex15JoinNativo() {
        return livroRepository.findLivrosAutoresBrasileirosNativo().stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroResponseDTO> ex16FuncaoBancoNativo(String categoria) {
        return livroRepository.findByCategoriaIgnoreCaseNativo(categoria).stream().map(livroMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public List<LivroMinimoProjection> ex17InterfaceProjection() {
        return livroRepository.findLivrosMinimos();
    }

    @Transactional(readOnly = true)
    public List<EstatisticasEditoraDTO> ex18ClassBasedDto() {
        return livroRepository.findEstatisticasEditoras();
    }

    @Transactional(readOnly = true)
    public List<LivroMinimoProjection> ex19NativeProjection(BigDecimal precoMax) {
        return livroRepository.findLivrosBaratosNativo(precoMax);
    }

    @Transactional(readOnly = true)
    public <T> List<T> ex20DynamicProjection(String categoria, Class<T> tipoAlvo) {
        return livroRepository.findByCategoria(categoria, tipoAlvo);
    }
}