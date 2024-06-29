package com.gestor_paciente.gestion.enumeradores;




public enum EnumGrupoFamiliar {
    MADRASTRA("Madrastra"),
    PADRASTRO("Padrastro"),
    MADRE("Madre"),
    PADRE("Padre"),
    TUTOR("Tutor"),
    BISABUELO("BisAbuelo"),
    BISABUELA("BisAbuela"),
    ABUELO("Abuelo"),
    ABUELA("Abuela"),
    HERMANO("Hermano"),
    HERMANA("Hermana"),
    HERMANASTRO("Hermanastro"),
    HERMANASTRA("Hermanastra"),
    TIO("Tío"),
    TIA("Tía"),
    FAMILIAR("Familiar"),
    VINCULADO("Vinculado"),
    AMIGO("Amigo");

    private final String categoria;

    EnumGrupoFamiliar(String categoria){
        this.categoria = categoria;
    }

    // Getter methods
    public String getCategoria() {
        return categoria;
    }

}
