package ec.edu.ups.ppw.ParqueaderoPF.negocio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.dao.VehiculoDAO;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

@Stateless
public class GestionVehiculo {
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
		
		if(daoVehiculo.read(vehiculo.getPlaca()) == null) {
			try {
				daoVehiculo.create(vehiculo);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoVehiculo.update(vehiculo);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public List<Vehiculo> getAll(){
		return daoVehiculo.getAll();
	}
	
	public boolean eliminarVehiculo(String placa) {
		try {
			daoVehiculo.delete(placa);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Vehiculo buscarVehiculo(String placa) {
		Vehiculo vehiculo = new Vehiculo(); 
		try {
			vehiculo = daoVehiculo.findPlaca(placa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehiculo;
    }
}
