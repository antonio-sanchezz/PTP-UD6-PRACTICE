package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Esta clase perfil de usuario tiene los datos del usuario
 * en una famosa red Social
 * 
 * @author eserrano
 *
 */
public class UserProfile implements Comparable<UserProfile>, Comparator<UserProfile> {
	
	/**
	 * Atributos de la clase
	 * 
	 * <b>nick</b> atributo de tipo cadena. Los nick son unicos. Solo
	 * puede haber un usuario con el mismo nick. No se distingue entre
	 * Mayusculas y minusculas 
	 * 
	 * <b>regDate</b> atributo de tipo fecha "LocalDate". Registra la fecha en la que
	 * el usuario se dio de alta en la red social. La fecha sigue el formato
	 * "dd/MM/yyyy"
	 * 
	 * <b>rating</b> atributo de tipo Float. almacena la media de las puntuaciones
	 * recibidas por popularidad recibida de otros usuarios.
	 */
	
	private String nick;
	private LocalDate regDate;
	private Float rating;
	
	/**
	 * Metodos de la clase
	 * 
	 * Generar el constructor por defecto 
	 * Generar constructor sobrecargado con todos los atributos.
	 * Generar todos los getters/setters
	 * Generar un metodo equals que devuelve verdadero cuando el
	 * nick es el mismo y falso en caso contrario
	 */
	
	public UserProfile() {
		
	}
	
	public UserProfile(String nick, LocalDate regDate, Float rating) {
		this.nick = nick;
		this.regDate = regDate;
		this.rating = rating;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the regDate
	 */
	public LocalDate getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	@Override
	public boolean equals(Object o) {

		boolean validador = false;

		if (!(o instanceof UserProfile)) {
			throw new ClassCastException("El objeto introducido no es valido");
		} else {
			UserProfile user = (UserProfile) o;
			if (this == o) {
				validador = true;
			} else {
				// Comprobamos si los nick son iguales, ignorando mayusculas y minusculas.
				if ((this.nick).equalsIgnoreCase(user.nick)) {
					validador = true;
				}
			}
		}
		return validador;
	}
	
	public String toString() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		// nick>dd/MM/yyyy>3.2
		return nick + ">" + regDate.format(dtf) + ">" + rating;
	}
	
	@Override
	public int compareTo(UserProfile o) {
		
		int result = 0;
		
		result = nick.compareTo(o.nick);
		
		if (result == 0)  {
			result = this.regDate.compareTo(o.regDate);
		}
		
		return result;
	}

	@Override
	public int compare(UserProfile o1, UserProfile o2) {
		return o1.rating.compareTo(o2.rating);
	}
	

}