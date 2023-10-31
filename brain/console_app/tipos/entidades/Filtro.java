package console_app.tipos.entidades;

import java.util.function.Function;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IFiltro;

/**
 * Ver descripción en {@link console_app.interfaces.entidades.IFiltro}
 */
public class Filtro implements IFiltro {

	private String etiqueta;
    private Function<IEntidad, Boolean> filtro;

    public Filtro(Function<IEntidad, Boolean> filtro) {
        this.filtro = filtro;
    }

    public Filtro(String etiqueta, Function<IEntidad, Boolean> filtro) {
        this.etiqueta = etiqueta;
        this.filtro = filtro;
    }

    public String getEtiqueta() {
		return this.etiqueta;
	}

    public boolean aplicar(Entidad entidad) {
        return filtro.apply(entidad);
    }

    public Function<IEntidad, Boolean> getFiltro() {
        return this.filtro;
    }

}
