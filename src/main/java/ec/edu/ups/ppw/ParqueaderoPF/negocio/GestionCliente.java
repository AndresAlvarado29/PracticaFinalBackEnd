package ec.edu.ups.ppw.ParqueaderoPF.negocio;

import ec.edu.ups.ppw.ParqueaderoPF.dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCliente {
@Inject
private ClienteDAO clienteDAO;


}
