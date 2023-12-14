package com.evolutioncode.technicaltest.shared.mapper;

import java.util.List;

public interface EntityToDto<E, O> {

  E toEntity(O e);

  O toDto(E e);

  List<E> toEntity(List<O> o);

  List<O> toDto(List<E> e);

}
