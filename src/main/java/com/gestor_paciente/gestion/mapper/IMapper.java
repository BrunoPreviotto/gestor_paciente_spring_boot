package com.gestor_paciente.gestion.mapper;

public interface IMapper <T, U>{
    public T aDTO(U object);
    public U aEntity(T dto);
} 