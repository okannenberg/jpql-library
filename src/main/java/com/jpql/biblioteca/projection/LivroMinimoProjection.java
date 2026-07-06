package com.jpql.biblioteca.projection;

import java.math.BigDecimal;

public interface LivroMinimoProjection {
    String getTitulo();
    BigDecimal getPreco();
}